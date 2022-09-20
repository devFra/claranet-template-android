package net.clara.it.claranet_template_android.screen.streaming

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import net.clara.it.claranet_template_android.screen.home.homeScreen

@Composable
fun streamingScreen(navController: NavController){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Text(text = "Streaming")
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun streamingScreenPreview(){
    streamingScreen(navController = rememberNavController())
}