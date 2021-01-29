package com.xrest.finalassignment.Class

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Food(val name:String?=null
,val description:String?=null
,val img:String?=null
,val rating :Float?=null
,val price:Float?=null

) {

    @PrimaryKey(autoGenerate = true)
    val Food_Id =0

}