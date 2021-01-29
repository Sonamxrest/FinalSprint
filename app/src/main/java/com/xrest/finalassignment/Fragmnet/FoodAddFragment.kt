package com.xrest.finalassignment.Fragmnet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.xrest.finalassignment.Class.Food
import com.xrest.finalassignment.R
import com.xrest.finalassignment.UserDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FoodAddFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_food_add, container, false)

        var foodName:EditText = view.findViewById(R.id.name)
        var description:EditText = view.findViewById(R.id.description)
        var rating:EditText = view.findViewById(R.id.rating)
        var price:EditText = view.findViewById(R.id.price)
        var image:EditText = view.findViewById(R.id.image)
        var submit: Button = view.findViewById(R.id.submit)
submit.setOnClickListener() {

    CoroutineScope(Dispatchers.IO).launch {

        UserDb.getInstance(container!!.context).getFoodDAO().insertFood(Food(foodName.text.toString(),description.text.toString(),image.text.toString(),rating.text.toString().toFloat(),price.text.toString().toFloat()))
withContext(Dispatchers.Main){
    foodName.setText(null)
    description.setText(null)
    rating.setText(null)
    price.setText(null)
    image.setText(null)
}

    }




}





        return view
    }

}