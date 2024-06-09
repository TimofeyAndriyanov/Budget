package ru.budget.mobile.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp

@Composable
fun ActionMenu(items: @Composable (ColumnScope.() -> Unit), visibly: Boolean) =
    if (visibly) {
        Column(
            verticalArrangement = Arrangement.spacedBy(
                space = 20.dp
            ),
            horizontalAlignment = Alignment.End,
            content = items
        )
    } else null
