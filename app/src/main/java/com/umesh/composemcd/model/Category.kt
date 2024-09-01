package com.umesh.composemcd.model

import com.umesh.composemcd.R

data class Category(val categoryName: String, val icon: Int)

val categories = listOf(
    Category(categoryName = "Hamburger", icon = R.drawable.ic_burger_menu),
    Category(categoryName = "Fries", icon = R.drawable.ic_fries_menu),
    Category(categoryName = "Pizza", icon = R.drawable.ic_pizza_menu)
)