package com.xrest.finalassignment.Fragmnet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xrest.finalassignment.Class.Food
import com.xrest.finalassignment.Adapter.FoodAdapter
import com.xrest.finalassignment.Adapter.Food_Adpater
import com.xrest.finalassignment.R
import com.xrest.finalassignment.food
import com.xrest.finalassignment.foods


class DashboardFragment : Fragment() {


 override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_dashboard, container, false)

     val rv: RecyclerView = view.findViewById(R.id.rv)
     val rv2: RecyclerView = view.findViewById(R.id.rv2)
     rv.layoutManager = LinearLayoutManager(container?.context, LinearLayoutManager.VERTICAL,false)
     rv.adapter = FoodAdapter(food, container!!.context)
     rv2.layoutManager = LinearLayoutManager(container?.context, LinearLayoutManager.HORIZONTAL,false)
     rv2.adapter = Food_Adpater(foods, container!!.context)
     return view
    }
}