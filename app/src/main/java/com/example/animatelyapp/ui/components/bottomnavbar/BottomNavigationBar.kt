package com.example.animatelyapp.ui.components.bottomnavbar

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.ui.theme.AnimatelyAppTheme
import com.example.animatelyapp.ui.theme.primaryLight

@Composable
fun BottomNavigationBar(
    modifier: Modifier = Modifier,
    selectedIndex: Int = 0,
    indicatorColor: Color? = null,
    itemCount: Int,
    content: @Composable RowScope.() -> Unit,
) {
    var indicatorWidthPx by remember { mutableIntStateOf(0) }

    val indicatorTranslationAnimation by animateFloatAsState(
        targetValue =
            with(LocalDensity.current) {
                selectedIndex * (indicatorWidthPx.toDp().toPx())
            },
        label = "indicatorAnimation",
    )

    Column(modifier = modifier) {
        val indicatorWidthDp = with(LocalDensity.current) { indicatorWidthPx.toDp() }
        Box(
            modifier =
                Modifier
                    .graphicsLayer {
                        translationX = indicatorTranslationAnimation
                    }
                    .background(indicatorColor ?: MaterialTheme.colorScheme.primary)
                    .height(4.dp)
                    .width(indicatorWidthDp)
                    .padding(top = 52.dp),
        )

        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .onGloballyPositioned {
                        indicatorWidthPx = it.size.width / itemCount
                    },
            horizontalArrangement = Arrangement.SpaceEvenly,
            content = content,
        )
    }
}

@Composable
fun BottomNavigationBarItem(
    modifier: Modifier = Modifier,
    title: String,
    icon: ImageVector,
    isSelected: Boolean,
    onItemClick: () -> Unit,
) {
    val color = if (isSelected) primaryLight else Color.Gray

    Column(
        modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .clickable { onItemClick() },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            imageVector = icon,
            tint = color,
            contentDescription = "Navigate $title",
        )

        Spacer(modifier = Modifier.padding(bottom = 4.dp))

        Text(
            text = title,
            color = color,
            style = MaterialTheme.typography.titleMedium,
        )
    }
}

@Preview
@Composable
private fun BottomNavigationBarPreview() {
    AnimatelyAppTheme {
        BottomNavigationBar(
            indicatorColor = primaryLight,
            itemCount = 4,
            selectedIndex = 0,
        ) {
            BottomNavigationBarItem(
                title = "Home",
                icon = Icons.Outlined.Home,
                isSelected = true,
                onItemClick = {},
            )

            BottomNavigationBarItem(
                title = "Calculate",
                icon = Icons.Outlined.DateRange,
                isSelected = false,
                onItemClick = {},
            )

            BottomNavigationBarItem(
                title = "Shipment",
                icon = Icons.Outlined.Refresh,
                isSelected = false,
                onItemClick = {},
            )

            BottomNavigationBarItem(
                title = "Profile",
                icon = Icons.Outlined.Person,
                isSelected = false,
                onItemClick = {},
            )
        }
    }
}

@Preview
@Composable
private fun BottomNavigationBarItemSelectedPreview() {
    AnimatelyAppTheme {
        BottomNavigationBarItem(
            title = "Home",
            icon = Icons.Outlined.Home,
            isSelected = true,
            onItemClick = {},
        )
    }
}

@Preview
@Composable
private fun BottomNavigationBarItemUnselectedPreview() {
    AnimatelyAppTheme {
        BottomNavigationBarItem(
            title = "Home",
            icon = Icons.Outlined.Home,
            isSelected = false,
            onItemClick = {},
        )
    }
}
