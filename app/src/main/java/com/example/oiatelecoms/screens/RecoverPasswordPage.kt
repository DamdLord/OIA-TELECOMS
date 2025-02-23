package com.example.oiatelecoms.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oiatelecoms.R
import com.example.oiatelecoms.ui.theme.OIATELECOMSTheme
import com.example.oiatelecoms.ui.theme.useAnotherColor
import com.example.oiatelecoms.ui.theme.useColor
import com.example.oiatelecoms.ui.theme.useForthColor

@Composable
fun RecoverPasswordPage(
    modifier: Modifier = Modifier,
    onRecoverPasswordClicked:()->Unit,
    onAlreadyHaveAnAccountClicked:()->Unit,
    onDontHaveAnAccountClicked:()->Unit

) {
    Box {
        Image(
            painter = painterResource(id = R.drawable.royalbluebackground),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier.fillMaxSize()
        )
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(2.dp),
                colors = CardDefaults.cardColors(useForthColor)
            ) {
               Column(
                   modifier = modifier
                       .fillMaxWidth()
                       .padding(2.dp),
                   horizontalAlignment = Alignment.CenterHorizontally
               ) {
                   Spacer(modifier = modifier.height(5.dp))
                   Image(
                       painter = painterResource(id = R.drawable.telecompicture),
                       contentDescription =null
                   )
                   Spacer(modifier = modifier.height(10.dp))
                   Text(
                       text = "Enter the email account associated with your account and we'll send you the reset instructions!",
                       textAlign = TextAlign.Center,
                       fontSize = 20.sp,
                       color = Color.White,
                       fontWeight = FontWeight.SemiBold
                   )
                   Spacer(modifier = modifier.height(20.dp))
                   OutlinedTextField(
                       value = "",
                       onValueChange ={},
                       leadingIcon = {
                                     Icon(imageVector = Icons.Default.Email, contentDescription = null)
                       },
                       label = {
                               Text(text = "Email")
                       },
                       colors = OutlinedTextFieldDefaults.colors(Color.White),
                       shape = RoundedCornerShape(20.dp),
                       modifier = modifier.fillMaxWidth()
                   )
                   Spacer(modifier = modifier.height(20.dp))
                   Button(
                       onClick = onRecoverPasswordClicked,
                       colors = ButtonDefaults.buttonColors(useColor),
                       modifier = modifier
                           .fillMaxWidth()
                           .height(50.dp)
                       ) {
                       Text(
                           text = "Recover Password",
                           fontSize = 20.sp
                       )
                   }
                   Spacer(modifier = modifier.height(10.dp))
                   Column {
                       TextButton(onClick = onAlreadyHaveAnAccountClicked) {
                           Text(
                               text = "Already Have An Account? Login Now",
                               color = Color.White,
                               fontSize = 20.sp
                               )
                       }
                       TextButton(onClick = onDontHaveAnAccountClicked) {
                           Text(
                               text = "Don't Have An Account, Create Account",
                               color = Color.White,
                               fontSize = 20.sp
                               )
                       }
                   }
               }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ShowRecoverPage(){
    OIATELECOMSTheme {
        RecoverPasswordPage(
            onRecoverPasswordClicked = {},
            onDontHaveAnAccountClicked = {},
            onAlreadyHaveAnAccountClicked = {}
        )
    }
}