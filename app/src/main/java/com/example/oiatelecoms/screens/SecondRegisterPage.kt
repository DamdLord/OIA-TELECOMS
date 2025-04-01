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
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person2
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oiatelecoms.DBViewModel
import com.example.oiatelecoms.R
import com.example.oiatelecoms.data.States
import com.example.oiatelecoms.ui.theme.useThirdColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondRegisterPage(
    modifier: Modifier = Modifier,
    onRegisterDoneClicked:()->Unit,
    onIHaveAnAccountAlreadySoLoginNow:()->Unit,
    dbViewModel: DBViewModel
){
    val stateList = States.listOfStates
    var selectedState by remember{ mutableStateOf(stateList[0]) }
    var isStateDropdownExpanded by remember { mutableStateOf(false) }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var pin by remember { mutableStateOf("") }
    var referral by remember { mutableStateOf("") }
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
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = modifier.height(10.dp))
                    ExposedDropdownMenuBox(
                        expanded = isStateDropdownExpanded,
                        onExpandedChange = { isStateDropdownExpanded = !isStateDropdownExpanded}
                    ) {
                        OutlinedTextField(
                            value = selectedState,
                            onValueChange = {},
                            readOnly = true,
                            label = { },
                            trailingIcon = {
                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isStateDropdownExpanded)
                            },
                            modifier = modifier
                                .fillMaxWidth()
                                .menuAnchor()
                        )

                        ExposedDropdownMenu(
                            expanded = isStateDropdownExpanded,
                            onDismissRequest = { isStateDropdownExpanded = false }
                        ) {
                            stateList.forEach { option ->
                                DropdownMenuItem(
                                    text = { Text(option) },
                                    onClick = {
                                        selectedState = option
                                        isStateDropdownExpanded = false
                                    }
                                )
                            }
                        }
                    }
                    Spacer(modifier = modifier.height(10.dp))
                    OutlinedTextField(
                        value = password,
                        onValueChange = {
                            password = it
                            dbViewModel.updatePassword(it)
                                        },
                        label = {
                            Text(text = "Password")
                        },
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Lock, contentDescription = null )
                        },
                        shape = RoundedCornerShape(20.dp),
                        colors = OutlinedTextFieldDefaults.colors(useThirdColor),
                        modifier = modifier
                            .fillMaxWidth()
                    )
                    Spacer(modifier = modifier.height(10.dp))
                    OutlinedTextField(
                        value = confirmPassword,
                        onValueChange = { confirmPassword = it},
                        label = {
                            Text(text = "Confirm Password")
                        },
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Lock, contentDescription = null )
                        },
                        shape = RoundedCornerShape(20.dp),
                        colors = OutlinedTextFieldDefaults.colors(useThirdColor),
                        modifier = modifier.fillMaxWidth()
                    )
                    Spacer(modifier = modifier.height(5.dp))
                    if (password != confirmPassword && confirmPassword.isNotEmpty()) {
                        Text(text = "Password does not much")
                    }
                    Spacer(modifier = modifier.height(10.dp))
                    OutlinedTextField(
                        value = pin,
                        onValueChange = {
                            pin = it
                            dbViewModel.updatePin(it.toInt())
                                        },
                        label = {
                            Text(text = "Pin")
                        },
                        shape = RoundedCornerShape(20.dp),
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Lock, contentDescription = null)
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                        colors = OutlinedTextFieldDefaults.colors(useThirdColor),
                        modifier = modifier.fillMaxWidth()
                    )
                    Spacer(modifier = modifier.height(10.dp))
                    OutlinedTextField(
                        value = referral,
                        onValueChange = { referral = it},
                        label = {
                            Text(text = "Referral")
                        },
                        shape = RoundedCornerShape(20.dp),
                        leadingIcon = {
                            Icon(imageVector = Icons.Default.Person2, contentDescription =  null)
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        colors = OutlinedTextFieldDefaults.colors(useThirdColor),
                        modifier = modifier.fillMaxWidth()
                    )
                    Spacer(modifier = modifier.height(10.dp))
                    Button(
                        onClick = onRegisterDoneClicked,
                        modifier = modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary)
                    ) {
                        Text(
                            text = "Register",
                            fontSize = 20.sp
                        )
                    }
                    Spacer(modifier = modifier.height(10.dp))
                    Row(
                        modifier = modifier,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Already Have An Account?")
                        TextButton(onClick = onIHaveAnAccountAlreadySoLoginNow) {
                            Text(
                                text = "Login Now",
                                fontSize = 20.sp
                            )
                        }
                    }
                }
            }
        }
    }
}


//@Preview
//@Composable
//fun ShowSecondRegister(){
//    val dbVM = DBViewModel()
//    OIATELECOMSTheme {
//        SecondRegisterPage(
//            onRegisterDoneClicked = {},
//            onIHaveAnAccountAlreadySoLoginNow = {},
//            dbViewModel = dbVM
//        )
//    }
//}