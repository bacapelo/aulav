package model

import javax.persistence.*

@Entity
@Table(name = "alumno")
class Alumno {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id : Long? = null

    var cedula : Long? = null
    var nombre : String? = null
    var apellido: String? = null
    var edad: String?=null
    var discapacidad: String? = null
}