package ru.budget.mobile.ui.primary

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import ru.budget.mobile.ui.navigation.BottomNavigation
import ru.budget.mobile.ui.navigation.NavigationGraph
import ru.budget.mobile.ui.theme.white1

@Composable
@Preview(
    showBackground = true,
    device = "id:Xiaomi POCO M5s"
)
fun PrimaryScreenPreview() = PrimaryScreen()

@Composable
fun PrimaryScreen() {
    val navigationController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation(
                navigation = navigationController
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
            ) {
                NavigationGraph(navHostController = navigationController)
            }
        },
        containerColor = white1
    )
}