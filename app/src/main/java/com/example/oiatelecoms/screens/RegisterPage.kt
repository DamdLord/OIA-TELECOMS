package com.example.oiatelecoms.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oiatelecoms.R
import com.example.oiatelecoms.ui.theme.OIATELECOMSTheme
import com.example.oiatelecoms.ui.theme.useAnotherColor
import com.example.oiatelecoms.ui.theme.useThirdColor

@Composable
fun RegisterPage(
    modifier: Modifier = Modifier,
    onContinueClick: ()->Unit,
    onLoginClick:()->Unit
){
   Box {
       Image(
           painter = painterResource(id = R.drawable.istockphoto_1334764353_612x612),
           contentDescription = null,
           modifier = modifier.fillMaxSize(),
           contentScale = ContentScale.Crop
           )
       Column(
           modifier = modifier
               .fillMaxSize()
               .padding(6.dp),
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally
       ) {
           Card(
               modifier = modifier.fillMaxWidth(),
               colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer)
           ) {
               Column(
                   modifier = modifier
                       .padding(6.dp)
                       .fillMaxWidth(),
                   horizontalAlignment = Alignment.CenterHorizontally
               ) {
                   Text(
                       text = "Register",
                       fontSize = 25.sp,
                       fontWeight = FontWeight.Bold
                       )
                   Spacer(modifier = modifier.height(10.dp))
                   Text(
                       text = "Enter your credentials below to create a free account",
                       color = Color.Blue,
                       fontSize = 20.sp,
                       textAlign = TextAlign.Center
                       )
                   Spacer(modifier = modifier.height(10.dp))
                   OutlinedTextField(
                       value = "",
                       onValueChange = {},
                       label = {
                               Text(text = "First Name")
                       },
                       keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next),
                       leadingIcon = {
                           Icon(imageVector = Icons.Default.Person, contentDescription = null )
                       },
                       shape = RoundedCornerShape(20.dp),
                       colors = OutlinedTextFieldDefaults.colors(useThirdColor),
                       modifier = modifier
                           .fillMaxWidth()
                   )
                   Spacer(modifier = modifier.height(10.dp))
                   OutlinedTextField(
                       value = "",
                       onValueChange = {},
                       label = {
                               Text(text = "Last Name")
                       },
                       keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next),
                       leadingIcon = {
                                     Icon(imageVector = Icons.Default.Person, contentDescription = null )
                       },
                       shape = RoundedCornerShape(20.dp),
                       colors = OutlinedTextFieldDefaults.colors(useThirdColor),
                       modifier = modifier.fillMaxWidth()
                   )
                   Spacer(modifier = modifier.height(10.dp))
                   OutlinedTextField(
                       value = "",
                       onValueChange = {},
                       label = {
                               Text(text = "Phone")
                       },
                       shape = RoundedCornerShape(20.dp),
                       leadingIcon = {
                                     Icon(imageVector = Icons.Default.Call, contentDescription = null)
                       },
                       keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                       colors = OutlinedTextFieldDefaults.colors(useThirdColor),
                       modifier = modifier.fillMaxWidth()
                   )
                   Spacer(modifier = modifier.height(10.dp))
                   OutlinedTextField(
                       value = "",
                       onValueChange = {},
                       label = {
                               Text(text = "Email")
                       },
                       shape = RoundedCornerShape(20.dp),
                       leadingIcon = {
                                     Icon(imageVector = Icons.Default.Email, contentDescription =  null)
                       },
                       keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                       colors = OutlinedTextFieldDefaults.colors(useThirdColor),
                       modifier = modifier.fillMaxWidth()
                   )
                   Spacer(modifier = modifier.height(10.dp))
                   Button(
                       onClick = onContinueClick,
                       modifier = modifier.fillMaxWidth(),
                       colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
                   ) {
                       Text(
                           text = "Continue",
                           fontSize = 20.sp
                           )
                   }
                   Spacer(modifier = modifier.height(10.dp))
                   Row(
                       modifier = modifier,
                       verticalAlignment = Alignment.CenterVertically
                   ) {
                       Text(text = "Already Have An Account?")
                       TextButton(onClick = onLoginClick) {
                           Text(
                               text = "Login",
                               fontSize =  23.sp
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
fun RegisterPagePreview(){
    OIATELECOMSTheme {
        RegisterPage(
            onContinueClick = {},
            onLoginClick = {}
        )
    }
}
