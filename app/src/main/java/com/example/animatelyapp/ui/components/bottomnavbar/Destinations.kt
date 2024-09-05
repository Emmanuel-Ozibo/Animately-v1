package com.example.animatelyapp.ui.components.bottomnavbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Refresh
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(
    val route: String,
    val title: String,
    val icon: ImageVector,
) {
    data object HomeScreen : Destinations(
        route = "shipments_summary",
        title = "Home",
        icon = Icons.Outlined.Home,
    )

    data object Calculate : Destinations(
        route = "calculateNav",
        title = "Calculate",
        icon = Icons.Outlined.DateRange,
    )

    data object Shipment : Destinations(
        route = "shipment",
        title = "Shipment",
        icon = Icons.Outlined.Refresh,
    )

    data object Profile : Destinations(
        route = "profile_screen",
        title = "Profile",
        icon = Icons.Outlined.Person,
    )
}
