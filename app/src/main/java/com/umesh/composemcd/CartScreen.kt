package com.umesh.composemcd

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.umesh.composemcd.component.CartItem
import com.umesh.composemcd.model.selectedItem

@Composable
fun CartScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start
    ) {
        LazyColumn {
            items(selectedItem) { food ->
               CartItem(food = food)
            }
        }
    }
}