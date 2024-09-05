package com.example.animatelyapp.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyHorizontalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.ui.theme.greyOp
import com.example.animatelyapp.utils.DummyData

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun <T> StaggeredSelection(
    modifier: Modifier = Modifier,
    showCategories: Boolean = false,
    items: List<StaggeredItem<T>>,
    onItemSelected: (selectedItems: List<StaggeredItem<T>>) -> Unit,
) {
    val itemsSelected = remember { mutableStateListOf<StaggeredItem<T>>() }

    AnimatedVisibility(
        visible = showCategories,
        enter = slideInHorizontally(animationSpec = tween(durationMillis = 300)) { it },
        exit = slideOutHorizontally(animationSpec = tween(durationMillis = 300)) { it },
    ) {
        LazyHorizontalStaggeredGrid(
            modifier = modifier.height(120.dp),
            rows = StaggeredGridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalItemSpacing = 16.dp,
            contentPadding = PaddingValues(16.dp),
            state = rememberLazyStaggeredGridState(),
        ) {
            items(items = items, key = { it.title }) { item ->
                var category by remember { mutableStateOf(item) }

                StaggeredSelectionItem(
                    modifier =
                        Modifier
                            .animateItemPlacement(
                                spring(
                                    dampingRatio = Spring.DampingRatioLowBouncy,
                                    stiffness = Spring.StiffnessHigh,
                                ),
                            )
                            .clickable {
                                category = item.copy(selected = !item.selected)

                                if (!itemsSelected.contains(item)) {
                                    itemsSelected.add(item.copy(selected = true))
                                    onItemSelected(itemsSelected)
                                } else {
                                    itemsSelected.remove(item)
                                    onItemSelected(itemsSelected)
                                }
                            },
                    staggeredItem = category,
                )
            }
        }
    }
}

@Composable
fun <T> StaggeredSelectionItem(
    modifier: Modifier = Modifier,
    staggeredItem: StaggeredItem<T>,
) {
    val titleTextColor = if (staggeredItem.selected) Color.White else Color.Black
    val backgroundColor = if (staggeredItem.selected) greyOp else Color.Transparent
    val borderColor = if (staggeredItem.selected) greyOp else Color.Gray

    Surface(
        modifier = modifier.wrapContentHeight(),
        border = BorderStroke(width = 1.dp, color = borderColor),
        shape = RoundedCornerShape(8.dp),
        color = backgroundColor,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 8.dp),
        ) {
            AnimatedVisibility(visible = staggeredItem.selected) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    imageVector = Icons.Outlined.Check,
                    contentDescription = "selected",
                    tint = Color.White,
                )
            }

            Text(
                modifier = Modifier.padding(8.dp),
                text = staggeredItem.title,
                color = titleTextColor,
                style = MaterialTheme.typography.bodyMedium,
            )
        }
    }
}

@Preview
@Composable
private fun StaggeredSelectionItemUnselectedPreview() {
    StaggeredSelectionItem(
        staggeredItem = StaggeredItem(title = "Document", selected = false, value = "random"),
    )
}

@Preview
@Composable
private fun StaggeredSelectionItemSelectedPreview() {
    StaggeredSelectionItem(
        staggeredItem = StaggeredItem(title = "Document", selected = true, value = "random"),
    )
}

@Preview
@Composable
private fun StaggeredSelectionPreview() {
    StaggeredSelection(
        modifier = Modifier.fillMaxWidth(),
        items = DummyData.getStaggeredItems(),
        onItemSelected = {},
    )
}

data class StaggeredItem<T>(
    val value: T,
    val title: String,
    val selected: Boolean = false,
)
