package com.example.animatelyapp.ui.screens.calculator.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.R
import com.example.animatelyapp.ui.components.FancyTextField
import com.example.animatelyapp.ui.theme.AnimatelyAppTheme

@Composable
fun ShipmentDestinationWidget(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Destination",
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.W500
            ),
        )

        Card(
            modifier =
                Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
            colors =
                CardDefaults.cardColors(
                    containerColor = Color.White,
                ),
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                FancyTextField(
                    leadingIcon = R.drawable.ic_sender_address,
                    hintText = "Sender location",
                )

                FancyTextField(
                    leadingIcon = R.drawable.ic_receiver_address,
                    hintText = "Receiver location",
                )

                FancyTextField(
                    leadingIcon = R.drawable.ic_timer,
                    hintText = "Approx weight",
                )
            }
        }
    }
}

@Preview
@Composable
fun ShipmentDestinationWidgetPreview() {
    AnimatelyAppTheme {
        ShipmentDestinationWidget()
    }
}
