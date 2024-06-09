package ru.budget.mobile.ui.transactions

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.budget.mobile.R
import ru.budget.mobile.ui.base.productList
import ru.budget.mobile.ui.base.typeOfConsumptionList
import ru.budget.mobile.ui.components.DropdownMenuButton
import ru.budget.mobile.ui.components.ToolBar
import ru.budget.mobile.ui.entities.CategoryEnum
import ru.budget.mobile.ui.entities.Transaction
import ru.budget.mobile.ui.entities.TypeOfConsumption
import ru.budget.mobile.ui.theme.black
import ru.budget.mobile.ui.theme.blue
import ru.budget.mobile.ui.theme.gray3
import ru.budget.mobile.ui.theme.gray4
import ru.budget.mobile.ui.theme.gray5
import ru.budget.mobile.ui.theme.white

@Composable
@Preview(
    showBackground = true,
    device = "spec:width=360dp,height=800dp,dpi=480"
)
fun TransactionScreenPreview() = TransactionScreen()

object State {
    var currentSelect = mutableStateOf(CategoryEnum.ALL)
}

@Composable
fun TransactionScreen() {
    Scaffold(
        topBar = {
            Column(
                content = {
                    ToolBar(
                        title = "Транзакции",
                        color = white
                    )
                    ChoiceBar()
                }
            )
        },
        content = {
            Column(
                content = {
                    ProductList(
                        list = productList
                    )
                },
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .background(white),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )
        },
        containerColor = white
    )
}

@Composable
fun ChoiceBar() {
    Row(
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

        },
        modifier = Modifier
            .padding(
                start = 16.dp
            )
            .fillMaxWidth()
            .height(64.dp),
        horizontalArrangement = Arrangement.spacedBy(
            space = 16.dp,
            alignment = Alignment.Start
        ),
        verticalAlignment = Alignment.CenterVertically
    )
}

@Composable
fun CategoryList() {
    val selectedIndexed = remember { mutableStateOf(CategoryEnum.ALL) }

    LazyRow(
        content = {
            items(typeOfConsumptionList) { item ->
                TypeOfConsumptionItem(
                    typeOfConsumption = item,
                    onClick = {
                        selectedIndexed.value = if (selectedIndexed.value == item.category) item.category else item.category
                        State.currentSelect.value = selectedIndexed.value
                    },
                    selected = selectedIndexed.value == item.category
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
fun ProductList(list: List<Transaction>) {
    if (list.isNotEmpty()) {
        LazyColumn(
            content = {
                items(
                    items = list.filter {
                        if (State.currentSelect.value != CategoryEnum.ALL) {
                            State.currentSelect.value == it.category
                        } else true
                    },
                    itemContent = { item ->
                        TransactionItemTemplate(transaction = item)
                    }
                )
            },
            modifier = Modifier
                .fillMaxSize()
        )
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
                verticalAlignment = Alignment.CenterVertically,
                content = {
                    if (typeOfConsumption.roundColor != Color(0)) {
                        Spacer(
                            modifier = Modifier
                                .height(16.dp)
                                .width(16.dp)
                                .background(
                                    color = typeOfConsumption.roundColor,
                                    shape = RoundedCornerShape(25.dp)
                                )
                        )
                    }
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
            )
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
