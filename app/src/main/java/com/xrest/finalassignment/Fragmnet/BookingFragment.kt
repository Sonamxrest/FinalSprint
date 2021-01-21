package com.xrest.finalassignment.Fragmnet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xrest.finalassignment.Adapter.BookAdapter
import com.xrest.finalassignment.R
import com.xrest.finalassignment.book


class BookingFragment : Fragment() {

var books: BookAdapter? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_booking, container, false)
        val rv:RecyclerView = view.findViewById(R.id.rv)
        rv.layoutManager= LinearLayoutManager(container!!.context)
         books=BookAdapter(book,container!!.context)
        rv.adapter =books
        return view
    }

    }
