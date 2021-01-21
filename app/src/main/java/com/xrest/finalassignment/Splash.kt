package com.xrest.finalassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.xrest.finalassignment.Class.Food
import com.xrest.finalassignment.Class.Person
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class Splash : AppCompatActivity() {
    public var lst:ArrayList<Food> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_front)
        supportActionBar?.hide()
add()
        Handler().postDelayed(
            {val intent = Intent(this, Dashboard::class.java)
                startActivity(intent)

            },1500

        )
    }



    fun loadTxt(){
        try{
            val path = openFileInput("Food.txt")
            val inputStreamReader = InputStreamReader(path)
            val bf:BufferedReader = BufferedReader(inputStreamReader)
            for(line in bf.lines())
            {


                val d = line.split(" , ")
                lst.add(
                    Food(
                        d[0].toInt(),
                        d[1].toString(),
                        d[2].toString(),
                        d[3].toString()

                    )
                )


            }
        }
        catch(i:IOException)
        {
            Toast.makeText(this, "${i.localizedMessage}", Toast.LENGTH_SHORT).show()
        }








    }




}