package com.doctores.doctores.domains.request

import java.time.Instant

data class UpdatePatientRequest(
    val nombre: String?,
    val apellido: String?,
    val identificacion: String?,
    val telefono: Long?,
    val updatedAt: Instant?
)
