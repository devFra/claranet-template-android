package net.clara.it.claranet_template_android.screen

sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_screen")
    object streamingScreen: Screen("streaming_screen")
    object resultsScreen: Screen("results_screen")
    object othersScreen: Screen("others_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg -> append("/$arg") }
        }
    }
}
