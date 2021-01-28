package com.xrest.finalassignment

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton
import com.xrest.finalassignment.Class.Person
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SignupActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        var fullname = findViewById(R.id.fullname) as EditText
        var male : RadioButton = findViewById(R.id.male)
        var female : RadioButton = findViewById(R.id.female)
        var others : RadioButton = findViewById(R.id.others)
        var txt:TextView = findViewById(R.id.txt)
        var username = findViewById(R.id.username) as EditText
        var password = findViewById(R.id.password) as EditText
        var btn: Button = findViewById(R.id.btn)


        btn.setOnClickListener(){

            var gender =""
            var img=""
            if(male.isChecked)
            {
                gender ="Male"
                img ="https://cdn6.f-cdn.com/contestentries/895802/20628095/584189d7b4a1e_thumb900.jpg"
            }
            if(female.isChecked)
            {

                gender ="Female"
                img="https://image.shutterstock.com/image-vector/face-expression-woman-smiling-female-260nw-753503635.jpg"
            }
            if(others.isChecked){

                gender ="others"
                img="https://i.guim.co.uk/img/media/e2a94be940745ef6fd8f86f929cc6930e68f7513/125_60_971_583/master/971.jpg?width=700&quality=85&auto=format&fit=max&s=467b768b57ea29062a6b2077c0ef6d4e"
            }




            CoroutineScope(Dispatchers.IO).launch {
UserDb.getInstance(this@SignupActivity).getUserDAO().insert(Person(fullname.text.toString(),gender,username.text.toString(),password.text.toString(),img))


            }








        }


        txt.setOnClickListener(){

            val intent = Intent(this, Login::class.java)


        }





    }


}