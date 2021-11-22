package repository


import model.Alumno
import model.Asignatura
import org.springframework.data.jpa.repository.JpaRepository

interface AsignaturaRepository: JpaRepository<Asignatura, Long> {
    fun findById(id: Long?): Asignatura?
}