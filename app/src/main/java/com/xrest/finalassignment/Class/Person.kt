package com.xrest.finalassignment.Class

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Person(var fname:String?=null
                  ,var gender:String?=null
                  ,var username:String?=null
                  ,var password:String?=null
                  ,var img:String?=null,
var type:String?=null) {
    @PrimaryKey(autoGenerate = true)
    var userID =0


}