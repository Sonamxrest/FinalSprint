package com.xrest.finalassignment.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.xrest.finalassignment.Class.Food
import com.xrest.finalassignment.R

class Food_Adpater(val lst:ArrayList<Food>,val context:Context):RecyclerView.Adapter<Food_Adpater.FoodHolder>() {

    class FoodHolder(view: View):RecyclerView.ViewHolder(view){


        val img:ImageView
        init{

            img = view.findViewById(R.id.img)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.food_show,parent,false)
        return FoodHolder(view)
    }

    override fun getItemCount(): Int {
        return lst.size
    }

    override fun onBindViewHolder(holder: FoodHolder, position: Int) {
        val food = lst[position]
        Glide.with(context).load(food.img).into(holder.img)
    }

}