package com.xrest.finalassignment.Class

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Food(var name:String?=null
,var description:String?=null
,var img:String?=null
,var rating :Float?=null
,var price:Float?=null

) {

    @PrimaryKey(autoGenerate = true)
    var Food_Id =0

}