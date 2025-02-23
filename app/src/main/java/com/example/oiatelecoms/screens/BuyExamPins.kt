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
import com.example.oiatelecoms.data.ExamType
import com.example.oiatelecoms.ui.theme.OIATELECOMSTheme
import com.example.oiatelecoms.ui.theme.useAnotherColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuyExamPins(
    modifier: Modifier = Modifier
){
    val examTypeList = ExamType.examTypeList
    var isExamTypeDropdownExanped by remember { mutableStateOf(false) }
    var selectedExamType by remember { mutableStateOf(examTypeList[0]) }
    var quantity by remember { mutableStateOf("") }
    var amountToPay = when {
        quantity.isEmpty() -> ""
        quantity.toDoubleOrNull() == null -> "Invalid quantity"
        else -> {
            val qualityToDouble = quantity.toDouble()
            when (selectedExamType) {
                examTypeList[1] -> (qualityToDouble * 2050).toString()
                examTypeList[2] -> (qualityToDouble * 900).toString()
                examTypeList[3] -> (qualityToDouble * 800).toString()
                else -> ""
            }
        }
    }

    Surface(
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(4.dp),
            //verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Exam Checker",
                color = Color.Blue,
                fontWeight = FontWeight.SemiBold,
                fontSize = 30.sp,
                modifier = modifier.padding(4.dp)
            )
            Spacer(modifier = modifier.height(10.dp))
            Text(
                text = "Exam Pins",
                fontWeight = FontWeight.SemiBold,
                fontSize = 25.sp,
                modifier = modifier.padding(4.dp)
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
                                selectedExamType = examTypeList[1]
                                quantity = ""
                                amountToPay = ""
                            },
                            modifier = modifier.size(80.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.waeclogo),
                                contentDescription = "WAEC",
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
                                selectedExamType = examTypeList[2]
                                quantity = ""
                                amountToPay = ""
                            },
                            modifier = modifier.size(70.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.necologo),
                                contentDescription = "NECO",
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
                                selectedExamType = examTypeList[3]
                                quantity = ""
                                amountToPay = ""
                            },
                            modifier = modifier.size(70.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.nabteblogo),
                                contentDescription = "Star times",
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
                expanded = isExamTypeDropdownExanped,
                onExpandedChange = { isExamTypeDropdownExanped = !isExamTypeDropdownExanped }
            ) {
                OutlinedTextField(
                    value = selectedExamType,
                    onValueChange = {},
                    readOnly = true,
                    label = { },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExamTypeDropdownExanped)
                    },
                    modifier = modifier
                        .fillMaxWidth()
                        .menuAnchor()
                )

                ExposedDropdownMenu(
                    expanded = isExamTypeDropdownExanped,
                    onDismissRequest = { isExamTypeDropdownExanped = false }
                ) {
                    examTypeList.forEach { option ->
                        DropdownMenuItem(
                            text = { Text(option) },
                            onClick = {
                                selectedExamType = option
                                isExamTypeDropdownExanped = false
                            }
                        )
                    }
                }
            }
            Spacer(modifier = modifier.height(15.dp))
            OutlinedTextField(
                value = quantity,
                onValueChange = { quantity = it },
                label = { Text(text = "Quantity") },
                shape = RoundedCornerShape(15.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                modifier = modifier.fillMaxWidth()
            )
            Spacer(modifier = modifier.height(15.dp))
            OutlinedTextField(
                value = amountToPay,
                onValueChange = { },
                label = {
                    Text(text = "Amount to pay")
                },
                readOnly = true,
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
                    text = "Continue",
                    fontSize = 20.sp,
                    color = Color.White
                    )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowBigIdi(){
    OIATELECOMSTheme {
        BuyExamPins()
    }
}