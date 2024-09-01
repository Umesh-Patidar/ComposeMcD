package com.umesh.composemcd.model

import com.umesh.composemcd.R

data class Food(
    val foodId: Int,
    val foodName: String,
    val price: String,
    val categoryName: String,
    val rating: String,
    val description: String,
    val foodUrl: List<Int>
)

val foods = listOf(
    Food(
        foodId = 1,
        foodName = "Cheese Burger",
        price = "2.55",
        categoryName = "Hamburger",
        rating = "4.5",
        description = "A cheeseburger is a hamburger with a slice of melted cheese on top of the meat patty, added near the end of the cooking time. Cheeseburgers can include variations in structure, ingredients and composition. As with other hamburgers, a cheeseburger may include various condiments and other toppings such as lettuce, tomato, onion, pickles, bacon, avocado, mushrooms, mayonnaise, ketchup, and mustard.",
        foodUrl = listOf(
            R.drawable.ic_cheese_burger,
            R.drawable.ic_chicken_burger,
            R.drawable.ic_classic_burger,
        )
    ),
    Food(
        foodId = 2,
        foodName = "Classic Burger",
        price = "3.50",
        categoryName = "Hamburger",
        rating = "4.3",
        description = "The ingredients used to create cheeseburgers follow similar patterns found in the regional variations of hamburgers, although most start with ground beef. Common cheeses used for topping are American, Swiss, Cheddar and other meltable cheeses. Popular toppings include lettuce, tomato, onion, pickles, bacon, avocado or guacamole, sliced sautéed mushrooms, cheese sauce or chili, but the variety of possible toppings is broad.",
        foodUrl = listOf(
            R.drawable.ic_classic_burger,
            R.drawable.ic_cheese_burger,
            R.drawable.ic_chicken_burger,
        )
    ),
    Food(
        foodId = 3,
        foodName = "Chicken Burger",
        price = "3.10",
        categoryName = "Hamburger",
        rating = "4.5",
        description = "In the United States, the chicken sandwich usually consists of a chicken filet or patty, toppings and bread. The chicken meat can be deep fried, grilled, roasted or boiled, served hot or cold, and white or dark meat chicken can be used. Shredded chicken in one form or another, such as chicken salad, can also be used in chicken sandwiches.",
        foodUrl = listOf(
            R.drawable.ic_chicken_burger,
            R.drawable.ic_classic_burger,
            R.drawable.ic_cheese_burger,
        )
    ),
    Food(
        foodId = 4,
        foodName = "King Fries",
        price = "3.50",
        categoryName = "Fries",
        rating = "4.3",
        description = "We outdid ourselves with the King Fries. It was difficult, but we did it. To our potato, we added our creamy cheddar cheese sauce, crispy onions and bacon, lots of bacon. To accompany your menu or to take individually, because one day you're a potato and the next you're the perfect side dish.",
        foodUrl = listOf(
            R.drawable.ic_fries_king,
            R.drawable.ic_cheese_fries,
            R.drawable.ic_peri_fries,
            R.drawable.ic_fries,
            R.drawable.ic_smokey_fries
        )
    ),
    Food(
        foodId = 5,
        foodName = "Cheese Fries",
        price = "2.58",
        categoryName = "Fries",
        rating = "4.5",
        description = "Cheese fries or cheesy chips is a dish consisting of French fries covered in cheese, with the possible addition of various other toppings. Cheese fries are generally served as a lunch or dinner dish. They can be found in fast-food locations, diners, and grills mainly in English speaking countries.",
        foodUrl = listOf(
            R.drawable.ic_cheese_fries,
            R.drawable.ic_fries_king,
            R.drawable.ic_peri_fries,
            R.drawable.ic_fries,
            R.drawable.ic_smokey_fries
        )
    ),
    Food(
        foodId = 6,
        foodName = "Peri Fries",
        price = "2.50",
        categoryName = "Fries",
        rating = "4.3",
        description = "In a bowl, combine the paprika, ground ginger, ground cardamom, granulated garlic, granulated onion, cayenne pepper and salt. Fry the french fries according to package directions and then drain. Toss the hot fries with the honey, sesame seeds and spice mix.",
        foodUrl = listOf(
            R.drawable.ic_peri_fries,
            R.drawable.ic_fries_king,
            R.drawable.ic_cheese_fries,
            R.drawable.ic_fries,
            R.drawable.ic_smokey_fries
        )
    ),
    Food(
        foodId = 7,
        foodName = "Smokey Fries",
        price = "4.50",
        categoryName = "Fries",
        rating = "4.3",
        description = "Smoky Chipotle Parmesan French Fries are a scrumptious snack, appetizer or side. They're subtly spicy, wonderfully smoky, and are crisped to perfection with cheese.Smoky Chipotle Parmesan French Fries on a whim years ago. Turns out it was the best whim ever, and they've become a regular side dish, appetizer and snack at our house.",
        foodUrl = listOf(
            R.drawable.ic_smokey_fries,
            R.drawable.ic_fries_king,
            R.drawable.ic_cheese_fries,
            R.drawable.ic_peri_fries,
            R.drawable.ic_fries,
        )
    ),
    Food(
        foodId = 11,
        foodName = "Cheese Pizza",
        price = "3.40",
        categoryName = "Pizza",
        rating = "4.3",
        description = "Pizza cheese encompasses several varieties and types of cheeses and dairy products that are designed and manufactured for use specifically on pizza. These include processed and modified cheese, such as mozzarella-like processed cheeses and mozzarella variants. The term can also refer to any type of cheese suitable for use on pizza.",
        foodUrl = listOf(
            R.drawable.ic_cheese_pizza,
            R.drawable.ic_paneer_pizza,
            R.drawable.ic_peri_peri_pizza
        )
    ),
    Food(
        foodId = 12,
        foodName = "Paneer Pizza",
        price = "3.40",
        categoryName = "Pizza",
        rating = "4.3",
        description = "Paneer Pizza is out of the world tasty dish made by baking flatrolled wheat flour base and topping it with sauce & veggies. Paneer Pizza is world’s favorite & could be made at home which tastes like Domino’s & Pizza Hut and the family will crave for more. Paneer Pizza published in this post is topped with paneer, capsicum and cheese.",
        foodUrl = listOf(
            R.drawable.ic_paneer_pizza,
            R.drawable.ic_peri_peri_pizza,
            R.drawable.ic_cheese_pizza,
        )
    ),
    Food(
        foodId = 13,
        foodName = "Peri Peri Pizza",
        price = "3.40",
        categoryName = "Pizza",
        rating = "4.3",
        description = "Slice fire roasted red capsicum into strips and add the strips, sliced jalapenos (if you don't mind a bit of heat, alternatively reduce the amount used), green olives and cooked chicken to the pizza, scattering evenly over the base.",
        foodUrl = listOf(
            R.drawable.ic_peri_peri_pizza,
            R.drawable.ic_cheese_pizza,
            R.drawable.ic_paneer_pizza,
        )
    )
)

