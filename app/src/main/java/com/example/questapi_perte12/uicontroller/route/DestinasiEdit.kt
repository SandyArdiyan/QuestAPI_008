package com.example.questapi_perte12.uicontroller.route

import com.example.questapi_perte12.R

object DestanasiEdit : DestinasiNavigasi {
    override val route = "item_edit"
    override val titleRes = R.string.edit_siswa
    const val itemIdArg = "idSiswa"

    // PERBAIKAN: Gunakan $route
    val routeWithArgs = "$route/{$itemIdArg}"
}