package com.umesh.composemcd.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.umesh.composemcd.R

@Composable
fun CustomTitleBar(modifier: Modifier = Modifier, onProfileIconClick: () -> Unit) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = modifier
                .size(30.dp),
            painter = painterResource(id = R.drawable.ic_hamburger),
            contentScale = ContentScale.Crop,
            contentDescription = "profile image"
        )

        Spacer(modifier = Modifier.weight(1f))

        Image(
            modifier = Modifier
                .size(55.dp)
                .clip(CircleShape)
                .clickable {
                    onProfileIconClick()
                },
            painter = painterResource(id = R.drawable.img_pic),
            contentScale = ContentScale.Crop,
            contentDescription = "profile image"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCustomTitleBar() {
    CustomTitleBar {}
}

@Preview(showSystemUi = true)
@Composable
fun PreviewFullCustomTitleBar() {
    CustomTitleBar {}
}