package repository

import model.Alumno
import org.springframework.data.jpa.repository.JpaRepository

interface AlumnoRepository: JpaRepository<Alumno, Long> {
    fun findById(id: Long?): Alumno?
}