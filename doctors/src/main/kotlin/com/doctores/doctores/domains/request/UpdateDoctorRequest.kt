package com.doctores.doctores.domains.request

import java.time.Instant

data class UpdateDoctorRequest(
    val nombre: String?,
    val apellido: String?,
    val especialidad: String?,
    val consultorio: Long?,
    val correo: String?,
    val updatedAt: Instant?
)
