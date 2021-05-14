package com.droid.posts.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun ProvideNavHostController(
    content: @Composable () -> Unit
) {
    val navController = rememberNavController()
    CompositionLocalProvider(LocalNavHostController provides navController) {
        content()
    }
}

val LocalNavHostController = staticCompositionLocalOf<NavHostController> {
    error("Provide a nav host controller")
}
