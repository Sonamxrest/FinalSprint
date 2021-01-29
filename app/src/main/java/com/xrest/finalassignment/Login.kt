package com.xrest.finalassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.xrest.finalassignment.Class.Person
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Login : AppCompatActivity(), View.OnClickListener {


    private lateinit var btn:TextView
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

                CoroutineScope(Dispatchers.IO).launch {

                    var person: Person = UserDb.getInstance(this@Login).getUserDAO().login(etUser.text.toString(),etPassword.text.toString())
                    withContext(Dispatchers.Main){
                        if(person==null)
                        {
                            Toast.makeText(this@Login, "Invalid Credentials", Toast.LENGTH_SHORT).show()

                        }
                        else{
                         var intent=   Intent(this@Login,Dashboard::class.java)
                            intent.putExtra("type",person.type)
                            startActivity(intent)
                        }
                    }


                }






            }
            R.id.signup->{

               


            }


        }
    }
}