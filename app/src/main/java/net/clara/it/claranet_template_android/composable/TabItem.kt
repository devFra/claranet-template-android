package net.clara.it.claranet_template_android.composable

import androidx.compose.runtime.Composable
import net.clara.it.claranet_template_android.R
import net.clara.it.claranet_template_android.screen.Screen

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(
    var icon: Int,
    var title: String,
    var route: String
){
    object Home: TabItem(R.drawable.ic_home_icon, "Home", Screen.HomeScreen.route)
    object Streaming: TabItem(R.drawable.ic_straming_ico, "Streaming", Screen.streamingScreen.route )
    object Results: TabItem(R.drawable.ic_results_ico, "Results", Screen.resultsScreen.route )
    object Other: TabItem(R.drawable.ic_other_ico, "Other", Screen.othersScreen.route)
}
