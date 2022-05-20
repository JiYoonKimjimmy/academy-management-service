package me.jimmyberg.ams.student

import org.springframework.stereotype.Service

@Service
class StudentService(
    val studentRepository: StudentRepository
) {

    fun findOne(id: Int): Student = studentRepository.findById(id).orElseThrow()
    fun findAll(): List<Student> = studentRepository.findAll()

}