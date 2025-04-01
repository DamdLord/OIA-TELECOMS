package com.example.oiatelecoms

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update


data class UiState(
    var currentPhoneNumber:String = "",
    var currentPassword:String = "",
    var currentScreen:Routes = Routes.HOME,
)

enum class Routes(val title :String){
    HOME("Home"),  HISTORY("History"), SPLASH_SCREEN("Splash Screen"),
    PROFILE("Profile"), LOGIN("Login"),
    REGISTER("Register"), SIGNUP("SignUp"),
    RECOVER_PASSWORD("Recover"), BUY_DATA("Buy Data"),
    BUY_AIRTIME("Buy Airtime"), CABLE_TV("Cable TV"), SECOND_REGISTER("Second Register"),
    Buy_Electricity("Buy Electricity"), BUY_EXAM_PINS("Buy Exam Pins"), BUY_DATA_PINS("Buy Data Pins"),
    BUY_RECHARGE_PINS("Buy Recharge Pin"), ALPHA_TOP("Alpha Tech"), RECEIPT_SCREEN("Receipt Screen")
}
class OIAViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState

    var isCurrentTransactionAirtimePurchase by mutableStateOf(false)
    var isCurrentTransactionDataPurchase by mutableStateOf(false)
    var isCurrentTransactionCableTvPurchase by mutableStateOf(false)
    var isCurrentTransactionElectricityPurchase by mutableStateOf(false)

    var userBalance by mutableStateOf("10000")
        private set

    var dataTypeUserWantsToBuy by mutableStateOf("")
        private set

    var dataPlanUserWantsToBuy by mutableStateOf("")
        private set

    var numberToBuyCardOrDataFor by mutableStateOf("")
        private set

    var validatedNetwork by mutableStateOf("")
        private  set


    var amountUserWantsToBuy by mutableStateOf("")
        private set


    var netWorkUserIsBuying by mutableStateOf("")
        private set

    var userPin by mutableStateOf("1123")
        private set

    var amountUserWillPay by mutableStateOf("")
        private set


    fun networkValidation(number: String){
        if (number.startsWith("0702") || number.startsWith("0704") ||
            number.startsWith("0803") || number.startsWith("0806") ||
            number.startsWith("0703") || number.startsWith("0706") ||
            number.startsWith("0813") || number.startsWith("0816") ||
            number.startsWith("0810") || number.startsWith("0814") ||
            number.startsWith("0903") || number.startsWith("0906") ||
            number.startsWith("0913") && number.length >= 5
            ){
            validatedNetwork = "MTN"
        }
        else if (
            number.startsWith("0805") || number.startsWith("0807") ||
            number.startsWith("0705") || number.startsWith("0815") ||
            number.startsWith("0811") || number.startsWith("0905") && number.length >= 5
            ){
            validatedNetwork = "GLO"
        }
        else if (
            number.startsWith("0802") || number.startsWith("0808") ||
            number.startsWith("0708") || number.startsWith("0812") ||
            number.startsWith("0701") || number.startsWith("0901") ||
            number.startsWith("0902") || number.startsWith("0907") ||
            number.startsWith("0912") && number.length >= 5
            ){
             validatedNetwork = "AIRTEL"
        }
        else if (
            number.startsWith("0809") ||  number.startsWith("0818") ||
            number.startsWith("0817") || number.startsWith("0908") ||
            number.startsWith("0909") && number.length >= 5
        ){
            validatedNetwork = "9 MOBILE"
        }
        else if (
            number.startsWith("0804") && number.length >= 5
        ){
            validatedNetwork = "NTEL"
        }
        else{
            validatedNetwork = "Unable to identify network!!"
        }


    }
    fun updateAmountIWantToBuy(amount: String){
        amountUserWantsToBuy = amount

    }
    fun updateNetworkUserWantsToBuy(network: String){
        netWorkUserIsBuying = network
    }
    fun updateDataType(dataType: String){
        dataTypeUserWantsToBuy = dataType
    }
    fun updateDataPlan(dataPlan: String){
        dataPlanUserWantsToBuy = dataPlan

    }
    fun updateNumberToBuyCardOrDataFor(number: String){
        numberToBuyCardOrDataFor = number
    }
    fun verifyUserPin(imputedPin: String): Boolean{
        val verification: Boolean = userPin == imputedPin
        return verification
    }

    fun updateAmountUserWillPayForData(amount: String){
        amountUserWillPay = amount
    }

    fun updateAmountUserWillPay(amount: String){
        try {
            // Parse the input to a double, ensuring it is a valid numeric value
            val numericAmount = amount.toDoubleOrNull()

            if (numericAmount != null && numericAmount >= 0) {
                // Subtract 1% of the amount
                val calculatedAmountToPay = numericAmount - (numericAmount * 0.01)
                amountUserWillPay = calculatedAmountToPay.toString()
            } else {
                // Handle invalid or negative input gracefully
                amountUserWillPay = "0.00" // Default or fallback value
            }
        } catch (e: Exception) {
            // Catch any unforeseen errors and provide a fallback value
            amountUserWillPay = "0.00"
        }
    }
    fun updateUserBalance(imputedPin: String){
        val currentUserBalance  = userBalance.toDouble()
        val amountToDeduct = amountUserWillPay.toDouble()
        if (verifyUserPin(imputedPin)) {
           userBalance =  (currentUserBalance - amountToDeduct).toString()
        }
    }


    fun updateCurrentScreen(routes: Routes){
        _uiState.update {
            it.copy(
                currentScreen = routes
            )
        }
    }

    fun updateCurrentPhoneNumber(firstName: String){
        _uiState.update {
            it.copy(
                currentPhoneNumber =  firstName
            )
        }
    }
    fun updateCurrentPassword(password: String){
        _uiState.update {
            it.copy( currentPassword = password)
        }
    }

}