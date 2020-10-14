package com.app.socialapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.app.socialapp.entities.ItemCategory

@Dao
interface CategoryDao {

    @Query("SELECT* from item_category")
    fun getAll(): List<ItemCategory>

    @Query("SELECT* from item_category WHERE idItem = :idItem")
    fun getById(idItem: Long): ItemCategory

    @Insert
    fun insert(itemCategory: ItemCategory)

    @Delete
    fun delete(itemCategory: ItemCategory)

}