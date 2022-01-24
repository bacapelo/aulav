package com.eduescial.bryam.service

import com.eduescial.bryam.model.Alumno
import com.eduescial.bryam.repository.AlumnoRepository
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
class AlumnoServiceTest {

    @InjectMocks
    lateinit var alumnoService: AlumnoService

    @Mock
    lateinit var alumnoRepository: AlumnoRepository

    val returnObject: Alumno = Alumno().apply{
        id = 2
        cedula = "015105236"
        nombre = "juan"
        apellido = "Perez"
        edad = "20"
        discapacidad = "visual"
    }
    val newObject: Alumno = Alumno().apply{
        id = 2
        cedula = "015105236"
        nombre = "juan"
        apellido = "Perez"
        edad = "20"
        discapacidad = "visual"
    }

    @Test
    fun saveIsCorrect() {
        Mockito.`when`(alumnoRepository.save(Mockito.any(Alumno::class.java))).thenReturn(returnObject)
        val response = alumnoService.save(newObject)
        Assertions.assertEquals(response.id, newObject.id)
        Assertions.assertEquals(response.nombre, newObject.nombre)

    }
    val jsonString = File("./src/test/resources/Alumno/crearAlumno.json").readText(Charsets.UTF_8)
    val alumnoMock = Gson().fromJson(jsonString, Alumno::class.java)

    @Test
    fun saveTeacher(){
        //PAra actualizar
        //Mockito.`when`(dietRepository.findById(dietMock.id)).thenReturn(dietMock)
        Mockito.`when`(alumnoRepository.save(Mockito.any(Alumno::class.java))).thenReturn(alumnoMock)
        val response = alumnoService.save(alumnoMock)
        Assertions.assertEquals(response.id, alumnoMock.id)
        Assertions.assertEquals(response.cedula, alumnoMock.cedula)
        Assertions.assertEquals(response.nombre, alumnoMock.nombre)
        Assertions.assertEquals(response.apellido, alumnoMock.apellido)
        Assertions.assertEquals(response.edad, alumnoMock.edad)
        Assertions.assertEquals(response.discapacidad, alumnoMock.discapacidad)
    }

    @Test
    fun saveTeacherFailed() {
        Assertions.assertThrows(Exception::class.java) {
            alumnoMock.apply { nombre = "    " }
            Mockito.`when`(alumnoRepository.save(Mockito.any(Alumno::class.java))).thenReturn(alumnoMock)
            alumnoService.save(alumnoMock)
        }


    }
}