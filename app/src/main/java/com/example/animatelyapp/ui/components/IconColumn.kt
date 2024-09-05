package com.example.animatelyapp.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.R
import com.example.animatelyapp.ui.theme.AnimatelyAppTheme
import com.example.animatelyapp.ui.theme.lightOrange

@Composable
fun IconColumn(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    @DrawableRes iconDrawableRes: Int,
    iconTint: Color,
    showIcon: Boolean = true,
    showGreenIndicator: Boolean = false,
    title: String,
    description: String,
    iconSize: Dp = 40.dp,
    titleTextStyle: TextStyle = MaterialTheme.typography.bodySmall.copy(
        color = Color.Gray
    ),
    descriptionTextStyle: TextStyle = MaterialTheme.typography.labelLarge,
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        if (showIcon) {
            BackgroundIcon(
                modifier = Modifier.size(iconSize),
                backgroundColor = backgroundColor,
                iconDrawableRes = iconDrawableRes,
                iconTint = iconTint,
            )
        }

        Column(modifier = Modifier.padding(start = if (showIcon) 16.dp else 0.dp)) {
            Text(
                text = title,
                style = titleTextStyle
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (showGreenIndicator) {
                    Surface(modifier = Modifier.size(5.dp), color = Color.Green, shape = CircleShape){}
                }

                Text(
                    text = description,
                    style = descriptionTextStyle,
                )
            }
        }
    }
}

@Preview
@Composable
fun IconColumnPreview() {
    AnimatelyAppTheme {
        IconColumn(
            backgroundColor = lightOrange,
            iconDrawableRes = R.drawable.ic_send_package,
            iconTint = Color.Unspecified,
            title = "Sender",
            description = "Atlanta, 50943",
        )
    }
}

@Preview
@Composable
fun IconColumnShowPreview() {
    AnimatelyAppTheme {
        IconColumn(
            backgroundColor = lightOrange,
            iconDrawableRes = R.drawable.ic_send_package,
            iconTint = Color.Unspecified,
            showIcon = false,
            showGreenIndicator = true,
            title = "Sender",
            description = "Atlanta, 50943",
        )
    }
}
