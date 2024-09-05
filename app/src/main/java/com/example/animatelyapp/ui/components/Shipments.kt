package com.example.animatelyapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.R
import com.example.animatelyapp.ui.theme.AnimatelyAppTheme
import com.example.animatelyapp.ui.theme.primaryLight
import com.example.animatelyapp.utils.DummyData

@Composable
fun Shipments(
    modifier: Modifier = Modifier,
    shipments: List<Shipment> = DummyData.getShipments(),
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        )
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            for (index in shipments.indices) {
                val shipment = shipments[index]

                IconColumn(
                    backgroundColor = primaryLight,
                    iconDrawableRes = R.drawable.ic_package_box,
                    iconTint = Color.Unspecified,
                    showIcon = true,
                    title = shipment.title,
                    description = shipment.detail,
                    titleTextStyle = MaterialTheme.typography.titleMedium,
                    descriptionTextStyle = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.Gray
                    ),
                )

                if (index < DummyData.getShipments().size-1) {
                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 8.dp),
                        color = Color.Gray.copy(alpha = 0.15f),
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ShipmentsPreview() {
    AnimatelyAppTheme {
        Shipments()
    }
}

data class Shipment(
    val title: String,
    val detail: String,
)
