package me.jimmyberg.ams.student

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/student")
class StudentController(
    val studentService: StudentService
) {

    @GetMapping("/all")
    fun findAll() = studentService.findAll()

}