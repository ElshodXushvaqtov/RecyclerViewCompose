package com.example.recyclerview.navigation

const val ID_KEY = "id_key"

sealed class Screens(val route: String) {
    object Home : Screens("home_screen")
    object Details : Screens(route = "details_screen/{$ID_KEY}") {
        fun getFullRoute(id: Int): String {
            return "details_screen/$id"
        }
    }

}
