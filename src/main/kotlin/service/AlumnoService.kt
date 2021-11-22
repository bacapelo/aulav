package service

import model.Alumno
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import repository.AlumnoRepository

@Service
class AlumnoService {
    @Autowired
    lateinit var alumnoRepository: AlumnoRepository
    fun list(): List<Alumno> {

        return alumnoRepository.findAll()
    }
    @PostMapping
    fun save  (alumno: Alumno):Alumno{
        return alumnoRepository.save(alumno)
    }
    @PutMapping
    fun update (alumno: Alumno): Alumno{
        return alumnoRepository.save(alumno)
    }
    fun updateDescripcion(alumno: Alumno):Alumno {
        val response = alumnoRepository.findById(alumno.id)
                ?: throw Exception()
        response.apply {
            this.discapacidad=alumno.discapacidad
        }
        return alumnoRepository.save(response)
    }
    fun delete (id:Long): Boolean{
        alumnoRepository.deleteById(id)
        return true
    }
}