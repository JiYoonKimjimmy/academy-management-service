package me.jimmyberg.ams.student

import me.jimmyberg.ams.Parents.Parents
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
        studentRepository.save(Student.of(request).apply {
            parents += Parents(
                id = 2,
                name = "김아빠2",
                mobileNumber = "01020326457",
                gender = 'M',
                student = this
            )
        })

}