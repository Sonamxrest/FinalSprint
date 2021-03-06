package com.xrest.finalassignment.Adapter

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.xrest.finalassignment.Class.Food
import com.xrest.finalassignment.R

class FoodAdapter(val lst:MutableList<Food>, val context: Context):RecyclerView.Adapter<FoodAdapter.FoodHolder>() {


    class FoodHolder(view:View):RecyclerView.ViewHolder(view){

        var img:ImageView
        var name:TextView
        var desc:TextView
        var price:TextView
        var btn: Button
        var rating:RatingBar


        init{

            img = view.findViewById(R.id.imageView)
            name = view.findViewById(R.id.textView)
            desc = view.findViewById(R.id.textView2)
            price = view.findViewById(R.id.price)
            btn = view.findViewById(R.id.book)
            rating = view.findViewById(R.id.rating)


        }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {
       val view = LayoutInflater.from(context).inflate(R.layout.mero_food,parent,false)
        return FoodHolder(view)
    }

    override fun getItemCount(): Int {
       return lst.size
    }

    override fun onBindViewHolder(holder: FoodHolder, position: Int) {
       val food = lst[position]
        holder.name.text = food.name
        holder.desc.text = food.description
        holder.price.text = food.price.toString()
        holder.rating.rating = food!!.rating!!
        Glide.with(context).load(food.img).into(holder.img)

        holder.btn.setOnClickListener(){
dialog()
        }


    }


    fun dialog(){
        val d = AlertDialog.Builder(context)
        d.setTitle("Book Confirmation")

        d.setMessage("Are you sure you want to book this item?")
        d.setPositiveButton("Yes"){dialog,which->


            Toast.makeText(context, "Added to Cart", Toast.LENGTH_SHORT).show()
            dialog.cancel()

        }
        d.setNegativeButton("No"){dialog, which ->

        }
        val alert = d.create()

        alert.setCancelable(true)
        alert.show()


    }
}