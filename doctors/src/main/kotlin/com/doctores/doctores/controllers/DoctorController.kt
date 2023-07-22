package com.doctores.doctores.controllers

import com.doctores.doctores.constants.CreateDoctors
import com.doctores.doctores.constants.Doctor
import com.doctores.doctores.constants.GetDoctorById
import com.doctores.doctores.constants.UpdateDoctor
import com.doctores.doctores.domains.entity.Doctor
import com.doctores.doctores.domains.request.CreateDoctorRequest
import com.doctores.doctores.domains.request.UpdateDoctorRequest
import com.doctores.doctores.domains.responses.CreateDoctorResponse
import com.doctores.doctores.domains.responses.Result
import com.doctores.doctores.services.DoctorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*


@RestController
class DoctorController {
    @Autowired
    private lateinit var doctorService: DoctorService

    @GetMapping(Doctor)
    fun getAllDoctors(): List<Doctor> =doctorService.getAllDoctors()
    @PostMapping(CreateDoctors)
    fun createDoctor(
        @RequestBody @Validated request: CreateDoctorRequest
    ):CreateDoctorResponse = doctorService.createDoctor(request)
    @GetMapping(GetDoctorById)
    fun getDoctorById(
        @PathVariable("id") id: Long
    ): Result<CreateDoctorResponse> = doctorService.getDoctorById(id)
    @PutMapping(UpdateDoctor)
    fun updateDoctor(
        @PathVariable("id") id: Long,
        @RequestBody @Validated request : UpdateDoctorRequest
    ): Result<CreateDoctorResponse> = doctorService.updateDoctor(id, request)
}