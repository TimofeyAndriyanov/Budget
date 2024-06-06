package ru.budget.mobile.ui.main

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.rememberScrollState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.runtime.mutableStateOf
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.runtime.remember
import ru.budget.mobile.ui.components.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.Alignment
import androidx.compose.foundation.*
import androidx.compose.material3.*
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import ru.budget.mobile.ui.theme.*
import androidx.compose.ui.unit.*
import kotlinx.coroutines.launch
import ru.budget.mobile.R
import ru.budget.mobile.ui.consumption.BottomSheet
import ru.budget.mobile.ui.entities.TransactionType

@Composable
@Preview(
    showBackground = true,
    device = "id:Xiaomi POCO M5s"
)
fun MainScreenPreview() = MainScreen()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState()
    val type = remember {
        mutableStateOf(TransactionType.CONSUMPTION)
    }
    val show = remember {
        mutableStateOf(false)
    }

    Scaffold(
        modifier = Modifier.background(color = black),
        topBar = {
            ToolBar(
                title = "Главная",
                actions = {
                    Balance(
                        sum = 0
                    )
                },
                color = white1
            )
        },
        floatingActionButton = {
            val visibly = remember {
                mutableStateOf(false)
            }
            Column(
                content = {
                    ActionMenu(
                        visibly = visibly.value,
                        items = {
                            TextFAB(
                                title = "Расход",
                                icon = R.drawable.minus,
                                onClick = {
                                    type.value = TransactionType.CONSUMPTION
                                    show.value = true
                                    scope.launch {
                                        sheetState.show()
                                    }
                                }
                            )
                            TextFAB(
                                title = "Доход",
                                icon = R.drawable.add,
                                onClick = {
                                    type.value = TransactionType.INCOME
                                    show.value = true
                                    scope.launch {
                                        sheetState.show()
                                    }
                                }
                            )
                            TextFAB(
                                title = "Закрыть",
                                icon = R.drawable.close,
                                onClick = {
                                    visibly.value = false
                                }
                            )
                        }
                    )
                    FAB(
                        icon = R.drawable.add,
                        onClick = {
                            visibly.value = true
                        },
                        visibly = !visibly.value
                    )
                },
                horizontalAlignment = Alignment.End
            )
        },
        content = {
            if (show.value) {
                BottomSheet(
                    sheetState = sheetState,
                    type = type.value,
                    back = {
                        show.value = false
                        scope.launch {
                            sheetState.hide()
                        }
                    },
                    save = {

                    },
                    onDismissRequest = {
                        show.value = false

                    }
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 16.dp
                    )
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(
                    space = 16.dp,
                    alignment = Alignment.Top
                ),
                horizontalAlignment = Alignment.Start,

                content = {
                    CoinCard(title = "Траты")
                    CoinCard(title = "Доходы")
                }
            )
        },
        containerColor = white1
    )
}

@Composable
fun CoinCard(title: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardColors(
            containerColor = white,
            contentColor = white,
            disabledContentColor = white,
            disabledContainerColor = white
        ),
        content = {
            Column(
                modifier = Modifier
                    .padding(
                        start = 24.dp,
                        top = 20.dp,
                        end = 24.dp,
                        bottom = 12.dp
                    ),
                content = {
                    TitleCard(title = title)
                    ItemCard(title = "Сегодня")
                    Rectangle()
                    ItemCard(title = "Неделя")
                    Rectangle()
                    ItemCard(title = "Месяц")
                }
            )
        },
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(
            width = 1.dp,
            color = gray1
        )
    )
}

@Composable
fun Rectangle() =
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(gray2)
    )

@Composable
fun ItemCard(title: String) =
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp),
        content = {
            Text(
                text = title,
                textAlign = TextAlign.Start
            )
            Text(
                text = "0₽",
                textAlign = TextAlign.End
            )
        },
        verticalAlignment = Alignment.CenterVertically
    )

@Composable
fun TitleCard(title: String) {
    Text(
        modifier = Modifier
            .padding(
                bottom = 16.dp
            )
            .border(
                width = 0.dp,
                color = white,
                shape = RoundedCornerShape(0.dp)
            ),
        text = title,
        style = TextStyle(
            fontSize = 20.sp,
            lineHeight = 23.sp,
            fontFamily = FontFamily(
                Font(R.font.roboto)
            ),
            fontWeight = FontWeight.Bold,
            color = black
        )
    )
}

@Composable
fun RowScope.Text(text: String, textAlign: TextAlign) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .weight(50f),
        text = text,
        style = TextStyle(
            fontSize = 16.sp,
            lineHeight = 18.75.sp,
            fontFamily = FontFamily(
                Font(R.font.roboto)
            ),
            fontWeight = FontWeight.Normal,
            color = black,
            textAlign = textAlign
        )
    )
}