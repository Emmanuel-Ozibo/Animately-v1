package com.example.animatelyapp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.animatelyapp.ui.components.NavigationHost
import com.example.animatelyapp.ui.components.bottomnavbar.AnimatelyBottomNavigation

/*
Root Composable.
 */
@Composable
fun AnimatelyApp() {
    val rootNavController = rememberNavController()

    var isBottomBarVisible by remember {
        mutableStateOf(true)
    }

    val screenDensity = LocalDensity.current

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.fillMaxWidth(),
    ) {
        NavigationHost(
            modifier = Modifier.weight(1f),
            rootNavController = rootNavController,
            onDestinationChanged = { shouldShowBottomNav ->
                isBottomBarVisible = !shouldShowBottomNav
            },
        )

        AnimatedVisibility(
            visible = isBottomBarVisible,
            exit =
                slideOutVertically {
                    with(screenDensity) { 80.dp.roundToPx() } // 80dp is the bottom nav height
                },
            enter =
                slideInVertically {
                    with(screenDensity) { 80.dp.roundToPx() }
                },
        ) {
            AnimatelyBottomNavigation(
                navController = rootNavController,
                onDestinationChanged = { shouldShowBottomNav ->
                    isBottomBarVisible = !shouldShowBottomNav
                },
            )
        }
    }
}
