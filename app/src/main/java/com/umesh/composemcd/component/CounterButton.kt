package com.umesh.composemcd.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.umesh.composemcd.ui.theme.DarkGreen

@Composable
fun CategoryButton(onAddToCartClick: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(5.dp)
            .background(
                color = DarkGreen,
                shape = RoundedCornerShape(5.dp)
            )
            .size(25.dp)
            .clickable {
                onAddToCartClick()
            },
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.size(15.dp),
            imageVector = Icons.Filled.Add,
            contentDescription = null,
            colorFilter = ColorFilter.tint(color = Color.White)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCategoryButton() {
    CategoryButton {}
}