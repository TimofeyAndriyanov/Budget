package ru.budget.mobile.ui.navigation

import ru.budget.mobile.R

sealed class ItemNavigation(
    val title: String,
    val icon: Int,
    val route: String
) {
    class Main: ItemNavigation(
        title = "Главная",
        icon = R.drawable.home,
        route = "main"
    )

    class Transactions: ItemNavigation(
        title = "Транзакции",
        icon = R.drawable.transactions,
        route = "transactions"
    )
}