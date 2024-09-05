package com.example.animatelyapp.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.R
import com.example.animatelyapp.ui.theme.orange

@Composable
fun BackgroundIcon(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    @DrawableRes iconDrawableRes: Int,
    iconTint: Color,
    iconPadding: Dp = 8.dp,
) {
    Surface(
        modifier = modifier,
        shape = CircleShape,
        color = backgroundColor,
    ) {
        Icon(
            modifier = Modifier.padding(iconPadding),
            tint = iconTint,
            painter = painterResource(id = iconDrawableRes),
            contentDescription = "Copy Text",
        )
    }
}

@Preview
@Composable
fun BackgroundIconPreview() {
    BackgroundIcon(
        modifier = Modifier.padding(vertical = 8.dp).size(50.dp),
        backgroundColor = orange,
        iconDrawableRes = R.drawable.ic_receiver_address,
        iconTint = Color.White,
    )
}
