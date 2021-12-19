package com.eduescial.bryam.repository


import com.eduescial.bryam.model.Asignatura
import org.springframework.data.jpa.repository.JpaRepository

interface AsignaturaRepository: JpaRepository<Asignatura, Long> {
    fun findById(id: Long?): Asignatura?
}