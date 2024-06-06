package ru.budget.mobile.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.boguszpawlowski.composecalendar.SelectableCalendar
import io.github.boguszpawlowski.composecalendar.day.DayState
import io.github.boguszpawlowski.composecalendar.selection.DynamicSelectionState
import ru.budget.mobile.R
import ru.budget.mobile.ui.theme.black
import ru.budget.mobile.ui.theme.black3
import ru.budget.mobile.ui.theme.black4
import ru.budget.mobile.ui.theme.blue
import ru.budget.mobile.ui.theme.white
import java.time.LocalDate


@Composable
@Preview(
    showBackground = true,
    device = "id:Xiaomi POCO M5s"
)
fun CalendarPreview() = Calendar()

@Composable
fun Calendar() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(
                color = white
            )
    ) {
        Text(
            text = "Выберите дату",
            style = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontFamily = FontFamily(
                    Font(R.font.roboto)
                ),
                fontWeight = FontWeight.Medium,
                letterSpacing = 0.1.sp,
                color = black4,
                textAlign = TextAlign.Start
            ),
            modifier = Modifier
                .padding(
                    top = 16.dp,
                    start = 24.dp,
                    end = 12.dp,
                    bottom = 36.dp
                )
                .fillMaxWidth()
        )
        SelectableCalendar(
            showAdjacentMonths = false,
            dayContent = {
                ItemDay(day = it)
            },
            monthHeader = {
                Column {
                    val currentDay = it.currentMonth.atDay(LocalDate.now().dayOfMonth)
                    val currentDayOfWeek = dayOfWeekToRussia[
                        currentDay.dayOfWeek.name
                    ]
                    val currentMonth = dayOfMonthToRussia[
                        currentDay.month.name
                    ]
                    Text(
                        text = "$currentDayOfWeek, ${currentDay.dayOfMonth} ${currentMonth?.get(1).toString()}",
                        style = TextStyle(
                            fontSize = 32.sp,
                            lineHeight = 40.sp,
                            fontFamily = FontFamily(
                                Font(R.font.roboto)
                            ),
                            fontWeight = FontWeight(400),
                            color = black3
                        )
                    )
                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(2.dp)
                            .background(black)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .padding(
                                start = 24.dp
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${currentMonth?.get(0).toString()} ${currentDay.year}",
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 20.sp,
                                fontFamily = FontFamily(
                                    Font(R.font.roboto)
                                ),
                                fontWeight = FontWeight.Medium,
                                letterSpacing = 0.1.sp,
                                color = black4,
                                textAlign = TextAlign.Start
                            )
                        )
                        Row() {
                            ButtonCalendar(icon = R.drawable.back)
                            ButtonCalendar(icon = R.drawable.forward)

                        }

                    }
                }
            },
            daysOfWeekHeader = {
                LazyRow {
                    dayOfWeekToRussia.forEach {
                        item(it.key) {
                            DayOfWeek(title = it.value)
                        }
                    }
                }
            },
            modifier = Modifier
                .width(336.dp)
                .background(color = white)
        )
        Row(
            content = {
                Button(
                    title = "Отмена",
                    onClick = {

                    }
                )
                Button(
                    title = "Сохранить",
                    onClick = {

                    }
                )
            },
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .padding(
                    start = 12.dp,
                    end = 12.dp
                ),
            horizontalArrangement = Arrangement.spacedBy(
                space = 8.dp,
                alignment = Alignment.End
            ),
            verticalAlignment = Alignment.CenterVertically
        )
    }

}

val dayOfWeekToRussia = mapOf(
    "MONDAY" to "Пн",
    "TUESDAY" to "Вт",
    "WEDNESDAY" to "Ср",
    "THURSDAY" to "Чт",
    "FRIDAY" to "Пт",
    "SATURDAY" to "Сб",
    "SUNDAY" to "Вс"
)

val dayOfMonthToRussia = mapOf(
    "JANUARY" to listOf("Январь", "января"),
    "FEBRUARY" to listOf("Февраль", "Февраля"),
    "MARCH" to listOf("Март", "марта"),
    "APRIL" to listOf("Апрель", "апреля"),
    "MAY" to listOf("Май", "мая"),
    "JUNE" to listOf("Июнь", "июня"),
    "JULY" to listOf("Июль", "июля"),
    "AUGUST" to listOf("Август", "августа"),
    "SEPTEMBER" to listOf("Сентябрь", "сентября"),
    "OCTOBER" to listOf("Октябрь", "октября"),
    "NOVEMBER" to listOf("Ноябрь", "ноября"),
    "DECEMBER" to listOf("Декабрь", "декабря"),
)

@Composable
fun DayOfWeek(title: String) {
    Card(
        content = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(
                    space = 10.dp,
                    alignment = Alignment.CenterHorizontally
                ),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = title,
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontFamily = FontFamily(
                            Font(R.font.roboto)
                        ),
                        fontWeight = FontWeight.Normal,
                        letterSpacing = 0.5.sp,
                        textAlign = TextAlign.Center,
                        color = black3
                    )
                )
            }
        },
        modifier = Modifier
            .height(48.dp)
            .width(48.dp),
        shape = RoundedCornerShape(0.dp),
        colors = CardColors(
            contentColor = white,
            containerColor = white,
            disabledContainerColor = white,
            disabledContentColor = white
        )
    )
}

@Composable
fun ItemDay(day: DayState<DynamicSelectionState>) {

    Card(
        content = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(
                    space = 10.dp,
                    alignment = Alignment.CenterHorizontally
                ),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = day.date.dayOfMonth.toString(),
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontFamily = FontFamily(
                            Font(R.font.roboto)
                        ),
                        fontWeight = FontWeight.Normal,
                        letterSpacing = 0.5.sp,
                        textAlign = TextAlign.Center,
                        color = black3
                    )
                )
            }

        },
        modifier = Modifier
            .height(48.dp)
            .width(48.dp),
        shape = RoundedCornerShape(0.dp),
        colors = CardColors(
            contentColor = white,
            containerColor = white,
            disabledContainerColor = white,
            disabledContentColor = white
        )
    )
}

@Composable
fun Button(title: String, onClick: () -> Unit) {
    Card(
        colors = CardColors(
            containerColor = white,
            contentColor = white,
            disabledContentColor = white,
            disabledContainerColor = white
        ),
        onClick = onClick,
        content = {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontFamily = FontFamily(
                        Font(R.font.roboto)
                    ),
                    fontWeight = FontWeight.Medium,
                    letterSpacing = 0.1.sp,
                    textAlign = TextAlign.Center,
                    color = blue
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = 12.dp,
                        top = 10.dp,
                        end = 12.dp,
                        bottom = 10.dp
                    )
            )
        },
        modifier = Modifier
            .height(40.dp)
            .width(100.dp),
        shape = RoundedCornerShape(0.dp)
    )
}

@Composable
fun ButtonCalendar(icon: Int) {
    Card(
        content = {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(
                        start = 8.dp,
                        top = 8.dp,
                        end = 8.dp,
                        bottom = 8.dp
                    )
                    .fillMaxSize()
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = null,
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp)
                )
            }
        },
        modifier = Modifier
            .height(48.dp)
            .width(48.dp),
        shape = RoundedCornerShape(0.dp),
        colors = CardColors(
            containerColor = white,
            contentColor = black4,
            disabledContainerColor = white,
            disabledContentColor = white
        )
    )
}