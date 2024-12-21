package com.example.movieapp.navigation

enum class MovieScreens{
    HomeScreen,
    DetaisScreen;

    companion object{
        fun fromRoute(route: String?): MovieScreens
        = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            DetaisScreen.name -> DetaisScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}