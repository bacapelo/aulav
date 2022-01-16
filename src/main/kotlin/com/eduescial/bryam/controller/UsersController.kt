package com.eduescial.bryam.controller

import com.eduescial.bryam.model.Alumno
import com.eduescial.bryam.model.User
import com.eduescial.bryam.service.AlumnoService
import com.eduescial.bryam.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

class UsersController {
    @Autowired
    lateinit var userService: UserService

    @GetMapping
    fun list(): List<User>{

        return userService.list()
    }
    @PostMapping
    fun save ( @RequestBody user: User): User {
        return userService.save(user)
    }
}