package ru.budget.mobile.ui.transactions

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.*
import ru.budget.mobile.R
import ru.budget.mobile.ui.entities.*
import ru.budget.mobile.ui.theme.*

@Composable
@Preview(
    showBackground = true,
    device = "id:Xiaomi POCO M5s"
)
fun TransactionItemTemplatePreview() =
    TransactionItemTemplate(
        transaction = Transaction(
            id = 1,
            title = "Сосиски",
            category = CategoryEnum.FOOD,
            sum = 235.0,
            type = TransactionType.CONSUMPTION
        )
    )

@Composable
fun TransactionItemTemplate(
    transaction: Transaction
) {
    Row(
        content = {
            Image(
                painter = painterResource(
                    if (transaction.type == TransactionType.CONSUMPTION) transaction.category.category.icon else R.drawable.salary
                ),
                contentDescription = null,
                modifier = Modifier
                    .padding(
                        end = 16.dp
                    )
            )

            TextTemplate(
                text = if (transaction.type == TransactionType.CONSUMPTION) transaction.title else "Зарплата",
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                visibly = true
            )

            TextTemplate(
                text = "·",
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(
                        start = 8.dp,
                        end = 8.dp
                    ),
                visibly = transaction.type == TransactionType.CONSUMPTION
            )

            TextTemplate(
                text = transaction.category.category.title,
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                visibly = transaction.type == TransactionType.CONSUMPTION
            )
            val char = if (transaction.type == TransactionType.CONSUMPTION) "-" else "+"

            TextTemplate(
                text = "$char${transaction.sum} ₽",
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.End,
                visibly = true
            )
        },
        verticalAlignment = Alignment.CenterVertically,

        modifier = Modifier
            .fillMaxWidth()
            .height(68.dp)
            .padding(
                start = 16.dp,
                end = 16.dp
            )
    )
}

@Composable
fun TextTemplate(
    text: String,
    fontWeight: FontWeight,
    fontSize: TextUnit,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Center,
    visibly: Boolean
) = if (visibly) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = fontSize,
            lineHeight = 20.sp,
            fontFamily = FontFamily(
                Font(R.font.roboto)
            ),
            fontWeight = fontWeight,
            color = black,
            letterSpacing = 0.1.sp,
            textAlign = textAlign
        ),
        modifier = modifier
    )
} else null
