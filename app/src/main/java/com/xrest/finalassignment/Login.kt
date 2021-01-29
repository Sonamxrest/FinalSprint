package com.xrest.finalassignment

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import com.xrest.finalassignment.Class.Person
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Login : AppCompatActivity(), View.OnClickListener {

    var permissions = arrayOf(android.Manifest.permission.CAMERA,android.Manifest.permission.ACCESS_FINE_LOCATION,android.Manifest.permission.WRITE_EXTERNAL_STORAGE)

    private lateinit var btn:TextView
    private lateinit var etUser:EditText
    private lateinit var etPassword:EditText
    private lateinit var signup :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        if(!hasPermission())
        {
            requestPermission()
        }


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


                var dialog =AlertDialog.Builder(this)
                dialog.setTitle("Save User")

                dialog.setMessage("Do you want to save the User?")
                dialog.setPositiveButton("Yes"){dialog,which->

                    val sharedPref = getSharedPreferences("Saved",MODE_PRIVATE)
                    val editor = sharedPref.edit()
                    editor.putString("username",etUser.text.toString())
                    editor.putString("password",etPassword.text.toString())
                    editor.apply()
                    Toast.makeText(this, "User Saved", Toast.LENGTH_SHORT).show()
                    dialog.cancel()
                    login()

                }
                dialog.setNegativeButton("No"){dialog, which ->
login()
                }
                val alert = dialog.create()

                alert.setCancelable(true)
                alert.show()
            }
            R.id.signup->{

               
startActivity(Intent(this@Login,MainActivity::class.java))

            }


        }
    }


    private fun requestPermission() {
        ActivityCompat.requestPermissions(
                this@Login,
                permissions, 1
        )
    }
    private fun hasPermission(): Boolean {
        var hasPermission = true
        for (permission in permissions) {
            if (ActivityCompat.checkSelfPermission(
                            this,
                            permission
                    ) != PackageManager.PERMISSION_GRANTED
            ) {
                hasPermission = false
            }
        }
        return hasPermission
    }

    fun login(){
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

}