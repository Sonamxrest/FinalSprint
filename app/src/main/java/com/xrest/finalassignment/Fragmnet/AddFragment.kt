package com.xrest.finalassignment.Fragmnet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.xrest.finalassignment.Class.Food
import com.xrest.finalassignment.R
import com.xrest.finalassignment.food


class AddFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_add, container, false)

        val fn:EditText = view.findViewById(R.id.etFn)
        val fd:EditText = view.findViewById(R.id.etFd)
        val fi :EditText = view.findViewById(R.id.etFi)
        val btn:Button = view.findViewById(R.id.add)
        btn.setOnClickListener(){

            food.add(food.size, Food(food.size-1,fn.text.toString(),fd.text.toString(),fi.text.toString()))
            Toast.makeText(container!!.context, "One Row Inserted", Toast.LENGTH_SHORT).show()

        }
        


        return view
    }


    }
