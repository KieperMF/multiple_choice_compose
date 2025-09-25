package com.example.multiplechoice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        Header()
        LazyColumn {
            items(options) {
                opt-> OptionContainer(opt)
            }
        }
    }
}

@Composable
fun OptionContainer(option: OptionClass) {
    Row (modifier = Modifier.padding(8.dp).fillMaxSize().border(
        border = BorderStroke(1.dp, Color.Gray), // Define the border's width and color
        shape = RoundedCornerShape(8.dp)), verticalAlignment = Alignment.CenterVertically){
        Image(
            painterResource(option.image),
            contentScale = ContentScale.FillBounds,
            contentDescription = "",

            modifier = Modifier.height(80.dp).width(80.dp).
            padding(8.dp).clip(RoundedCornerShape(12.dp)))
        Text(option.textOption, modifier = Modifier.padding(8.dp))
        Box(modifier = Modifier.fillMaxSize(0.8f))
        RadioButton(
            modifier = Modifier.padding(12.dp),
            selected = option.isClicked.value,
            onClick = {option.isClicked.value = !option.isClicked.value}
        )
    }
}

@Composable
fun Header(){
    Box(modifier = Modifier.background(Color.LightGray).padding(horizontal = 12.dp).height(80.dp).border(
        border = BorderStroke(1.dp, Color.Gray),
        shape = RoundedCornerShape(12.dp)).clip(RoundedCornerShape(12.dp))){
        Text("Pick a fucking option son of a bitch!", textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(top = 24.dp).size(24.dp))
    }
}


var option0 = OptionClass(textOption = "Racoon",

    image = R.drawable.attachment_belchertown_racoon)

var option1 = OptionClass(textOption = "Sam",
    image = R.drawable.sam)

var option2 = OptionClass(textOption = "Elden",
    image = R.drawable.elden)

var option3 = OptionClass(textOption = "Pernalonga",
    image = R.drawable.pernalonga)

var  options = mutableListOf<OptionClass>(option0, option1, option2, option3)


