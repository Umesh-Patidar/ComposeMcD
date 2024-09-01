package com.umesh.composemcd.component


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.umesh.composemcd.R
import com.umesh.composemcd.ui.theme.LightThinGrey

@Composable
fun CustomSearchBar() {
    val textState = remember { mutableStateOf(TextFieldValue("")) }

    Box(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth()
            .border(width = 1.5.dp, color = LightThinGrey, shape = RoundedCornerShape(15.dp))

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,

        ) {
            OutlinedTextField(
                value = textState.value,
                onValueChange = { textState.value = it },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = null
                    )
                },
                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Sentences,
                    keyboardType = KeyboardType.Text
                ),
                singleLine = true,
                placeholder = {
                    Text(
                        text = "Search hear",
                        color = Color.Gray,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCustomSearchBar() {
    CustomSearchBar()
}