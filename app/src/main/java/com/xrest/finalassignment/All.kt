package com.xrest.finalassignment

import com.xrest.finalassignment.Class.Booking
import com.xrest.finalassignment.Class.Food
import com.xrest.finalassignment.Class.Person

var food:ArrayList<Food> = ArrayList()
var foods:ArrayList<Food> = ArrayList()
var perso :ArrayList<Person> = ArrayList()
var map:MutableMap<Person,String> = mutableMapOf()
var book:ArrayList<Booking> = ArrayList()




fun add(){

perso.add(Person("Sonam","sonam","sonam",""))

    food.add(
        Food(
            1,
            "Burger",
            "Home made with crispy bacon and home made bun",
            "https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/20190503-delish-pineapple-baked-salmon-horizontal-ehg-450-1557771120.jpg?crop=0.669xw:1.00xh;0.173xw,0&resize=640:*"
        )
    )
    food.add(
        Food(
            2,
            "Burger",
            "Home made with crispy bacon and home made bun",
            "https://wallpapercave.com/wp/wp1929358.jpg" )
    )



    foods.add(
        Food(
            1,
            "Burger",
            "Home made with crispy bacon and home made bun",
            "https://wallpapercave.com/wp/wp1929447.jpg"    )
    )
    food.add(
        Food(
            3,
            "Burger",
            "Home made with crispy bacon and home made bun",
            "https://wallpapercave.com/wp/wp1929448.jpg" )
    )
    food.add(
        Food(
            4,
            "Burger",
            "Home made with crispy bacon and home made bun",
            "https://wallpapercave.com/wp/wp1929449.jpg" )
    )
    foods.add(
            Food(
                    1,
                    "Burger",
                    "Home made with crispy bacon and home made bun",
                    "https://wallpapercave.com/wp/wp1929450.jpg" )
    )
    foods.add(
            Food(
                    1,
                    "Burger",
                    "Home made with crispy bacon and home made bun",
                    "https://wallpapercave.com/wp/wp1929445.jpg" )
    )
    food.add(
            Food(
                    5,
                    "Burger",
                    "Home made with crispy bacon and home made bun",
                    "https://wallpapercave.com/wp/wp1929445.jpg" )
    )
    foods.add(
            Food(
                    1,
                    "Burger",
                    "Home made with crispy bacon and home made bun",
                    "https://wallpapercave.com/wp/wp1929445.jpg" )
    )
    foods.add(
            Food(
                    1,
                    "Burger",
                    "Home made with crispy bacon and home made bun",
                    "https://wallpapercave.com/wp/wp1929455.jpg" )
    )


}