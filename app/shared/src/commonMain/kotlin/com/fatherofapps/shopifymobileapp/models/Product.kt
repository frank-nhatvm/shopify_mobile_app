package com.fatherofapps.shopifymobileapp.models


data class Product(
    val id: String,
    val title: String,
    val handle: String,
    val description: String? = null,
    val descriptionHtml: String? = null,
    val createdAt: String? = null,
    val featuredImage: Image? = null,
    val priceRange: PriceRange? = null,
    val vendor: String? = null,
    val productType: String? = null,
    val tags: List<String> = emptyList()
)

data class Image(
    val url: String,
    val altText: String? = null,
    val height: Int? = null,
    val width: Int? = null
)

data class PriceRange(
    val minVariantPrice: MoneyV2,
    val maxVariantPrice: MoneyV2? = null
)

data class MoneyV2(
    val amount: String,
    val currencyCode: String
)