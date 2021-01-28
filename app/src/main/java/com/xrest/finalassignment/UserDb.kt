package com.xrest.finalassignment


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.xrest.finalassignment.Class.Person

@Database(
    entities = [Person::class],
    version =1

)
abstract class UserDb :RoomDatabase() {


    abstract fun getUserDAO():UserDAO

    companion object{
        @Volatile
       private  var instance :UserDb?= null
        fun getInstance(context:Context):UserDb{

            if(instance ==null)
            {
                synchronized(UserDb::class){

                    instance = buildDatabase(context)

                }
            }


return instance!!
        }


        fun buildDatabase(context: Context):UserDb{

            return Room.databaseBuilder(context.applicationContext,UserDb::class.java,"UserDb").build()

        }

    }







}