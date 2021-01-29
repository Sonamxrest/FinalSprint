package com.xrest.finalassignment.Fragmnet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xrest.finalassignment.Adapter.FoodAdapter
import com.xrest.finalassignment.Adapter.Food_Adpater
import com.xrest.finalassignment.Class.Food
import com.xrest.finalassignment.R
import com.xrest.finalassignment.UserDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class FoodShowFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var lst:MutableList<Food> = mutableListOf()

        // Inflate the layout for this fragment
        var view= inflater.inflate(R.layout.fragment_food_show, container, false)

        var rv:RecyclerView = view.findViewById(R.id.rv)
        var rv2:RecyclerView = view.findViewById(R.id.rv1)


CoroutineScope(Dispatchers.IO).launch {

  lst = UserDb.getInstance(container!!.context).getFoodDAO().getFood()
    withContext(Dispatchers.Main){
        var adapter =FoodAdapter(lst,container!!.context)
        lst.reverse()
        var adapter2 = Food_Adpater(lst,container!!.context)
        rv.layoutManager = LinearLayoutManager(container!!.context,LinearLayoutManager.HORIZONTAL,false)
        rv2.layoutManager = LinearLayoutManager(container!!.context,LinearLayoutManager.VERTICAL,false)
        rv.adapter =adapter2
        rv2.adapter =adapter


    }
}





        return view
    }


}