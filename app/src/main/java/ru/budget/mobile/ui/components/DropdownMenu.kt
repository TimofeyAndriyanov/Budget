package ru.budget.mobile.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.runtime.remember
import androidx.compose.ui.text.font.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material3.*
import androidx.compose.ui.text.style.TextAlign
import ru.budget.mobile.ui.theme.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.window.PopupProperties
import ru.budget.mobile.R

@Composable
@Preview(
    showBackground = true,
    device = "id:Xiaomi POCO M5s"
)
fun DropdownMenuPreview() = DropdownMenuButton()

@Composable
fun DropdownMenuButton() {
    val visibly = remember {
        mutableStateOf(false)
    }
    val currentItem = remember { mutableStateOf("Расходы") }

    Card(
        modifier = Modifier
            .width(125.dp)
            .height(40.dp),
        onClick = {
            visibly.value = true
        },
        content = {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 8.dp,
                        bottom = 8.dp
                    ),
                content = {
                    DropdownMenuTitle(text = currentItem.value)
                    DropdownMenuIcon(
                        icon = if (visibly.value) R.drawable.up else R.drawable.down
                    )
                    DropdownMenu(
                        visibly = visibly.value,
                        onDismissRequest = {
                            visibly.value = false
                        },
                        items = {
                            DropdownMenuItem(
                                text = "Доходы",
                                onClick = {
                                    currentItem.value = "Доходы"
                                    visibly.value = false
                                }
                            )
                            Spacer(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(1.dp)
                                    .background(
                                        color = gray4
                                    )
                            )
                            DropdownMenuItem(
                                text = "Расходы",
                                onClick = {
                                    currentItem.value = "Расходы"
                                    visibly.value = false
                                }
                            )
                        }
                    )
                },
                horizontalArrangement = Arrangement.spacedBy(
                    space = 6.dp,
                    alignment = Alignment.CenterHorizontally
                ),
                verticalAlignment = Alignment.CenterVertically
            )
        },
        colors = CardColors(
            containerColor = blue,
            contentColor = white,
            disabledContentColor = white,
            disabledContainerColor = blue
        ),
        shape = RoundedCornerShape(12.dp),
        enabled = !visibly.value
    )

}

@Composable
fun DropdownMenu(
    visibly: Boolean,
    onDismissRequest: () -> Unit,
    items: @Composable (ColumnScope.() -> Unit)
) = DropdownMenu(
        expanded = visibly,
        onDismissRequest = onDismissRequest,
        content = items,
        modifier = Modifier
            .width(125.dp)
            .background(
                color = white
            )
    )

@Composable
fun DropdownMenuTitle(text: String) =
    Text(
        text = text,
        style = TextStyle(
            fontSize = 16.sp,
            lineHeight = 1.2.sp,
            fontFamily = FontFamily(
                Font(R.font.inter)
            ),
            fontWeight = FontWeight.Bold,
            color = white
        )
    )

@Composable
fun DropdownMenuIcon(icon: Int) =
    Icon(
        modifier = Modifier
            .width(20.dp)
            .height(20.dp),
        painter = painterResource(id = icon),
        contentDescription = null
    )

@Composable
fun DropdownMenuItem(text: String, onClick: () -> Unit) {
    DropdownMenuItem(
        text = {
            Text(
                text = text,
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 1.2.sp,
                    fontFamily = FontFamily(
                        Font(R.font.roboto)
                    ),
                    fontWeight = FontWeight.Normal,
                    color = black,
                    textAlign = TextAlign.Start
                ),
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 8.dp,
                        end = 16.dp,
                        bottom = 8.dp
                    )
                    .fillMaxSize()
            )
        },
        onClick = onClick
    )

}