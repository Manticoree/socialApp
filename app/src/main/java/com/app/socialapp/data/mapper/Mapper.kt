package com.app.socialapp.data.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}