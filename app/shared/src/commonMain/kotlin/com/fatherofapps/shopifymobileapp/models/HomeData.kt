package com.fatherofapps.shopifymobileapp.models

data class HomeData(
    val categories: List<Category>,
    val newArrivals: List<Product>,
    val bestSellers: List<Product>,
)
