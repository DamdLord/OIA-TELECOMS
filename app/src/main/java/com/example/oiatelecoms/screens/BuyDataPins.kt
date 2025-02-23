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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.oiatelecoms.data.DataPlan
import com.example.oiatelecoms.data.DataTypeForDataPins
import com.example.oiatelecoms.data.NetworkList
import com.example.oiatelecoms.ui.theme.OIATELECOMSTheme
import com.example.oiatelecoms.ui.theme.useAnotherColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuyDataPins(
    modifier: Modifier = Modifier
){
    var isNetworkDropdownExpanded by remember { mutableStateOf(false) }
    var isDataTypeDropdownExpanded by remember { mutableStateOf(false) }
    var isDataPlanDropdownExpanded by remember { mutableStateOf(false) }
    val networkList = NetworkList.networkList
    val dataTypeList = DataTypeForDataPins.dataTypeList
    var selectedDataType by remember { mutableStateOf(dataTypeList[0]) }
    var selectedDataPlan by remember { mutableStateOf("Select Plan") }
    var selectedNetwork by remember { mutableStateOf(networkList[0]) }
    var quantity by remember { mutableStateOf("") }
    var businessName by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(4.dp)
            .verticalScroll(rememberScrollState()),
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Data For All Network",
            color = Color.Blue,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )
        Spacer(modifier = modifier.height(10.dp))
        Text(
            text = "Buy Data Pins",
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
                            selectedNetwork = networkList[1]
                            selectedDataType = "Select type"
                            selectedDataPlan = "Select plan"
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
                            selectedNetwork = networkList[2]
                            selectedDataType = "Select type"
                            selectedDataPlan = "Select plan"
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
                            selectedNetwork = networkList[4]
                            selectedDataType = "Select type"
                            selectedDataPlan = "Select plan"
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
                            selectedNetwork = networkList[3]
                            selectedDataType = "Select type"
                            selectedDataPlan = "Select plan"
                        },
                        modifier = modifier.size(70.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable._mobile_logo),
                            contentDescription = "9 Mobile",
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
            expanded = isNetworkDropdownExpanded,
            onExpandedChange = { isNetworkDropdownExpanded = !isNetworkDropdownExpanded}
        ) {
            OutlinedTextField(
                value = selectedNetwork,
                onValueChange = {},
                readOnly = true,
                label = {  },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isNetworkDropdownExpanded)
                },
                modifier = modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = isNetworkDropdownExpanded,
                onDismissRequest = { isNetworkDropdownExpanded = false }
            ) {
                networkList.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selectedNetwork= option
                            isNetworkDropdownExpanded = false
                            selectedDataType = "Select type"
                        }
                    )
                }
            }
        }
        Spacer(modifier = modifier.height(15.dp))
        ExposedDropdownMenuBox(
            expanded = isDataTypeDropdownExpanded,
            onExpandedChange = { isDataTypeDropdownExpanded = !isDataTypeDropdownExpanded}
        ) {
            OutlinedTextField(
                value = selectedDataType,
                onValueChange = {},
                readOnly = true,
                label = {  },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isDataTypeDropdownExpanded)
                },
                modifier = modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = isDataTypeDropdownExpanded,
                onDismissRequest = { isDataTypeDropdownExpanded = false }
            ) {
                dataTypeList.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selectedDataType = option
                            isDataTypeDropdownExpanded = false
                        }
                    )
                }
            }
        }
        Spacer(modifier = modifier.height(15.dp))
        ExposedDropdownMenuBox(
            expanded = isDataPlanDropdownExpanded,
            onExpandedChange = { isDataPlanDropdownExpanded = !isDataPlanDropdownExpanded}
        ) {
            OutlinedTextField(
                value = selectedDataPlan,
                onValueChange = {},
                readOnly = true,
                label = {  },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isDataPlanDropdownExpanded)
                },
                modifier = modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = isDataPlanDropdownExpanded,
                onDismissRequest = { isDataPlanDropdownExpanded = false }
            ) {
                DataPlan.dataPlanList.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selectedDataPlan = option
                            isDataPlanDropdownExpanded = false
                        }
                    )
                }
            }
        }
        Spacer(modifier = modifier.height(15.dp))
        OutlinedTextField(
            value = quantity,
            onValueChange = { quantity = it},
            label = {
                Text(text = "Quantity")
            },
            shape = RoundedCornerShape(15.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier = modifier.height(15.dp))
        OutlinedTextField(
            value = "",
            onValueChange = { },
            label = { Text(text = "Amount to pay")},
            shape = RoundedCornerShape(15.dp),
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier = modifier.height(15.dp))
        OutlinedTextField(
            value = businessName,
            onValueChange = { businessName = it},
            label = { Text(text = "Business Name")},
            shape = RoundedCornerShape(15.dp),
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier = modifier.height(15.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
            modifier = modifier.fillMaxWidth(),
            shape = RectangleShape
        ) {
            Text(
                text = "Buy Data",
                fontSize = 20.sp,
                color = Color.White
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun ShowBuns(){
    OIATELECOMSTheme {
        BuyDataPins()
    }
}