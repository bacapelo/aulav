package com.eduescial.bryam.service

import com.eduescial.bryam.model.Docente
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

    fun save  (user: User): User {

            return userRepository.save(user)
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

    fun calcMultiplication(index:Int, number: Int): Int {
        if (index % 2 == 0) {
            return number * 2
        } else {
            return number
        }
    }
    fun restNine(number: Int):Int{
        if (number in 10..18){
            return number - 9
        }else
            return number

    }
    fun subtactFromNextTen(number: Int):Int{
         var decena = (number/10) +1
        var response =(decena*10)-number

        return response
    }
   /*fun  verifyIdEcuador(ced: String):Boolean{
       return true
   }*/

}
