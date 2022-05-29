package me.jimmyberg.ams.common

import org.springframework.data.domain.Page

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
) {
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