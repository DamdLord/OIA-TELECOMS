package com.example.oiatelecoms

import android.app.Notification
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oiatelecoms.screens.CableTVPage
import com.example.oiatelecoms.ui.theme.OIATELECOMSTheme
import com.example.oiatelecoms.ui.theme.useAnotherColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OIATELECOMSTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainApp(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
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
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 5.dp, end = 5.dp, bottom = 5.dp)
    ) {
        AnimatedVisibility(visible = if(currentScreen != Routes.HOME && currentScreen != Routes.LOGIN && currentScreen != Routes.REGISTER && currentScreen != Routes.SIGNUP && currentScreen != Routes.SECOND_REGISTER && currentScreen != Routes.RECOVER_PASSWORD && currentScreen != Routes.HISTORY && currentScreen != Routes.PROFILE ){ true} else{false}) {
            IconButton(onClick = onBackPressed) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription ="Back",
                    modifier = modifier.size(35.dp),
                    tint = useAnotherColor
                    )
            }
        }
        Image(
            painter = painterResource(id = R.drawable.telecompicture),
            //contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier =  modifier.size(50.dp)
           // modifier = modifier.height(100.dp)
        )
        Spacer(modifier = modifier.width(10.dp))
        Text(
            text = "OIA TELECOMS",
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        )
        Spacer(modifier = modifier.width(5.dp))
        AnimatedVisibility(visible = if (currentScreen != Routes.LOGIN && currentScreen != Routes.REGISTER && currentScreen != Routes.SIGNUP && currentScreen != Routes.SECOND_REGISTER && currentScreen != Routes.RECOVER_PASSWORD){true}else{false}) {
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

