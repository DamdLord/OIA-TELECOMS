package com.example.oiatelecoms.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.oiatelecoms.R
import com.example.oiatelecoms.Routes
import com.example.oiatelecoms.data.DataStoreHelper
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController, context: Context,modifier: Modifier = Modifier){
    var isFirstLaunch by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        isFirstLaunch = DataStoreHelper.isFirstLaunch(context)
        delay(2000)
        if (isFirstLaunch){
            navController.navigate(Routes.SIGNUP.name){
                popUpTo(Routes.SPLASH_SCREEN.name) { inclusive = true  }
            }
            DataStoreHelper.setFirstLaunch(context, false)
        }
        else{
            navController.navigate(Routes.LOGIN.name){
                popUpTo(Routes.SPLASH_SCREEN.name) {inclusive = true  }
            }
        }
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.telecompicture),
            contentDescription = null,
            modifier = modifier.size(250.dp).clip(CircleShape),
            contentScale = ContentScale.Crop
        )
    }
}