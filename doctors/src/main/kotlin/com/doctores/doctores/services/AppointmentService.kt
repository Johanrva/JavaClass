package com.doctores.doctores.services

import com.doctores.doctores.domains.entity.Appointment
import com.doctores.doctores.domains.entity.Doctor
import com.doctores.doctores.domains.request.CreateAppointmentRequest
import com.doctores.doctores.domains.request.UpdateAppointmentRequest
import com.doctores.doctores.domains.responses.CreateAppointmentResponse
import com.doctores.doctores.domains.responses.Failure
import com.doctores.doctores.domains.responses.Result
import com.doctores.doctores.domains.responses.Success
import com.doctores.doctores.repositories.AppointmentRepository
import com.doctores.doctores.repositories.DoctorRepository
import com.doctores.doctores.repositories.PatientRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class AppointmentService {
    @Autowired
    private lateinit var appointmentRepository : AppointmentRepository
    @Autowired
    private lateinit var doctorRepository : DoctorRepository
    @Autowired
    private lateinit var patientRepository: PatientRepository


    fun createAppointment(request: CreateAppointmentRequest): Result<CreateAppointmentResponse>{
        val doctor = doctorRepository.getDoctorById(request.idDoctor)
        val patient = patientRepository.getPatientByIdentification(request.idPaciente)
        if (doctor != null && patient != null) {
            val appointment = appointmentRepository.save(
                Appointment(
                    horario = request.horario,
                    especialidad = doctor.especialidad,
                    idDoctor = doctor.idDoctor,
                    identificacionPaciente = patient.identificacion,
                    updatedAt = Instant.now()
                )
            )
            return Success(mapResponseAppointment(appointment, doctor))
        } else {
            return Failure ("Failure to create appointment")
        }
    }

    fun getAllAppointments(): List<CreateAppointmentResponse>{
        val appointments : List<Appointment> = appointmentRepository.findAll()

        var appointmentsRes = listOf<CreateAppointmentResponse>()
        appointmentsRes = appointments.map { appointment ->
            val doctor = doctorRepository.getDoctorById(appointment.idDoctor)
            CreateAppointmentResponse(
                idPaciente = appointment.identificacionPaciente,
                especialidad = appointment.especialidad,
                doctor = ("Dr ${doctor?.nombre} ${doctor?.apellido}") ?: "not found",
                consultorio = doctor?.consultorio?: -1,
                horario = appointment.horario,
                updateAt = appointment.updatedAt
            )
        }
        return appointmentsRes
    }

    fun getAppointmentById(id: Long): Result<CreateAppointmentResponse>{
        val appointment : Appointment? = appointmentRepository.getAppointmentById(id)

        if (appointment != null) {
            val doctor = doctorRepository.getDoctorById(appointment.idDoctor)
            return Success(mapResponseAppointment(appointment, doctor))
        } else {
            return Failure ("Appointment not found")
        }
    }

    fun updateAppointment(id: Long, request : UpdateAppointmentRequest): Result<CreateAppointmentResponse>{
        var appointment : Appointment? = appointmentRepository.getAppointmentById(id)
        if (appointment != null) {
            val appointmentUpdate = appointmentRepository.save(
                Appointment(
                    idCita = id,
                    horario = request.horario?: appointment.horario,
                    especialidad = request.especialidad?: appointment.especialidad,
                    idDoctor = request.idDoctor?: appointment.idDoctor,
                    identificacionPaciente = request.identificacionPaciente?: appointment.identificacionPaciente,
                    updatedAt = Instant.now()
                )
            )
            val doctor = doctorRepository.getDoctorById(appointmentUpdate.idDoctor)
            return Success(mapResponseAppointment(appointmentUpdate, doctor))
        } else{
            return Failure("Appointment not found")
        }
    }
}

fun mapResponseAppointment (appointment: Appointment, doctor: Doctor?) : CreateAppointmentResponse {
    return CreateAppointmentResponse(
        idPaciente = appointment.identificacionPaciente,
        especialidad = appointment.especialidad,
        doctor = ("Dr ${doctor?.nombre} ${doctor?.apellido}"),
        consultorio = doctor?.consultorio?: -1,  // se asignaría -1 para consultorio en caso de no doctor
        horario = appointment.horario,
        updateAt = appointment.updatedAt
    )
}