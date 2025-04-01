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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Lock
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import androidx.fragment.app.FragmentActivity
import com.example.oiatelecoms.OIAViewModel
import com.example.oiatelecoms.auth.BiometricAuth
import com.example.oiatelecoms.R
import com.example.oiatelecoms.ui.theme.OIATELECOMSTheme
import com.example.oiatelecoms.ui.theme.useThirdColor


@Composable
fun LoginPage(
    modifier: Modifier = Modifier,
    onLoginClick: ()->Unit,
    onForgotPassWordClick: ()-> Unit,
    onNewUserClicked:()-> Unit,
    activity:FragmentActivity,
    onSuccess: () -> Unit,
    onFailure: (String) -> Unit,
    oiaViewModel: OIAViewModel
){
    var phoneNumber by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Box {
        Image(
            painter = painterResource(id = R.drawable.istockphoto_1334764353_612x612),
            contentDescription = null,
            modifier = modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,

        )
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(2.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.telecompicture),
                contentDescription = null,
                modifier = modifier.size(75.dp).clip(CircleShape)
                )
            Spacer(modifier = modifier.height(10.dp))
            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(6.dp),
                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer)
            ) {
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(6.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "LOGIN",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Welcome Back!",
                        fontSize = 25.sp,
                        color = Color.Blue,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = modifier.padding(6.dp))
                    OutlinedTextField(
                        value = phoneNumber,
                        onValueChange ={
                            phoneNumber = it
                            oiaViewModel.updateCurrentPhoneNumber(it)
                                       },
                        colors = OutlinedTextFieldDefaults.colors(useThirdColor),
                        shape = RoundedCornerShape(20.dp),
                        label = { Text(text = "Phone number")},
                        modifier = modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next),
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Call, contentDescription = null)
                        }
                    )
                    Spacer(modifier = modifier.padding(4.dp))
                    OutlinedTextField(
                        value = password,
                        onValueChange = {
                            password = it
                            oiaViewModel.updateCurrentPassword(it)
                                        },
                        shape = RoundedCornerShape(20.dp),
                        modifier = modifier.fillMaxWidth(),
                        label = { Text(text = "Password")},
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Lock, contentDescription = null)
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Done)
                    )
                    Spacer(modifier = modifier.padding(4.dp))
                    Button(
                        onClick = onLoginClick,
                        modifier = modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
                    ) {
                        Text(
                            text = "Login",
                            fontSize = 20.sp,
                            color = Color.White
                        )
                    }
                    BiometricAuth(activity = activity, onSuccess = onSuccess, onFailure = onFailure, modifier = modifier)
                    Column {
                        TextButton(
                            onClick = onForgotPassWordClick
                        ) {
                            Text(
                                text = "Forgot Password? Recover it",
                                color = Color.Black,
                                fontSize = 20.sp
                                )
                        }
                        TextButton(onClick = onNewUserClicked) {
                            Text(
                                text = "New User? Create Account",
                                color = Color.Black,
                                fontSize = 20.sp
                            )
                        }
                    }
                }
            }

        }
    }
}


@Preview
@Composable
fun ShowLoginPreview(){

    OIATELECOMSTheme {
//        LoginPage(
//            onLoginClick = {},
//            onForgotPassWordClick = {},
//            onNewUserClicked = {},
//            context = context,
//            onSuccess = {},
//            onFailure = {}
//        )
    }
}