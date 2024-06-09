package ru.budget.mobile.ui.entities

import androidx.compose.ui.graphics.Color

data class TypeOfConsumption(
    val id: Long,
    val title: String,
    val category: CategoryEnum,
    val roundColor: Color
)