package com.eduescial.bryam.controller

import com.eduescial.bryam.model.Docente
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import com.eduescial.bryam.service.DocenteService

@RestController
@RequestMapping("/docente")
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT])

class DocenteController {
        @Autowired
        lateinit var docenteService: DocenteService

        @GetMapping
        fun list(): List<Docente>{
            return docenteService.list()
        }
        @PostMapping
        fun save ( @RequestBody docente:Docente): Docente {
            return docenteService.save(docente)
        }
        @PutMapping
        fun update(@RequestBody docente: Docente): Docente {
            return docenteService.update(docente)
        }
        @PatchMapping
        fun updateDescripcion(@RequestBody docente: Docente): Docente {
            return docenteService.updateDescripcion(docente)
        }
        @DeleteMapping("/delete/{id}")
        fun delete (@PathVariable("id") id: Long):Boolean{
            return docenteService.delete(id)
        }
}