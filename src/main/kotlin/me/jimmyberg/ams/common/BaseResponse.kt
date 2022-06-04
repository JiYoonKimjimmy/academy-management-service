package me.jimmyberg.ams.common

import me.jimmyberg.ams.config.exception.ErrorCode
import me.jimmyberg.ams.support.enums.BaseStatus
import org.springframework.data.domain.Page

open class BaseResponse(
    open val result: Result? = null
) {
    data class Result(
        val status: BaseStatus? = null,
        val reason: String? = null,
        val message: String? = null
    )
    companion object {
        fun success() = BaseResponse().success()
        fun fail(error: ErrorCode) = BaseResponse().fail(error = error)
    }
    fun success() = BaseResponse(result = Result(status = BaseStatus.SUCCESS))
    fun fail(error: ErrorCode) = BaseResponse(
        result = Result(
            status = BaseStatus.FAILED,
            reason = error.code,
            message = error.message
        )
    )
}

open class PageableModel<T>(
    open val number: Int = 0,
    open val size: Int = 0,
    open val numberOfElements: Int = 0,
    open val totalPages: Int = 0,
    open val totalElements: Long = 0,
    open val first: Boolean = false,
    open val last: Boolean = false,
    open val empty: Boolean = false,
    open val content: List<T> = listOf()
) : BaseResponse() {

    constructor(pageable: Page<T>): this(
        number = pageable.number,
        size = pageable.size,
        numberOfElements = pageable.numberOfElements,
        totalPages = pageable.totalPages,
        totalElements = pageable.totalElements,
        first = pageable.isFirst,
        last = pageable.isLast,
        empty = pageable.isEmpty,
        content = pageable.content
    )

}