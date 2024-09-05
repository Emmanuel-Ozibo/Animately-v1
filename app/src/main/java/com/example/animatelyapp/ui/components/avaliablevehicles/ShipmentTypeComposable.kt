package com.example.animatelyapp.ui.components.avaliablevehicles

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.R

@Composable
fun ShipmentTypeComposable(
    modifier: Modifier = Modifier,
    shipmentType: String,
    subTitle: String,
    @DrawableRes shipmentImage: Int,
) {
    Card(
        colors =
            CardDefaults.cardColors(
                containerColor = Color.White,
            ),
        modifier = modifier
            .aspectRatio(0.8f)
    ) {
        Column {
            Text(
                modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                text = shipmentType,
                style = MaterialTheme.typography.titleMedium,
            )

            Text(
                modifier = Modifier.padding(start = 16.dp, top = 2.dp),
                text = subTitle,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.Gray
                ),
            )

            Spacer(modifier = Modifier.padding(bottom = 32.dp))

            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(x = 45.dp, y = (-10).dp),
                painter = painterResource(id = shipmentImage),
                contentDescription = "Image of $shipmentType",
                contentScale = ContentScale.Fit,
            )
        }
    }
}

@Preview
@Composable
fun ShipmentTypeComposablePreview() {
    ShipmentTypeComposable(
        shipmentType = "Ocean freight",
        subTitle = "International",
        shipmentImage = R.drawable.img_air_freight,
    )
}
