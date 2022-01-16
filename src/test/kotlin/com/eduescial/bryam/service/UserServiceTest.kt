package com.eduescial.bryam.service

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest {
    @Autowired
    lateinit var userService: UserService

    @Test
    fun calcMultiplicationIfIsPair() {
        val response = userService.calcMultiplication(2,2)
        Assertions.assertEquals(4,response)
    }

    @Test
    fun calcMultiplicationIfIsNoPair() {
        val response = userService.calcMultiplication(1,4)
        Assertions.assertEquals(4,response)
    }
    @Test
    fun restNineIfIsLessTen(){
        val response = userService.restNine(10)
        Assertions.assertEquals(1, response)
    }

    @Test
    fun restNineIfIsHigherTen(){
        val response = userService.restNine(11)
        Assertions.assertEquals(2, response)
    }

    @Test
    fun subtactFromNextTen(){
        val response = userService.subtactFromNextTen(18)
        Assertions.assertEquals(2,response)
    }
   /* @Test
    fun verifyIdEcuador(){
        val response = userService.verifyIdEcuador(0151052347)
        Assertions.assertEquals(true,response)
    }*/





}