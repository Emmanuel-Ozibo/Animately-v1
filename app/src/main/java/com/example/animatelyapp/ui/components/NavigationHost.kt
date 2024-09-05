package com.example.animatelyapp.ui.components

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.animatelyapp.ui.components.bottomnavbar.Destinations
import com.example.animatelyapp.ui.screens.ProfileScreen
import com.example.animatelyapp.ui.screens.ShipmentSummaryScreen
import com.example.animatelyapp.ui.screens.calculator.CalculatorResultScreen
import com.example.animatelyapp.ui.screens.calculator.CalculatorScreen
import com.example.animatelyapp.ui.screens.shipmenthistory.ShipmentHistoryScreen
import com.example.animatelyapp.utils.Constants

@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    rootNavController: NavHostController,
    onDestinationChanged: (Boolean) -> Unit,
) {
    rootNavController.addOnDestinationChangedListener { _, destination, _ ->
        onDestinationChanged(
            destination.route == Destinations.Shipment.route  || destination.route == "calculator"
                    || destination.route == "calculator_result",
        )
    }

    NavHost(
        modifier = modifier,
        navController = rootNavController,
        startDestination = "shipments_summary",
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
    ) {
        composable(route = "shipments_summary") {
            ShipmentSummaryScreen()
        }

        navigation(route = "calculateNav", startDestination = "calculator") {
            composable(
                route = "calculator",
                enterTransition = {
                    fadeIn(
                        animationSpec = tween(durationMillis = Constants.TRANSITION_ANIM_DURATION),
                    )
                },
            ) {
                CalculatorScreen(
                    onBackClick = {
                        rootNavController.popBackStack()
                    },
                    onCalculateClick = {
                        rootNavController.navigate("calculator_result")
                    },
                )
            }

            composable(route = "calculator_result") {
                CalculatorResultScreen(
                    backToHomeClick = {
                        rootNavController.navigate("shipments_summary") {
                            popUpTo("home") { inclusive = true }
                        }
                    },
                )
            }
        }

        composable(route = "shipment") {
            ShipmentHistoryScreen(
                onBackClicked = {
                    rootNavController.popBackStack()
                },
            )
        }

        composable(route = "profile_screen") {
            ProfileScreen()
        }
    }
}
