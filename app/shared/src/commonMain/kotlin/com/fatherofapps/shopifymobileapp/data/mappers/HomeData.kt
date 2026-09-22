package com.fatherofapps.shopifymobileapp.data.mappers

import com.fatherofapps.shopifymobileapp.HomePageDataQuery
import com.fatherofapps.shopifymobileapp.models.Category
import com.fatherofapps.shopifymobileapp.models.Image
import com.fatherofapps.shopifymobileapp.models.MoneyV2
import com.fatherofapps.shopifymobileapp.models.PriceRange
import com.fatherofapps.shopifymobileapp.models.Product


fun HomePageDataQuery.Node.toProductModel() = Product(
    id = id,
    title = title,
    handle = handle,
    createdAt = createdAt.toString(),
    featuredImage = featuredImage?.toImageModel(),
    priceRange = priceRange.toPriceRangeModel()
)

fun HomePageDataQuery.FeaturedImage.toImageModel() = Image(
    url = url.toString(),
    altText = altText
)

fun HomePageDataQuery.PriceRange.toPriceRangeModel() = PriceRange(
    minVariantPrice = minVariantPrice.toMoneyV2Model()
)

fun HomePageDataQuery.MinVariantPrice.toMoneyV2Model() = MoneyV2(
    amount = amount.toString(),
    currencyCode = currencyCode.rawValue
)

fun HomePageDataQuery.Node1.toProductModel() = Product(
    id = id,
    title = title,
    handle = handle,
    featuredImage = featuredImage?.toImageModel(),
    priceRange = priceRange.toPriceRangeModel()
)

fun HomePageDataQuery.FeaturedImage1.toImageModel() = Image(
    url = url.toString(),
    altText = altText
)

fun HomePageDataQuery.PriceRange1.toPriceRangeModel() = PriceRange(
    minVariantPrice = minVariantPrice.toMoneyV2Model()
)

fun HomePageDataQuery.MinVariantPrice1.toMoneyV2Model() = MoneyV2(
    amount = amount.toString(),
    currencyCode = currencyCode.rawValue
)

fun HomePageDataQuery.Node2.toCategoryModel() = Category(
    id = id,
    title = title,
    handle = handle
)