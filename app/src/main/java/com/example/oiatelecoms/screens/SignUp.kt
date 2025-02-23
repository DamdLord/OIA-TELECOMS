package com.example.oiatelecoms.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oiatelecoms.R
import com.example.oiatelecoms.ui.theme.OIATELECOMSTheme
import com.example.oiatelecoms.ui.theme.useColor

@Composable
fun SignUpPage(
    modifier: Modifier = Modifier,
    onRegisterClick:()->Unit,
    onLoginClick:()->Unit
){
    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.istockphoto_1334764353_612x612),
            contentDescription = null,
            modifier = modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxSize()
                .padding(6.dp)
        ){

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(6.dp),

            ) {
                Box {
                    Image(painter = painterResource(id = R.drawable.telecompicture) , contentDescription = null )
                }
                Spacer(modifier = modifier.height(20.dp))
               Row(
                   modifier = modifier,
                   verticalAlignment = Alignment.CenterVertically
               ) {
                   Text(
                       text = "Welcome to",
                       color = androidx.compose.ui.graphics.Color.White,
                       fontWeight = FontWeight.Bold,
                       fontSize = 25.sp
                   )
                   Spacer(modifier =modifier.width(4.dp))
                   Text(
                       text = "OIA TELECOMS",
                       color = useColor,
                       fontWeight = FontWeight.Bold,
                       fontSize = 25.sp
                   )
               }
                Spacer(modifier = modifier.height(20.dp))
                Text(
                    text = "A technology platform that offers solutions to digital needs at best possible price without compromising quality.",
                    color = androidx.compose.ui.graphics.Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )
                Spacer(modifier = modifier.height(50.dp))
                Row {
                    Button(
                        onClick = onRegisterClick,
                        shape = RectangleShape,
                        modifier = modifier.size(width = 150.dp, height = 50.dp),
                        colors = ButtonDefaults.buttonColors(androidx.compose.ui.graphics.Color.White)
                        ) {
                        Text(
                            text = "REGISTER",
                            color = useColor,
                            fontSize = 20.sp
                        )
                    }
                    Spacer(modifier = modifier.width(20.dp))
                    Button(
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(useColor),
                        onClick = onLoginClick,
                        modifier = modifier.size(width = 150.dp, height = 50.dp)
                    ) {
                        Text(
                            text = "LOGIN",
                            fontSize = 20.sp
                            )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview(){
    OIATELECOMSTheme {
        SignUpPage(
            onLoginClick = {},
            onRegisterClick = {}
        )
    }
}