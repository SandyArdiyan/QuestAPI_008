package com.example.questapi_perte12.uicontroller.route

object DestanasiDetail : DestinasiNavigasi {
    override val route = "detail_siswa"
    override val titleRes = R.string.detail_siswa
    const val itemIdArg = "idSiswa"
    val routeWithArgs = "&route/{$itemIdArg}"
}