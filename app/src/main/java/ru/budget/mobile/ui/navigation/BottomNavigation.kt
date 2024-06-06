package ru.budget.mobile.ui.navigation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.budget.mobile.R
import ru.budget.mobile.ui.theme.*

@Composable
@Preview(
    showBackground = true,
    device = "id:Xiaomi POCO M5s"
)
fun BottomNavigationPreview() = BottomNavigation()

@Composable
fun BottomNavigation(navigation: NavController = rememberNavController()) {
    val listItem = listOf(
        ItemNavigation.Main(),
        ItemNavigation.Transactions()
    )

    BottomAppBar(
        content = {
            val backstackEntry by navigation.currentBackStackEntryAsState()
            val currentRoute = backstackEntry?.destination?.route

            listItem.forEach { item ->
                Item(
                    itemNavigation = item,
                    selected = currentRoute == item.route,
                    onClick = {
                        navigation.navigate(item.route)
                    }
                )
            }
        },
        containerColor = white,
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = white2
            )
    )
}

@Composable
fun RowScope.Item(
    itemNavigation: ItemNavigation,
    selected: Boolean,
    onClick: () -> Unit
) {
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = {
            Icon(
                painter = painterResource(id = itemNavigation.icon),
                contentDescription = itemNavigation.title
            )
        },
        label = {
            Text(
                text = itemNavigation.title,
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontFamily = FontFamily(
                        Font(R.font.roboto)
                    ),
                    fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.5.sp
                ),
                modifier = Modifier
                    .padding(
                        top = 4.dp,
                    )
            )
        },
        colors = NavigationBarItemColors(
            selectedIconColor = white,
            selectedIndicatorColor = blue,
            selectedTextColor = blue,
            unselectedIconColor = gray,
            unselectedTextColor = gray,
            disabledIconColor = gray,
            disabledTextColor = gray
        )
    )
}