val selectedItem = listOf(
    Food(
        foodId = 1,
        foodName = "Cheese Burger",
        price = "2.55",
        categoryName = "Hamburger",
        rating = "4.5",
        description = "A cheeseburger is a hamburger with a slice of melted cheese on top of the meat patty, added near the end of the cooking time. Cheeseburgers can include variations in structure, ingredients and composition. As with other hamburgers, a cheeseburger may include various condiments and other toppings such as lettuce, tomato, onion, pickles, bacon, avocado, mushrooms, mayonnaise, ketchup, and mustard.",
        foodUrl = listOf(
            R.drawable.ic_cheese_burger,
            R.drawable.ic_chicken_burger,
            R.drawable.ic_classic_burger,
        )
    ),
    Food(
        foodId = 6,
        foodName = "Peri Fries",
        price = "2.50",
        categoryName = "Fries",
        rating = "4.3",
        description = "In a bowl, combine the paprika, ground ginger, ground cardamom, granulated garlic, granulated onion, cayenne pepper and salt. Fry the french fries according to package directions and then drain. Toss the hot fries with the honey, sesame seeds and spice mix.",
        foodUrl = listOf(
            R.drawable.ic_peri_fries,
            R.drawable.ic_fries_king,
            R.drawable.ic_cheese_fries,
            R.drawable.ic_fries,
            R.drawable.ic_smokey_fries
        )
    ),
    Food(
        foodId = 13,
        foodName = "Peri Peri Pizza",
        price = "3.40",
        categoryName = "Pizza",
        rating = "4.3",
        description = "Slice fire roasted red capsicum into strips and add the strips, sliced jalapenos (if you don't mind a bit of heat, alternatively reduce the amount used), green olives and cooked chicken to the pizza, scattering evenly over the base.",
        foodUrl = listOf(
            R.drawable.ic_peri_peri_pizza,
            R.drawable.ic_cheese_pizza,
            R.drawable.ic_paneer_pizza,
        )
    )
)