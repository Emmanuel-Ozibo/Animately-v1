package com.example.animatelyapp.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.ui.theme.AnimatelyAppTheme
import com.example.animatelyapp.ui.theme.lighterPurple
import com.example.animatelyapp.ui.theme.orange
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun FancyScrollableSelection(
    modifier: Modifier = Modifier,
    options: List<Item>,
    onItemSelected: (Item) -> Unit,
) {
    Row(
        modifier =
            modifier
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        for (i in options.indices) {
            val item = options[i]

            FancyScrollableSelectionItem(
                title = item.title,
                count = item.count,
                isSelected = item.isSelected,
                onClick = {
                    onItemSelected(item)
                },
            )
        }
    }
}

data class Item(
    val title: String,
    val count: String,
    val isSelected: Boolean,
    val status: Status
)

@Composable
fun FancyScrollableSelectionItem(
    title: String,
    count: String,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    val textColor = if (isSelected) Color.White else Color(0xFFB2A4DF)
    val titleTextStyle =
        if (isSelected) MaterialTheme.typography.titleMedium else MaterialTheme.typography.titleMedium
    val countBg = if (isSelected) orange else lighterPurple

    var scaleFactor by remember { mutableFloatStateOf(1f) }
    val scale by animateFloatAsState(targetValue = scaleFactor, label = "scaleAnimation")

    var indicatorWidthPx by remember { mutableIntStateOf(0) }

    val widthGrowthAnimation by animateDpAsState(
        targetValue = with(LocalDensity.current) { indicatorWidthPx.toDp() },
        label = "widthAnimation",
    )

    Column(
        modifier =
            Modifier
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                }
                .clickable {
                    CoroutineScope(Dispatchers.Main).launch {
                        scaleFactor = 0.8f
                        delay(100)
                        scaleFactor = 1f
                        delay(100)
                        onClick()
                    }
                }
    ) {
        Row(
            modifier =
                Modifier.onGloballyPositioned {
                    indicatorWidthPx = it.size.width
                },
        ) {
            Text(
                text = title,
                style = titleTextStyle,
                color = textColor,
            )

            Spacer(modifier = Modifier.padding(end = 4.dp))

            Surface(
                modifier = Modifier,
                shape = RoundedCornerShape(16.dp),
                color = countBg,
            ) {
                Text(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    text = count,
                    color = textColor,
                )
            }
        }

        if (isSelected) {
            Box(
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 0.dp)
                    .background(orange)
                    .height(4.dp)
                    .width(widthGrowthAnimation)
            )
        }
    }
}

@Preview
@Composable
private fun FancyScrollableSelectionPreview() {
    AnimatelyAppTheme {
        FancyScrollableSelection(
            options =
                listOf(
                    Item(
                        title = "All",
                        count = "20",
                        isSelected = true,
                        status = Status.ALL
                    ),
                    Item(
                        title = "In Progress",
                        count = "10",
                        isSelected = false,
                        status = Status.IN_PROGRESS
                    ),
                    Item(
                        title = "Pending",
                        count = "5",
                        isSelected = false,
                        status = Status.PENDING
                    ),
                    Item(
                        title = "Loading",
                        count = "20",
                        isSelected = false,
                        status = Status.LOADING
                    ),
                ),
            onItemSelected = {
            },
        )
    }
}

@Preview
@Composable
private fun FancyScrollableSelectionItemEnabledPreview() {
    AnimatelyAppTheme {
        FancyScrollableSelectionItem(
            title = "Progress",
            count = "20",
            isSelected = true,
            onClick = {},
        )
    }
}

@Preview
@Composable
private fun FancyScrollableSelectionItemDisabledPreview() {
    AnimatelyAppTheme {
        FancyScrollableSelectionItem(
            title = "Progress",
            count = "20",
            isSelected = false,
            onClick = {},
        )
    }
}
