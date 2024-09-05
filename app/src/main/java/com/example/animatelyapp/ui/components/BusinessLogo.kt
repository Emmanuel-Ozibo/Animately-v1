package com.example.animatelyapp.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.R
import com.example.animatelyapp.ui.theme.AnimatelyAppTheme
import com.example.animatelyapp.ui.theme.orange
import com.example.animatelyapp.ui.theme.primaryLight

@Composable
fun BusinessLogo(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = "MoveMate",
            style = MaterialTheme.typography.displaySmall,
            color = primaryLight,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
        )

        Icon(
            modifier = Modifier.padding(start = 16.dp).height(50.dp),
            painter = painterResource(id = R.drawable.ic_fast_delivery),
            contentDescription = "",
            tint = orange,
        )
    }
}

@Preview
@Composable
private fun BusinessLogoPreview() {
    AnimatelyAppTheme {
        BusinessLogo()
    }
}
