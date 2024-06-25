package com.alreadyoccupiedseat.design_app

import androidx.navigation.compose.NavHost
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.alreadyoccupiedseat.core.extention.EMPTY
import com.alreadyoccupiedseat.design_app.Screen.Companion.bottomNavigationItems
import com.alreadyoccupiedseat.design_app.screens.TypoScreen
import com.alreadyoccupiedseat.design_app.screens.IconScreen
import com.alreadyoccupiedseat.design_app.screens.ColorScreen
import com.alreadyoccupiedseat.designsystem.component.ShowPotBottomNavigation

@Composable
fun AppScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {

            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            ShowPotBottomNavigation(
                bottomNavigationItems = bottomNavigationItems,
                currentDestination?.route ?: String.EMPTY
            ) {
                navController.navigate(it.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    launchSingleTop = true
                    restoreState = true
                }
            }

        }
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = Screen.Typo.route,
            Modifier.padding(innerPadding),
        ) {

            composable(Screen.Typo.route) {
                TypoScreen(navController)
            }

            composable(Screen.Icon.route) {
                IconScreen(navController)
            }

            composable(Screen.Color.route) {
                ColorScreen(navController)
            }
        }
    }
}