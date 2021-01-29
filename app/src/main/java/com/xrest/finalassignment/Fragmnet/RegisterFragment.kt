package com.xrest.finalassignment.Fragmnet


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton
import com.xrest.finalassignment.Class.Person
import com.xrest.finalassignment.Login
import com.xrest.finalassignment.R
import com.xrest.finalassignment.UserDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class RegisterFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var view =inflater.inflate(R.layout.fragment_register, container, false)
        var fullname = view.findViewById(R.id.fullname) as EditText
        var admin :RadioButton = view.findViewById(R.id.admin)
        var male :RadioButton = view.findViewById(R.id.male)
        var female :RadioButton = view.findViewById(R.id.female)
        var others :RadioButton = view.findViewById(R.id.others)
        var username = view.findViewById(R.id.username) as EditText
        var password = view.findViewById(R.id.password) as EditText
        var btn: Button = view.findViewById(R.id.btn)


        btn.setOnClickListener(){

            var gender =""
            var img=""
            var type=""
            if(admin.isChecked)
            {
                type="admin"
            }
            else{

                type ="user"
            }

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
                UserDb.getInstance(container!!.context).getUserDAO().insert(Person(fullname.text.toString(),gender,username.text.toString(),password.text.toString(),img,type))
withContext(Dispatchers.Main){
    Toast.makeText(container!!.context, "User Inserted", Toast.LENGTH_SHORT).show()

    startActivity(Intent(container!!.context,Login::class.java))






}
            }








        }



        return view
    }


}