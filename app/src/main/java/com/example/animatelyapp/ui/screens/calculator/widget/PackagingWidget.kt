package com.example.animatelyapp.ui.screens.calculator.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.R
import com.example.animatelyapp.ui.components.FancyDropdown
import com.example.animatelyapp.ui.theme.AnimatelyAppTheme

@Composable
fun PackagingWidget(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Packaging",
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.W500
            ),
        )

        Text(
            modifier = Modifier.padding(top = 8.dp, bottom = 16.dp),
            text = "What are you sending",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
        )

        FancyDropdown(
            title = "Box",
            leadingIcon = R.drawable.box,
        )
    }
}

@Preview
@Composable
private fun PackagingWidgetPreview() {
    AnimatelyAppTheme {
        PackagingWidget()
    }
}
