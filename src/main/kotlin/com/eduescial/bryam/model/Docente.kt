package com.eduescial.bryam.model

import javax.persistence.*

@Entity
@Table(name = "docente")
class Docente {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id : Long? = null

    var cedula : String? = null
    var nombre : String? = null
    var apellido: String? = null
    var edad: Long?=null
    var celular : String? = null
    var email: String? = null
}