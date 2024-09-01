package com.umesh.composemcd.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.umesh.composemcd.model.Category
import com.umesh.composemcd.model.categories
import com.umesh.bmicalculator.ui.theme.DarkGreen
import com.umesh.bmicalculator.ui.theme.LightThinGrey

@Composable
fun FoodCategory(
    modifier: Modifier = Modifier,
    category: Category,
    isSelected: Boolean = false,
    onCategoryClick: (String) -> Unit
) {
    Box(
        modifier = modifier
            .padding(end = 10.dp)
            .wrapContentWidth()
            .defaultMinSize(minWidth = 100.dp)
            .height(50.dp)
            .background(
                color = if (isSelected) DarkGreen else LightThinGrey,
                shape = RoundedCornerShape(18.dp)
            )
            .padding(15.dp)
            .clickable(onClick = { onCategoryClick(category.categoryName) }),
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = category.icon),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = category.categoryName,
                style = MaterialTheme.typography.titleMedium,
                color = if (isSelected) Color.White else Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCategory() {
    FoodCategory(category = categories.first(), isSelected = true) {}
}

@Preview(showBackground = true)
@Composable
fun PreviewCategory2() {
    FoodCategory(category = categories.first(), isSelected = false) {}
}