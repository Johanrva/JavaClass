package com.doctores.doctores.services

import com.doctores.doctores.domains.entity.Patient
import com.doctores.doctores.domains.request.CreatePatientRequest
import com.doctores.doctores.domains.request.UpdatePatientRequest
import com.doctores.doctores.domains.responses.CreatePatientResponse
import com.doctores.doctores.domains.responses.Failure
import com.doctores.doctores.domains.responses.Result
import com.doctores.doctores.domains.responses.Success
import com.doctores.doctores.repositories.PatientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class PatientService {
    @Autowired
    private lateinit var patientRepository: PatientRepository
    fun createPatient(request: CreatePatientRequest): CreatePatientResponse {
        val patient =  patientRepository.save(
            Patient(
                nombre = request.nombre,
                apellido = request.apellido,
                identificacion = request.identificacion,
                telefono = request.telefono,
                updatedAt = Instant.now()
            )
        )
        return mapResponsePatient(patient)
    }

    fun getAllPatients(): List<Patient>{
        val patients : List<Patient> = patientRepository.findAll()
        return patients
    }

    fun getPatientById(id: Long): Result<CreatePatientResponse> {
        var patient: Patient? = patientRepository.getPatientById(id)
        if (patient!=null){
            return Success(mapResponsePatient(patient))
        }else{
            return Failure("Patient not found")
        }
    }

    fun updatePatient(id: Long, request: UpdatePatientRequest): Result<CreatePatientResponse> {
        var patient: Patient? =  patientRepository.getPatientById(id)
        if (patient != null) {
            val patientUpdate = patientRepository.save(
                Patient(
                    idPaciente = id,
                    nombre = request.nombre?: patient.nombre,
                    apellido = request.apellido?: patient.apellido,
                    identificacion = request.identificacion?: patient.identificacion,
                    telefono = request.telefono?: patient.telefono,
                    createdAt = patient.createdAt,
                    updatedAt = Instant.now()
                )
            )
            return Success(mapResponsePatient(patientUpdate))
        } else{
            return Failure("Doctor not found")
        }
    }
}

fun mapResponsePatient (patient: Patient) : CreatePatientResponse {
    return CreatePatientResponse(
        idPaciente = patient.idPaciente,
        nombre = patient.nombre,
        apellido = patient.apellido,
        identificacion = patient.identificacion,
        telefono = patient.telefono,
        createAt = patient.createdAt,
        updateAt = patient.updatedAt
    )
}