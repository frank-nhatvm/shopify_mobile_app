package com.fatherofapps.shopifymobileapp.data.repositories

import com.fatherofapps.shopifymobileapp.data.mappers.toCategoryModel
import com.fatherofapps.shopifymobileapp.data.mappers.toProductModel
import com.fatherofapps.shopifymobileapp.data.network.graphql.HomeGraphQLSource
import com.fatherofapps.shopifymobileapp.models.HomeData

interface HomeRepository {
    suspend fun getHomeData(): HomeData
}

class HomeRepositoryImpl constructor(private val homeGraphQLSource: HomeGraphQLSource) :
    HomeRepository {

    override suspend fun getHomeData(): HomeData {
        val data = homeGraphQLSource.getHomeData()
        return HomeData(
            newArrivals = data.newArrivals.nodes.map { it.toProductModel() },
            bestSellers = data.bestSellers.nodes.map { it.toProductModel() },
            categories = data.collections.nodes.map { it.toCategoryModel() }
        )
    }
}