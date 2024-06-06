package ru.budget.mobile.ui.entities

data class Transaction(
    val id: Long,
    val title: String,
    val type: TransactionType,
    val category: CategoryEnum,
    val sum: Double
)
