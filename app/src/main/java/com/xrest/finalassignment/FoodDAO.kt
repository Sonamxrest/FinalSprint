package com.xrest.finalassignment

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.xrest.finalassignment.Class.Food

@Dao

interface FoodDAO {
@Insert
    suspend fun insertFood(food:Food)

    @Query("select * from Food")
    suspend fun getFood():MutableList<Food>




}