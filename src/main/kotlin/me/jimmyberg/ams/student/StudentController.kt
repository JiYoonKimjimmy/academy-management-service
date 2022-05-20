package me.jimmyberg.ams.student

import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/student")
@Api(tags = ["Student APIs"])
class StudentController(
    val studentService: StudentService
) {

    @GetMapping("/{id}")
    fun findOne(@PathVariable id: Int) = studentService.findOne(id)

    @GetMapping("/all")
    fun findAll() = studentService.findAll()

}