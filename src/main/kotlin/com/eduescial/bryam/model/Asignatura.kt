package com.eduescial.bryam.model

import javax.persistence.*

@Entity
@Table(name = "asignatura")
class Asignatura {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)

    var id : Long? = null

    var materia : String? = null
    @Column(name="alumno_id")
    var alumnoId : Long? = null
    @Column(name="docente_id")
    var docenteId : Long? = null
}