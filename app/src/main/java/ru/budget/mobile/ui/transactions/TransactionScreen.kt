package ru.budget.mobile.ui.transactions

import android.util.Log
import androidx.compose.foundation.shape.RoundedCornerShape
import ru.budget.mobile.ui.entities.TypeOfConsumption
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.material3.CardColors
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.foundation.lazy.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import ru.budget.mobile.ui.components.*
import androidx.compose.ui.text.font.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import ru.budget.mobile.ui.theme.*
import ru.budget.mobile.ui.base.*
import ru.budget.mobile.R
import ru.budget.mobile.ui.entities.CategoryEnum
import ru.budget.mobile.ui.entities.Transaction
import ru.budget.mobile.ui.entities.TransactionType

@Composable
@Preview(
    showBackground = true,
    device = "spec:width=360dp,height=800dp,dpi=480"
)
fun TransactionScreenPreview() = TransactionScreen()

@Composable
fun TransactionScreen() {
    val productList = remember { mutableStateOf(productList) }
    Scaffold(
        topBar = {
            Column(
                content = {
                    ToolBar(
                        title = "Транзакции",
                        color = white
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(64.dp)
                            .padding(
                                start = 16.dp
                            ),
                        horizontalArrangement = Arrangement.spacedBy(
                            space = 16.dp,
                            alignment = Alignment.Start
                        ),
                        verticalAlignment = Alignment.CenterVertically,
                        content = {
                            DropdownMenuButton()
                            Spacer(
                                modifier = Modifier
                                    .height(24.dp)
                                    .width(2.dp)
                                    .background(
                                        color = gray4,
                                        shape = RoundedCornerShape(100.dp)
                                    )
                            )
                            CategoryList()
                        }
                    )
                },
                modifier = Modifier
                    .background(white)
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .background(white),
                content = {
                    ProductList()
                },
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )
        },
        containerColor = white1
    )
}

@Composable
fun ProductList() {
    if (productList.isNotEmpty()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(productList) { item ->
                TransactionItemTemplate(
                    transaction = item
                )
            }
        }
    } else {
        Text(
            text = "Здесь появятся Ваши транзакции.",
            style = TextStyle(
                fontSize = 20.sp,
                lineHeight = 23.sp,
                fontFamily = FontFamily(
                    Font(R.font.roboto)
                ),
                fontWeight = FontWeight.Bold,
                color = gray3
            )
        )
    }
}

@Composable
fun CategoryList() {
    val selectedIndexed = remember { mutableIntStateOf(1) }

    LazyRow(
        content = {
            items(typeOfConsumptionList) { item ->

                TypeOfConsumptionItem(
                    typeOfConsumption = item,
                    onClick = {
                        selectedIndexed.intValue = if (selectedIndexed.intValue == item.id) item.id else item.id
                    },
                    selected = selectedIndexed.intValue == item.id
                )
            }

        },
        horizontalArrangement = Arrangement.spacedBy(
            12.dp,
            alignment = Alignment.Start
        ),
        contentPadding = PaddingValues(
            end = 18.dp
        )
    )
}

@Composable
fun TypeOfConsumptionItem(
    typeOfConsumption: TypeOfConsumption,
    onClick: () -> Unit,
    selected: Boolean
) {
    Card(
        modifier = Modifier
            .height(40.dp),
        content = {
            Row(
                modifier = Modifier
                    .padding(
                        start = 12.dp,
                        top = 8.dp,
                        end = 12.dp,
                        bottom = 8.dp
                    )
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.spacedBy(
                    space = 8.dp,
                    alignment = Alignment.CenterHorizontally
                ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                AnimatedVisibility(
                    visible = typeOfConsumption.roundColor != Color(0),
                    content = {
                        Spacer(modifier = Modifier
                            .height(16.dp)
                            .width(16.dp)
                            .background(
                                color = typeOfConsumption.roundColor,
                                shape = RoundedCornerShape(25.dp)
                            )
                        )
                    }
                )
                Text(
                    text = typeOfConsumption.title,
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontFamily = FontFamily(
                            Font(R.font.roboto)
                        ),
                        fontWeight = FontWeight.Medium,
                        color = if (selected) white else black
                    )
                )
            }
        },
        colors = CardColors(
            containerColor = if (selected) blue else gray5,
            contentColor = white,
            disabledContainerColor = if (selected) blue else gray5,
            disabledContentColor = white
        ),
        onClick = onClick
    )
}
