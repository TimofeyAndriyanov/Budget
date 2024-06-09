package ru.budget.mobile.ui.consumption

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.budget.mobile.R
import ru.budget.mobile.ui.base.*
import ru.budget.mobile.ui.entities.Category
import ru.budget.mobile.ui.entities.CategoryEnum
import ru.budget.mobile.ui.entities.TransactionType
import ru.budget.mobile.ui.theme.*

@Composable
@Preview(
    showBackground = true,
    device = "id:Xiaomi POCO M5s"
)
fun TransactionInputPreview() {
    TransactionInput(
        type = TransactionType.CONSUMPTION,
        save = {

        },
        back = {

        }
    )

}

object State {
    var currentSelect = mutableStateOf(CategoryEnum.ALL)
    val currentSum = mutableStateOf("")
    val currentDescription = mutableStateOf("")
}

@Composable
fun TransactionInput(
    type: TransactionType,
    save: () -> Unit,
    back: () -> Unit
) {
    Scaffold(
        topBar = {
            TopBar(
                title = if (type.id == 1) "Расход" else "Доход",
                save = save,
                back = back,
                saveEnable = if (type == TransactionType.CONSUMPTION) {
                    State.currentSum.value.isNotEmpty() && State.currentDescription.value.isNotEmpty()
                } else {
                    State.currentSum.value.isNotEmpty()
                }
            )
        },
         content = {
             Column(
                 modifier = Modifier
                     .fillMaxSize()

                     .padding(it)
                     .padding(
                         start = 16.dp,
                         end = 16.dp
                     ),
                 content = {
                     Category(
                         title = if (type.id == 1) "Категория" else "Источник",
                         list = if (type.id == 1) categoryList else source
                     )
                     State.currentSum.value = textInput(
                         title = "Сумма",
                         hint = "0 ₽",
                         keyboardType = KeyboardType.Number
                     )
                     DateSelection()

                     if (type.id == 1) {
                         State.currentDescription.value = textInput(
                             title = "На что потрачено?",
                             hint = "Например: Яблоко",
                             KeyboardType.Text
                         )
                     }
                 },
                 verticalArrangement = Arrangement.spacedBy(32.dp)
             )
         },
        containerColor = white
    )
}

@Composable
fun TopBar(
    title: String,
    save: () -> Unit,
    back: () -> Unit,
    saveEnable: Boolean
) {
    Row(
        modifier = Modifier
            .height(44.dp)
            .fillMaxWidth(),
        content = {
            ItemButtonTopBar(
                title = "Назад",
                onClick = back,
                textAlign = TextAlign.Start,
                enable = true
            )
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 17.sp,
                    lineHeight = 20.sp,
                    fontFamily = FontFamily(
                        Font(R.font.roboto)
                    ),
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.25.sp,
                    color = black,
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier
                    .weight(33.3f)
                    .fillMaxWidth()
            )
            ItemButtonTopBar(
                title = "Сохранить",
                onClick = save,
                textAlign = TextAlign.End,
                enable = saveEnable
            )
        },
        horizontalArrangement = Arrangement.Absolute.Center,
        verticalAlignment = Alignment.CenterVertically
    )
}

@Composable
fun RowScope.ItemButtonTopBar(
    title: String,
    onClick: () -> Unit,
    textAlign: TextAlign,
    enable: Boolean
) {
    Text(
        text = title,
        style = TextStyle(
            fontSize = 16.sp,
            lineHeight = 20.sp,
            fontFamily = FontFamily(
                Font(R.font.roboto)
            ),
            fontWeight = FontWeight.Medium,
            letterSpacing = 0.25.sp,
            color = if (enable) blue else gray6,
            textAlign = textAlign
        ),
        modifier = Modifier
            .padding(
                start = 17.dp,
                end = 17.dp
            )
            .clickable(
                onClick = onClick,
                enabled = enable
            )
            .weight(33.3f)
    )
}

