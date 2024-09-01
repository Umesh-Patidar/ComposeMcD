package com.umesh.composemcd

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.umesh.bmicalculator.ui.theme.DarkGreen
import com.umesh.composemcd.component.CartButton
import com.umesh.composemcd.component.CustomButton
import com.umesh.composemcd.component.CustomMenuBar
import com.umesh.composemcd.component.FullItemCounter
import com.umesh.composemcd.component.PageIndicator
import com.umesh.composemcd.model.foods
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest

private const val SCROLL_ANIMATION_DURATION = 3_000L

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    itemId: Int,
    onBack:() ->Unit
) {
    val selectedFood = foods.find { it.foodId == itemId }
    val imageUrlList = selectedFood?.foodUrl
    val pagerState =
        rememberPagerState(initialPage = 1, pageCount = { imageUrlList?.size ?: 0 })

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        CustomMenuBar(title = "Detail", menuIcon = R.drawable.ic_more, onNavigateUp = {
            onBack()
        }) {}

        Column(
            modifier = Modifier
                .padding(12.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {

                HorizontalPager(
                    modifier = Modifier.height(200.dp),
                    pageSize = PageSize.Fill,
                    pageSpacing = 15.dp,
                    contentPadding = PaddingValues(horizontal = 40.dp),
                    state = pagerState
                ) { index ->
                    imageUrlList?.getOrNull(
                        index % (imageUrlList.size)
                    )?.let { item ->
                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp),
                            painter = painterResource(id = item),
                            contentDescription = null
                        )
                    }
                }
            }
            imageUrlList?.size?.let {
                PageIndicator(
                    count = it,
                    pagerState = pagerState,
                    modifier = Modifier
                        .wrapContentWidth()
                        .align(Alignment.CenterHorizontally)
                )
            }

            val isDraggedState = pagerState.interactionSource.collectIsDraggedAsState()

            LaunchedEffect(isDraggedState) {
                snapshotFlow { isDraggedState.value }
                    .collectLatest { isDragged ->
                        if (!isDragged) {
                            while (true) {
                                delay(SCROLL_ANIMATION_DURATION)
                                runCatching {
                                    pagerState.animateScrollToPage(pagerState.currentPage.inc() % pagerState.pageCount)
                                }
                            }
                        }
                    }
            }

            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = "Popular ${selectedFood?.foodName}",
                style = MaterialTheme.typography.titleMedium,
                color = Color.Gray,
                fontWeight = FontWeight.Light
            )

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = selectedFood?.foodName!!,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.width(20.dp))

                Text(
                    text = "$ ${selectedFood.price}",
                    style = MaterialTheme.typography.headlineSmall,
                    color = DarkGreen,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    imageVector = Icons.Filled.Star,
                    contentDescription = "rating",
                    colorFilter = ColorFilter.tint(DarkGreen)
                )

                Spacer(modifier = Modifier.width(5.dp))

                Text(
                    text = selectedFood?.rating!!,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Gray,
                    fontWeight = FontWeight.Light
                )

                Spacer(modifier = Modifier.width(2.dp))

                Text(
                    text = "(2.5K Reviews)",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Gray,
                    fontWeight = FontWeight.Light
                )
            }

            Spacer(modifier = Modifier.height(25.dp))

            Text(
                text = "Description",
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = selectedFood?.description!!,
                style = MaterialTheme.typography.titleMedium,
                color = Color.Gray,
                fontWeight = FontWeight.Light
            )

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                FullItemCounter()

                Spacer(modifier = Modifier.width(20.dp))

                Row(
                    modifier = Modifier.wrapContentWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_selected_tick),
                        contentDescription = "rating",
                        colorFilter = ColorFilter.tint(DarkGreen)
                    )

                    Spacer(modifier = Modifier.width(3.dp))

                    Text(
                        text = "Free Shipping",
                        style = MaterialTheme.typography.titleSmall,
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Spacer(modifier = Modifier.height(15.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                CartButton()

                Spacer(modifier = Modifier.width(10.dp))
                CustomButton(text = "Order Now") {}
            }
        }
    }
}