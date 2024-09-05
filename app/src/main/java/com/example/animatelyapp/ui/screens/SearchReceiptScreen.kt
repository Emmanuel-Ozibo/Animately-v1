package com.example.animatelyapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.animatelyapp.ui.components.headers.HeaderMode
import com.example.animatelyapp.ui.components.headers.ShipmentSummaryHeader
import kotlinx.coroutines.delay

@Composable
fun SearchReceiptScreen() {
    var headerMode by remember { mutableStateOf(HeaderMode.VIEW) }

    LaunchedEffect(key1 = true) {
        delay(300)
        headerMode = HeaderMode.EDIT
    }

    Column {
        ShipmentSummaryHeader(
            onSearchBoxClicked = {},
            onBackButtonClicked = {
            },
            headerMode = headerMode,
        )
    }
}
