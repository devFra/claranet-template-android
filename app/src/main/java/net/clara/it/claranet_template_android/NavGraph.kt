package net.clara.it.claranet_template_android

import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.clara.it.claranet_template_android.screen.Screen
import net.clara.it.claranet_template_android.screen.home.homeScreen
import net.clara.it.claranet_template_android.screen.others.othersScreen
import net.clara.it.claranet_template_android.screen.results.resultsScreen
import net.clara.it.claranet_template_android.screen.splashScreen.splashScreen
import net.clara.it.claranet_template_android.screen.streaming.streamingScreen

@Composable
fun NavGraph(
    navController: NavController
) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = Screen.splashScreen.route
    ) {
        composable(route = Screen.splashScreen.route) {
            splashScreen(navController = navController)
        }
        composable(route = Screen.homeScreen.route) {
            homeScreen(navController = navController)
        }
        composable(route = Screen.streamingScreen.route) {
            streamingScreen(navController = navController)
        }
        composable(route = Screen.resultsScreen.route) {
            resultsScreen(navController = navController)
        }
        composable(route = Screen.othersScreen.route) {
            othersScreen(navController = navController)
        }
        /*
        composable(
            route = Screen.streamingScreen.route + "?value={value}",
            arguments = listOf(
                navArgument(name = "value") {
                    type = NavType.StringType
                    defaultValue = "no value"
                    nullable = true
                }
            )
        ){ entry ->
            streamingScreen(name = entry.arguments?.getString("name"))
        }
        */
    }

}


