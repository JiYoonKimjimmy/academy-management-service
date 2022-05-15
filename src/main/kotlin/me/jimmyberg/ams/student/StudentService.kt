package me.jimmyberg.ams.student

import org.springframework.stereotype.Service

@Service
class StudentService(
    val studentRepository: StudentRepository
) {

    fun findAll(): List<Student> = studentRepository.findAll()

}