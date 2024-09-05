package com.example.animatelyapp.ui.components.tracking

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.R

@Composable
fun ShipmentNumber(
    modifier: Modifier = Modifier,
    title: String,
    shipmentNumber: String,
    @DrawableRes iconRes: Int,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column(modifier = Modifier.padding(end = 16.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.Gray
                ),
            )

            Text(
                text = shipmentNumber,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.SemiBold
                ),
            )
        }

        Image(
            modifier = Modifier.size(50.dp).padding(4.dp),
            painter = painterResource(id = iconRes),
            contentDescription = "",
        )
    }
}

@Preview
@Composable
fun ShipmentNumberPreview() {
    ShipmentNumber(
        title = "Shipment Number",
        shipmentNumber = "NEJKJHJDKKLKHJLDHKJS",
        iconRes = R.drawable.ic_fork_lift,
    )
}
