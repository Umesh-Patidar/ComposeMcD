package com.umesh.composemcd.component


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ItemCounter(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .padding(5.dp)
            .wrapContentSize()
            .border(width = 1.dp, color = Color.LightGray, RoundedCornerShape(18.dp))
            .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "-", style = MaterialTheme.typography.titleMedium, color = Color.Gray)
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "1", style = MaterialTheme.typography.titleMedium, color = Color.Gray)
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = "+", style = MaterialTheme.typography.titleMedium, color = Color.Gray)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewItemCounter() {
    ItemCounter()
}