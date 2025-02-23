package com.example.oiatelecoms.adsPackage

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.oiatelecoms.R
import com.example.oiatelecoms.ui.theme.OIATELECOMSTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdsRow(
    modifier: Modifier = Modifier,
    onFirstCardClicked: () -> Unit,
    onSecondCardClicked: () -> Unit,
    onThirdCardClicked: () -> Unit
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .size(170.dp)
            .horizontalScroll(rememberScrollState())
    ) {
        Card(
            onClick = onFirstCardClicked,
            modifier = modifier.padding(4.dp).width(350.dp)
            ) {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data("https://www.canny-creative.com/wp-content/uploads/2020/07/greatestprintads_cocacola.jpg")
                    .crossfade(true)
                    .build(),
                contentDescription = "",
                error = painterResource(id = R.drawable.errorimage),
                placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Crop,
                modifier = modifier.fillMaxSize()
            )
        }
        Card(
            onClick = onSecondCardClicked,
            modifier = modifier.padding(4.dp).width(350.dp)
            ) {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRt9wVuYsOjnl4PrXY9s5Exx_hqNTQJWPQKRw&s")
                    .crossfade(true)
                    .build(),
                contentDescription = "",
                error = painterResource(id = R.drawable.errorimage),
                placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Crop,
                modifier = modifier.fillMaxSize()
            )
        }
        Card(
            onClick = onThirdCardClicked,
            modifier = modifier.padding(4.dp).width(350.dp)
            ) {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSgdoep9tSYVxob2rEC7MYQN8hSbf0flGB6rQ&s")
                    .crossfade(true)
                    .build(),
                contentDescription = "",
                error = painterResource(id = R.drawable.errorimage),
                placeholder = painterResource(id = R.drawable.placeholder),
                contentScale = ContentScale.Crop,
                modifier = modifier.fillMaxSize()
            )
        }
    }
}

@Preview
@Composable
fun ShowAds(){
    OIATELECOMSTheme {
        AdsRow(
            onFirstCardClicked = { /*TODO*/ },
            onSecondCardClicked = { /*TODO*/ },
            onThirdCardClicked = {})
    }
}