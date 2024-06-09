package ru.budget.mobile.ui.entities

import ru.budget.mobile.R

enum class CategoryEnum(open var category: Category) {
    ALL(
        Category(
            id = -1,
            title = "Все",
            icon = 0
        )
    ),
    PRODUCTS(
        Category(
            id = 1,
            title = "Продукты",
            icon = R.drawable.products
        )
    ),
    ENTERTAINMENT(
        Category(
            id = 2,
            title = "Развлечения",
            icon = R.drawable.entertainment
        )
    ),
    TRANSPORT(
        Category(
            id = 3,
            title = "Транспорт",
            icon = R.drawable.transport
        )
    ),
    FOOD(
        Category(
            id = 4,
            title = "Еда",
            icon = R.drawable.food
        )
    ),
    HEALTH(
        Category(
            id = 5,
            title = "Здоровье",
            icon = R.drawable.health
        )
    ),
    FAMILY(
        Category(
            id = 6,
            title = "Семья",
            icon = R.drawable.family
        )
    ),
    PRESENT(
        Category(
            id = 7,
            title = "Подарок",
            icon = R.drawable.present
        )
    ),
    PROCUREMENT(
        Category(
            id = 8,
            title = "Закупки",
            icon = R.drawable.procurement
        )
    )
}