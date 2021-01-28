package com.xrest.finalassignment.Adapter

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.xrest.finalassignment.Class.Person
import com.xrest.finalassignment.R
import com.xrest.finalassignment.UserDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.w3c.dom.Text

class UserAdapter(var lst:MutableList<Person>,var context: Context):RecyclerView.Adapter<UserAdapter.UserHolder>() {

    class UserHolder(view: View):RecyclerView.ViewHolder(view){

        var fullname:TextView
        var username:TextView
        var gender:TextView
        var img: ImageView
        var delete:ImageButton
        var update:ImageButton
        init{
            fullname = view.findViewById(R.id.fullname)
            username = view.findViewById(R.id.username)
            gender = view.findViewById(R.id.gender)
            img = view.findViewById(R.id.prof)
            delete = view.findViewById(R.id.delete)
            update = view.findViewById(R.id.update)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
     val view = LayoutInflater.from(context).inflate(R.layout.user_show,parent,false)
        return  UserHolder(view)
    }

    override fun getItemCount(): Int {
       return lst.size
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {

        val current = lst[position]

        holder.fullname.text = current.fname
        holder.username.text = current.username
        holder.gender.text = current.gender
        Glide.with(context).load(current.img).into(holder.img)

        holder.delete.setOnClickListener(){

            CoroutineScope(Dispatchers.IO).launch {
                UserDb.getInstance(context).getUserDAO().delete(current)
                withContext(Dispatchers.Main){
                    Toast.makeText(context, "User Deleted", Toast.LENGTH_SHORT).show()
                }

            }
        }

        holder.update.setOnClickListener(){


            var dialog = Dialog(context,R.style.ThemeOverlay_AppCompat_Dialog_Alert)
            dialog.setContentView(R.layout.alert_view)
            dialog.show()
            dialog.setCancelable(true)



            var fname:EditText = dialog.findViewById(R.id.efname)
var gender = lst[position].gender
            var img =""
            var male:RadioButton = dialog.findViewById(R.id.male)
            var female:RadioButton = dialog.findViewById(R.id.female)
            var others:RadioButton = dialog.findViewById(R.id.others)
            var username:EditText = dialog.findViewById(R.id.eusername)
            var password:EditText = dialog.findViewById(R.id.epassword)
            var add:Button = dialog.findViewById(R.id.eadd)

            when(gender){

                "Male"->male.isChecked = true

                "Female"->female.isChecked
                "Others"->others.isChecked
            }

            fname.setText(lst[position].fname)
            username.setText(lst[position].username)
            password.setText(lst[position].password)


            add.setOnClickListener(){
               if(male.isChecked) {
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
                val username = username.text.toString()
                val fname = fname.text.toString()
                val password = password.text.toString()

                lst[position].fname = fname
                lst[position].username = username
                lst[position].password = password
                lst[position].gender = gender
                lst[position].img = img

                CoroutineScope(Dispatchers.IO).launch {
                   UserDb
                            .getInstance(context)
                            .getUserDAO()
                            .update(lst[position])

                    withContext(Dispatchers.Main) {
                        Toast.makeText(context, "student data updated", Toast.LENGTH_SHORT)
                                .show()


                    }
                }

                notifyDataSetChanged()
                dialog.dismiss()


            }



        }



    }


}