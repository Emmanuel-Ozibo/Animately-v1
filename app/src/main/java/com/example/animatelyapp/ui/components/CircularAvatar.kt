package com.example.animatelyapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.R

@Composable
fun CircularAvatar(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier,
        shape = CircleShape,
    ) {
        Image(
            painter = painterResource(R.drawable.profile_image),
            contentDescription = "Profile picture",
            contentScale = ContentScale.Crop,
        )
    }
}

@Preview
@Composable
fun CircularAvatarPreview() {
    CircularAvatar(
        modifier = Modifier.size(60.dp),
    )
}
