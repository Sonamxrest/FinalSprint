package com.xrest.finalassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import com.xrest.finalassignment.Class.Person
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var fullname = findViewById(R.id.fullname) as EditText

        var male : RadioButton = findViewById(R.id.male)
        var female : RadioButton = findViewById(R.id.female)
        var others : RadioButton = findViewById(R.id.others)
        var username = findViewById(R.id.username) as EditText
        var password = findViewById(R.id.password) as EditText
        var btn: Button = findViewById(R.id.btn)

        btn.setOnClickListener(){

            var gender =""
            var img=""
            var type="user"

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
                UserDb.getInstance(this@MainActivity).getUserDAO().insert(Person(fullname.text.toString(),gender,username.text.toString(),password.text.toString(),img,type))
                withContext(Dispatchers.Main){
                    Toast.makeText(this@MainActivity, "User Inserted", Toast.LENGTH_SHORT).show()

                    startActivity(Intent(this@MainActivity,Login::class.java))






                }
            }








        }



    }
}