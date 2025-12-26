package com.example.questapi_perte12.uicontroller

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.questapi_perte12.uicontroller.route.DestanasiDetail
import com.example.questapi_perte12.uicontroller.route.DestanasiEdit
import com.example.questapi_perte12.uicontroller.route.DestinasiEntry
import com.example.questapi_perte12.uicontroller.route.DestinasiHome
import com.example.questapi_perte12.view.DetailScreen
import com.example.questapi_perte12.view.EditScreen
import com.example.questapi_perte12.view.EntrySiswaScreen
import com.example.questapi_perte12.view.HomeScreen

@Composable
fun DataSiswaApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    HostNavigasi(navController = navController, modifier = modifier)
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {
        // Halaman Home
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                // PERBAIKAN DISINI: Tambahkan logika navigasi ke detail
                navigateToUpdate = { idSiswa ->
                    navController.navigate("${DestanasiDetail.route}/$idSiswa")
                }
            )
        }

