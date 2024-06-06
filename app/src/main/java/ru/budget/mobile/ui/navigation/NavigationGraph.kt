package ru.budget.mobile.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.budget.mobile.ui.main.MainScreen
import ru.budget.mobile.ui.transactions.TransactionScreen


@Composable
fun NavigationGraph(navHostController: NavHostController) =
    NavHost(
        navController = navHostController,
        startDestination = "main",
        builder = {
            composable(
                "main",
                content = {
                    MainScreen()
                }
            )
            composable(
                "transactions",
                content = {
                    TransactionScreen()
                }
            )
        }
    )