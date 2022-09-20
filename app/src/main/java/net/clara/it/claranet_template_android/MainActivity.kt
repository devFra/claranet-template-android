package net.clara.it.claranet_template_android

import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.clara.it.claranet_template_android.composable.tabNav.TabItem
import net.clara.it.claranet_template_android.composable.tabNav.navTab
import net.clara.it.claranet_template_android.ui.theme.ClaranettemplateandroidTheme
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {

    val tabs = listOf(
        TabItem.Home,
        TabItem.Streaming,
        TabItem.Results,
        TabItem.Other
    )

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin {
            androidContext(this@MainActivity)
            modules(listOf(networkModule))
        }

        setContent {

            val navController = rememberNavController()

            ClaranettemplateandroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                   // var pagerState = rememberPagerState(tabs.size)
                    Scaffold(
                        bottomBar = { navTab(tabs,navController) }
                    ) {
                       NavGraph(navController)
                    }
                }
            }
        }
    }
}

