package com.xrest.finalassignment.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.xrest.finalassignment.Class.Booking
import com.xrest.finalassignment.R
import com.xrest.finalassignment.food

class BookAdapter(val lst:ArrayList<Booking>,val context: Context):RecyclerView.Adapter<BookAdapter.BookHolder>(){


    class BookHolder(view: View):RecyclerView.ViewHolder(view){

        val img:ImageView
        init{

            img = view.findViewById(R.id.img)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.show_book,parent,false)
        return BookHolder(view)
    }

    override fun getItemCount(): Int {
      return lst[0].id.size
    }

    override fun onBindViewHolder(holder: BookHolder, position: Int) {
Glide.with(context).load(food[lst[0].id[position]].img).into(holder.img)
    }


}