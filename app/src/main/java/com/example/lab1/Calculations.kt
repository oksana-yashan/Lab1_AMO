package com.example.lab1

import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin

class Calculations(){
    fun task1(c: Double, g: Double):String{

        return if(c == 0.0 || g == 0.0){
            "Try one more time"
        }

        else{
             "%.3f".format(((c+27*g).pow(g+27*c))/(234*c*g))
        }
}

    fun task2( x: Double, z: Double):String{
        return if(x == -23.0 || z == 2*x){
            "Try one more time"
        }
        else if (x > 23.0){
            (((x+2*z)/(z-2*x))+((sin(x))/21)).toString()
        }
        else{"%.3f".format((((1+x))/(1+(x/23)))+(cos(x)/21))}
    }

    fun task3():String {
        var i:Int = 1
        val list: MutableList<Int> = mutableListOf(i)

        while( i < 2001){
            i += 4*i
            if(i < 2001){list.add(i)}

        };   for (element in list) {
            println(element)

        }
        return list.toString()

        }

}