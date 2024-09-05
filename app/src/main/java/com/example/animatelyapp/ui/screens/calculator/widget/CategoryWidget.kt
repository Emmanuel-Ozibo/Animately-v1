package com.example.animatelyapp.ui.screens.calculator.widget

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.ui.components.StaggeredItem
import com.example.animatelyapp.ui.components.StaggeredSelection
import com.example.animatelyapp.ui.theme.AnimatelyAppTheme
import com.example.animatelyapp.utils.DummyData

@Composable
fun CategoryWidget(
    modifier: Modifier = Modifier,
    categories: List<StaggeredItem<String>> = listOf(),
    showCategories: Boolean,
) {
    Column(
        modifier = modifier.wrapContentHeight(),
    ) {
        Text(
            text = "Categories",
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.W500
            ),
        )

        Text(
            modifier = Modifier.padding(top = 8.dp),
            text = "What are you sending",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray,
        )

        StaggeredSelection(
            items = categories,
            showCategories = showCategories,
            onItemSelected = {
            },
        )
    }
}

@Preview
@Composable
private fun CategoryWidgetPreview() {
    AnimatelyAppTheme {
        CategoryWidget(
            modifier = Modifier.fillMaxWidth(),
            categories = DummyData.getStaggeredItems(),
            showCategories = true,
        )
    }
}
