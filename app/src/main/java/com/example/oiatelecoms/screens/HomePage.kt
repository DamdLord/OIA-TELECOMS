package com.example.oiatelecoms.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Adjust
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.material.icons.filled.Print
import androidx.compose.material.icons.filled.QrCode2
import androidx.compose.material.icons.filled.RocketLaunch
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Stars
import androidx.compose.material.icons.filled.SupportAgent
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material.icons.filled.Tv
import androidx.compose.material.icons.filled.Wifi
import androidx.compose.material.icons.outlined.PhoneIphone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oiatelecoms.R
import com.example.oiatelecoms.adsPackage.AdsRow
import com.example.oiatelecoms.ui.theme.OIATELECOMSTheme
import com.example.oiatelecoms.ui.theme.useAnotherColor

@Composable
fun HomePage(
    modifier: Modifier = Modifier,
    currentBalance: String,
    onAirtimeClicked: () -> Unit,
    onDataClicked: () -> Unit,
    onCableTVClicked: () -> Unit,
    onElectricityClicked: () -> Unit,
    onExamPinsClicked: () -> Unit,
    onDataPinsClicked: () -> Unit,
    onCardPinClicked:() -> Unit,
    onAlphaTopClicked: () -> Unit
){
    var showBalance: Boolean by remember { mutableStateOf(false) }
    val commission = 0
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(2.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Card(
            modifier = modifier
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(20.dp),
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary)
        ) {
            Column(
                modifier = modifier.padding(10.dp)
            ) {
                Text(
                    text = "Available Balance",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                    )
                Spacer(modifier = modifier.height(10.dp))
                Row(
                    modifier = modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    //horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        modifier = modifier.width(150.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (showBalance){
                            Text(
                                text = "₦ $currentBalance",
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }else{
                            Text(
                                text = "₦ ***",
                                color = Color.White,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                        IconButton(onClick = { showBalance = !showBalance }) {
                            if (showBalance){
                                Icon(
                                    painter = painterResource(id = R.drawable.baseline_visibility_24),
                                    contentDescription = null,
                                    tint = Color.White
                                )
                            }else{
                                Icon(
                                    painter = painterResource(id = R.drawable.baseline_visibility_off_24),
                                    contentDescription = null,
                                    tint = Color.White
                                )
                            }
                        }
                    }
                    Spacer(modifier = modifier.width(100.dp))
                    Text(
                        text = "9 Payments Service",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.White
                    )
                }
                Row(
                    modifier = modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Commission: $commission ",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    IconButton(onClick = { /*TODO*/ }) {
                       Icon(
                           painter = painterResource(id = R.drawable.round_content_copy_24),
                           contentDescription = "copy account number",
                           tint = Color.White
                       )
                    }
                }
                Row(
                    modifier = modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    OutlinedButton(
                        onClick = { /*TODO*/ },
                        border = BorderStroke(2.dp, Color.White),
                        modifier = modifier.size(135.dp, 40.dp)
                    ){
                        Row(
                            modifier = modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Add,
                                contentDescription = null,
                                tint = Color.White
                                )
                            Text(
                                text = "Add Money",
                                color = Color.White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                                )
                        }
                    }
                    OutlinedButton(
                        onClick = { /*TODO*/ },
                        border = BorderStroke(2.dp, Color.White),
                        modifier = modifier.size(115.dp, 40.dp)
                        ) {
                        Row(
                            modifier = modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_groups_24),
                                contentDescription = null,
                                tint = Color.White
                            )
                            Text(
                                text = "Transfer",
                                color = Color.White,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold
                                )
                        }
                    }
                    OutlinedButton(
                        onClick = { /*TODO*/ },
                        border = BorderStroke(2.dp, Color.White),
                        modifier = modifier.size(135.dp, 40.dp)

                        ) {
                        Row(
                            modifier = modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_groups_24),
                                contentDescription = null,
                                tint = Color.White,
                                
                            )
                            Text(
                                text = "Referrals",
                                color = Color.White,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold
                                )
                        }
                    }
                }
            }

        }
        Spacer(modifier = modifier.height(15.dp))
        Card(
            elevation = CardDefaults.cardElevation(20.dp),
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer)
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(4.dp),
            ) {
                // first icon on row 1
                Row(
                    modifier = modifier
                        .padding(start = 20.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = modifier,
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OutlinedIconButton(
                            onClick = onAirtimeClicked,
                            modifier = modifier.size(60.dp),
                            border = BorderStroke(width = 2.dp, color = useAnotherColor)
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.PhoneIphone,
                                contentDescription = "Buy Airtime",
                                modifier = modifier
                                    .size(45.dp)
                                    .padding(4.dp),
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                        Text(
                            text = "Airtime",
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Column(
                        modifier = modifier,
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OutlinedIconButton(
                            onClick = onDataClicked,
                            modifier = modifier.size(60.dp),
                            border = BorderStroke(width = 2.dp, color = useAnotherColor)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Wifi,
                                contentDescription = "Buy Data",
                                modifier = modifier
                                    .size(45.dp)
                                    .padding(4.dp),
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                        Text(
                            text = "Data",
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Column(
                        modifier = modifier,
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OutlinedIconButton(
                            onClick = onCableTVClicked,
                            modifier = modifier.size(60.dp),
                            border = BorderStroke(width = 2.dp, color = useAnotherColor)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Tv,
                                contentDescription = "Cable TV",
                                modifier = modifier
                                    .size(45.dp)
                                    .padding(4.dp),
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                        Text(
                            text = "Cable TV",
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Column(
                        modifier = modifier,
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OutlinedIconButton(
                            onClick = onElectricityClicked,
                            modifier = modifier.size(60.dp),
                            border = BorderStroke(width = 2.dp, color = useAnotherColor)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Bolt,
                                contentDescription = "Buy Electricity",
                                modifier = modifier
                                    .size(45.dp)
                                    .padding(4.dp),
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                        Text(
                            text = "Electricity",
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
                Spacer(modifier = modifier.height(20.dp))
                // Row two
                Row(
                    modifier = modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = modifier,
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OutlinedIconButton(
                            onClick = onExamPinsClicked,
                            modifier = modifier.size(60.dp),
                            border = BorderStroke(width = 2.dp, color = useAnotherColor)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.School,
                                contentDescription = "Education pins",
                                modifier = modifier
                                    .size(45.dp)
                                    .padding(4.dp),
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                        Text(
                            text = "Exam Pins",
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Column(
                        modifier = modifier,
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OutlinedIconButton(
                            onClick = onDataPinsClicked,
                            modifier = modifier.size(60.dp),
                            border = BorderStroke(width = 2.dp, color = useAnotherColor)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.QrCode2,
                                contentDescription = "Data pins",
                                modifier = modifier
                                    .size(45.dp)
                                    .padding(4.dp),
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                        Text(
                            text = "Data Pins",
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Column(
                        modifier = modifier,
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OutlinedIconButton(
                            onClick = onCardPinClicked,
                            modifier = modifier.size(60.dp),
                            border = BorderStroke(width = 2.dp, color = useAnotherColor)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Print,
                                contentDescription = "Card Print",
                                modifier = modifier
                                    .size(45.dp)
                                    .padding(4.dp),
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                        Text(
                            text = "Card Print",
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Column(
                        modifier = modifier,
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OutlinedIconButton(
                            onClick = { /*TODO*/ },
                            modifier = modifier.size(60.dp),
                            border = BorderStroke(width = 2.dp, color = useAnotherColor)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.RocketLaunch,
                                contentDescription = "Our App",
                                modifier = modifier
                                    .size(45.dp)
                                    .padding(4.dp),
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                        Text(
                            text = "Our App",
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
                Spacer(modifier = modifier.height(20.dp))
                // Row 3
                Row(
                    modifier = modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = modifier,
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OutlinedIconButton(
                            onClick = onAlphaTopClicked,
                            modifier = modifier.size(60.dp),
                            border = BorderStroke(width = 2.dp, color = useAnotherColor)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Adjust,
                                contentDescription = "Alpha Top",
                                modifier = modifier
                                    .size(45.dp)
                                    .padding(4.dp),
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                        Text(
                            text = "Alpha Top",
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Column(
                        modifier = modifier,
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OutlinedIconButton(
                            onClick = { /*TODO*/ },
                            modifier = modifier.size(60.dp),
                            border = BorderStroke(width = 2.dp, color = useAnotherColor)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.CreditCard,
                                contentDescription = "Credit Card",
                                modifier = modifier
                                    .size(45.dp)
                                    .padding(4.dp),
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                        Text(
                            text = "Card",
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Column(
                        modifier = modifier,
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OutlinedIconButton(
                            onClick = { /*TODO*/ },
                            modifier = modifier.size(60.dp),
                            border = BorderStroke(width = 2.dp, color = useAnotherColor)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.SwapHoriz,
                                contentDescription = "Air2Cash",
                                modifier = modifier
                                    .size(45.dp)
                                    .padding(4.dp),
                                tint =MaterialTheme.colorScheme.primary
                            )
                        }
                        Text(
                            text = "Air2Cash",
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Column(
                        modifier = modifier,
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OutlinedIconButton(
                            onClick = { /*TODO*/ },
                            modifier = modifier.size(60.dp),
                            border = BorderStroke(width = 2.dp, color = useAnotherColor)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.SupportAgent,
                                contentDescription = "Agent",
                                modifier = modifier
                                    .size(45.dp)
                                    .padding(4.dp),
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                        Text(
                            text = "Agent",
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
                Spacer(modifier = modifier.height(20.dp))
                //Row 4
                Row(
                    modifier = modifier
                        .padding(4.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = modifier,
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OutlinedIconButton(
                            onClick = { /*TODO*/ },
                            modifier = modifier.size(60.dp),
                            border = BorderStroke(width = 2.dp, color = useAnotherColor)
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.List,
                                contentDescription = "Price List",
                                modifier = modifier
                                    .size(45.dp)
                                    .padding(4.dp),
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                        Text(
                            text = "Price List",
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Column(
                        modifier = modifier,
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OutlinedIconButton(
                            onClick = { /*TODO*/ },
                            modifier = modifier.size(60.dp),
                            border = BorderStroke(width = 2.dp, color = useAnotherColor)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Code,
                                contentDescription = "API DOC",
                                modifier = modifier
                                    .size(45.dp)
                                    .padding(4.dp),
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                        Text(
                            text = "API DOC",
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Column(
                        modifier = modifier,
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OutlinedIconButton(
                            onClick = { /*TODO*/ },
                            modifier = modifier.size(60.dp),
                            border = BorderStroke(width = 2.dp, color = useAnotherColor)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Stars,
                                contentDescription = "Status",
                                modifier = modifier
                                    .size(45.dp)
                                    .padding(4.dp),
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                        Text(
                            text = "Status",
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                    Column(
                        modifier = modifier,
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        OutlinedIconButton(
                            onClick = { /*TODO*/ },
                            modifier = modifier.size(60.dp),
                            border = BorderStroke(width = 2.dp, color = useAnotherColor)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.CheckCircle,
                                contentDescription = "Own VTU",
                                modifier = modifier
                                    .size(45.dp)
                                    .padding(4.dp),
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                        Text(
                            text = "Own VTU",
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }

            }
        }
        Spacer(modifier = modifier.height(10.dp))
        AdsRow(onFirstCardClicked = { /*TODO*/ }, onSecondCardClicked = { /*TODO*/ }, onThirdCardClicked = {})
    }
}


@Preview(showBackground = true)
@Composable
fun ShowHome(){
    OIATELECOMSTheme {
        HomePage(
            currentBalance = "700000",
            onAirtimeClicked = {},
            onDataClicked = {},
            onElectricityClicked = {},
            onCableTVClicked = {},
            onExamPinsClicked = {},
            onDataPinsClicked = {},
            onCardPinClicked = {},
            onAlphaTopClicked = {}
        )
    }
}