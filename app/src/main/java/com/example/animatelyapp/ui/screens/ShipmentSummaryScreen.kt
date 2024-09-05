package com.example.animatelyapp.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.ui.components.Shipments
import com.example.animatelyapp.ui.components.avaliablevehicles.AvailableVehicleSection
import com.example.animatelyapp.ui.components.headers.HeaderMode
import com.example.animatelyapp.ui.components.headers.ShipmentSummaryHeader
import com.example.animatelyapp.ui.components.tracking.TrackingSection
import com.example.animatelyapp.ui.theme.AnimatelyAppTheme
import com.example.animatelyapp.ui.theme.dirtyWhite
import com.example.animatelyapp.utils.DummyData

@Composable
fun ShipmentSummaryScreen() {
    var headerMode by remember { mutableStateOf(HeaderMode.VIEW) }

    var showMainContent by remember { mutableStateOf(false) }

    val showEditContent =
        when (headerMode) {
            HeaderMode.VIEW -> false
            HeaderMode.EDIT -> true
        }

    var showToolBar by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = "animation") {
        showToolBar = true
        showMainContent = true
    }

    Column(
        modifier = Modifier.background(color = dirtyWhite),
        verticalArrangement = Arrangement.Top,
    ) {
        AnimatedVisibility(
            visible = showToolBar,
            enter =
                slideInVertically(
                    animationSpec = tween(durationMillis = 300),
                ) { -it },
        ) {
            ShipmentSummaryHeader(
                headerMode = headerMode,
                onSearchBoxClicked = {
                    headerMode = HeaderMode.EDIT
                    showMainContent = false
                },
                onBackButtonClicked = {
                    showMainContent = true
                    headerMode =
                        when (headerMode) {
                            HeaderMode.VIEW -> HeaderMode.EDIT
                            HeaderMode.EDIT -> HeaderMode.VIEW
                        }
                },
            )
        }

        Column(
            modifier = Modifier.verticalScroll(rememberScrollState()),
        ) {
            AnimatedVisibility(
                visible = showEditContent,
                enter =
                    fadeIn(animationSpec = tween(durationMillis = 600)) +
                        slideInVertically(
                            animationSpec = tween(durationMillis = 300, delayMillis = 350),
                        ) { it * 4 },
            ) {
                Shipments(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                )
            }

            AnimatedVisibility(
                visible = showMainContent,
                enter =
                    fadeIn(animationSpec = tween(durationMillis = 300, easing = LinearEasing)) +
                        slideInVertically(animationSpec = tween(durationMillis = 300)) { it },
                exit =
                    fadeOut(animationSpec = tween(durationMillis = 300, easing = LinearEasing)) +
                        slideOutVertically(animationSpec = tween(durationMillis = 300)) { it },
            ) {
                TrackingSection(
                    modifier = Modifier.padding(top = 32.dp, start = 16.dp, end = 16.dp),
                )
            }

            AnimatedVisibility(
                visible = showMainContent,
                enter =
                    fadeIn(animationSpec = tween(durationMillis = 300, easing = LinearEasing)) +
                        slideInVertically(animationSpec = tween(durationMillis = 300)) { it },
                exit =
                    fadeOut(animationSpec = tween(durationMillis = 300, easing = LinearEasing)) +
                        slideOutVertically(animationSpec = tween(durationMillis = 300)) { it },
            ) {
                AvailableVehicleSection(
                    modifier = Modifier.padding(top = 32.dp, start = 16.dp, end = 16.dp),
                    vehicles = DummyData.getAvailableVehicles(),
                )
            }
        }
    }
}

@Preview
@Composable
fun ShipmentSummaryScreenPreview() {
    AnimatelyAppTheme {
        ShipmentSummaryScreen()
    }
}
