package ru.budget.mobile.ui.base

import androidx.compose.ui.graphics.Color
import ru.budget.mobile.R
import ru.budget.mobile.ui.entities.Category
import ru.budget.mobile.ui.entities.CategoryEnum
import ru.budget.mobile.ui.entities.Transaction
import ru.budget.mobile.ui.entities.TransactionType
import ru.budget.mobile.ui.entities.TypeOfConsumption

val typeOfConsumptionList = listOf(
    TypeOfConsumption(
        id = 1,
        title = "Все",
        roundColor = Color(0)
    ),
    TypeOfConsumption(
        id = 2,
        title = "Продукты",
        roundColor = Color(0xFF62B9BA)
    ),
    TypeOfConsumption(
        id = 3,
        title = "Развлечения",
        roundColor = Color(0xFFFF2684)
    ),
    TypeOfConsumption(
        id = 4,
        title = "Еда",
        roundColor = Color(0xFF3A52BC)
    ),
    TypeOfConsumption(
        id = 5,
        title = "Транспорт",
        roundColor = Color(0xFFFFA60F)
    ),
    TypeOfConsumption(
        id = 6,
        title = "Семья",
        roundColor = Color(0xFF844AFF)
    ),
    TypeOfConsumption(
        id = 7,
        title = "Здоровье",
        roundColor = Color(0xFF00B241)
    ),
    TypeOfConsumption(
        id = 8,
        title = "Подарок",
        roundColor = Color(0xFFFF3C49)
    ),
    TypeOfConsumption(
        id = 9,
        title = "Закупки",
        roundColor = Color(0xFF7F5345)
    )
)
val d = CategoryEnum.entries.toList()
val categoryList = listOf(
    Category(
        id = 1,
        title = "Продукты",
        icon = R.drawable.products,
        color = Color(0xFF62B9BA)
    ),
    Category(
        id = 2,
        title = "Развлечения",
        icon = R.drawable.entertainment,
        color = Color(0xFFFF2684)
    ),
    Category(
        id = 3,
        title = "Транспорт",
        icon = R.drawable.transport,
        color = Color(0xFFFFA60F)
    ),
    Category(
        id = 4,
        title = "Еда",
        icon = R.drawable.food,
        color = Color(0xFF3A52BC)
    ),
    Category(
        id = 5,
        title = "Здоровье",
        icon = R.drawable.health,
        color = Color(0xFF00B241)
    ),
    Category(
        id = 6,
        title = "Семья",
        icon = R.drawable.family,
        color = Color(0xFF844AFF)
    ),
    Category(
        id = 7,
        title = "Подарок",
        icon = R.drawable.present,
        color = Color(0xFFFF3C49)
    ),
    Category(
        id = 8,
        title = "Закупки",
        icon = R.drawable.procurement,
        color = Color(0xFF7F5345)
    )
)

val source = listOf(
    Category(
        id = 1,
        title = "Зарплата",
        icon = R.drawable.salary,
        color = Color(0xFF009988)
    )
)
//val productList = emptyList<Transaction>()

val productList = listOf(
    Transaction(
        id = 1,
        title = "Булочка",
        type = TransactionType.CONSUMPTION,
        category = CategoryEnum.FOOD,
        sum = 50.0
    ),
    Transaction(
        id = 2,
        title = "Лекарство",
        type = TransactionType.CONSUMPTION,
        category = CategoryEnum.HEALTH,
        sum = 30.0
    ),
    Transaction(
        id = 3,
        title = "Пиво",
        type = TransactionType.CONSUMPTION,
        category = CategoryEnum.ENTERTAINMENT,
        sum = 70.0
    ),
    Transaction(
        id = 4,
        title = "Проезд на автобусе",
        type = TransactionType.CONSUMPTION,
        category = CategoryEnum.TRANSPORT,
        sum = 110.0
    ),
    Transaction(
        id = 5,
        title = "Подарок маме",
        type = TransactionType.CONSUMPTION,
        category = CategoryEnum.PRESENT,
        sum = 140.0
    ),
    Transaction(
        id = 6,
        title = "Оплата кикбокса Дейвиду",
        type = TransactionType.CONSUMPTION,
        category = CategoryEnum.FAMILY,
        sum = 5000.0
    ),
    Transaction(
        id = 7,
        title = "Телевизор",
        type = TransactionType.CONSUMPTION,
        category = CategoryEnum.PRODUCTS,
        sum = 5.0
    )
    ,
    Transaction(
        id = 8,
        title = "Новая шуба",
        type = TransactionType.CONSUMPTION,
        category = CategoryEnum.PROCUREMENT,
        sum = 5.0
    )
)