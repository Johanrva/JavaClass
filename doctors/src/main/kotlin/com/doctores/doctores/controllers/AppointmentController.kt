package com.doctores.doctores.controllers
import com.doctores.doctores.constants.*
import com.doctores.doctores.domains.request.CreateAppointmentRequest
import com.doctores.doctores.domains.request.UpdateAppointmentRequest
import com.doctores.doctores.domains.responses.CreateAppointmentResponse
import com.doctores.doctores.domains.responses.Result
import com.doctores.doctores.services.AppointmentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
class AppointmentController {
    @Autowired
    private lateinit var appointmentService: AppointmentService
    @GetMapping(Appointment)
    fun getAllAppointments(): List<CreateAppointmentResponse> = appointmentService.getAllAppointments()
    @PostMapping(CreateAppointments)
    fun createAppointment(
        @RequestBody @Validated request: CreateAppointmentRequest
    ): Result<CreateAppointmentResponse> = appointmentService.createAppointment(request)
    @GetMapping(GetAppointmentById)
    fun getAppointmentById(
        @PathVariable("id") id: Long
    ): Result<CreateAppointmentResponse> = appointmentService.getAppointmentById(id)
    @PutMapping(UpdateAppointment)
    fun updateAppointment(
        @PathVariable("id") id: Long,
        @RequestBody @Validated request: UpdateAppointmentRequest
    ): Result<CreateAppointmentResponse> = appointmentService.updateAppointment(id, request)
}