package me.jimmyberg.ams.student

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
@Api(tags = ["Student APIs"])
class StudentController(
    val studentService: StudentService
) {

    @ApiOperation(
        value = "학생 단건 조회 API",
        response = FindStudentResponse::class
    )
    @GetMapping("/student/{id}")
    fun findOne(@PathVariable id: Int) = studentService.findOne(id)

    @ApiOperation(
        value = "학생 다건 조회 API",
        response = FindStudentsResponse::class
    )
    @GetMapping("/students")
    fun findAll() = studentService.findAll()

}