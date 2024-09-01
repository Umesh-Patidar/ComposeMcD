package com.umesh.composemcd

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.umesh.composemcd.model.categories
import com.umesh.composemcd.navigation.BottomNavigationBar
import com.umesh.composemcd.navigation.Screen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    var selectedCategory by remember { mutableStateOf(categories.first()) }

    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.Detail.route) {
                BottomNavigationBar(navController = navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Main.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Main.Home.route) {
                HomeScreen(
                    selectedCategory = selectedCategory,
                    onCategoryClick = { category ->
                        selectedCategory = category
                    }, onNavigateToDetail = { foodId ->
                        navController.navigate(
                            Screen.Detail.createRoute(
                                selectedCategory.categoryName,
                                foodId
                            )
                        )
                    })
            }
            composable(Screen.Main.Offer.route) { OfferScreen() }
            composable(Screen.Main.Cart.route) { CartScreen() }
            composable(Screen.Main.Setting.route) { SettingScreen() }

            composable(
                Screen.Detail.route,
                arguments = listOf(
                    navArgument("itemId") { type = NavType.IntType }
                ),
            ) { backStackEntry ->
                val itemId = backStackEntry.arguments?.getInt("itemId", 0) ?: 0
                DetailScreen(
                    itemId = itemId,
                    onBack = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
