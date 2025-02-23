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
import androidx.compose.runtime.LaunchedEffect
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
import com.example.oiatelecoms.data.DataPlan
import com.example.oiatelecoms.data.DataPlanList
import com.example.oiatelecoms.data.DataType
import com.example.oiatelecoms.data.NetworkList
import com.example.oiatelecoms.ui.theme.OIATELECOMSTheme
import com.example.oiatelecoms.ui.theme.useAnotherColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuyDataPage(
    modifier: Modifier = Modifier,
    appViewModel: OIAViewModel,
    onBuyDataButtonClicked: () -> Unit
){
    var selectedOption by remember { mutableStateOf("") }
    var selectedDataPlan by remember { mutableStateOf("") }
    var selectedDataType by remember { mutableStateOf("") }
    var isSelectNetworkDropdownExpanded by remember { mutableStateOf(false) }
    var isSelectTypeDropdownExpanded by remember { mutableStateOf(false) }
    var isSelectPlanDropdownExpanded by remember { mutableStateOf(false) }
    var isNumberValidatorOn by remember { mutableStateOf(false) }
    var phoneNumber by remember { mutableStateOf("") }
    val dataTypeList = when(selectedOption){
        NetworkList.networkList[1] -> DataType.MTNDataTypeList
        NetworkList.networkList[2] -> DataType.AirtelDataType
        NetworkList.networkList[3] -> DataType.NineMobileDtaType
        NetworkList.networkList[4] -> DataType.GLODtaType
        else -> listOf()
    }
    val dataPlanList = when(selectedOption to selectedDataType){
        NetworkList.networkList[1] to DataType.MTNDataTypeList[1] -> DataPlanList.mtnSME
        NetworkList.networkList[1] to DataType.MTNDataTypeList[2] -> DataPlanList.mtnGifting
        NetworkList.networkList[1] to DataType.MTNDataTypeList[3] -> DataPlanList.ntnCorporate
        NetworkList.networkList[2] to DataType.AirtelDataType[1] -> DataPlanList.airtelGifting
        NetworkList.networkList[2] to DataType.AirtelDataType[2] -> DataPlanList.airtelCorporate
        NetworkList.networkList[4] to DataType.GLODtaType[1] -> DataPlanList.gloCorporate
        NetworkList.networkList[3] to DataType.NineMobileDtaType[1] -> DataPlanList.nineMobileSME
        NetworkList.networkList[3] to DataType.NineMobileDtaType[2] -> DataPlanList.nineMobileCorporate
        else -> listOf("")
    }
    val  amountToPay = when(selectedOption to selectedDataType to selectedDataPlan){
        //MTN SME
        NetworkList.networkList[1] to DataType.MTNDataTypeList[1] to DataPlanList.mtnSME[1] -> "142"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[1] to DataPlanList.mtnSME[2] -> "261"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[1] to DataPlanList.mtnSME[3] -> "526"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[1] to DataPlanList.mtnSME[4] -> "790"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[1] to DataPlanList.mtnSME[5] -> "1315"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[1] to DataPlanList.mtnSME[6] -> "2605"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[1] to DataPlanList.mtnSME[7] -> "139"
        // MTN /Gifting
        NetworkList.networkList[1] to DataType.MTNDataTypeList[2] to DataPlanList.mtnGifting[1] -> "129"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[2] to DataPlanList.mtnGifting[2] -> "30"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[2] to DataPlanList.mtnGifting[3] -> "225"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[2] to DataPlanList.mtnGifting[4] -> "510"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[2] to DataPlanList.mtnGifting[5] -> "1785"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[2] to DataPlanList.mtnGifting[6] -> "1530"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[2] to DataPlanList.mtnGifting[7] -> "639"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[2] to DataPlanList.mtnGifting[8] -> "24"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[2] to DataPlanList.mtnGifting[9] -> "20"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[2] to DataPlanList.mtnGifting[10] -> "65"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[2] to DataPlanList.mtnGifting[11] -> "384"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[2] to DataPlanList.mtnGifting[12] -> "2250"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[2] to DataPlanList.mtnGifting[13] -> "1275"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[2] to DataPlanList.mtnGifting[14] -> "765"
        // MTN / Corporate
        NetworkList.networkList[1] to DataType.MTNDataTypeList[3] to DataPlanList.ntnCorporate[1]-> "135"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[3] to DataPlanList.ntnCorporate[2]-> "265"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[3] to DataPlanList.ntnCorporate[3]-> "532"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[3] to DataPlanList.ntnCorporate[4]-> "1327"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[3] to DataPlanList.ntnCorporate[5]-> "2652"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[3] to DataPlanList.ntnCorporate[6]-> "5222"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[3] to DataPlanList.ntnCorporate[7]-> "65"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[3] to DataPlanList.ntnCorporate[8]-> "85"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[3] to DataPlanList.ntnCorporate[9]-> "3915"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[3] to DataPlanList.ntnCorporate[10]-> "3132"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[3] to DataPlanList.ntnCorporate[11]-> "10440"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[3] to DataPlanList.ntnCorporate[12]-> "19575"
        NetworkList.networkList[1] to DataType.MTNDataTypeList[3] to DataPlanList.ntnCorporate[13]-> "26100"
        // AIRTEL/ Gifting
        NetworkList.networkList[2] to DataType.AirtelDataType[1] to DataPlanList.airtelGifting[1]-> "4600"
        NetworkList.networkList[2] to DataType.AirtelDataType[1] to DataPlanList.airtelGifting[2]-> "8800"
        NetworkList.networkList[2] to DataType.AirtelDataType[1] to DataPlanList.airtelGifting[3]-> "13375"
        NetworkList.networkList[2] to DataType.AirtelDataType[1] to DataPlanList.airtelGifting[4]-> "19000"
        NetworkList.networkList[2] to DataType.AirtelDataType[1] to DataPlanList.airtelGifting[5]-> "900"
        NetworkList.networkList[2] to DataType.AirtelDataType[1] to DataPlanList.airtelGifting[6]-> "1100"
        NetworkList.networkList[2] to DataType.AirtelDataType[1] to DataPlanList.airtelGifting[7]-> "2800"
        NetworkList.networkList[2] to DataType.AirtelDataType[1] to DataPlanList.airtelGifting[8]-> "3700"
        NetworkList.networkList[2] to DataType.AirtelDataType[1] to DataPlanList.airtelGifting[9]-> "2250"
        // AIRTEL/Corporate
        NetworkList.networkList[2] to DataType.AirtelDataType[2] to DataPlanList.airtelCorporate[1]-> "148"
        NetworkList.networkList[2] to DataType.AirtelDataType[2] to DataPlanList.airtelCorporate[2]-> "282"
        NetworkList.networkList[2] to DataType.AirtelDataType[2] to DataPlanList.airtelCorporate[3]-> "556"
        NetworkList.networkList[2] to DataType.AirtelDataType[2] to DataPlanList.airtelCorporate[4]-> "1390"
        NetworkList.networkList[2] to DataType.AirtelDataType[2] to DataPlanList.airtelCorporate[5]-> "2782"
        NetworkList.networkList[2] to DataType.AirtelDataType[2] to DataPlanList.airtelCorporate[6]-> "124"
        NetworkList.networkList[2] to DataType.AirtelDataType[2] to DataPlanList.airtelCorporate[7]-> "100"
        NetworkList.networkList[2] to DataType.AirtelDataType[2] to DataPlanList.airtelCorporate[8]-> "5440"
        NetworkList.networkList[2] to DataType.AirtelDataType[2] to DataPlanList.airtelCorporate[9]-> "4080"
        // NINE MOBILE/SME
        NetworkList.networkList[3] to DataType.NineMobileDtaType[1] to DataPlanList.nineMobileSME[1]-> "220"
        NetworkList.networkList[3] to DataType.NineMobileDtaType[1] to DataPlanList.nineMobileSME[2]-> "660"
        // NINE MOBILE/Corporate
        NetworkList.networkList[3] to DataType.NineMobileDtaType[2] to DataPlanList.nineMobileCorporate[1]-> "150"
        NetworkList.networkList[3] to DataType.NineMobileDtaType[2] to DataPlanList.nineMobileCorporate[2]-> "292"
        NetworkList.networkList[3] to DataType.NineMobileDtaType[2] to DataPlanList.nineMobileCorporate[3]-> "436"
        NetworkList.networkList[3] to DataType.NineMobileDtaType[2] to DataPlanList.nineMobileCorporate[4]-> "726"
        // GLO/Corporate
        NetworkList.networkList[4] to DataType.GLODtaType[1] to DataPlanList.gloCorporate[1]-> "77"
        NetworkList.networkList[4] to DataType.GLODtaType[1] to DataPlanList.gloCorporate[2]-> "142"
        NetworkList.networkList[4] to DataType.GLODtaType[1] to DataPlanList.gloCorporate[3]-> "277"
        NetworkList.networkList[4] to DataType.GLODtaType[1] to DataPlanList.gloCorporate[4]-> "552"
        NetworkList.networkList[4] to DataType.GLODtaType[1] to DataPlanList.gloCorporate[5]-> "826"
        NetworkList.networkList[4] to DataType.GLODtaType[1] to DataPlanList.gloCorporate[6]-> "1376"
        NetworkList.networkList[4] to DataType.GLODtaType[1] to DataPlanList.gloCorporate[7]-> "2752"

        else -> ""
    }
    LaunchedEffect(amountToPay) {
        appViewModel.updateAmountUserWillPayForData(amountToPay)
        appViewModel.updateAmountIWantToBuy(amountToPay)
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
            text = "Data For All Network",
            color = Color.Blue,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )
        Spacer(modifier = modifier.height(10.dp))
        Text(
            text = "Buy Data",
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
                            selectedOption = NetworkList.networkList[1]
                            selectedDataType = ""
                            selectedDataPlan = ""
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
                            selectedDataType = ""
                            selectedDataPlan = ""
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
                            selectedDataType = ""
                            selectedDataPlan = ""
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
                            selectedDataType = ""
                            selectedDataPlan = ""
                            appViewModel.updateNetworkUserWantsToBuy(selectedOption)
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
            expanded = isSelectNetworkDropdownExpanded,
            onExpandedChange = { isSelectNetworkDropdownExpanded = !isSelectNetworkDropdownExpanded}
        ) {
            OutlinedTextField(
                value = selectedOption,
                onValueChange = {},
                readOnly = true,
                label = { Text(text = "Select network") },
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
                            selectedDataType = ""
                            appViewModel.updateNetworkUserWantsToBuy(selectedOption)
                        }
                    )
                }
            }
        }
        Spacer(modifier = modifier.height(15.dp))
        ExposedDropdownMenuBox(
            expanded = isSelectTypeDropdownExpanded,
            onExpandedChange = { isSelectTypeDropdownExpanded = !isSelectTypeDropdownExpanded}
        ) {
            OutlinedTextField(
                value = selectedDataType,
                onValueChange = {},
                readOnly = true,
                label = { Text("Select type") },
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
                dataTypeList.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selectedDataType = option
                            isSelectTypeDropdownExpanded = false
                            appViewModel.updateDataType(selectedDataType)
                        }
                    )
                }
            }
        }
        Spacer(modifier = modifier.height(15.dp))
        ExposedDropdownMenuBox(
            expanded = isSelectPlanDropdownExpanded,
            onExpandedChange = { isSelectPlanDropdownExpanded = !isSelectPlanDropdownExpanded}
        ) {
            OutlinedTextField(
                value = selectedDataPlan,
                onValueChange = {},
                readOnly = true,
                label = { Text(text = "Select Plan") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isSelectPlanDropdownExpanded)
                },
                modifier = modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )

            ExposedDropdownMenu(
                expanded = isSelectPlanDropdownExpanded,
                onDismissRequest = { isSelectPlanDropdownExpanded = false }
            ) {
                dataPlanList.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selectedDataPlan = option
                            isSelectPlanDropdownExpanded = false
                            appViewModel.updateDataPlan(selectedDataPlan)
                        }
                    )
                }
            }
        }
        Spacer(modifier = modifier.height(15.dp))
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = {
                phoneNumber = it
                appViewModel.updateNumberToBuyCardOrDataFor(it)
                appViewModel.networkValidation(it)
            },
            label = {
                Text(text = "Phone Number")
            },
            shape = RoundedCornerShape(15.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone, imeAction = ImeAction.Done),
            modifier = modifier.fillMaxWidth()
        )
        AnimatedVisibility(visible = if(!isNumberValidatorOn && phoneNumber.isNotEmpty()){true}else{false}) {
            Spacer(modifier = modifier.height(10.dp))
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
        Spacer(modifier = modifier.height(15.dp))
        OutlinedTextField(
            value = amountToPay,
            onValueChange = {
                appViewModel.updateAmountUserWillPayForData(amountToPay)
                appViewModel.updateAmountIWantToBuy(amountToPay)
            },
            label = { Text(text = "Amount to pay")},
            readOnly = true,
            shape = RoundedCornerShape(15.dp),
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier = modifier.height(15.dp))
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
        Spacer(modifier = modifier.height(15.dp))
        Button(
            onClick = onBuyDataButtonClicked,
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
            modifier = modifier.fillMaxWidth(),
            shape = RectangleShape
        ) {
            Text(
                text = "Buy Data",
                fontSize = 20.sp
                )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ShowSomeIdi(){
    val apple: OIAViewModel = viewModel()
    OIATELECOMSTheme {
        BuyDataPage( onBuyDataButtonClicked = {}, appViewModel =  apple)
    }
}