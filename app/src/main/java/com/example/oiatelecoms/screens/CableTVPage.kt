package com.example.oiatelecoms.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.example.oiatelecoms.data.CableTvProvider
import com.example.oiatelecoms.data.CableTvProviderServiceList
import com.example.oiatelecoms.data.SubscriptionType
import com.example.oiatelecoms.ui.theme.OIATELECOMSTheme
import com.example.oiatelecoms.ui.theme.useAnotherColor



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CableTVPage(
    modifier: Modifier = Modifier
) {

    var isProviderDropdownExpanded by remember { mutableStateOf(false) }
    var isServiceDropdownExpanded by remember { mutableStateOf(false) }
    var isSubscriptionDropdownExpanded by remember { mutableStateOf(false) }
    val newProviderList = CableTvProvider.providerList
    var newSelectedProvider by remember { mutableStateOf(newProviderList[0]) }
    var newSelectedService  by remember { mutableStateOf("Plan") }
    var customerNumber by remember { mutableStateOf("") }
    var iUCnUMBER by remember{ mutableStateOf("") }
    val newServiceList = when(newSelectedProvider){
        newProviderList[0] -> listOf("")
        newProviderList[1] -> CableTvProviderServiceList.GOTVServiceList
        newProviderList[2] -> CableTvProviderServiceList.DSTVServiceList
        else -> CableTvProviderServiceList.STARTIMESServiceList
    }
    val newSubscriptionTypeList = SubscriptionType.subscriptionTypeList
    var newSelectedSubscriptionType = newSubscriptionTypeList[0]
    var amountToPay = when(newSelectedService){
        //GOTV
        CableTvProviderServiceList.GOTVServiceList[0] -> "1575"
        CableTvProviderServiceList.GOTVServiceList[1] -> "3300"
        CableTvProviderServiceList.GOTVServiceList[2] -> "4850"
        CableTvProviderServiceList.GOTVServiceList[3] -> "7200"
        CableTvProviderServiceList.GOTVServiceList[4] -> "9600"
        CableTvProviderServiceList.GOTVServiceList[5] -> "15700"
        //DSTV
        CableTvProviderServiceList.DSTVServiceList[0] -> "3600"
        CableTvProviderServiceList.DSTVServiceList[1] -> "5100"
        CableTvProviderServiceList.DSTVServiceList[2] -> "9300"
        CableTvProviderServiceList.DSTVServiceList[3] -> "15700"
        CableTvProviderServiceList.DSTVServiceList[4] -> "25000"
        CableTvProviderServiceList.DSTVServiceList[5] -> "30000"
        //STARTIMES
        CableTvProviderServiceList.STARTIMESServiceList[0] -> "1900"
        CableTvProviderServiceList.STARTIMESServiceList[1] -> "1900"
        CableTvProviderServiceList.STARTIMESServiceList[2] -> "3700"
        CableTvProviderServiceList.STARTIMESServiceList[3] -> "4700"
        CableTvProviderServiceList.STARTIMESServiceList[4] -> "5500"
        else -> ""
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(6.dp),
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Cable TV Subscription",
            color = Color.Blue,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            modifier = modifier.padding(4.dp)
        )
        Text(
            text = "Cable TV",
            fontWeight = FontWeight.SemiBold,
            fontSize = 25.sp,
            modifier = modifier.padding(4.dp)
        )
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
                            newSelectedProvider = newProviderList[2]
                            newSelectedService = "Plan"
                            amountToPay = ""
                            newSelectedSubscriptionType = newSubscriptionTypeList[0]
                            iUCnUMBER = ""
                        },
                        modifier = modifier.size(80.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.dstvlogo),
                            contentDescription = "D-S-T-V",
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
                            newSelectedProvider = newProviderList[1]
                            newSelectedService = "Plan"
                            amountToPay = ""
                            newSelectedSubscriptionType = newSubscriptionTypeList[0]
                            iUCnUMBER = ""
                        },
                        modifier = modifier.size(70.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.gotvlogo),
                            contentDescription = "G-O-T-V",
                            modifier = modifier.clip(CircleShape),
                            contentScale = ContentScale.Crop
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
                            newSelectedProvider = newProviderList[3]
                            newSelectedService = "Plan"
                            amountToPay = ""
                            newSelectedSubscriptionType = newSubscriptionTypeList[0]
                            iUCnUMBER = ""
                        },
                        modifier = modifier.size(70.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.startimelogo),
                            contentDescription = "Star times",
                            modifier = modifier.clip(CircleShape)
                        )
                    }
                }
            }
        }
        Spacer(modifier = modifier.height(10.dp))
        Divider(modifier = modifier.height(1.5.dp))
        Spacer(modifier = modifier.height(15.dp))
        ExposedDropdownMenuBox(
            expanded = isProviderDropdownExpanded,
            onExpandedChange = { isProviderDropdownExpanded = !isProviderDropdownExpanded}
        ) {
            OutlinedTextField(
                value = newSelectedProvider,
                onValueChange = {},
                readOnly = true,
                label = { },
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
                newProviderList.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            newSelectedProvider = option
                            isProviderDropdownExpanded = false
                        }
                    )
                }
            }
        }
        Spacer(modifier = modifier.height(15.dp))
        ExposedDropdownMenuBox(
            expanded = true,
            onExpandedChange = { isServiceDropdownExpanded = !isServiceDropdownExpanded}
        ) {
            OutlinedTextField(
                value = newSelectedService,
                onValueChange = {},
                readOnly = true,
                label = {  },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isServiceDropdownExpanded)
                },
                modifier = modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = isServiceDropdownExpanded,
                onDismissRequest = { isServiceDropdownExpanded = false }
            ) {
                newServiceList.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            newSelectedService = option
                            isServiceDropdownExpanded = false
                        }
                    )
                }
            }
        }
        Spacer(modifier = modifier.height(15.dp))
        OutlinedTextField(
            value = amountToPay,
            onValueChange = {},
            readOnly = true,
            label = { Text(text = "Amount to pay")},
            shape = RoundedCornerShape(15.dp),
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier = modifier.height(15.dp))
        ExposedDropdownMenuBox(
            expanded = isSubscriptionDropdownExpanded,
            onExpandedChange = { isSubscriptionDropdownExpanded = !isSubscriptionDropdownExpanded}
        ) {
            OutlinedTextField(
                value = newSelectedSubscriptionType,
                onValueChange = {},
                readOnly = true,
                label = { },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isSubscriptionDropdownExpanded)
                },
                modifier = modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = isSubscriptionDropdownExpanded,
                onDismissRequest = { isSubscriptionDropdownExpanded = false }
            ) {
                newSubscriptionTypeList.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            newSelectedSubscriptionType = option
                            isSubscriptionDropdownExpanded = false
                        }
                    )
                }
            }
        }
        Spacer(modifier = modifier.height(15.dp))
        OutlinedTextField(
            value = customerNumber,
            onValueChange = { customerNumber = it },
            label = {
                Text(text = "Customer Phone Number")
            },
            shape = RoundedCornerShape(15.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier = modifier.height(15.dp))
        OutlinedTextField(
            value = iUCnUMBER,
            onValueChange = { iUCnUMBER = it },
            label = {
                Text(text = "IUC Number")
            },
            shape = RoundedCornerShape(15.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
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
                text = "Continue",
                fontSize = 20.sp
            )
        }

    }
}



@Preview(showBackground = true)
@Composable
fun ShowMassiveIdi(){
    OIATELECOMSTheme {
        CableTVPage()
    }
}