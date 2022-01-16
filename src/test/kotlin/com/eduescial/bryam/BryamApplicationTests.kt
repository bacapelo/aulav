package com.eduescial.bryam

import com.eduescial.bryam.service.DocenteService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class BryamApplicationTests {

	@Autowired
	lateinit var docenteService: DocenteService

	@Test
	fun contextLoads() {


	}
	@Test
	fun verifySizewordWhenIsIncorrect(){
		val response:Boolean = docenteService.verifyWord("A")
		Assertions.assertEquals(false,response)
	}

	@Test
	fun verifySizewordWhenIsCorrect(){
		val response:Boolean = docenteService.verifyWord("ABCD")
		Assertions.assertEquals(true,response)


	}
}
