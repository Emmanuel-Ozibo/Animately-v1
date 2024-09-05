package com.example.animatelyapp.ui.components.headers

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.ui.theme.primaryLight

@Composable
fun ShipmentCalculationHeader(
    modifier: Modifier = Modifier,
    headerState: ShipmentHeaderState = ShipmentHeaderState.EXPANDED,
    onClick: () -> Unit,
) {
    val stateAnimation = updateTransition(targetState = headerState, label = "header_state")

    val heightAnimation by stateAnimation.animateDp(
        label = "heightAnimation",
        transitionSpec = { tween(durationMillis = 400) },
    ) { state ->
        when (state) {
            ShipmentHeaderState.EXPANDED -> 150.dp
            ShipmentHeaderState.COLLAPSED -> 70.dp
        }
    }

    val iconTranslationX by stateAnimation.animateFloat(
        label = "iconAnimation",
        transitionSpec = { tween(durationMillis = 400) },
    ) { state ->
        when (state) {
            ShipmentHeaderState.EXPANDED -> -100f
            ShipmentHeaderState.COLLAPSED -> 0f
        }
    }

    val textAlpha by stateAnimation.animateFloat(
        label = "textAlphaAnimation",
        transitionSpec = { tween(durationMillis = 400) },
    ) { state ->
        when (state) {
            ShipmentHeaderState.EXPANDED -> 0f
            ShipmentHeaderState.COLLAPSED -> 1f
        }
    }

    Surface(
        modifier =
            modifier
                .height(height = heightAnimation)
                .fillMaxWidth(),
        color = primaryLight,
    ) {
        Row(
            modifier = Modifier.padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                modifier =
                    Modifier
                        .size(40.dp)
                        .clickable { onClick() }
                        .graphicsLayer {
                            translationX = iconTranslationX
                        },
                imageVector = Icons.Outlined.KeyboardArrowLeft,
                contentDescription = "Go Back",
                tint = Color.White,
            )

            Text(
                modifier = Modifier.weight(1f).alpha(textAlpha),
                text = "Calculate",
                color = Color.White,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge,
            )

            Spacer(
                modifier = Modifier.size(40.dp),
            )
        }
    }
}

enum class ShipmentHeaderState {
    EXPANDED,
    COLLAPSED,
}

@Preview
@Composable
fun ShipmentCalculationHeaderPreview() {
    ShipmentCalculationHeader(
        headerState = ShipmentHeaderState.EXPANDED,
        onClick = {},
    )
}
