package com.fatherofapps.shopifymobileapp.models

data class Category(
    val id: String,
    val title: String,
    val handle: String,
    val description: String? = null,
    val descriptionHtml: String? = null,
    val image: Image? = null,
    val updatedAt: String? = null
)