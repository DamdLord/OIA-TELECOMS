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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.oiatelecoms.OIAViewModel
import com.example.oiatelecoms.R
import com.example.oiatelecoms.data.AirtimeType
import com.example.oiatelecoms.data.NetworkList
import com.example.oiatelecoms.ui.theme.OIATELECOMSTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuyAirTimePage(
    modifier: Modifier = Modifier,
    onBuyAirtimeButtonClicked: () -> Unit,
    appViewModel: OIAViewModel
){
    var selectedOption by remember { mutableStateOf(NetworkList.networkList[0]) }
    var selectedAirtimeType by remember { mutableStateOf(AirtimeType.airtimeTypeList[0])}
    var isSelectNetworkDropdownExpanded by remember { mutableStateOf(false) }
    var isSelectTypeDropdownExpanded by remember { mutableStateOf(false) }
    var isNumberValidatorOn by remember { mutableStateOf(false) }
    var phoneNumber by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    val discount = if(amount.isEmpty()){"" }else{"1%"}
    var amountToPay = if (amount.isNotEmpty() && amount.toDoubleOrNull() != null) {
        val numericAmount = amount.toDouble() // Use `toDouble` for accurate percentage calculation
        val calculatedAmountToPay = numericAmount - (numericAmount * 0.01) // Subtract 1% of the amount
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
            text = "Airtime For All Network",
            color = Color.Blue,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )
        Spacer(modifier = modifier.height(10.dp))
        Text(
            text = "Buy Airtime",
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
                            selectedOption = NetworkList.networkList[1]
                            amount = ""
                            amountToPay = ""
                            appViewModel.updateNetworkUserWantsToBuy(selectedOption)
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
                            selectedOption = NetworkList.networkList[2]
                            amount = ""
                            amountToPay = ""
                            appViewModel.updateNetworkUserWantsToBuy(selectedOption)
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
                            selectedOption = NetworkList.networkList[4]
                            amount = ""
                            amountToPay = ""
                            appViewModel.updateNetworkUserWantsToBuy(selectedOption)
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
                            selectedOption = NetworkList.networkList[3]
                            amount = ""
                            amountToPay = ""
                            appViewModel.updateNetworkUserWantsToBuy(selectedOption)
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
        ExposedDropdownMenuBox(
            expanded = isSelectNetworkDropdownExpanded,
            onExpandedChange = { isSelectNetworkDropdownExpanded = !isSelectNetworkDropdownExpanded}
        ) {
            OutlinedTextField(
                value = selectedOption,
                onValueChange = {appViewModel.updateNetworkUserWantsToBuy(it)},
                readOnly = true,
                label = {  },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isSelectNetworkDropdownExpanded)
                },
                modifier = modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = isSelectNetworkDropdownExpanded,
                onDismissRequest = { isSelectNetworkDropdownExpanded = false }
            ) {
                NetworkList.networkList.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selectedOption = option
                            isSelectNetworkDropdownExpanded = false
                            appViewModel.updateNetworkUserWantsToBuy(option)
                        }
                    )
                }
            }
        }
        Spacer(modifier = modifier.height(10.dp))
        ExposedDropdownMenuBox(
            expanded = isSelectTypeDropdownExpanded,
            onExpandedChange = { isSelectTypeDropdownExpanded = !isSelectTypeDropdownExpanded}
        ) {
            OutlinedTextField(
                value = selectedAirtimeType,
                onValueChange = {},
                readOnly = true,
                label = {  },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isSelectTypeDropdownExpanded)
                },
                modifier = modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = isSelectTypeDropdownExpanded,
                onDismissRequest = { isSelectTypeDropdownExpanded = false }
            ) {
                AirtimeType.airtimeTypeList.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selectedAirtimeType = option
                            isSelectTypeDropdownExpanded = false
                        }
                    )
                }
            }
        }
        Spacer(modifier = modifier.height(10.dp))
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = {newValue ->
                phoneNumber = newValue
                appViewModel.updateNumberToBuyCardOrDataFor(newValue)
                appViewModel.networkValidation(newValue)
            },
            label = {
                Text(text = "Phone number")
            },
            shape = RoundedCornerShape(15.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone, imeAction = ImeAction.Next),
            modifier = modifier.fillMaxWidth()
        )

        AnimatedVisibility(visible = !isNumberValidatorOn && phoneNumber.isNotEmpty()) {
            Spacer(modifier = modifier.height(15.dp))
            Column(
                modifier = modifier.fillMaxWidth()
            ) {
                Row {
                    Text(
                        text = "Identified Network:",
                        fontSize = 15.sp,
                    )
                    Spacer(modifier = modifier.width(5.dp))
                    Text(
                        text = appViewModel.validatedNetwork,
                        fontSize = 15.sp,
                    )
                }
                Text(
                    text = "Note: Ignore warning for Ported Number",
                    fontSize = 15.sp,
                    //fontWeight = FontWeight.SemiBold
                )
            }
        }
        Spacer(modifier = modifier.height(10.dp))
        OutlinedTextField(
            value = amount,
            onValueChange = {newValue->
                amount = newValue
                appViewModel.updateAmountIWantToBuy(newValue)
                appViewModel.updateAmountUserWillPay(newValue)
            },
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
            label = { Text(text = "Amount")}
        )
        Spacer(modifier = modifier.height(10.dp))
        OutlinedTextField(
            value = amountToPay,
            onValueChange = {

            },
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
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Checkbox(
                checked = isNumberValidatorOn ,
                onCheckedChange = { isNumberValidatorOn = !isNumberValidatorOn}
            )
            Text(text = "Disable Number Validator")
        }
        Spacer(modifier = modifier.height(10.dp))
        Button(
            onClick = onBuyAirtimeButtonClicked ,
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
            modifier = modifier.fillMaxWidth(),
            shape = RectangleShape
        ) {
            Text(
                text = "Buy Airtime",
                fontSize = 20.sp
                )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun BuyAirTimePreview(){
    val appViewModel:OIAViewModel = viewModel()
    OIATELECOMSTheme {
        BuyAirTimePage(
            onBuyAirtimeButtonClicked= {},
            appViewModel = appViewModel
        )
    }
}