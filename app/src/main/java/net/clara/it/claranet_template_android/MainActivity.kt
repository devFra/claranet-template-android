package net.clara.it.claranet_template_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import net.clara.it.claranet_template_android.composable.tabNav.TabItem
import net.clara.it.claranet_template_android.composable.toRemove.navTab
import net.clara.it.claranet_template_android.screen.Screen
import net.clara.it.claranet_template_android.ui.theme.ClaranettemplateandroidTheme
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin

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
            modules(listOf(
                networkModule,
                viewModelModule
            ))
        }

        setContent {

            val navController = rememberNavController()
            val bottomBarState = rememberSaveable{ (mutableStateOf(true)) }
            val navBackStackEntry by navController.currentBackStackEntryAsState()

            when (navBackStackEntry?.destination?.route){
                Screen.splashScreen.route -> {
                    bottomBarState.value = false;
                }
                Screen.homeScreen.route -> {
                    bottomBarState.value = true;
                }
                Screen.streamingScreen.route -> {
                    bottomBarState.value = true;
                }
                Screen.resultsScreen.route -> {
                    bottomBarState.value = true;
                }
                Screen.othersScreen.route -> {
                    bottomBarState.value = true;
                }
            }

            ClaranettemplateandroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                   // var pagerState = rememberPagerState(tabs.size)
                    Scaffold(
                        bottomBar = {
                            AnimatedVisibility(
                                visible = bottomBarState.value
                            ) {
                                navTab(tabs,navController)
                            }
                        }
                    ) { innerPadding ->
                        Box( modifier = Modifier.padding(innerPadding)) {
                            NavGraph(navController)
                        }
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        stopKoin()
    }
}

