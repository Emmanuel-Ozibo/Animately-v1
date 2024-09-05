package com.example.animatelyapp.ui.components

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.ui.theme.AnimatelyAppTheme
import com.example.animatelyapp.ui.theme.green
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun AnimatedCounterTextView(
    modifier: Modifier = Modifier,
    value: Int,
) {
    // start from the middle
    var initialValue by remember { mutableIntStateOf(value / 2) }

    val animatedValue by animateIntAsState(
        targetValue = initialValue,
        label = "intAmin",
        animationSpec = tween(durationMillis = 300),
    )

    LaunchedEffect("value") {
        val slice = value / 100
        launch {
            while (animatedValue < value) {
                initialValue += slice
                delay(20)
            }
            initialValue = value
        }
    }

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.Bottom,
    ) {
        Text(
            text = "\$$animatedValue",
            color = green,
            style = MaterialTheme.typography.displaySmall.copy(
                fontWeight = FontWeight.SemiBold
            ),
        )

        Text(
            modifier = Modifier.padding(start = 4.dp, bottom = 4.dp),
            text = "USD",
            color = green,
            style = MaterialTheme.typography.titleLarge.copy(
                fontWeight = FontWeight.SemiBold
            ),
        )
    }
}

@Preview
@Composable
private fun AnimatedCounterTextViewPreview() {
    AnimatelyAppTheme {
        AnimatedCounterTextView(value = 3000)
    }
}
