package ru.budget.mobile.ui.base

import androidx.compose.ui.graphics.Color
import ru.budget.mobile.R
import ru.budget.mobile.ui.entities.*

val typeOfConsumptionList = listOf(
    TypeOfConsumption(
        id = 1,
        title = "Все",
        category = CategoryEnum.ALL,
        roundColor = Color(0)
    ),
    TypeOfConsumption(
        id = 2,
        title = "Продукты",
        category = CategoryEnum.PRODUCTS,
        roundColor = Color(0xFF62B9BA)
    ),
    TypeOfConsumption(
        id = 3,
        title = "Развлечения",
        category = CategoryEnum.ENTERTAINMENT,
        roundColor = Color(0xFFFF2684)
    ),
    TypeOfConsumption(
        id = 4,
        title = "Еда",
        category = CategoryEnum.FOOD,
        roundColor = Color(0xFF3A52BC)
    ),
    TypeOfConsumption(
        id = 5,
        title = "Транспорт",
        category = CategoryEnum.TRANSPORT,
        roundColor = Color(0xFFFFA60F)
    ),
    TypeOfConsumption(
        id = 6,
        title = "Семья",
        category = CategoryEnum.FAMILY,
        roundColor = Color(0xFF844AFF)
    ),
    TypeOfConsumption(
        id = 7,
        title = "Здоровье",
        category = CategoryEnum.HEALTH,
        roundColor = Color(0xFF00B241)
    ),
    TypeOfConsumption(
        id = 8,
        title = "Подарок",
        category = CategoryEnum.PRESENT,
        roundColor = Color(0xFFFF3C49)
    ),
    TypeOfConsumption(
        id = 9,
        title = "Закупки",
        category = CategoryEnum.PROCUREMENT,
        roundColor = Color(0xFF7F5345)
    )
)

val categoryList = listOf(
    Category(
        id = 1,
        title = "Продукты",
        icon = R.drawable.products
    ),
    Category(
        id = 2,
        title = "Развлечения",
        icon = R.drawable.entertainment
    ),
    Category(
        id = 3,
        title = "Транспорт",
        icon = R.drawable.transport
    ),
    Category(
        id = 4,
        title = "Еда",
        icon = R.drawable.food
    ),
    Category(
        id = 5,
        title = "Здоровье",
        icon = R.drawable.health
    ),
    Category(
        id = 6,
        title = "Семья",
        icon = R.drawable.family
    ),
    Category(
        id = 7,
        title = "Подарок",
        icon = R.drawable.present
    ),
    Category(
        id = 8,
        title = "Закупки",
        icon = R.drawable.procurement
    )
)

val source = listOf(
    Category(
        id = 1,
        title = "Зарплата",
        icon = R.drawable.salary
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
        title = "Колбаса",
        type = TransactionType.CONSUMPTION,
        category = CategoryEnum.FOOD,
        sum = 50.0
    ),
    Transaction(
        id = 3,
        title = "Дилдак",
        type = TransactionType.CONSUMPTION,
        category = CategoryEnum.ENTERTAINMENT,
        sum = 666.6
    ),
    Transaction(
        id = 4,
        title = "Лекарство",
        type = TransactionType.CONSUMPTION,
        category = CategoryEnum.HEALTH,
        sum = 30.0
    ),
    Transaction(
        id = 5,
        title = "Пиво",
        type = TransactionType.CONSUMPTION,
        category = CategoryEnum.ENTERTAINMENT,
        sum = 70.0
    ),
    Transaction(
        id = 6,
        title = "Проезд на автобусе",
        type = TransactionType.CONSUMPTION,
        category = CategoryEnum.TRANSPORT,
        sum = 110.0
    ),
    Transaction(
        id = 7,
        title = "Подарок маме",
        type = TransactionType.CONSUMPTION,
        category = CategoryEnum.PRESENT,
        sum = 140.0
    ),
    Transaction(
        id = 8,
        title = "Оплата кикбокса Дейвиду",
        type = TransactionType.CONSUMPTION,
        category = CategoryEnum.FAMILY,
        sum = 5000.0
    ),
    Transaction(
        id = 9,
        title = "Телевизор",
        type = TransactionType.CONSUMPTION,
        category = CategoryEnum.PRODUCTS,
        sum = 2159.4
    ),
    Transaction(
        id = 10,
        title = "Новая шуба",
        type = TransactionType.CONSUMPTION,
        category = CategoryEnum.PROCUREMENT,
        sum = 915.0
    ),
    Transaction(
        id = 11,
        title = "виагра",
        type = TransactionType.CONSUMPTION,
        category = CategoryEnum.HEALTH,
        sum = 150.7
    ),
    Transaction(
        id = 12,
        title = "Новая шуба",
        type = TransactionType.CONSUMPTION,
        category = CategoryEnum.PROCUREMENT,
        sum = 915.0
    ),
    Transaction(
        id = 13,
        title = "виагра",
        type = TransactionType.CONSUMPTION,
        category = CategoryEnum.HEALTH,
        sum = 130.0
    ),
    Transaction(
        id = 14,
        title = "Новая шуба",
        type = TransactionType.CONSUMPTION,
        category = CategoryEnum.PROCUREMENT,
        sum = 915.0
    ),
    Transaction(
        id = 15,
        title = "виагра",
        type = TransactionType.CONSUMPTION,
        category = CategoryEnum.HEALTH,
        sum = 130.0
    ),
)