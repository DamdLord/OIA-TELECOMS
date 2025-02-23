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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.example.oiatelecoms.data.Discos
import com.example.oiatelecoms.data.MeterType
import com.example.oiatelecoms.data.NetworkList
import com.example.oiatelecoms.ui.theme.OIATELECOMSTheme
import com.example.oiatelecoms.ui.theme.useAnotherColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuyElectricityScreen(
    modifier: Modifier = Modifier
){
    val discoProviderList = Discos.discosProviderList
    val meterTypeList = MeterType.meterTypeList
    var selectedDiscoProvider by remember { mutableStateOf(discoProviderList[0]) }
    var selectedMeterType by remember { mutableStateOf(meterTypeList[0]) }
    var isProviderDropdownExpanded by remember { mutableStateOf(false) }
    var isMeterDropdownExpanded by remember { mutableStateOf(false) }
    var amount by remember { mutableStateOf("") }
    var customerNumber by remember { mutableStateOf("") }
    var meterNumber by remember { mutableStateOf("") }
    val amountToPay = if (amount.isNotEmpty() && amount.toDoubleOrNull() != null) {
        val numericAmount = amount.toDouble() // Use `toDouble` for accurate percentage calculation
        val calculatedAmountToPay = numericAmount + 150 // Subtract 1% of the amount
        calculatedAmountToPay.toString() // Convert back to String
    } else {
        "" // Default value for invalid or empty input
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(6.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Electricity Payment",
            color = Color.Blue,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )
        Spacer(modifier = modifier.height(10.dp))
        Text(
            text = "Electricity Bill",
            fontWeight = FontWeight.SemiBold,
            fontSize = 25.sp
        )
        Spacer(modifier = modifier.height(10.dp))
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
                            selectedDiscoProvider = discoProviderList[1]
                        },
                        modifier = modifier.size(80.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.aedc),
                            contentDescription = discoProviderList[1],
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
                            selectedDiscoProvider = discoProviderList[2]
                        },
                        modifier = modifier.size(70.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ekedc),
                            contentDescription =discoProviderList[2],
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
                            selectedDiscoProvider = discoProviderList[3]
                        },
                        modifier = modifier.size(70.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.kaduna),
                            contentDescription = discoProviderList[3],
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
                            selectedDiscoProvider = discoProviderList[4]
                        },
                        modifier = modifier.size(70.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.kano),
                            contentDescription = discoProviderList[4],
                            modifier = modifier.clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
            }
        }
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
                            selectedDiscoProvider = discoProviderList[5]
                        },
                        modifier = modifier.size(80.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.jos),
                            contentDescription = discoProviderList[5],
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
                            selectedDiscoProvider = discoProviderList[6]
                        },
                        modifier = modifier.size(70.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ikeja),
                            contentDescription = discoProviderList[6],
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
                            selectedDiscoProvider = discoProviderList[7]
                        },
                        modifier = modifier.size(70.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ibadan),
                            contentDescription = discoProviderList[7],
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
                            selectedDiscoProvider = discoProviderList[8]
                        },
                        modifier = modifier.size(70.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ph),
                            contentDescription = discoProviderList[8],
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
            expanded = isProviderDropdownExpanded,
            onExpandedChange = { isProviderDropdownExpanded = !isProviderDropdownExpanded}
        ) {
            OutlinedTextField(
                value = selectedDiscoProvider,
                onValueChange = {},
                readOnly = true,
                label = {  },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isProviderDropdownExpanded)
                },
                modifier = modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = isProviderDropdownExpanded,
                onDismissRequest = { isProviderDropdownExpanded = false }
            ) {
                discoProviderList.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selectedDiscoProvider = option
                            isProviderDropdownExpanded = false
                        }
                    )
                }
            }
        }
        Spacer(modifier = modifier.height(10.dp))
        ExposedDropdownMenuBox(
            expanded = isMeterDropdownExpanded,
            onExpandedChange = { isMeterDropdownExpanded = !isMeterDropdownExpanded}
        ) {
            OutlinedTextField(
                value = selectedMeterType,
                onValueChange = {},
                readOnly = true,
                label = {  },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isMeterDropdownExpanded)
                },
                modifier = modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )

            ExposedDropdownMenu(
                expanded =isMeterDropdownExpanded,
                onDismissRequest = { isMeterDropdownExpanded = false }
            ) {
                meterTypeList.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selectedMeterType = option
                            isMeterDropdownExpanded = false
                        }
                    )
                }
            }
        }
        Spacer(modifier = modifier.height(10.dp))
        OutlinedTextField(
            value = customerNumber,
            onValueChange = { customerNumber = it},
            label = {
                Text(text = "Customer Phone Number")
            },
            shape = RoundedCornerShape(15.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier = modifier.height(10.dp))
        OutlinedTextField(
            value = meterNumber,
            onValueChange = { meterNumber = it },
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            label = { Text(text = "Meter Number") }
        )
        Spacer(modifier = modifier.height(10.dp))
        OutlinedTextField(
            value = amount,
            onValueChange = { amount = it },
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            label = { Text(text = "Amount") }
        )
        Spacer(modifier = modifier.height(10.dp))
        OutlinedTextField(
            value = amountToPay,
            onValueChange = {},
            label = { Text(text = "Amount To Pay") },
            readOnly = true,
            shape = RoundedCornerShape(15.dp),
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier = modifier.height(10.dp))
        Column {
            Text(
                text = "Note: Transaction attracts a service charges of N150 only",
                color = Color.Red,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Note: Minimum Unit Purchase Is N1000",
                color = Color.Red,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = modifier.height(10.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
            modifier = modifier.fillMaxWidth(),
            shape = RectangleShape
        ) {
            Text(
                text = "Continue",
                fontSize = 20.sp
            )
        }

    }
}

@Preview
@Composable
fun ShowMeMassiveIdi(){
    OIATELECOMSTheme {
        BuyElectricityScreen()
    }
}
