package net.clara.it.claranet_template_android.screen.home


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import net.clara.it.claranet_template_android.composable.news.newsComposable

@Composable
fun homeScreen(
    navController: NavController,
){
    val vm = viewModel<HomeScreenViewModel>()
    val news by vm.getNews().observeAsState()

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        news?.forEach{ news ->
            newsComposable(news)
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun homeScreenPreview(){
    homeScreen(navController = rememberNavController())
}

