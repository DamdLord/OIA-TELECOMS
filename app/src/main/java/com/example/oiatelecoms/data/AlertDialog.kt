package com.example.oiatelecoms.data

import android.app.AlertDialog
import android.view.KeyEvent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.oiatelecoms.OIAViewModel
import com.example.oiatelecoms.R
import com.example.oiatelecoms.ui.theme.OIATELECOMSTheme
import com.example.oiatelecoms.ui.theme.lightUseAnotherColor
import com.example.oiatelecoms.ui.theme.useAnotherColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AirtimeAlertDialog(
    modifier: Modifier = Modifier,
    onYesOnAlertDialogClicked: () -> Unit,
    onNoOnAlertDialogClicked: () -> Unit,
    onDismissRequest: () -> Unit,
    appViewModel: OIAViewModel
){
    AlertDialog(onDismissRequest = onDismissRequest) {
        Card( modifier = modifier.fillMaxWidth()) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.infoicon),
                    contentDescription = null,
                    modifier = modifier
                        .clip(CircleShape)
                        .size(90.dp)
                )
                Spacer(modifier = modifier.height(5.dp))
                Text(
                    text = "Are you sure?",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = modifier.height(5.dp))
                if (appViewModel.isCurrentTransactionAirtimePurchase) {
                    Text(
                        text = "You are about to purchase ${appViewModel.netWorkUserIsBuying} airtime of ${appViewModel.amountUserWantsToBuy} for the phone number ${appViewModel.numberToBuyCardOrDataFor}. Do you wish to continue?",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        modifier = modifier
                            .padding(2.dp)
                            .width(255.dp)
                    )
                }
                if (appViewModel.isCurrentTransactionDataPurchase){
                    Text(
                        text = "You are about to purchase ${appViewModel.netWorkUserIsBuying} data of ${appViewModel.dataPlanUserWantsToBuy} for the phone number ${appViewModel.numberToBuyCardOrDataFor}. Do you wish to continue?",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        modifier = modifier
                            .padding(2.dp)
                            .width(255.dp)
                    )
                }
                Spacer(modifier = modifier.height(10.dp))
                Row(
                    modifier = modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    OutlinedButton(
                        onClick =onNoOnAlertDialogClicked,
                        border = BorderStroke(width = 1.dp, color = Color.Red),
                        shape = RoundedCornerShape(8.dp),
                        modifier = modifier.size(width = 90.dp, height = 55.dp)
                    ) {
                        Text(text = "No")
                    }
                    OutlinedButton(
                        onClick =  onYesOnAlertDialogClicked ,
                        border = BorderStroke(width = 1.dp, color = Color.Green),
                        shape = RoundedCornerShape(8.dp),
                        modifier = modifier.size(width = 90.dp, height = 55.dp)
                    ) {
                        Text(text = "Yes")
                    }
                }

            }
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginSuccessful(modifier: Modifier= Modifier, onDismissRequest: () -> Unit){
    AlertDialog(onDismissRequest = onDismissRequest) {
        Card(
            modifier = modifier.fillMaxWidth()
        ) {
            Column(
                modifier = modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(imageVector = Icons.Filled.CheckCircle, contentDescription = null, tint = Color.Green, modifier = modifier.size(60.dp))
                Text("Login Successful")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginUnSuccessful(modifier: Modifier= Modifier, onDismissRequest: () -> Unit){
    AlertDialog(onDismissRequest = onDismissRequest) {
        Card(
            modifier = modifier.fillMaxWidth()
        ) {
            Column(
                modifier = modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(imageVector = Icons.Filled.Cancel, contentDescription = null, tint = Color.Red, modifier = modifier.size(60.dp))
                Text("Login Unsuccessful")
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfirmToLeavePayment(
    modifier: Modifier = Modifier,
    onLeaveClicked:()-> Unit,
    onDismissRequest: () -> Unit,
    onContinueClicked:()-> Unit
){
    AlertDialog(onDismissRequest = onDismissRequest) {
        Card(
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Payment is not yet complete",
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.padding(2.dp)
                )
                Text(
                    text = "Are you confirmed to leave?",
                    fontSize = 13.sp,
                    modifier = modifier.padding(2.dp)
                )
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Button(
                        onClick =onLeaveClicked,
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(lightUseAnotherColor),
                        modifier = modifier.size(width = 120.dp, height = 41.dp)
                    ) {
                        Text(text = "Leave")
                    }
                    Button(
                        onClick = onContinueClicked,
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(useAnotherColor),
                        modifier = modifier.size(width = 120.dp, height = 41.dp)
                    ) {
                        Text(text = "Continue")
                    }
                }
            }
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputPinCard(
    modifier: Modifier = Modifier,
    amount:String,
    onPinComplete: (String) -> Unit,
    onCancelPaymentClicked:  () -> Unit,
    onDismissRequest: () -> Unit
){
    AlertDialog(onDismissRequest = onDismissRequest) {
        Card(
            modifier = modifier
                .padding(4.dp)

                .fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(Color.DarkGray)
        ) {
            Column(
                modifier = modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "PIN Verification",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Spacer(modifier = modifier.width(18.dp))
                    IconButton(onClick = onCancelPaymentClicked ) {
                        Icon(
                            imageVector = Icons.Default.Cancel,
                            contentDescription = "Cancel Payment",
                            tint = Color.Gray,
                            modifier = modifier.size(35.dp)
                        )
                    }
                }
                Spacer(modifier = modifier.height(15.dp))
                Text(
                    text = "₦${amount}",
                    fontSize = 33.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = modifier.height(10.dp))
                ThirdPinInputField(onPinComplete = onPinComplete)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordVerificationFailedDialog(
    modifier: Modifier = Modifier,
    onForgotPinClicked:() -> Unit,
    onRetryClicked:() -> Unit
){
    AlertDialog(onDismissRequest = {}) {
        Card(
            modifier = modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "FAILED",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier.padding(2.dp)
                )
                Text(
                    text = "Incorrect PIN entered. You have 1 more attempts remaining before your accounts gets locked for 2 hours. If you have forgotten your PIN, click 'Forgot PIN'",
                    fontSize = 13.sp,
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .padding(2.dp)
                        .width(255.dp)
                )
                Spacer(modifier = modifier.height(5.dp))
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(4.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Button(
                        onClick = onForgotPinClicked,
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(lightUseAnotherColor),
                        modifier = modifier.size(width = 120.dp, height = 41.dp)
                    ) {
                        Text(text = "Forgot PIN")
                    }
                    Button(
                        onClick = onRetryClicked,
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(useAnotherColor),
                        modifier = modifier.size(width = 120.dp, height = 41.dp)
                    ) {
                        Text(text = "Retry")
                    }
                }
            }
        }
    }
}


@Composable
fun PinInputField(
    modifier: Modifier = Modifier,
    pinLength: Int = 4,
    onPinComplete: (String) -> Unit,
) {
    var pinValues = remember { mutableStateListOf("", "", "", "") }
    var focusedIndex by remember { mutableIntStateOf(0) }

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        for (index in 0 until pinLength) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(50.dp)
                    .border(
                        width = 2.dp,
                        color = if (focusedIndex == index && pinValues[index].isNotEmpty()) Color.Blue else Color.Gray,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .clickable { focusedIndex = index }
            ) {
                Text(
                    text = pinValues[index],
                    style = MaterialTheme.typography.bodySmall,
                    textAlign = TextAlign.Center
                )
            }
        }
    }

    // Handle keyboard input
    DisposableEffect(Unit) {
        val keyboardCallback = object : androidx.activity.OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // This prevents default backspace handling
            }
        }
        val keyListener = object : KeyEvent.Callback {
            override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
                if (keyCode in KeyEvent.KEYCODE_0..KeyEvent.KEYCODE_9 && focusedIndex < pinLength) {
                    val digit = (keyCode - KeyEvent.KEYCODE_0).toString()
                    pinValues[focusedIndex] = digit
                    focusedIndex++
                    if (focusedIndex == pinLength) {
                        onPinComplete(pinValues.joinToString(""))
                    }
                } else if (keyCode == KeyEvent.KEYCODE_DEL && focusedIndex > 0) {
                    focusedIndex--
                    pinValues[focusedIndex] = ""
                }
                return true
            }

            override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
                return true
            }

            override fun onKeyMultiple(keyCode: Int, repeatCount: Int, event: KeyEvent?): Boolean {
                return true
            }

            override fun onKeyLongPress(keyCode: Int, event: KeyEvent): Boolean {
                return false
            }
        }

        // You might want to integrate key listener here!

        onDispose { /* Remove any listeners if required */ }
    }
}

@Composable
fun ThirdPinInputField(
    modifier: Modifier = Modifier,
    pinLength: Int = 4,
    onPinComplete: (String) -> Unit,
) {
    var pin by remember { mutableStateOf("") }

    // FocusRequester to request focus programmatically
    val focusRequester = remember { FocusRequester() }

    // PIN input row with clickable overlay
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { focusRequester.requestFocus() }, // Clicking the row focuses the TextField
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Create individual boxes for each PIN digit
            repeat(pinLength) { index ->
                val digit = pin.getOrNull(index)?.toString() ?: ""
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .border(
                            width = 2.dp,
                            color = if (digit.isNotEmpty()) Color.Blue else Color.Gray,
                            shape = RoundedCornerShape(8.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = digit,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White
                    )
                }
            }
        }

        // Invisible TextField overlays the row
        BasicTextField(
            value = pin,
            onValueChange = { input ->
                if (input.length <= pinLength && input.all { it.isDigit() }) {
                    pin = input
                    if (input.length == pinLength) {
                        onPinComplete(input)
                    }
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .matchParentSize() // Covers the entire row
                .focusRequester(focusRequester)
                .alpha(0f) // Makes it invisible
        )
    }

    // Automatically bring up the keyboard when the composable loads
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}


@Composable
fun SecondPinInputField(
    modifier: Modifier = Modifier,
    pinLength: Int = 4,
    onPinComplete: (String) -> Unit,
) {
    var pin by remember { mutableStateOf("") }

    // Focus Manager for seamless input
    val focusManager = LocalFocusManager.current

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 20.dp)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Create individual boxes for each PIN digit
        repeat(pinLength) { index ->
            val digit = pin.getOrNull(index)?.toString() ?: ""
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .border(
                        width = 2.dp,
                        color = if (digit.isNotEmpty()) Color.Blue else Color.Gray,
                        shape = RoundedCornerShape(8.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = digit,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White
                )
            }
        }
    }

    // Invisible TextField to capture the PIN input
    BasicTextField(
        value = pin,
        onValueChange = { input ->
            pin = input
            // Allow only digits and ensure it doesn't exceed the PIN length
            if (input.length <= pinLength && input.all { it.isDigit() }) {
                if (input.length == pinLength) {
                    // Call onPinComplete when PIN input is finished
                    onPinComplete(input)
                    focusManager.clearFocus() // Dismiss the keyboard
                }
                else{
                    pin = input
                }
            }
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
        modifier = Modifier
            .focusable(true)
            .size(0.dp) // Hidden size
    )

    // Automatically request focus and show the keyboard

}


@Preview
@Composable
fun AirtimeAlertDialogPreview(){
    val apple:OIAViewModel = viewModel()
    OIATELECOMSTheme {
        AirtimeAlertDialog(
            onYesOnAlertDialogClicked = {},
            onNoOnAlertDialogClicked = {},
            onDismissRequest = {},
            appViewModel = apple
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SecondPinInputFieldPreview(){
    OIATELECOMSTheme {
       PasswordVerificationFailedDialog(onForgotPinClicked = { /*TODO*/ }, onRetryClicked = {})
    }
}
@Preview
@Composable
fun CanvasPreview(){
    OIATELECOMSTheme {
        InputPinCard(amount = "700,000", onPinComplete = {}, onCancelPaymentClicked = {}, onDismissRequest = {})
    }
}