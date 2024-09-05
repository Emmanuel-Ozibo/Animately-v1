package com.example.animatelyapp.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.ui.theme.deepOrange
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun FancyPrimaryButton(
    modifier: Modifier = Modifier,
    buttonText: String,
    onClick: () -> Unit,
) {
    var scaleFactor by remember { mutableFloatStateOf(1f) }

    val scale by animateFloatAsState(targetValue = scaleFactor, label = "scaleAnimation")

    Button(
        modifier =
            modifier
                .height(50.dp)
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                },
        onClick = {
            CoroutineScope(Dispatchers.Main).launch {
                scaleFactor = 0.8f
                delay(200)
                scaleFactor = 1f
                delay(200)
                onClick()
            }
        },
        shape = RoundedCornerShape(50.dp),
        colors =
            ButtonDefaults.buttonColors(
                containerColor = deepOrange,
            ),
    ) {
        Text(
            text = buttonText,
            style = MaterialTheme.typography.titleMedium,
        )
    }
}

@Preview
@Composable
fun FancyPrimaryButtonPreview() {
    FancyPrimaryButton(
        modifier = Modifier.fillMaxWidth(),
        buttonText = "Calculate",
        onClick = { },
    )
}
