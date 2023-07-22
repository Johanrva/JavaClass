package com.doctores.doctores.domains.request

data class CreatePatientRequest(
    val nombre: String,
    val apellido: String,
    val identificacion: String,
    val telefono: Long?
)
