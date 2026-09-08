package com.fatherofapps.shopifymobileapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform