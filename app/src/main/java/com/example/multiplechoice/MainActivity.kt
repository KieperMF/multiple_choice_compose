package com.example.multiplechoice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.multiplechoice.ui.theme.MultipleChoiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MultipleChoiceTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier) {
    Column(modifier = modifier.fillMaxSize()) {

    }
}

@Composable
fun OptionContainer(option: Option) {
    Row {
        Image(
            painterResource(option.image),
            contentDescription = "")
        Text(option.textOption)
        RadioButton(
            selected = option.isClicked,
            onClick = {}
        )
    }
}

class Option {
    var textOption: String = "";
    var image: Int = 0;
    var isClicked: Boolean = false;
}
