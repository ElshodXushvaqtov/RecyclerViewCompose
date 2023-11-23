package com.example.recyclerview.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.recyclerview.DetailsScreen
import com.example.recyclerview.HomeScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Home.route
    ) {
        composable(
            route = Screens.Home.route
        ) {
            HomeScreen(navController)
        }

        composable(
            route = Screens.Details.route,
            arguments = listOf(
                navArgument(name = ID_KEY) {
                    type = NavType.IntType
                }
            )) { navBackStackEntry ->
            val id = navBackStackEntry.arguments?.getInt(ID_KEY)
            if (id != null) {
                DetailsScreen(id = id)
            }
        }
    }
}