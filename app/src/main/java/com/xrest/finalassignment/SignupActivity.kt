package com.xrest.finalassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton
import com.xrest.finalassignment.Class.Person

class SignupActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val fullname:EditText = findViewById(R.id.fullname)
        val username:EditText = findViewById(R.id.username)
        val password:EditText = findViewById(R.id.password)
        val btn:CircularProgressButton = findViewById(R.id.btn)
        val txt:TextView = findViewById(R.id.txt)


        btn.setOnClickListener(){

            perso.add(Person(fullname.text.toString(),username.text.toString(),password.text.toString(),""))


        }
        txt.setOnClickListener(){

            val intent = Intent(this, Login::class.java)


        }





    }


}