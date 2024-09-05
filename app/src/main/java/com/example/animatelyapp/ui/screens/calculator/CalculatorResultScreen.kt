package com.example.animatelyapp.ui.screens.calculator

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseInOutCubic
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.R
import com.example.animatelyapp.ui.components.AnimatedCounterTextView
import com.example.animatelyapp.ui.components.BusinessLogo
import com.example.animatelyapp.ui.components.FancyPrimaryButton
import com.example.animatelyapp.ui.theme.AnimatelyAppTheme
import kotlinx.coroutines.launch

@Composable
fun CalculatorResultScreen(
    modifier: Modifier = Modifier,
    backToHomeClick: () -> Unit,
) {
    val businessLogoAnimatable = remember { Animatable(0f) }
    val businessLogoTranslationAnimatable = remember { Animatable(500f) }

    val boxImageAnimatable = remember { Animatable(0f) }
    val boxImageTranslationAnimatable = remember { Animatable(500f) }

    val estimatedAmountAnimatable = remember { Animatable(0f) }
    val estimatedAmountTranslationAnimatable = remember { Animatable(500f) }

    val buttonAnimatable = remember { Animatable(0f) }
    val buttonTranslationAnimatable = remember { Animatable(500f) }

    LaunchedEffect("anim") {
        // Business logo animatable.
        launch {
            businessLogoAnimatable.animateTo(
                1f,
                animationSpec = tween(durationMillis = 300, easing = EaseInOutCubic),
            )
        }
        launch {
            businessLogoTranslationAnimatable.animateTo(
                0f,
                animationSpec = tween(durationMillis = 300, easing = EaseInOutCubic),
            )
        }

        // Image box
        launch {
            boxImageAnimatable.animateTo(
                1f,
                animationSpec =
                    tween(
                        durationMillis = 300,
                        delayMillis = 100,
                        easing = EaseInOutCubic,
                    ),
            )
        }
        launch {
            boxImageTranslationAnimatable.animateTo(
                0f,
                animationSpec =
                    tween(
                        durationMillis = 300,
                        delayMillis = 100,
                        easing = EaseInOutCubic,
                    ),
            )
        }

        // Total estimate
        launch {
            estimatedAmountAnimatable.animateTo(
                1f,
                animationSpec =
                    tween(
                        durationMillis = 300,
                        delayMillis = 200,
                        easing = EaseInOutCubic,
                    ),
            )
        }
        launch {
            estimatedAmountTranslationAnimatable.animateTo(
                0f,
                animationSpec =
                    tween(
                        durationMillis = 300,
                        delayMillis = 200,
                        easing = EaseInOutCubic,
                    ),
            )
        }

        // Button
        launch {
            buttonAnimatable.animateTo(
                1f,
                animationSpec =
                    tween(
                        durationMillis = 300,
                        delayMillis = 300,
                        easing = EaseInOutCubic,
                    ),
            )
        }

        launch {
            buttonTranslationAnimatable.animateTo(
                0f,
                animationSpec =
                    tween(
                        durationMillis = 300,
                        delayMillis = 300,
                        easing = EaseInOutCubic,
                    ),
            )
        }
    }

    Column(
        modifier = modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        BusinessLogo(
            modifier =
                Modifier.graphicsLayer {
                    scaleX = businessLogoAnimatable.value
                    scaleY = businessLogoAnimatable.value
                    alpha = businessLogoAnimatable.value
                    translationY = businessLogoTranslationAnimatable.value
                },
        )

        Image(
            modifier =
                Modifier
                    .size(200.dp)
                    .graphicsLayer {
                        scaleX = boxImageAnimatable.value
                        scaleY = boxImageAnimatable.value
                        alpha = boxImageAnimatable.value
                        translationY = boxImageTranslationAnimatable.value
                    },
            painter = painterResource(id = R.drawable.box),
            contentDescription = "",
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                modifier =
                    Modifier.graphicsLayer {
                        scaleX = estimatedAmountAnimatable.value
                        scaleY = estimatedAmountAnimatable.value
                        alpha = estimatedAmountAnimatable.value
                        translationY = estimatedAmountTranslationAnimatable.value
                    },
                text = "Total Estimated account",
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontWeight = FontWeight.W500
                ),
            )

            AnimatedCounterTextView(
                modifier =
                    Modifier.padding(vertical = 8.dp).graphicsLayer {
                        scaleX = estimatedAmountAnimatable.value
                        scaleY = estimatedAmountAnimatable.value
                        alpha = estimatedAmountAnimatable.value
                        translationY = estimatedAmountTranslationAnimatable.value
                    },
                value = 2000,
            )

            Text(
                modifier =
                    Modifier
                        .padding(vertical = 16.dp, horizontal = 64.dp)
                        .graphicsLayer {
                            scaleX = estimatedAmountAnimatable.value
                            scaleY = estimatedAmountAnimatable.value
                            alpha = estimatedAmountAnimatable.value
                            translationY = estimatedAmountTranslationAnimatable.value
                        },
                text = "This amount is estimated this will vary if you change your location and weight",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                color = Color.Gray,
            )

            FancyPrimaryButton(
                modifier =
                    Modifier
                        .padding(
                            top = 16.dp,
                            bottom = 32.dp,
                            start = 16.dp,
                            end = 16.dp,
                        )
                        .fillMaxWidth()
                        .graphicsLayer {
                            scaleX = buttonAnimatable.value
                            scaleY = buttonAnimatable.value
                            alpha = buttonAnimatable.value
                            translationY = buttonTranslationAnimatable.value
                        },
                buttonText = "Back to home",
            ) {
                backToHomeClick()
            }
        }
    }
}

enum class ResultState {
    START,
    END,
}

@Preview
@Composable
private fun CalculatorResultScreenPreview() {
    AnimatelyAppTheme {
        CalculatorResultScreen {
        }
    }
}
