package com.eduescial.bryam.service

import com.eduescial.bryam.model.Docente
import com.eduescial.bryam.repository.DocenteRepository
import com.google.gson.Gson
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest
import java.io.File

@SpringBootTest
class DocenteServiceTestEva {

    @InjectMocks
    lateinit var docenteService: DocenteService

    @Mock
    lateinit var docenteRepository: DocenteRepository

    val returnObject: Docente = Docente().apply{
        id=4
        cedula= "0104612312"
        nombre="juan"
        edad= 19
        celular= "0987497879"
        email="juan@gamil.com"
    }
    val newObject: Docente = Docente().apply{
        id=4
        nombre="juan"
        cedula= "0104612312"
        nombre="juan"
        edad= 19
        celular= "0987497879"
        email="juan@gamil.com"
    }

    val jsonString = File("./src/test/resources/docente/crearDocente.json").readText(Charsets.UTF_8)
    val docenteMock = Gson().fromJson(jsonString, Docente::class.java)

    @Test
    fun updateIsCorrect(){
        Mockito.`when`(docenteRepository.findById(newObject.id)).thenReturn(returnObject)
        Mockito.`when`(docenteRepository.save(Mockito.any(Docente::class.java))).thenReturn(returnObject)
        val response = docenteService.update(newObject)
        Assertions.assertEquals(response.id, newObject.id)
    }

    @Test
    fun  updateIsFailed() {
        Assertions.assertThrows(Exception::class.java) {
            Mockito.`when`(docenteRepository.findById(newObject.id)).thenReturn(null)
            Mockito.`when`(docenteRepository.save(Mockito.any(Docente::class.java))).thenReturn(returnObject)
            val response = docenteService.update(newObject)
            Assertions.assertEquals(response.id, newObject.id)

        }
    }


    @Test
    fun valideteDocenteIsPassList(){
        val response = docenteService.valideteDocente()
        Assertions.assertEquals(,response)


    }

    @Test
    fun valideteDocenteIsNotPassList(){

    }
}