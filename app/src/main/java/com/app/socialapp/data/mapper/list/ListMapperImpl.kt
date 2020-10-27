package com.app.socialapp.data.mapper.list

import com.app.socialapp.data.mapper.Mapper

class ListMapperImpl<I, O>(
        private val mapper: Mapper<I, O>
) : ListMapper<I, O> {

    override fun map(input: List<I>): List<O> = input.map { mapper.map(it) }

}