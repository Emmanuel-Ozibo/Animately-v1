package com.example.animatelyapp.ui.screens.shipmenthistory.widget


import androidx.compose.animation.core.EaseInBounce
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.R
import com.example.animatelyapp.ui.components.shipments.ShipmentHistory
import com.example.animatelyapp.ui.components.shipments.ShipmentHistoryItemWidget
import com.example.animatelyapp.ui.theme.AnimatelyAppTheme
import com.example.animatelyapp.utils.DummyData

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShipmentHistoryWidget(
    modifier: Modifier = Modifier,
    shipmentHistories: List<ShipmentHistory> = listOf(),
) {

    Column(modifier = modifier) {
        LazyColumn(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(16.dp)) {
            items(
                items = shipmentHistories,
                key = { item -> item.id }
            ) { shipmentHistory ->

                ShipmentHistoryItemWidget(
                    modifier = Modifier.animateItemPlacement(
                        animationSpec = tween(500, easing = EaseInBounce)
                    ),
                    shipmentHistory = shipmentHistory,
                )
            }
        }
    }
}

@Preview
@Composable
fun ShipmentHistoryWidgetPreview() {
    AnimatelyAppTheme {
        ShipmentHistoryWidget(
            shipmentHistories = DummyData.getShipmentHistories(),
        )
    }
}
