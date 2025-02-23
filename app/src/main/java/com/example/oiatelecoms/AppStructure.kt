package com.example.oiatelecoms

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.oiatelecoms.screens.BuyAirTimePage
import com.example.oiatelecoms.screens.BuyDataPage
import com.example.oiatelecoms.screens.BuyDataPins
import com.example.oiatelecoms.screens.BuyElectricityScreen
import com.example.oiatelecoms.screens.BuyExamPins
import com.example.oiatelecoms.screens.BuyRechargePins
import com.example.oiatelecoms.screens.CableTVPage
import com.example.oiatelecoms.screens.HistoryPage
import com.example.oiatelecoms.screens.HomePage
import com.example.oiatelecoms.screens.LoginPage
import com.example.oiatelecoms.screens.ProfilePage
import com.example.oiatelecoms.screens.RecoverPasswordPage
import com.example.oiatelecoms.screens.RegisterPage
import com.example.oiatelecoms.screens.SecondRegisterPage
import com.example.oiatelecoms.screens.SignUpPage
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.oiatelecoms.data.AirtimeAlertDialog
import com.example.oiatelecoms.data.ConfirmToLeavePayment
import com.example.oiatelecoms.data.InputPinCard
import com.example.oiatelecoms.data.PasswordVerificationFailedDialog
import com.example.oiatelecoms.screens.AlphaTopPage
import com.example.oiatelecoms.screens.ReceiptScreen

