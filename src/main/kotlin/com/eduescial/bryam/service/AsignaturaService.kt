package com.eduescial.bryam.service

import com.eduescial.bryam.model.Alumno
import com.eduescial.bryam.model.Asignatura
import com.eduescial.bryam.repository.AlumnoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import com.eduescial.bryam.repository.AsignaturaRepository
import com.eduescial.bryam.repository.DocenteRepository
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

@Service
class AsignaturaService {
    @Autowired
    lateinit var asignaturaRepository: AsignaturaRepository

    @Autowired
    lateinit var alumnoRepository: AlumnoRepository

    @Autowired
    lateinit var docenteRepository: DocenteRepository



    fun list(): List<Asignatura> {

        return asignaturaRepository.findAll()
    }
    @PostMapping
    fun save  (asignatura: Asignatura): Asignatura {



        try {
            asignatura.materia?.takeIf {it.trim()?.isNotEmpty()}
                    ?: throw java.lang.Exception("materia no puede estar vacio")

            if(asignatura.alumnoId!!.equals("no debe de estar vaico")){
                    throw Exception("el alumno no puede estar vacio")}

            alumnoRepository.findById(asignatura.id)
                    ?: throw Exception("El id ${asignatura.id} del alumno no se encuentra")

            if(asignatura.alumnoId!!.equals("no debe de estar vaico")){
                throw Exception("el docente no puede estar vacio")}

            docenteRepository.findById(asignatura.id)
                    ?: throw Exception("El id ${asignatura.id} del docente no se encuentra")


            return asignaturaRepository.save(asignatura)
        }

        catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }

    }
    @PutMapping
    fun update (asignatura: Asignatura): Asignatura {
        try {
            asignatura.materia?.takeIf {it.trim()?.isEmpty() }
                    ?: throw java.lang.Exception("materia no puede estar vacio")

            val response = asignaturaRepository.findById(asignatura.id)
                    ?: throw Exception("El id ${asignatura.id} de la asignatura no existe")
            response.apply {
                this.materia= asignatura.materia
            }
            return asignaturaRepository.save(asignatura)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }
    fun updateDescripcion(asignatura: Asignatura): Asignatura {
        try {
            asignatura.materia?.trim()?.isEmpty()
                    ?: throw java.lang.Exception("materia no puede estar vacio")

            val response = asignaturaRepository.findById(asignatura.id)
                    ?: throw Exception("El id ${asignatura.id} de la asignatura no existe")
            response.apply {
                this.materia= asignatura.materia
            }
            return asignaturaRepository.save(asignatura)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }
    fun delete (id:Long): Boolean{
        asignaturaRepository.deleteById(id)
        return true
    }
}