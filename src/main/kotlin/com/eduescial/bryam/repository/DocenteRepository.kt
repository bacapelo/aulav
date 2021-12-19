package com.eduescial.bryam.repository


import com.eduescial.bryam.model.Docente
import org.springframework.data.jpa.repository.JpaRepository

interface DocenteRepository: JpaRepository<Docente, Long> {
    fun findById(id: Long?): Docente?
}