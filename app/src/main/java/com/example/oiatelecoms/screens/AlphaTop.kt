package com.example.oiatelecoms.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.oiatelecoms.R
import com.example.oiatelecoms.data.NetworkList
import com.example.oiatelecoms.ui.theme.OIATELECOMSTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlphaTopPage(
    modifier: Modifier = Modifier
){
    var isSelectAmountDropdownExpanded by remember { mutableStateOf(false) }
    var selectedAmount by remember { mutableStateOf("Select Amount") }
    val listOfAmount = listOf("")
    var phoneNumber by remember { mutableStateOf("") }
    var amountToPay by remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(4.dp),
        //verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Alpha Technologies",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
            )
        Spacer(modifier = modifier.height(10.dp))
        Card(
            modifier = modifier.height(200.dp).fillMaxWidth()
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQf7O-1nWYlUqApQVTgK7BRGQevfhjSHJBpog&s")
                    .crossfade(true)
                    .build(),
                contentDescription = "",
                error = painterResource(id = R.drawable.errorimage),
                placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Crop,
                modifier = modifier.fillMaxSize()
            )
        }
        Spacer(modifier = modifier.height(10.dp))
        ExposedDropdownMenuBox(
            expanded = isSelectAmountDropdownExpanded,
            onExpandedChange = {isSelectAmountDropdownExpanded = !isSelectAmountDropdownExpanded}
        ) {
            OutlinedTextField(
                value = selectedAmount,
                onValueChange = {},
                readOnly = true,
                label = {  },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded =isSelectAmountDropdownExpanded)
                },
                modifier = modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )

            ExposedDropdownMenu(
                expanded =isSelectAmountDropdownExpanded,
                onDismissRequest = { isSelectAmountDropdownExpanded = false }
            ) {
                listOfAmount.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selectedAmount= option
                            isSelectAmountDropdownExpanded = false
                        }
                    )
                }
            }
        }
        Spacer(modifier = modifier.height(10.dp))
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it},
            label = { Text(text = "Phone number")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier = modifier.height(10.dp))
        OutlinedTextField(
            value = amountToPay,
            onValueChange = { },
            label = { Text(text = "Amount to pay")},
            readOnly = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
            modifier = modifier.fillMaxWidth()
        )
        Spacer(modifier = modifier.height(10.dp))
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.primary),
            modifier = modifier.fillMaxWidth(),
            shape = RectangleShape
        ) {
            Text(
                text = "Send Order",
                fontSize = 20.sp
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ShowAlphaTop(){
    OIATELECOMSTheme {
        AlphaTopPage()
    }
}