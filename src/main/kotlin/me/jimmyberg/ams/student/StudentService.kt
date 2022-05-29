package me.jimmyberg.ams.student

import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class StudentService(
    val studentRepository: StudentRepository
) {
    fun findOne(id: Int) =
        studentRepository
            .findById(id)
            .orElseThrow()
            .let { FindStudentResponse(student = StudentModel.of(it)) }

    fun findAll() =
        studentRepository
            .findAll(PageRequest.of(0, 10))
            .map { StudentModel.of(it) }
            .let { FindStudentsResponse.of(it) }
}