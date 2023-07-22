package com.doctores.doctores.controllers
import com.doctores.doctores.constants.*
import com.doctores.doctores.domains.entity.Patient
import com.doctores.doctores.domains.request.CreatePatientRequest
import com.doctores.doctores.domains.request.UpdatePatientRequest
import com.doctores.doctores.domains.responses.CreatePatientResponse
import com.doctores.doctores.domains.responses.Result
import com.doctores.doctores.services.PatientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
class PatientController {
    @Autowired
    private lateinit var patientService: PatientService
    @GetMapping(Patient)
    fun getAllPatients(): List<Patient> =patientService.getAllPatients()
    @PostMapping(CreatePatients)
    fun createPatient(
        @RequestBody @Validated request: CreatePatientRequest
    ): CreatePatientResponse = patientService.createPatient(request)
    @GetMapping(GetPatientById)
    fun getPatientById(
        @PathVariable("id") id: Long
    ): Result<CreatePatientResponse> = patientService.getPatientById(id)
    @PutMapping(UpdatePatient)
    fun updatePatient(
        @PathVariable("id") id: Long,
        @RequestBody @Validated request: UpdatePatientRequest
    ): Result<CreatePatientResponse> = patientService.updatePatient(id, request)
}