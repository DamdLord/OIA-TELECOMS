package com.example.oiatelecoms.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.oiatelecoms.OIAViewModel
import com.example.oiatelecoms.R
import com.example.oiatelecoms.data.NetworkList
import com.example.oiatelecoms.ui.theme.OIATELECOMSTheme

@Composable
fun ReceiptScreen(
    modifier: Modifier = Modifier,
    appOIAViewModel: OIAViewModel
){
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(4.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Receipt",
            fontSize = 25.sp
        )
        Spacer(modifier = modifier.height(10.dp))
        Card(
            modifier = modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(20.dp),
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer),
            shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp, bottomStart = 0.dp, bottomEnd = 0.dp)
        ) {
            Column(
                modifier = modifier.padding(4.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = when(appOIAViewModel.netWorkUserIsBuying){
                        NetworkList.networkList[1] -> painterResource(id = R.drawable.mtn_logo)
                        NetworkList.networkList[2] -> painterResource(id = R.drawable.airtel_logo)
                        NetworkList.networkList[3] -> painterResource(id = R.drawable._mobile_logo)
                        NetworkList.networkList[4] -> painterResource(id = R.drawable.glo_logo)
                        else -> painterResource(id = R.drawable.placeholder)
                    },
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .clip(CircleShape)
                        .size(65.dp)
                )
                Text(
                    text = appOIAViewModel.netWorkUserIsBuying,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "₦${appOIAViewModel.amountUserWantsToBuy}",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = modifier.height(10.dp))
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Order Amount",
                        fontSize = 16.sp
                    )
                    Text(
                        text = "₦${appOIAViewModel.amountUserWantsToBuy}",
                        fontSize = 18.sp
                    )
                }
                Spacer(modifier = modifier.height(10.dp))
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Payment Amount",
                        fontSize = 18.sp

                    )
                    Text(
                        text = "₦${appOIAViewModel.amountUserWillPay}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
            }
            Spacer(modifier = modifier.height(5.dp))
        }
        Spacer(modifier = modifier.height(15.dp))
        Card(
            modifier = modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(20.dp),
            colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer),
            shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 20.dp, bottomEnd = 20.dp)
        ) {
            Column(
                modifier = modifier.padding(4.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = modifier.height(15.dp))
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Recipient Mobile",
                        fontSize = 18.sp
                    )
                    Text(
                        text = appOIAViewModel.numberToBuyCardOrDataFor,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }
                Spacer(modifier = modifier.height(10.dp))
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Transaction Type",
                        fontSize = 18.sp
                    )
                    if (appOIAViewModel.isCurrentTransactionAirtimePurchase) {
                        Text(
                            text = "Top up Airtime",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }
                    if (appOIAViewModel.isCurrentTransactionDataPurchase){
                        Text(
                            text = "Data Bundle Purchase",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }
                }
                if (appOIAViewModel.isCurrentTransactionDataPurchase){
                    Spacer(modifier = modifier.height(10.dp))
                    Column(
                        modifier = modifier.fillMaxWidth()
                    ) {
                        Row(
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(4.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Data Type",
                                fontSize = 18.sp
                            )
                            Text(
                                text = appOIAViewModel.dataTypeUserWantsToBuy,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                        }
                        Row(
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(4.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Data Plan",
                                fontSize = 18.sp
                            )
                            Text(
                                text = appOIAViewModel.dataPlanUserWantsToBuy,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )
                        }
                    }
                }
                Row {
                    Text("")
                    Text("")
                }
                Spacer(modifier = modifier.height(5.dp))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ShowReceiptScreen(){
    val appViewModel: OIAViewModel = viewModel()
    OIATELECOMSTheme {
        ReceiptScreen(appOIAViewModel = appViewModel)
    }
}