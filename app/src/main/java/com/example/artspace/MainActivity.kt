package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreen() {
    var result by remember { mutableStateOf(1) }
    val imageResource = when (result) {
        1 -> R.drawable.rich_smith_ivozcg8ajgi_unsplash
        2 -> R.drawable.sid_balachandran_nywnmwapkww_unsplash
        3 -> R.drawable.christina_victoria_craft_nrommxblqk4_unsplash
        4 -> R.drawable.etienne_girardet_ngb91vwnowy_unsplash
        5 -> R.drawable.hang_niu_uwwq8av4dqy_unsplash
        6 -> R.drawable.james_orr_csudd9ekgpu_unsplash
        else -> R.drawable.karan_nagpal_12xx5_xhroc_unsplash
    }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ){
        Spacer(modifier = Modifier.height(16.dp))
        Image(painter = painterResource(id = imageResource), contentDescription = "Art")
        Spacer(modifier = Modifier.height(20.dp))
        Row (
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center
        ){
            Button(onClick = {result = DecreaseButton(result)}) {
                Text("Previous")
            }
            Button(onClick = {result = IncreaseButton(result)}) {
                Text("Next")
            }
        }
    }
}

private fun DecreaseButton(clickIndex: Int): Int {
    var newIndex = clickIndex
    if (clickIndex < 2) {
        newIndex = 7
    } else {newIndex--}
    return newIndex
}

private fun IncreaseButton(clickIndex: Int): Int {
    var newIndex = clickIndex
    if (clickIndex > 6) {
        newIndex = 1
    } else {newIndex++}
    return newIndex
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}