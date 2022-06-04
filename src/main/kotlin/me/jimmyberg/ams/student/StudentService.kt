package me.jimmyberg.ams.student

import me.jimmyberg.ams.common.BaseResponse
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
            .map { StudentModel.of(student = it) }
            .let { FindStudentsResponse.of(pageable = it) }

    fun save(request: SaveStudentRequest) =
        studentRepository
            .save(Student.of(request))
            .let { BaseResponse.success() }

}