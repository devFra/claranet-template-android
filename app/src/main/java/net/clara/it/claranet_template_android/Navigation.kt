package net.clara.it.claranet_template_android

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import net.clara.it.claranet_template_android.screen.Screen
import net.clara.it.claranet_template_android.screen.home.homeScreen
import net.clara.it.claranet_template_android.screen.streaming.streamingScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            homeScreen(navController = navController)
        }
        composable(
            route = Screen.streamingScreen.route + "/{name}",
            arguments = listOf(
                navArgument(name = "name") {
                    type = NavType.StringType
                    defaultValue = "Philip"
                    nullable = true
                }
            )
        ){ entry ->
            streamingScreen(name = entry.arguments?.getString("name"))
        }
    }
}


