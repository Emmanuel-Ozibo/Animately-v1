package com.example.animatelyapp.ui.components.headers

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.R
import com.example.animatelyapp.ui.components.BackgroundIcon
import com.example.animatelyapp.ui.components.CircularAvatar
import com.example.animatelyapp.ui.components.IconPosition
import com.example.animatelyapp.ui.components.IconText
import com.example.animatelyapp.ui.theme.AnimatelyAppTheme
import com.example.animatelyapp.ui.theme.orange
import com.example.animatelyapp.ui.theme.outlineVariantLight
import com.example.animatelyapp.ui.theme.primaryLight

enum class HeaderMode {
    VIEW,
    EDIT,
}

@Composable
fun ShipmentSummaryHeader(
    modifier: Modifier = Modifier,
    onSearchBoxClicked: () -> Unit,
    onBackButtonClicked: () -> Unit = {},
    headerMode: HeaderMode = HeaderMode.VIEW,
) {
    var headerHeight by remember { mutableIntStateOf(0) }

    val transition = updateTransition(targetState = headerMode, label = "transition")

    val paddingTransition by transition.animateDp(
        label = "padding_animation",
        transitionSpec = { tween(durationMillis = 300) },
    ) { mode ->
        when (mode) {
            HeaderMode.VIEW -> 16.dp
            HeaderMode.EDIT -> 0.dp
        }
    }

    val offsetY by transition.animateDp(
        label = "offset_y",
        transitionSpec = { tween(durationMillis = 300) },
    ) { mode ->
        when (mode) {
            HeaderMode.VIEW -> 0.dp
            HeaderMode.EDIT -> -with(LocalDensity.current) { headerHeight.toDp() }
        }
    }

    val iconVisibilityAnimation =
        when (headerMode) {
            HeaderMode.VIEW -> false
            HeaderMode.EDIT -> true
        }

    Surface(
        modifier =
            modifier
                .offset(y = offsetY)
                .fillMaxWidth(),
        color = primaryLight,
    ) {
        Column(
            modifier =
                Modifier.padding(
                    start = paddingTransition,
                    end = 16.dp,
                    bottom = 16.dp,
                    top = 8.dp,
                ),
        ) {
            ProfileSummarySection(
                modifier =
                    Modifier
                        .onGloballyPositioned {
                            headerHeight = it.size.height
                        }
                        .padding(bottom = 16.dp),
            )

            Row(
                modifier = Modifier.padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                AnimatedVisibility(
                    visible = iconVisibilityAnimation,
                    enter = slideInHorizontally(animationSpec = tween(durationMillis = 300)) { -it },
                ) {
                    Icon(
                        modifier = Modifier.size(40.dp).clickable { onBackButtonClicked() },
                        tint = Color.White,
                        imageVector = Icons.Outlined.KeyboardArrowLeft,
                        contentDescription = "",
                    )
                }

                SearchBarSection(
                    modifier =
                        Modifier
                            .clickable { onSearchBoxClicked() },
                )
            }
        }
    }
}

@Composable
fun ProfileSummarySection(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CircularAvatar(modifier = Modifier.size(50.dp))

        Column(modifier = Modifier.padding(start = 16.dp)) {
            IconText(
                text = "Your Location",
                textColor = outlineVariantLight,
                spacing = 8.dp,
                iconPosition = IconPosition.START,
                iconRes = R.drawable.ic_location,
            )

            Spacer(modifier = Modifier.padding(top = 4.dp))

            IconText(
                text = "Emmanuel Ozibo",
                textColor = Color.White,
                spacing = 8.dp,
                iconPosition = IconPosition.END,
                iconRes = R.drawable.ic_arrow_down,
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        BackgroundIcon(
            modifier = Modifier.size(50.dp),
            backgroundColor = Color.White,
            iconTint = Color.Black,
            iconDrawableRes = R.drawable.ic_notification,
            iconPadding = 12.dp,
        )
    }
}

@Composable
fun SearchBarSection(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.height(60.dp),
        shape = RoundedCornerShape(50.dp),
        color = Color.White,
    ) {
        Row(
            modifier =
                Modifier
                    .semantics(mergeDescendants = true) {}
                    .padding(start = 16.dp, end = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search Shipments",
            )

            Text(
                modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                text = "Enter the receipt number",
                color = Color.Gray,
            )

            Spacer(modifier = Modifier.weight(1f))

            BackgroundIcon(
                modifier = Modifier.padding(vertical = 8.dp),
                backgroundColor = orange,
                iconTint = Color.White,
                iconDrawableRes = R.drawable.ic_link,
            )
        }
    }
}

@Preview
@Composable
fun ShipmentSummaryHeaderPreview() {
    AnimatelyAppTheme {
        ShipmentSummaryHeader(
            onSearchBoxClicked = {},
        )
    }
}
