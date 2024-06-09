package ru.budget.mobile.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.budget.mobile.R
import ru.budget.mobile.ui.theme.black
import ru.budget.mobile.ui.theme.blue
import ru.budget.mobile.ui.theme.gray1
import ru.budget.mobile.ui.theme.white

@Composable
fun FAB(icon: Int, onClick: () -> Unit, visibly: Boolean) {
    if (visibly) {
        FloatingActionButton(
            onClick = onClick,
            content = {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    tint = white
                )
            },
            containerColor = blue,
            elevation = FloatingActionButtonDefaults.elevation(0.dp,0.dp)
        )
    }
}

@Composable
fun TextFAB(
    title: String,
    icon: Int,
    onClick: () -> Unit,
    visibly: Boolean = true
) {
    Row(
        content = {
            CardText(text = title)
            FAB(
                icon = icon,
                onClick = onClick,
                visibly = visibly
            )
        },
        horizontalArrangement = Arrangement.spacedBy(
            space = 10.dp,
            alignment = Alignment.CenterHorizontally
        ),
        verticalAlignment = Alignment.CenterVertically
    )
}

@Composable
fun CardText(text: String) {
    Card(
        colors = CardColors(
            containerColor = white,
            contentColor = black,
            disabledContainerColor = white,
            disabledContentColor = white
        ),
        content = {
            Text(
                modifier = Modifier
                    .padding(
                        start = 12.dp,
                        top = 8.dp,
                        end = 12.dp,
                        bottom = 8.dp
                    ),
                text = text,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontFamily = FontFamily(
                        Font(R.font.roboto)
                    ),
                    fontWeight = FontWeight.Medium,
                    letterSpacing = 0.25.sp,
                    color = black
                )
            )
        },
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(
            width = 1.dp,
            color = gray1
        )
    )
}