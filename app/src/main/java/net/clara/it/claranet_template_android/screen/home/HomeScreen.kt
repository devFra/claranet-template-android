package net.clara.it.claranet_template_android.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import net.clara.it.claranet_template_android.screen.Screen

@Composable
fun homeScreen(navController: NavController){
    Column{
        Button(onClick = {
            navController.navigate(Screen.streamingScreen.withArgs("hello"))
        }){
            Text(text = "To Detail screen")
        }
    }
}