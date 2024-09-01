package com.umesh.composemcd.navigation

import com.umesh.composemcd.R

sealed class BottomNavItem(val route: String, val icon: Int, val label: String) {
    data object Home :
        BottomNavItem(route = Screen.Main.Home.route, icon = R.drawable.ic_home, "Home")

    data object Offer :
        BottomNavItem(route = Screen.Main.Offer.route, icon = R.drawable.ic_offer, "Offer")

    data object Cart :
        BottomNavItem(route = Screen.Main.Cart.route, icon = R.drawable.ic_cart, "Cart")

    data object Settings :
        BottomNavItem(route = Screen.Main.Setting.route, icon = R.drawable.ic_settings, "Settings")
}

sealed class Screen(val route: String) {
    data object Splash : Screen(route = "splash")

    data object Main : Screen(route = "main") {
        data object Home : Screen(route = "home")
        data object Offer : Screen(route = "offer")
        data object Cart : Screen(route = "cart")
        data object Setting : Screen(route = "settings")
    }

    data object Detail : Screen(route = "detail/{category}/{itemId}") {
        fun createRoute(category: String, itemId: Int) = "detail/$category/$itemId"
    }
}

