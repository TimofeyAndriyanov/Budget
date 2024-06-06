package ru.budget.mobile.ui.entities

import androidx.compose.ui.graphics.Color
import ru.budget.mobile.R

enum class CategoryEnum(open val category: Category) {
    PRODUCTS(
        Category(
            id = 1,
            title = "Продукты",
            icon = R.drawable.products,
            color = Color(0xFF62B9BA)
        )
    ),
    ENTERTAINMENT(
        Category(
            id = 2,
            title = "Развлечения",
            icon = R.drawable.entertainment,
            color = Color(0xFFFF2684)
        )
    ),
    TRANSPORT(
        Category(
            id = 3,
            title = "Транспорт",
            icon = R.drawable.transport,
            color = Color(0xFFFFA60F)
        )
    ),
    FOOD(
        Category(
            id = 4,
            title = "Еда",
            icon = R.drawable.food,
            color = Color(0xFF3A52BC)
        )
    ),
    HEALTH(
        Category(
            id = 5,
            title = "Здоровье",
            icon = R.drawable.health,
            color = Color(0xFF00B241)
        )
    ),
    FAMILY(
        Category(
            id = 6,
            title = "Семья",
            icon = R.drawable.family,
            color = Color(0xFF844AFF)
        )
    ),
    PRESENT(
        Category(
            id = 7,
            title = "Подарок",
            icon = R.drawable.present,
            color = Color(0xFFFF3C49)
        )
    ),
    PROCUREMENT(
        Category(
            id = 8,
            title = "Закупки",
            icon = R.drawable.procurement,
            color = Color(0xFF7F5345)
        )
    )
}