package com.example.multiplechoice

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

class OptionClass(
    val textOption: String,
    val image: Int,
    var isClicked: MutableState<Boolean> = mutableStateOf(false))