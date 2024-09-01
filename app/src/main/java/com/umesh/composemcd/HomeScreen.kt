package com.umesh.composemcd

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.umesh.composemcd.component.CustomSearchBar
import com.umesh.composemcd.component.CustomTitleBar
import com.umesh.composemcd.component.FoodCard
import com.umesh.composemcd.component.FoodCategory
import com.umesh.composemcd.model.Category
import com.umesh.composemcd.model.categories
import com.umesh.composemcd.model.foods
import com.umesh.composemcd.ui.theme.DarkGreen

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    selectedCategory: Category,
    onCategoryClick:(Category) -> Unit,
    onNavigateToDetail: (Int) -> Unit
) {
    Box(
        modifier = modifier
            .padding(15.dp)
            .fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            CustomTitleBar {

            }
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Hi, Mr. Volverine",
                color = Color.Gray,
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Welcome Back!",
                color = Color.Black,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            CustomSearchBar()

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Food Category",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    modifier = Modifier.clickable { },
                    text = "See all",
                    style = MaterialTheme.typography.titleMedium,
                    color = DarkGreen
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
            LazyRow(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(categories.size) { index ->
                    val category = categories[index]
                    FoodCategory(
                        category = category,
                        isSelected = category == selectedCategory,
                        onCategoryClick = {
                            onCategoryClick(category)
                        })
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = "Popular",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    modifier = Modifier.clickable { },
                    text = "See all",
                    style = MaterialTheme.typography.titleMedium,
                    color = DarkGreen
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2)
            ) {
                items(foods.filter { it.categoryName == selectedCategory.categoryName }) { foodItem ->
                    FoodCard(food = foodItem,
                        onDetailClick = {
                            onNavigateToDetail(foodItem.foodId)
                        }, onAddToCart = {
                            //add cart event
                        }
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(selectedCategory = categories[2], onNavigateToDetail = {}, onCategoryClick = {})
}