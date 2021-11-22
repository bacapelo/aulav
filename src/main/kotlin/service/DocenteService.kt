package service

import model.Docente
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import repository.DocenteRepository

@Service
class DocenteService {
    @Autowired
    lateinit var docenteRepository: DocenteRepository
    fun list(): List<Docente> {

        return docenteRepository.findAll()
    }
    @PostMapping
    fun save  (docente: Docente): Docente {
        return docenteRepository.save(docente)
    }
    @PutMapping
    fun update (docente: Docente): Docente {
        return docenteRepository.save(docente)
    }
    fun updateDescripcion(docente: Docente): Docente {
        val response = docenteRepository.findById(docente.id)
                ?: throw Exception()
        response.apply {
            this.nombre=docente.nombre
        }
        return docenteRepository.save(response)
    }
    fun delete (id:Long): Boolean{
        docenteRepository.deleteById(id)
        return true
    }
}