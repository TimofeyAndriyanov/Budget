package ru.budget.mobile.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.budget.mobile.R
import ru.budget.mobile.ui.theme.black
import ru.budget.mobile.ui.theme.white1

@Composable
@Preview(
    showBackground = true,
    device = "id:Xiaomi POCO M5s"
)
fun ToolBarPreview() {
    ToolBar(
        title = "Главная",
        actions = {
            Balance(sum = 0)
        },
        color = white1
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolBar(
    title: String,
    actions: @Composable (RowScope.() -> Unit) = {},
    color: Color
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 32.sp,
                    lineHeight = 38.4.sp,
                    fontFamily = FontFamily(
                        Font(R.font.roboto)
                    ),
                    fontWeight = FontWeight.Medium,
                    letterSpacing = 0.1.sp,
                    color = black
                ),
                modifier = Modifier.padding(
                    top = 13.dp,
                    bottom = 13.dp,
                )
            )
        },
        modifier = Modifier
            .height(64.dp)
            .fillMaxWidth(),
        colors = TopAppBarColors(
            containerColor = color,
            actionIconContentColor = black,
            scrolledContainerColor = black,
            titleContentColor = black,
            navigationIconContentColor = black
        ),
        actions = actions

    )
}

@Composable
fun Balance(sum: Long) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(
                end = 15.dp
            ),

        content = {
            Text(
                text = "Баланс",
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontFamily = FontFamily(
                        Font(R.font.roboto)
                    ),
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 0.5.sp,
                    textAlign = TextAlign.Center,
                    color = black
                ),
                modifier = Modifier
                    .padding(
                        bottom = 2.dp
                    )
            )
            Text(
                text = "$sum ₽",
                style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 1.2.sp,
                    fontFamily = FontFamily(
                        Font(R.font.roboto)
                    ),
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 0.5.sp,
                    textAlign = TextAlign.Center,
                    color = black
                ),
                //modifier = Modifier
                //    .defaultMinSize(
                //        minWidth = 57.dp
                //    )

            )
        },
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Center
    )

}