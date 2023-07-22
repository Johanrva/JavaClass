package com.doctores.doctores.services

import com.doctores.doctores.domains.entity.Doctor
import com.doctores.doctores.domains.request.CreateDoctorRequest
import com.doctores.doctores.domains.request.UpdateDoctorRequest
import com.doctores.doctores.domains.responses.CreateDoctorResponse
import com.doctores.doctores.domains.responses.Failure
import com.doctores.doctores.domains.responses.Result
import com.doctores.doctores.domains.responses.Success
import com.doctores.doctores.repositories.DoctorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.Instant


@Service
class DoctorService {
    @Autowired
    private lateinit var doctorRepository: DoctorRepository
    fun createDoctor(request: CreateDoctorRequest): CreateDoctorResponse {
        val doctor =  doctorRepository.save(
            Doctor(
                nombre = request.nombre,
                apellido = request.apellido,
                especialidad = request.especialidad,
                correo = request.correo,
                consultorio = request.consultorio,
                updatedAt = Instant.now()
            )
        )
        return mapResponseDoctor(doctor)
}

    fun getAllDoctors(): List<Doctor>{
        val doctors : List<Doctor> = doctorRepository.findAll()
        return doctors
    }

    fun getDoctorById(id: Long): Result<CreateDoctorResponse> {
        var doctor: Doctor? =  doctorRepository.getDoctorById(id)
        if (doctor != null){
            return Success(mapResponseDoctor(doctor))

        }else{
            return Failure("Doctor not found")
        }
    }

    fun updateDoctor(id: Long, request: UpdateDoctorRequest): Result<CreateDoctorResponse>{
        var doctor: Doctor? =  doctorRepository.getDoctorById(id)
        if (doctor != null) {
            val doctorUpdate = doctorRepository.save(
                Doctor(
                    idDoctor = id,
                    nombre = request.nombre?: doctor.nombre,
                    apellido = request.apellido?: doctor.apellido,
                    especialidad = request.especialidad?: doctor.especialidad,
                    correo = request.correo?: doctor.correo,
                    consultorio = request.consultorio?: doctor.consultorio,
                    createdAt = doctor.createdAt,
                    updatedAt = Instant.now()
                )
            )
            return Success(mapResponseDoctor(doctorUpdate))
        } else{
            return Failure("Doctor not found")
        }

    }
}


fun mapResponseDoctor (doctor : Doctor) : CreateDoctorResponse{
    return CreateDoctorResponse(
        idDoctor = doctor.idDoctor,
        nombre = doctor.nombre,
        apellido = doctor.apellido,
        especialidad = doctor.especialidad,
        correo = doctor.correo,
        consultorio = doctor.consultorio,
        createAt = doctor.createdAt,
        updateAt = doctor.updatedAt
    )
}