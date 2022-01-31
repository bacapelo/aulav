package com.eduescial.bryam.service

import com.eduescial.bryam.model.Alumno
import com.eduescial.bryam.model.Asignatura
import com.eduescial.bryam.repository.AsignaturaRepository
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
class AsignaturaServiceTest {

    @InjectMocks
    lateinit var asignaturaService: AsignaturaService

    @Mock
    lateinit var asignaturaRepository:AsignaturaRepository

    val returnObject: Asignatura = Asignatura().apply{
        id= 4
        materia = "ciencias sociales"
        alumnoId = 8
        docenteId = 1
    }
    val newObject: Asignatura = Asignatura().apply{
        id= 4
        materia = "ciencias sociales"
        alumnoId = 8
        docenteId = 1
    }
    @Test
    fun saveIsCorrect() {
        Mockito.`when`(asignaturaRepository.save(Mockito.any(Asignatura::class.java))).thenReturn(returnObject)
        val response = asignaturaService.save(newObject)
        Assertions.assertEquals(response.id, newObject.id)
        Assertions.assertEquals(response.materia, newObject.materia)

    }
    val jsonString = File("./src/test/resources/Asignatura/crearAsignatura.json").readText(Charsets.UTF_8)
    val asignaturaMock = Gson().fromJson(jsonString, Asignatura::class.java)

    @Test
    fun saveTeacher(){
        //PAra actualizar
        //Mockito.`when`(dietRepository.findById(dietMock.id)).thenReturn(dietMock)
        Mockito.`when`(asignaturaRepository.save(Mockito.any(Asignatura::class.java))).thenReturn(asignaturaMock)
        val response = asignaturaService.save(asignaturaMock)
        Assertions.assertEquals(response.id, asignaturaMock.id)
        Assertions.assertEquals(response.materia, asignaturaMock.materia)
        Assertions.assertEquals(response.alumnoId, asignaturaMock.alumnoId)
        Assertions.assertEquals(response.docenteId, asignaturaMock.docenteId)
    }

    @Test
    fun saveTeacherFailed() {
        Assertions.assertThrows(Exception::class.java) {
            asignaturaMock.apply { materia = "    " }
            Mockito.`when`(asignaturaRepository.save(Mockito.any(Asignatura::class.java))).thenReturn(asignaturaMock)
            asignaturaService.save(asignaturaMock)
        }
    }

    @Test
    fun updateIsCorrect(){
        Mockito.`when`(asignaturaRepository.findById(newObject.id)).thenReturn(returnObject)
        Mockito.`when`(asignaturaRepository.save(Mockito.any(Asignatura::class.java))).thenReturn(returnObject)
        val response = asignaturaService.update(newObject)
        Assertions.assertEquals(response.id, newObject.id)
    }

    @Test
    fun  updateIsFailed() {
        Assertions.assertThrows(Exception::class.java) {
            Mockito.`when`(asignaturaRepository.findById(newObject.id)).thenReturn(null)
            Mockito.`when`(asignaturaRepository.save(Mockito.any(Asignatura::class.java))).thenReturn(returnObject)
            val response = asignaturaService.update(newObject)
            Assertions.assertEquals(response.id, newObject.id)

        }
    }

    @Test
    fun updateDescriptionIsCorrect(){
        Mockito.`when`(asignaturaRepository.findById(newObject.id)).thenReturn(returnObject)
        Mockito.`when`(asignaturaRepository.save(Mockito.any(Asignatura::class.java))).thenReturn(returnObject)
        val response = asignaturaService.updateDescripcion(newObject)
        Assertions.assertEquals(response.id, newObject.id)
    }

    @Test
    fun  updateDescriptionIsFailed() {
        Assertions.assertThrows(Exception::class.java) {
            Mockito.`when`(asignaturaRepository.findById(newObject.id)).thenReturn(null)
            Mockito.`when`(asignaturaRepository.save(Mockito.any(Asignatura::class.java))).thenReturn(returnObject)
            val response = asignaturaService.updateDescripcion(newObject)
            Assertions.assertEquals(response.id, newObject.id)
        }
    }


    @Test
    fun  delete() {
        Mockito.`when`(asignaturaRepository.findById(newObject.id)).thenReturn(returnObject)
        Mockito.`when`(asignaturaRepository.save(Mockito.any(Asignatura::class.java))).thenReturn(returnObject)
        val response = asignaturaService.delete(newObject.id)
        Assertions.assertEquals(response, true)
    }

    @Test
    fun  deleteIsFailed() {
        Assertions.assertThrows(Exception::class.java) {
            Mockito.`when`(asignaturaRepository.findById(newObject.id)).thenReturn(null)
            Mockito.`when`(asignaturaRepository.save(Mockito.any(Asignatura::class.java))).thenReturn(returnObject)
            val response = asignaturaService.delete(newObject.id)
            Assertions.assertEquals(response, true)
        }
    }


}