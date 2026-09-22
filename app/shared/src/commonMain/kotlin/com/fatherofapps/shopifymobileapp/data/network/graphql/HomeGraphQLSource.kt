package com.fatherofapps.shopifymobileapp.data.network.graphql

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Optional
import com.fatherofapps.shopifymobileapp.HomePageDataQuery

interface HomeGraphQLSource {

    suspend fun getHomeData(
        newArrivalsSizeInt: Int = 10,
        bestSellersSizeInt: Int = 10,
        newCategoriesSizeInt: Int = 20,
    ): HomePageDataQuery.Data

}

class HomeGraphQLSourceImpl constructor(private val apolloClient: ApolloClient) : HomeGraphQLSource{

    override suspend fun getHomeData(
        newArrivalsSizeInt: Int,
        bestSellersSizeInt: Int,
        newCategoriesSizeInt: Int
    ): HomePageDataQuery.Data {
        return apolloClient.query(
            HomePageDataQuery(
                newArrivalsCount = Optional.present(newArrivalsSizeInt),
                bestSellersCount = Optional.present(bestSellersSizeInt),
                collectionsCount = Optional.present(newArrivalsSizeInt)
            )
        ).execute().dataOrThrow()
    }
}