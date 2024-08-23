package com.alreadyoccupiedseat.model

data class PagedResult<T>(
    val hasNext: Boolean,
    val data: List<T>,
)
