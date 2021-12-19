package com.eduescial.bryam.service

import com.eduescial.bryam.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import com.eduescial.bryam.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

@Service
class UserService {
    @Autowired
    lateinit var userRepository:   UserRepository
    fun list(): List<User> {

        return userRepository.findAll()
    }
    fun getUser  (username:String?): User? {
        try {
            val response = userRepository.findByUsername(username)
                    ?: throw  Exception("no existe el usuario")
            return response

        } catch (ex: Exception) {
            throw ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }
    @PutMapping
    fun update (user: User): User {
            return userRepository.save(user)
        }
}