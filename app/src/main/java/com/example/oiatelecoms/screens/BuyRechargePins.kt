package com.example.oiatelecoms.screens

import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oiatelecoms.R
import com.example.oiatelecoms.data.AirtimeType
import com.example.oiatelecoms.data.NetworkList
import com.example.oiatelecoms.ui.theme.OIATELECOMSTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuyRechargePins(
    modifier: Modifier = Modifier
){
    var isNetworkDropdownExtended by remember { mutableStateOf(false) }
    var businessName by remember { mutableStateOf("") }
    val networkList = NetworkList.networkList
    var selectedNetwork  by remember{ mutableStateOf(networkList[0]) }
    var amount by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }
    val discount = if(amount.isEmpty()){"" }else{"1%"}
    var amountToPay = if (amount.isNotEmpty() && amount.toDoubleOrNull() != null) {
        val numericQuantity = quantity.toDouble()
        val numericAmount = amount.toDouble()  // Use `toDouble` for accurate percentage calculation
        val realAmount = numericAmount * numericQuantity
        val calculatedAmountToPay = realAmount - (realAmount * 0.01) // Subtract 1% of the amount
        calculatedAmountToPay.toString() // Convert back to String
    } else {
        "" // Default value for invalid or empty input
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(4.dp)
            .verticalScroll(rememberScrollState()),
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Recharge Card Pin",
            color = Color.Blue,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )
        Spacer(modifier = modifier.height(10.dp))
        Text(
            text = "Recharge Pin",
            fontWeight = FontWeight.SemiBold,
            fontSize = 25.sp
        )
        Spacer(modifier = modifier.height(15.dp))
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                shape = CircleShape,
                modifier = modifier.size(65.dp)
            ) {
                Box {
                    Image(
                        painter = painterResource(id = R.drawable.solidbackgroundiii),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                    IconButton(
                        onClick = {
                            selectedNetwork = NetworkList.networkList[1]
                            amount = ""
                            amountToPay = ""
                        },
                        modifier = modifier.size(80.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.mtn_logo),
                            contentDescription = "MTN",
                            modifier = modifier.clip(CircleShape)
                        )
                    }
                }
            }
            Surface(
                shape = CircleShape,
                modifier = modifier.size(65.dp)
            ) {
                Box {
                    Image(
                        painter = painterResource(id = R.drawable.solidbackgroundiii),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                    IconButton(
                        onClick = {
                            selectedNetwork = NetworkList.networkList[2]
                            amount = ""
                            amountToPay = ""
                        },
                        modifier = modifier.size(70.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.airtel_logo),
                            contentDescription = "Airtel",
                            modifier = modifier.clip(CircleShape)
                        )
                    }
                }
            }
            Surface(
                shape = CircleShape,
                modifier = modifier.size(65.dp)
            ) {
                Box {
                    Image(
                        painter = painterResource(id = R.drawable.solidbackgroundiii),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                    IconButton(
                        onClick = {
                           selectedNetwork = NetworkList.networkList[4]
                            amount = ""
                            amountToPay = ""
                        },
                        modifier = modifier.size(70.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.glo_logo),
                            contentDescription = "GLO",
                            modifier = modifier.clip(CircleShape)
                        )
                    }
                }
            }
            Surface(
                shape = CircleShape,
                modifier = modifier.size(65.dp)
            ) {
                Box {
                    Image(
                        painter = painterResource(id = R.drawable.solidbackgroundiii),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                    IconButton(
                        onClick = {
                            selectedNetwork = NetworkList.networkList[3]
                            amount = ""
                            amountToPay = ""
                        },
                        modifier = modifier.size(70.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable._mobile_logo),
                            contentDescription = "Nine Mobile",
                            modifier = modifier.clip(CircleShape)
                        )
                    }
                }
            }
        }
        Spacer(modifier = modifier.height(10.dp))
        Divider(modifier = modifier.height(1.5.dp))
        Spacer(modifier = modifier.height(10.dp))
        OutlinedTextField(
            value = businessName,
            onValueChange = { businessName = it},
            label = {
                Text(text = "Business Name")
            },
            shape = RoundedCornerShape(15.dp),
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier = modifier.height(10.dp))
        ExposedDropdownMenuBox(
            expanded = isNetworkDropdownExtended,
            onExpandedChange = { isNetworkDropdownExtended = !isNetworkDropdownExtended}
        ) {
            OutlinedTextField(
                value = selectedNetwork,
                onValueChange = {},
                readOnly = true,
                label = {  },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isNetworkDropdownExtended)
                },
                modifier = modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = isNetworkDropdownExtended,
                onDismissRequest = { isNetworkDropdownExtended = false }
            ) {
                NetworkList.networkList.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selectedNetwork = option
                            isNetworkDropdownExtended = false
                        }
                    )
                }
            }
        }
        Spacer(modifier = modifier.height(10.dp))
        OutlinedTextField(
            value = amount,
            onValueChange = { amount = it},
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            label = { Text(text = "Amount")}
        )
        OutlinedTextField(
            value = quantity,
            onValueChange = { quantity = it},
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            label = { Text(text = "Quantity")}
        )
        Spacer(modifier = modifier.height(10.dp))
        OutlinedTextField(
            value = amountToPay,
            onValueChange = {},
            label = { Text(text = "Amount To Pay")},
            readOnly = true,
            shape = RoundedCornerShape(15.dp),
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier = modifier.height(10.dp))
        OutlinedTextField(
            value = discount,
            onValueChange = {},
            label = { Text(text = "Discount")},
            readOnly = true,
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp)
        )
        Spacer(modifier = modifier.height(10.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
            modifier = modifier.fillMaxWidth(),
            shape = RectangleShape
        ) {
            Text(
                text = "Purchase Pin",
                fontSize = 20.sp
            )
        }

    }
}

@Preview(showBackground =  true)
@Composable
fun BuyRechargePinPreview(){
    OIATELECOMSTheme {
        BuyRechargePins()
    }
}