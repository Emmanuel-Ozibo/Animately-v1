package com.example.animatelyapp.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatelyapp.R
import com.example.animatelyapp.ui.theme.AnimatelyAppTheme
import com.example.animatelyapp.ui.theme.green
import com.example.animatelyapp.ui.theme.orange
import com.example.animatelyapp.ui.theme.paleBlue
import com.example.animatelyapp.ui.theme.statusGray

@Composable
fun FancyStatusBadge(
    modifier: Modifier = Modifier,
    status: Status,
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(24.dp),
        color = statusGray,
    ) {
        Row(
            modifier = Modifier.padding(6.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            val iconRes = getIconRes(status)
            val textColor = getTextColor(status)

            Icon(
                modifier = Modifier.size(16.dp),
                painter = painterResource(id = iconRes),
                contentDescription = status.name,
                tint = textColor,
            )

            Spacer(modifier = Modifier.padding(end = 4.dp))

            Text(
                text = status.uiName,
                color = textColor,
                style = MaterialTheme.typography.titleMedium,
            )
        }
    }
}

fun getIconRes(status: Status): Int {
    return when (status) {
        Status.IN_PROGRESS -> R.drawable.ic_repeat
        Status.PENDING -> R.drawable.ic_refresh
        Status.LOADING -> R.drawable.ic_clock
        else -> throw IllegalArgumentException("Not supported in items")
    }
}

fun getTextColor(status: Status): Color {
    return when (status) {
        Status.IN_PROGRESS -> green
        Status.PENDING -> orange
        Status.LOADING -> paleBlue
        else -> throw IllegalArgumentException("Not supported in items")
    }
}

enum class Status(val uiName: String) {
    IN_PROGRESS("in-progress"),
    PENDING("pending"),
    LOADING("loading"),
    ALL("All"),
    COMPLETED("completed"),
    CANCELLED("cancelled")
}

@Preview
@Composable
fun FancyStatusBadgePreview() {
    AnimatelyAppTheme {
        FancyStatusBadge(
            status = Status.IN_PROGRESS,
        )
    }
}
