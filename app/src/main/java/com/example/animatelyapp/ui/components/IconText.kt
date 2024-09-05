package com.example.animatelyapp.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.R

@Composable
fun IconText(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color,
    spacing: Dp,
    iconPosition: IconPosition = IconPosition.START,
    @DrawableRes iconRes: Int,
    iconTint: Color = Color.White,
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        if (iconPosition == IconPosition.START) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = "",
                tint = iconTint,
                modifier = Modifier.padding(end = spacing).size(12.dp),
            )
        }

        Text(
            text = text,
            color = textColor,
        )

        if (iconPosition == IconPosition.END) {
            Icon(
                painter = painterResource(id = iconRes),
                contentDescription = "",
                modifier = Modifier.padding(start = spacing).size(12.dp),
                tint = iconTint,
            )
        }
    }
}

enum class IconPosition {
    START,
    END,
}

@Preview
@Composable
fun IconTextPreview() {
    IconText(
        modifier = Modifier.padding(16.dp),
        text = "Emmanuel Ozibo",
        textColor = Color.White,
        spacing = 16.dp,
        iconPosition = IconPosition.START,
        iconRes = R.drawable.ic_link,
    )
}
