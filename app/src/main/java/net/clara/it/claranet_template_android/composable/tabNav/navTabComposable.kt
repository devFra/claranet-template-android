package net.clara.it.claranet_template_android.composable.toRemove

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import net.clara.it.claranet_template_android.composable.tabNav.TabItem


@Composable
fun navTab(
    tabs: List<TabItem>,
    navController: NavController
){

    BottomNavigation (
        modifier = Modifier.background(Color.Gray),
        backgroundColor = MaterialTheme.colors.primary
    ){
        //val navBackStackEntry by navController.currentBackStackEntryAsState()
        //val currentRoute = navBackStackEntry?.destination?.route

        tabs.forEach { tab ->

            BottomNavigationItem(
                selected = true,
                onClick = {
                    navController.navigate(tab.route)
                },
                icon = {
                    Icon(
                        painter = painterResource(tab.icon),
                        contentDescription = tab.title,
                        modifier = Modifier
                            .fillMaxSize(0.4f)
                    )
               },
                label = { Text(text = tab.title) },
                modifier = Modifier.background(Color.Gray)
            )

        }

    }




}

@Preview(showBackground = true)
@Composable
fun TabsPreview() {
    val tabs = listOf(
        TabItem.Home,
        TabItem.Streaming,

    )
    //val pagerState = rememberPagerState()
    //navTab(tabs = tabs, pagerState = pagerState)
    //navTab(tabs)
}