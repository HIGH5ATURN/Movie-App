package com.example.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.navigation.screens.home.HomeScreen
import com.example.movieapp.navigation.screens.details.DetailsScreen

//So How this navigation works?
/*
Navigation Component
|->Nav Controller
    |->Nav Host
        |->Nav Graph
            |->Destination
*/



@Composable
fun MovieNavigation(){
    val navController = rememberNavController()

    NavHost(navController=navController,
        startDestination = MovieScreens.HomeScreen.name) {
        //we are building the nav graph here
        //each composable is a node representing each page
        composable(MovieScreens.HomeScreen.name){

         HomeScreen(navController = navController)

        }

        //www.google.com/details-screen/id=34
        composable(MovieScreens.DetaisScreen.name+"/{movie}",
            arguments = listOf(navArgument(name="movie") {type= NavType.StringType})){

            backStackEntry ->
            DetailsScreen(navController = navController, backStackEntry.arguments?.getString("movie"))
        }
    }

}
