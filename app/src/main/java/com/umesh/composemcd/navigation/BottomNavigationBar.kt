package com.umesh.composemcd.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.umesh.composemcd.ui.theme.DarkGreen


@Composable
fun BottomNavigationBar(navController: NavController) {
    val navItems = listOf(
        BottomNavItem.Home,
        BottomNavItem.Offer,
        BottomNavItem.Cart,
        BottomNavItem.Settings
    )
    var selectedItem by rememberSaveable { mutableIntStateOf(0) }
    NavigationBar(containerColor = Color.White){
        navItems.forEachIndexed { index, item ->
            NavigationBarItem(
                alwaysShowLabel = false,
                selected = index == selectedItem,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = DarkGreen,
                    unselectedIconColor = Color.Black
                ),
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = item.label
                    )
                },
                onClick = {
                    selectedItem = index
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { destination ->
                            popUpTo(destination) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
            )
        }
    }
}

