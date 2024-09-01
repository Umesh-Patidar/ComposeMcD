package com.umesh.composemcd.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.umesh.composemcd.R

@Composable
fun CustomMenuBar(modifier: Modifier = Modifier, title: String, menuIcon: Int, onNavigateUp: () -> Unit, onMenuClick: () -> Unit) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Absolute.SpaceBetween
    ) {
        Image(
            modifier = Modifier.clickable { onNavigateUp() },
            imageVector = Icons.Filled.ArrowBack,
            contentScale = ContentScale.Crop,
            contentDescription = "profile image"
        )

        Text(
            text = title,
            color = Color.Black,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold
        )

        Image(
            modifier = Modifier.size(24.dp).clickable { onMenuClick() },
            painter = painterResource(id = menuIcon),
            contentScale = ContentScale.Crop,
            contentDescription = "profile image"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCustomMenuBar() {
    CustomMenuBar(title = "Details", menuIcon = R.drawable.ic_more, onNavigateUp = {}, onMenuClick = {})
}

@Preview(showSystemUi = true)
@Composable
fun PreviewFullCustomMenuBar() {
    CustomMenuBar(title = "Details", menuIcon = R.drawable.ic_more, onNavigateUp = {}, onMenuClick = {})
}