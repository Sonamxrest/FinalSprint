package com.xrest.finalassignment

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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

           // perso.add(Person(fullname.text.toString(),username.text.toString(),password.text.toString(),""))

            fullname.setText(null)
            username.setText(null)
            password.setText(null)
            Toast.makeText(this, "User have been added", Toast.LENGTH_SHORT).show()
            val d = AlertDialog.Builder(this)
            d.setTitle("Login Confirmation")

            d.setMessage("Do you want to login now?")
            d.setPositiveButton("Yes"){dialog,which->

startActivity(Intent(this@SignupActivity,Login::class.java))
                //a.add(food.id)


            }
            d.setNegativeButton("No"){dialog, which ->

            }
            val alert = d.create()

            alert.setCancelable(true)
            alert.show()

        }
        txt.setOnClickListener(){

            val intent = Intent(this, Login::class.java)


        }





    }


}