@Composable
fun MainApp(
    modifier: Modifier = Modifier
){
    var showLeaveOrContinueDialog  by remember { mutableStateOf(false) }
    var showPinVerification  by remember { mutableStateOf(false) }
    var showDialog  by remember { mutableStateOf(false) }
    var showDialogIfPasswordIsWrong  by remember { mutableStateOf(false) }
    val appViewModel : OIAViewModel = viewModel()
    val navController: NavHostController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = Routes.valueOf(
        backStackEntry?.destination?.route ?: Routes.HOME.name
    )
    val context = LocalContext.current

    Scaffold(
       topBar = {
              TopAppBar(
                  currentScreen = currentScreen,
                  onBackPressed = {navController.navigate(Routes.HOME.name)},
                  onLockClicked = { navController.navigate(Routes.LOGIN.name)},
                  onNotificationClicked = {}
              )
       },
        bottomBar = {
            AnimatedVisibility(visible = if(currentScreen != Routes.LOGIN && currentScreen != Routes.SIGNUP && currentScreen != Routes.REGISTER  && currentScreen != Routes.SECOND_REGISTER  && currentScreen != Routes.RECOVER_PASSWORD){true}else{false} ) {
                BottomBar(
                    appViewModel = appViewModel,
                    onTabPressed = { route: Routes ->
                        appViewModel.updateCurrentScreen(route)
                        navController.navigate(route.name){
                            popUpTo(navController.graph.startDestinationId){
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    ){innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Routes.SIGNUP.name,
            modifier = modifier.padding(innerPadding)
            ) {
            composable(route =Routes.SIGNUP.name){
                SignUpPage(
                    onRegisterClick = {
                        if (isInternetAvailable(context = context )) {
                            navController.navigate(Routes.REGISTER.name)
                        } else{
                            Toast.makeText(context, "No internet connection. Please check your network.", Toast.LENGTH_LONG).show()
                        }
                    },
                    onLoginClick = {
                        if (isInternetAvailable(context = context )) {
                            navController.navigate(Routes.LOGIN.name)
                        } else{
                            Toast.makeText(context, "No internet connection. Please check your network.", Toast.LENGTH_LONG).show()
                        }
                    }
                )
            }
            composable(route = Routes.LOGIN.name){
                LoginPage(
                    onLoginClick = {
                        if (isInternetAvailable(context = context )) {
                            navController.navigate(Routes.HOME.name)
                        } else{
                            Toast.makeText(context, "No internet connection. Please check your network.", Toast.LENGTH_LONG).show()
                        }
                    },
                    onForgotPassWordClick = {
                        if (isInternetAvailable(context = context )) {
                            navController.navigate(Routes.RECOVER_PASSWORD.name)
                        } else{
                            Toast.makeText(context, "No internet connection. Please check your network.", Toast.LENGTH_LONG).show()
                        }
                    },
                    onNewUserClicked = {
                        if (isInternetAvailable(context = context )) {
                            navController.navigate(Routes.REGISTER.name)
                        } else{
                            Toast.makeText(context, "No internet connection. Please check your network.", Toast.LENGTH_LONG).show()
                        }
                    }
                )
            }
            composable(route = Routes.REGISTER.name){
                RegisterPage(
                    onContinueClick = {
                        if (isInternetAvailable(context = context )) {
                            navController.navigate(Routes.SECOND_REGISTER.name)
                        } else{
                            Toast.makeText(context, "No internet connection. Please check your network.", Toast.LENGTH_LONG).show()
                        }
                    },
                    onLoginClick = {
                        if (isInternetAvailable(context = context )) {
                            navController.navigate(Routes.LOGIN.name)
                        } else{
                            Toast.makeText(context, "No internet connection. Please check your network.", Toast.LENGTH_LONG).show()
                        }
                    }
                )
            }
            composable(route = Routes.HOME.name ){
                HomePage(
                    currentBalance = appViewModel.userBalance,
                    onAirtimeClicked = { navController.navigate(Routes.BUY_AIRTIME.name) },
                    onDataClicked = { navController.navigate(Routes.BUY_DATA.name) },
                    onCableTVClicked = { navController.navigate(Routes.CABLE_TV.name) },
                    onElectricityClicked = { navController.navigate(Routes.Buy_Electricity.name) },
                    onExamPinsClicked = {  navController.navigate(Routes.BUY_EXAM_PINS.name)},
                    onDataPinsClicked = { navController.navigate(Routes.BUY_DATA_PINS.name)},
                    onCardPinClicked = { navController.navigate(Routes.BUY_RECHARGE_PINS.name)},
                    onAlphaTopClicked = { navController.navigate(Routes.ALPHA_TOP.name)}
                )
            }
            composable(route = Routes.RECOVER_PASSWORD.name){
                RecoverPasswordPage(
                    onRecoverPasswordClicked = {  },
                    onAlreadyHaveAnAccountClicked = { navController.navigate(Routes.LOGIN.name) },
                    onDontHaveAnAccountClicked = { navController.navigate(Routes.REGISTER.name) }
                )
            }
            composable(route = Routes.SECOND_REGISTER.name){
                SecondRegisterPage(
                    onRegisterDoneClicked = { navController.navigate(Routes.HOME.name)},
                    onIHaveAnAccountAlreadySoLoginNow = { navController.navigate(Routes.LOGIN.name)}
                )
            }
            composable(route = Routes.BUY_AIRTIME.name){
                BuyAirTimePage(
                    onBuyAirtimeButtonClicked = {
                        if(isInternetAvailable(context = context)){
                            showDialog = true
                        }else{
                            Toast.makeText(context, "No internet connection. Please check your network.", Toast.LENGTH_LONG).show()
                        }
                        appViewModel.isCurrentTransactionDataPurchase = false
                        appViewModel.isCurrentTransactionAirtimePurchase = true
                    },
                    appViewModel = appViewModel
                )
            }
            composable(route = Routes.BUY_DATA.name){
                BuyDataPage(
                    appViewModel = appViewModel,
                    onBuyDataButtonClicked = {
                        if(isInternetAvailable(context = context)){
                            showDialog = true
                        }else{
                            Toast.makeText(context, "No internet connection. Please check your network.", Toast.LENGTH_LONG).show()
                        }
                        appViewModel.isCurrentTransactionAirtimePurchase = false
                        appViewModel.isCurrentTransactionDataPurchase = true
                    }
                )
            }
            composable(route = Routes.CABLE_TV.name){
                CableTVPage()
            }
            composable(route = Routes.HISTORY.name){
                HistoryPage()
            }
            composable(route = Routes.PROFILE.name){
                ProfilePage()
            }
            composable(route = Routes.Buy_Electricity.name){
                BuyElectricityScreen()
            }
            composable(route = Routes.BUY_EXAM_PINS.name){
                BuyExamPins()
            }
            composable(route = Routes.BUY_DATA_PINS.name){
                BuyDataPins()
            }
            composable(route = Routes.BUY_RECHARGE_PINS.name){
                BuyRechargePins()
            }
            composable(route = Routes.ALPHA_TOP.name){
                AlphaTopPage()
            }
            composable(route = Routes.RECEIPT_SCREEN.name){
                ReceiptScreen(appOIAViewModel = appViewModel)
            }
        }
        if (showDialog && appViewModel.amountUserWantsToBuy.isNotEmpty() && appViewModel.netWorkUserIsBuying.isNotEmpty()){
            AirtimeAlertDialog(
                onYesOnAlertDialogClicked = {
                    showDialog = false
                    showPinVerification = true
                },
                onNoOnAlertDialogClicked = {showDialog = false},
                onDismissRequest = { showDialog = false },
                appViewModel = appViewModel
            )
        }
        if (showPinVerification){
            InputPinCard(
                amount = appViewModel.amountUserWillPay,
                onPinComplete = {
                    appViewModel.updateUserBalance(it)
                    if (appViewModel.verifyUserPin(it)){
                        showPinVerification = false
                        navController.navigate(Routes.RECEIPT_SCREEN.name)
                    }else{
                        showPinVerification = false
                        showDialogIfPasswordIsWrong = true
                    }
                } ,
                onCancelPaymentClicked = {
                    showLeaveOrContinueDialog = true
                    showPinVerification = false
                },
                onDismissRequest = {
                    showLeaveOrContinueDialog = true
                    showPinVerification = false
                }
            )
        }
        if (showLeaveOrContinueDialog){
            ConfirmToLeavePayment(
                onLeaveClicked = {
                    showLeaveOrContinueDialog = false
                    showPinVerification = false
                    showDialog = false
                },
                onDismissRequest = {
                    showLeaveOrContinueDialog = false
                    showDialog = false
                    showPinVerification = true
                },
                onContinueClicked = {
                    showDialog = false
                    showLeaveOrContinueDialog = false
                    showPinVerification = true
                }
            )
        }
        if (showDialogIfPasswordIsWrong){
            PasswordVerificationFailedDialog(
                onForgotPinClicked = {
                    showPinVerification = false
                    showDialogIfPasswordIsWrong = false
                },
                onRetryClicked = {
                    showDialogIfPasswordIsWrong = false
                    showPinVerification = true
                }
            )
        }


    }

}

@Composable
fun BottomBar(
    appViewModel: OIAViewModel,
    onTabPressed:(Routes)-> Unit
){
    data class NavItem(val icon : ImageVector, val name: String, val currentRoutes: Routes)

    val uiState = appViewModel.uiState.collectAsState().value

    val navItemList = listOf(
        NavItem(icon = Icons.Default.Person, Routes.PROFILE.name, Routes.PROFILE),
        NavItem( icon =  Icons.Default.Home, Routes.HOME.title, Routes.HOME ),
        NavItem(icon = Icons.Filled.History, Routes.HISTORY.title, Routes.HISTORY)
    )
    BottomAppBar {
        navItemList.forEach {navItem  ->
            NavigationBarItem(
                selected = uiState.currentScreen == navItem.currentRoutes ,
                label = { Text(text = navItem.name) },
                onClick = { onTabPressed(navItem.currentRoutes) },
                icon = { Icon(imageVector = navItem.icon, contentDescription = navItem.name) }
            )
        }
    }
}


fun isInternetAvailable(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork ?: return false
    val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
    return when {
        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
        else -> false
    }
}