package com.app.socialapp.domain.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.app.socialapp.domain.entities.db.ItemCategory
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface CategoryDao {

    @Query("SELECT* from item_category")
    fun getAll(): Single<List<ItemCategory>>

    @Query("SELECT* from item_category WHERE idItem = :idItem")
    fun getById(idItem: Long): Single<ItemCategory>

    @Insert
    fun insert(itemCategory: ItemCategory): Completable

    @Delete
    fun delete(itemCategory: ItemCategory): Completable

}