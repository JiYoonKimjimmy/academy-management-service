package me.jimmyberg.ams.student

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import me.jimmyberg.ams.common.BaseResponse
import org.springframework.web.bind.annotation.*

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
    @ApiResponses(
        value = [ApiResponse(responseCode = "200", content = [Content(schema = Schema(implementation = FindStudentResponse::class))])]
    )
    @GetMapping("/student/{id}")
    fun findOne(@PathVariable id: Int) = studentService.findOne(id = id).success()

    @ApiOperation(
        value = "학생 다건 조회 API",
        response = FindStudentsResponse::class
    )
    @ApiResponses(
        value = [ApiResponse(responseCode = "200", content = [Content(schema = Schema(implementation = FindStudentsResponse::class))])]
    )
    @GetMapping("/students")
    fun findAll() = studentService.findAll().success()

    @ApiOperation(
        value = "학생 단건 저장 API",
        response = BaseResponse::class
    )
    @ApiResponses(
        value = [ApiResponse(responseCode = "200", content = [Content(schema = Schema(implementation = BaseResponse::class))])]
    )
    @PostMapping("/student")
    fun save(request: SaveStudentRequest) = studentService.save(request = request).success()

}