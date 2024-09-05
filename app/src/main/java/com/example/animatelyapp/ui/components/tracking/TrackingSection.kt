package com.example.animatelyapp.ui.components.tracking

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.R
import com.example.animatelyapp.ui.components.IconColumn
import com.example.animatelyapp.ui.theme.AnimatelyAppTheme
import com.example.animatelyapp.ui.theme.lightGreen
import com.example.animatelyapp.ui.theme.lightOrange
import com.example.animatelyapp.ui.theme.orange

@Composable
fun TrackingSection(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            modifier = Modifier.padding(bottom = 16.dp),
            text = "Tracking",
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.W500
            ),
        )

        Card(
            colors =
            CardDefaults.cardColors(
                containerColor = Color.White,
            ),
        ) {
            ShipmentNumber(
                modifier =
                Modifier
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                title = "Shipment Number",
                shipmentNumber = "NEJ20089934122231",
                iconRes = R.drawable.ic_fork_lift,
            )

            Divider(
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 16.dp),
                thickness = 1.dp,
                color = Color.Gray.copy(alpha = 0.2f),
            )

            Row(
                modifier = Modifier
                    .height(130.dp)
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    IconColumn(
                        backgroundColor = lightOrange,
                        iconDrawableRes = R.drawable.ic_send_package,
                        iconTint = Color.Unspecified,
                        title = "Sender",
                        description = "Atlanta, 50943",
                    )

                    IconColumn(
                        backgroundColor = lightGreen,
                        iconDrawableRes = R.drawable.ic_package_receive,
                        iconTint = Color.Unspecified,
                        title = "Receive",
                        description = "Chicago, 50943",
                    )
                }

                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    IconColumn(
                        backgroundColor = lightOrange,
                        iconDrawableRes = R.drawable.ic_send_package,
                        iconTint = Color.Unspecified,
                        title = "Time",
                        showIcon = false,
                        showGreenIndicator = true,
                        description = "2 days - 3 days",
                    )

                    IconColumn(
                        backgroundColor = lightOrange,
                        iconDrawableRes = R.drawable.ic_receive_package,
                        iconTint = Color.Unspecified,
                        title = "Status",
                        showIcon = false,
                        description = "Waiting to collect",
                    )
                }
            }

            Divider(
                modifier = Modifier.padding(top = 8.dp),
                thickness = 1.dp,
                color = Color.Gray.copy(alpha = 0.2f),
            )

            Surface(modifier = Modifier.clickable { }, color = Color.White) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Add,
                        contentDescription = "",
                        tint = orange,
                    )
                    Text(
                        text = "Add Stop",
                        style = MaterialTheme.typography.titleMedium,
                        color = orange,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun TrackingSectionPreview() {
    AnimatelyAppTheme {
        TrackingSection()
    }
}