@Composable
fun Category(title: String, list: List<Category>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = 43.dp
            ),
        content = {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 1.2.sp,
                    fontFamily = FontFamily(
                        Font(R.font.roboto)
                    ),
                    fontWeight = FontWeight.Medium,
                    color = black
                )
            )
            val selectedIndexed = remember { mutableLongStateOf(0) }

            LazyRow(
                content = {
                    items(list) { item ->
                        ItemCategory(
                            category = item,
                            onClick = {
                                selectedIndexed.longValue = if (selectedIndexed.longValue == item.id) item.id else item.id
                                State.currentSelect.value.category = item
                            },
                            selected = selectedIndexed.longValue == item.id
                        )
                    }
                },
                horizontalArrangement = Arrangement.spacedBy(
                    space = 12.dp,
                    alignment = Alignment.Start
                )
            )
        },
        verticalArrangement = Arrangement.spacedBy(space = 20.dp)
    )
}

@Composable
fun ItemCategory(
    category: Category,
    onClick: () -> Unit,
    selected: Boolean
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(
            space = 8.dp
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(
                onClick = onClick
            )
    ) {
        Box(
            contentAlignment = Alignment.TopEnd
        ) {

            Image(
                painter = painterResource(id = category.icon),
                contentDescription = null
            )
            if (selected) {
                Image(
                    painter = painterResource(id = R.drawable.select),
                    contentDescription = null,
                    modifier = Modifier
                        .offset(
                            x = 6.dp,
                            y = (-4).dp
                        )
                )
            }
        }


        Text(
            text = category.title,
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontFamily = FontFamily(
                    Font(R.font.roboto)
                ),
                fontWeight = FontWeight.Normal,
                letterSpacing = 0.25.sp,
                color = black
            )
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun textInput(title: String, hint: String, keyboardType: KeyboardType): String {
    val text = remember { mutableStateOf("") }

    Column(
        content = {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 1.2.sp,
                    fontFamily = FontFamily(
                        Font(R.font.roboto)
                    ),
                    fontWeight = FontWeight.Medium,
                    color = black,
                ),
                modifier = Modifier.padding(bottom = 11.dp)
            )

            TextField(
                value = text.value,
                onValueChange = { textInput ->
                    text.value = textInput
                },
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontFamily = FontFamily(
                        Font(R.font.roboto)
                    ),
                    fontWeight = FontWeight.Normal,
                    letterSpacing = 0.25.sp,
                    color = black
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                placeholder = {
                    Text(
                        text = hint,
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            fontFamily = FontFamily(
                                Font(R.font.roboto)
                            ),
                            fontWeight = FontWeight.Normal,
                            letterSpacing = 0.25.sp,
                            color = gray8
                        )
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    disabledTextColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    containerColor = gray7
                ),
                shape = RoundedCornerShape(12.dp),
                suffix = {

                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType
                )
            )
        }
    )

    return text.value
}

@Composable
fun DateSelection() {
    Column(
        verticalArrangement = Arrangement.spacedBy(
            space = 11.dp,
            alignment = Alignment.Top
        ),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Дата",
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 1.2.sp,
                fontFamily = FontFamily(
                    Font(R.font.roboto)
                ),
                fontWeight = FontWeight.Medium,
                color = black,
            ),
            modifier = Modifier.padding(bottom = 11.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(
                space = 12.dp,
                alignment = Alignment.Start
            ),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.calendar),
                contentDescription = null,
                modifier = Modifier
                    .background(
                        color = gray9,
                        shape = RoundedCornerShape(12.dp)
                    )
            )
            Text(
                text = "Сегодня, 30 мая",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontFamily = FontFamily(
                        Font(R.font.roboto)
                    ),
                    fontWeight = FontWeight.Normal,
                    color = black,
                    letterSpacing = 0.25.sp
                )
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    sheetState: SheetState,
    type: TransactionType,
    back: () -> Unit,
    save: () -> Unit,
    onDismissRequest: () -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = onDismissRequest,
        content = {
            TransactionInput(
                back = back,
                save = save,
                type = type
            )
        },
        shape = RoundedCornerShape(
            topStart = 20f,
            topEnd = 20f
        ),
        modifier = Modifier
            .heightIn(
                max = 750.dp,
                min = 750.dp
            ),
        sheetState = sheetState,
        containerColor = white
    )

}
