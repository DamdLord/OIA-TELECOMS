package com.example.oiatelecoms.ui.theme

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StatusIcon() {
    Canvas(modifier = Modifier.size(48.dp)) { // Adjust size as needed
        val radius = size.minDimension / 2
        val dotRadius = 4.dp.toPx() // Size of each dot
        val dotCount = 8 // Number of dots in the circle

        for (i in 0 until dotCount) {
            val angle = (i * 360f / dotCount) * (Math.PI / 180f).toFloat()
            val x = radius + (radius - dotRadius * 2) * kotlin.math.cos(angle)
            val y = radius + (radius - dotRadius * 2) * kotlin.math.sin(angle)
            drawCircle(
                color = Color.Blue, // Adjust the color as needed
                radius = dotRadius,
                center = Offset(x, y)
            )
        }
    }
}

@Preview
@Composable
fun ShowIdi(){
    OIATELECOMSTheme {
        StatusIcon()
    }
}