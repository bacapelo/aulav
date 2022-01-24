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
class DocenteServiceTest {

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
    @Test
    fun saveIsCorrect() {
        Mockito.`when`(docenteRepository.save(Mockito.any(Docente::class.java))).thenReturn(returnObject)
        val response = docenteService.save(newObject)
        Assertions.assertEquals(response.id, newObject.id)
        Assertions.assertEquals(response.nombre, newObject.nombre)

    }
    val jsonString = File("./src/test/resources/docente/crearDocente.json").readText(Charsets.UTF_8)
    val docenteMock = Gson().fromJson(jsonString, Docente::class.java)

    @Test
    fun saveTeacher(){
        //PAra actualizar
        //Mockito.`when`(dietRepository.findById(dietMock.id)).thenReturn(dietMock)
        Mockito.`when`(docenteRepository.save(Mockito.any(Docente::class.java))).thenReturn(docenteMock)
        val response = docenteService.save(docenteMock)
        Assertions.assertEquals(response.id, docenteMock.id)
        Assertions.assertEquals(response.cedula, docenteMock.cedula)
        Assertions.assertEquals(response.nombre, docenteMock.nombre)
        Assertions.assertEquals(response.apellido, docenteMock.apellido)
        Assertions.assertEquals(response.celular, docenteMock.celular)
        Assertions.assertEquals(response.email, docenteMock.email)
    }

    @Test
    fun saveTeacherFailed() {
        Assertions.assertThrows(Exception::class.java) {
            docenteMock.apply { nombre = "    " }
            Mockito.`when`(docenteRepository.save(Mockito.any(Docente::class.java))).thenReturn(docenteMock)
            docenteService.save(docenteMock)
        }


    }
}