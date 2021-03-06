package com.eduescial.bryam.service

import com.eduescial.bryam.model.Alumno
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import com.eduescial.bryam.repository.AlumnoRepository
import com.eduescial.bryam.repository.AsignaturaRepository
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

@Service
class AlumnoService {
    @Autowired
    lateinit var alumnoRepository: AlumnoRepository

    fun list(): List<Alumno> {

            return alumnoRepository.findAll()
    }
    @PostMapping
    fun save  (alumno: Alumno):Alumno{
        try {
            alumno.nombre?.takeIf {it.trim()?.isNotEmpty()}
                    ?: throw Exception("no puede estar vacio el nombre")
            return alumnoRepository.save(alumno)

        }
        catch (ex: Exception) {
           throw ResponseStatusException(
                  HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    @PutMapping
    fun update (alumno: Alumno): Alumno{

            return alumnoRepository.save(alumno)
    }
    fun updateDescripcion(alumno: Alumno):Alumno {
        try {
            alumno.nombre?.takeIf {it.trim()?.isEmpty() }

            val response = alumnoRepository.findById(alumno.id)
                    ?: throw Exception("El id ${alumno.id} el alumno no existe")
            response.apply {
                this.nombre= alumno.nombre
            }
            return alumnoRepository.save(alumno)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Estudiante No Encontrada", ex)
        }
    }
    fun delete (id:Long?): Boolean{
        try {
            alumnoRepository.findById(id)
                    ?: throw Exception("No existe el id")

            alumnoRepository.deleteById(id!!)
            return true

        } catch (ex:Exception) {

            throw Exception()
        }
    }
}