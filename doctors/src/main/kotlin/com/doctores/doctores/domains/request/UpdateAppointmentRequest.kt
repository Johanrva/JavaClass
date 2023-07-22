package com.doctores.doctores.domains.request

data class UpdateAppointmentRequest(
    val horario : String?,
    val especialidad : String?,
    val idDoctor : Long?,
    val identificacionPaciente : String?,
)
