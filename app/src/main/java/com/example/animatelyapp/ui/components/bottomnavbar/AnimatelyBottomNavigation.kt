package com.example.animatelyapp.ui.components.bottomnavbar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.animatelyapp.ui.theme.primaryLight

@Composable
fun AnimatelyBottomNavigation(
    navController: NavController,
    onDestinationChanged: (Boolean) -> Unit,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    var selectedIndx by remember { mutableIntStateOf(0) }

    val screens =
        listOf(
            Destinations.HomeScreen,
            Destinations.Calculate,
            Destinations.Shipment,
            Destinations.Profile,
        )

    BottomNavigationBar(
        selectedIndex = selectedIndx,
        indicatorColor = primaryLight,
        itemCount = screens.size,
    ) {
        for (screenIndex in screens.indices) {
            val screen = screens[screenIndex]

            BottomNavigationBarItem(
                isSelected = screen.route == currentRoute,
                onItemClick = {
                    selectedIndx = screenIndex

                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                    val shouldHideNavBar = screen == Destinations.Shipment || screen == Destinations.Calculate
                    onDestinationChanged(shouldHideNavBar)
                },
                icon = screen.icon,
                title = screen.title,
            )
        }
    }
}

@Preview
@Composable
fun AppBottomNavigationPreview() {
    AnimatelyBottomNavigation(
        navController = rememberNavController(),
        onDestinationChanged = {},
    )
}
