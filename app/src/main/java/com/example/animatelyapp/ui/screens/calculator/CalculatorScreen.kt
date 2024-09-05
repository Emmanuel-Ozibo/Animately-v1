package com.example.animatelyapp.ui.screens.calculator

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.ui.components.FancyPrimaryButton
import com.example.animatelyapp.ui.components.headers.ShipmentCalculationHeader
import com.example.animatelyapp.ui.components.headers.ShipmentHeaderState
import com.example.animatelyapp.ui.screens.calculator.widget.CategoryWidget
import com.example.animatelyapp.ui.screens.calculator.widget.PackagingWidget
import com.example.animatelyapp.ui.screens.calculator.widget.ShipmentDestinationWidget
import com.example.animatelyapp.ui.theme.dirtyWhite
import com.example.animatelyapp.utils.DummyData
import kotlinx.coroutines.delay

@Composable
fun CalculatorScreen(
    onBackClick: () -> Unit,
    onCalculateClick: () -> Unit,
) {
    var headerStates by remember { mutableStateOf(ShipmentHeaderState.EXPANDED) }
    var showContent by remember { mutableStateOf(false) }

    var showCategoriesItems by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = "random") {
        delay(100)
        headerStates = ShipmentHeaderState.COLLAPSED
        showContent = true
        delay(100)
        showCategoriesItems = true
    }

    Column(
        modifier =
            Modifier
                .background(dirtyWhite),
    ) {
        ShipmentCalculationHeader(
            headerState = headerStates,
            onClick = onBackClick,
        )

        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            AnimatedVisibility(
                visible = showContent,
                enter =
                    fadeIn(animationSpec = tween(durationMillis = 200)) +
                        slideInVertically(
                            animationSpec = tween(durationMillis = 400),
                        ) { it },
            ) {
                ShipmentDestinationWidget(
                    modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
                )
            }

            AnimatedVisibility(
                visible = showContent,
                enter =
                    fadeIn(animationSpec = tween(durationMillis = 200)) +
                        slideInVertically(
                            animationSpec = tween(durationMillis = 400),
                        ) { it },
            ) {
                PackagingWidget(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
                )
            }

            AnimatedVisibility(
                visible = showContent,
                enter =
                    fadeIn(animationSpec = tween(durationMillis = 200)) +
                        slideInVertically(
                            animationSpec = tween(durationMillis = 400),
                        ) { it },
            ) {
                CategoryWidget(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
                    categories = DummyData.getStaggeredItems(),
                    showCategories = showCategoriesItems,
                )
            }

            AnimatedVisibility(
                visible = showContent,
                enter =
                    fadeIn(animationSpec = tween(durationMillis = 200)) +
                        slideInVertically(
                            animationSpec = tween(durationMillis = 400),
                        ) { it },
            ) {
                FancyPrimaryButton(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, bottom = 32.dp),
                    buttonText = "Calculate",
                ) {
                    onCalculateClick()
                }
            }
        }
    }
}
