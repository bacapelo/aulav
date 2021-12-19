package com.eduescial.bryam.service

import com.eduescial.bryam.model.Docente
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import com.eduescial.bryam.repository.DocenteRepository
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

@Service
class DocenteService {
    @Autowired
    lateinit var docenteRepository: DocenteRepository
    fun list(): List<Docente> {

        return docenteRepository.findAll()
    }
    @PostMapping
    fun save  (docente: Docente): Docente {
        try {
            docente.nombre?.takeIf {it.trim()?.isEmpty() }
            val response = docenteRepository.findById(docente.id)
                    ?: throw Exception("El id ${docente.id} el docente no existe")
            response.apply {
                this.nombre = docente.nombre
            }
            return docenteRepository.save(docente)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }
    @PutMapping
    fun update (docente: Docente): Docente {
        try {
            docente.nombre?.takeIf {it.trim()?.isEmpty() }
            val response = docenteRepository.findById(docente.id)
                    ?: throw Exception("El id ${docente.id} el docente no existe")
            response.apply {
                this.nombre = docente.nombre
            }
            return docenteRepository.save(docente)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }
    fun updateDescripcion(docente: Docente): Docente {
        try {
            docente.nombre?.takeIf {it.trim()?.isEmpty() }
                    ?: throw java.lang.Exception("el nombre no puede ser vacio")

            val response = docenteRepository.findById(docente.id)
                    ?: throw Exception("El id ${docente.id} el docente no existe")
            response.apply {
                this.nombre = docente.nombre
            }
            return docenteRepository.save(docente)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }
    fun delete (id:Long): Boolean{
        docenteRepository.deleteById(id)
        return true
    }
}