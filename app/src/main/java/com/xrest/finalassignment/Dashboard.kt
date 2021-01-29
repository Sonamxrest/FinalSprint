package com.xrest.finalassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.xrest.finalassignment.Fragmnet.*

private lateinit var fl:FrameLayout
private lateinit var bn:BottomNavigationView

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        fl = findViewById(R.id.fl)
        bn = findViewById(R.id.nav_view)


        var type = intent.getStringExtra("type")


        if (type == "admin")
        {
            currentFragmnet(RegisterFragment())
            bn.setOnNavigationItemSelectedListener(){
                when(it.itemId)
                {
                    R.id.navigation_home->{

                        currentFragmnet(SeeFragment())
                    }
                    R.id.navigation_dashboard->{
                        currentFragmnet(FoodAddFragment())
                    }
                    R.id.navigation_notifications->currentFragmnet(FoodShowFragment())

               }


                true
            }

        }
        else{


        }






    }


    fun currentFragmnet(fragment:Fragment)
    {
        supportFragmentManager.beginTransaction().apply {

            replace(R.id.fl,fragment)
            addToBackStack(null)
            commit()



        }


    }
}