package com.app.socialapp.domain.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}