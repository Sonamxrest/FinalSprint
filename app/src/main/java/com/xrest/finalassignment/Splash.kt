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

        Handler().postDelayed(
            {val intent = Intent(this, Login::class.java)
                startActivity(intent)

            },1000

        )
    }







}