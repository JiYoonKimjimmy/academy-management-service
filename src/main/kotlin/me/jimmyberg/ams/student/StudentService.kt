package me.jimmyberg.ams.student

import org.springframework.stereotype.Service

@Service
class StudentService(
    val studentRepository: StudentRepository
) {

    fun findOne(id: Int): StudentModel = studentRepository.findById(id).map(StudentModel::of).orElseThrow()

    fun findAll(): List<StudentModel> = studentRepository.findAll().map(StudentModel::of)

}