package com.umesh.composemcd.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.umesh.bmicalculator.ui.theme.DarkGreen
import com.umesh.composemcd.R

@Composable
fun CartButton(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(50.dp)
            .border(width = 1.dp, color = Color.Gray, shape = RoundedCornerShape(8.dp)),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.size(30.dp),
            painter = painterResource(id = R.drawable.ic_cart),
            contentDescription = "cart",
            colorFilter = ColorFilter.tint(DarkGreen),
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewCartButton() {
    CartButton()
}