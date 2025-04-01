package com.example.oiatelecoms

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.FragmentActivity
import com.example.oiatelecoms.ui.theme.OIATELECOMSTheme
import com.example.oiatelecoms.ui.theme.useAnotherColor

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OIATELECOMSTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainApp(
                        activity = this,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun TopAppBar(
    modifier: Modifier = Modifier,
    currentScreen: Routes,
    onBackPressed: () -> Unit,
    onLockClicked:() -> Unit,
    onNotificationClicked: () -> Unit
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(15.dp)
            //.padding(top = 20.dp, start = 5.dp, end = 5.dp, bottom = 5.dp)
    ) {
        AnimatedVisibility(visible = currentScreen != Routes.HOME && currentScreen != Routes.LOGIN && currentScreen != Routes.REGISTER && currentScreen != Routes.SIGNUP && currentScreen != Routes.SECOND_REGISTER && currentScreen != Routes.RECOVER_PASSWORD && currentScreen != Routes.HISTORY && currentScreen != Routes.PROFILE) {
            IconButton(onClick = onBackPressed) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription ="Back",
                    modifier = modifier.size(35.dp),
                    tint = useAnotherColor
                    )
            }
        }

        Text(
            text = "OIA TELECOMS",
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 25.sp
        )
        AnimatedVisibility(visible = currentScreen != Routes.LOGIN && currentScreen != Routes.REGISTER && currentScreen != Routes.SIGNUP && currentScreen != Routes.SECOND_REGISTER && currentScreen != Routes.RECOVER_PASSWORD && currentScreen != Routes.SPLASH_SCREEN) {
            Row(
                modifier = modifier,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(onClick = onLockClicked) {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null,
                        modifier = modifier.size(25.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                Spacer(modifier = modifier.width(10.dp))
                IconButton(onClick = onNotificationClicked) {
                    Icon(
                        imageVector = Icons.Default.Notifications,
                        contentDescription = null,
                        modifier = modifier.size(25.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OIATELECOMSTheme {
       TopAppBar(
           onBackPressed = {},
           currentScreen = Routes.HOME,
           onLockClicked = {},
           onNotificationClicked = {}
       )
    }
}

