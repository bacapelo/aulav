package model

import javax.persistence.*

@Entity
@Table(name = "docente")
class Docente {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id : Long? = null

    var cedula : Long? = null
    var nombre : String? = null
    var apellido: String? = null
    var edad: String?=null
    var celular : Long? = null
    var email: String? = null
}