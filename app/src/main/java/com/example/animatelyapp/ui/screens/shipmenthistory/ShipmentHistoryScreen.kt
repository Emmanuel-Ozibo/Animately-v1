package com.example.animatelyapp.ui.screens.shipmenthistory

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.R
import com.example.animatelyapp.ui.components.Status
import com.example.animatelyapp.ui.components.headers.ShipmentHistoryHeader
import com.example.animatelyapp.ui.components.headers.ShipmentHistoryHeaderState
import com.example.animatelyapp.ui.components.shipments.ShipmentHistory
import com.example.animatelyapp.ui.screens.shipmenthistory.widget.ShipmentHistoryWidget
import com.example.animatelyapp.utils.DummyData
import kotlinx.coroutines.delay

@Composable
fun ShipmentHistoryScreen(onBackClicked: () -> Unit) {
    var headerState by remember { mutableStateOf(ShipmentHistoryHeaderState.START) }
    var showHistories by remember { mutableStateOf(false) }
    val allList = DummyData.getShipmentHistories()
    val shipmentHistory = remember { mutableStateListOf<ShipmentHistory>() }

    LaunchedEffect("shipmentHistory") {
        delay(300)
        showHistories = true
        headerState = ShipmentHistoryHeaderState.FINAL
        shipmentHistory.addAll(DummyData.getShipmentHistories())
    }

    Column {
        ShipmentHistoryHeader(
            onBackClick = onBackClicked,
            headerState = headerState,
            filters = DummyData.getFilterOptions(),
            onItemSelected = { selected ->
                showHistories = false
                if (selected.status == Status.ALL) {
                    shipmentHistory.clear()
                    shipmentHistory.addAll(allList)
                    showHistories = true
                    return@ShipmentHistoryHeader
                }

                val filteredItems = allList.filter { shipment ->
                    shipment.status == selected.status
                }
                shipmentHistory.clear()
                shipmentHistory.addAll(filteredItems)
                showHistories = true
            }
        )

        Spacer(modifier = Modifier.padding(bottom = 16.dp))

        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = stringResource(R.string.shipment_history_list_title),
            style = MaterialTheme.typography.headlineSmall.copy(
                fontWeight = FontWeight.W500
            ),
        )

        Spacer(modifier = Modifier.padding(bottom = 16.dp))

        AnimatedVisibility(
            visible = showHistories,
            enter =
                fadeIn(animationSpec = tween(durationMillis = 300)) +
                    slideInVertically(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioNoBouncy,
                            stiffness = Spring.StiffnessLow,
                        )
                    ) { it * 2 },
            exit = slideOutVertically(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioNoBouncy,
                            stiffness = Spring.StiffnessLow,
                        )
                    ),
        ) {
            ShipmentHistoryWidget(
                modifier = Modifier.padding(16.dp),
                shipmentHistories = shipmentHistory,
            )
        }
    }
}
