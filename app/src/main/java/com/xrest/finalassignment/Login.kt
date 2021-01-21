package com.xrest.finalassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Login : AppCompatActivity(), View.OnClickListener {


    private lateinit var btn:Button
    private lateinit var etUser:EditText
    private lateinit var etPassword:EditText
    private lateinit var signup :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        btn = findViewById(R.id.login)
        etUser = findViewById(R.id.username)
        etPassword = findViewById(R.id.password)
        signup = findViewById(R.id.signup)



        btn.setOnClickListener(this)
        signup.setOnClickListener(this)




    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.login->{
                val intent = Intent(this,Dashboard::class.java)
                startActivity(intent)

            }
            R.id.signup->{

                val intent = Intent(this,SignupActivity::class.java)
                startActivity(intent)


            }


        }
    }
}