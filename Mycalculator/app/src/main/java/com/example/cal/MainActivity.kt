package com.example.cal

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var tvinput :TextView?=null
    var lastnumeric: Boolean = false
    var lastdot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvinput=findViewById(R.id.tvinput)
    }

    fun onclick(view: View){
        tvinput?.append((view as Button).text)
        lastnumeric =true


    }
    fun onclear(view: View){
        tvinput?.text = ""
        lastnumeric = false
        lastdot = false
    }
    fun onDecimalpoint(view: View){
        if(lastnumeric&&!lastdot){
            tvinput?.append(".")
            lastnumeric=false
            lastdot=true
        }
    }

    fun onOperator(view: View) {
        tvinput?.text?.let {

            if (lastnumeric && !isopetatorAdded(it.toString())){
                tvinput?.append((view as Button).text)
                lastnumeric=false
                lastdot=false
            }
        }
    }
    //output calculation
    fun onEqual(view: View) {
        //function for checking if the last value is (".") or not
        if (lastnumeric) {
            var tvvalue = tvinput?.text.toString()
            var prefix = ""
            try {
                if (tvvalue.startsWith("-")) {
                    prefix = "-"
                    tvvalue = tvvalue.substring(1)
                }
                when {
                    tvvalue.contains("/") -> {
                        val splitvalue = tvvalue.split("/")
                        var one = splitvalue[0] //value one
                        var two = splitvalue[1] // value two
                        if (prefix.isNotEmpty()) {
                            one = prefix + one
                        }
//                        var result = one.toDouble() - two.toDouble()
                        tvinput?.text =
                            removeZeroAfterDot((one.toDouble() / two.toDouble()).toString())

                    }
                    tvvalue.contains("x")-> {
                        val splitvalue = tvvalue.split("x")
                        var one = splitvalue[0]
                        var two = splitvalue[1]
                        if (prefix.isNotEmpty()) {
                            one = prefix + one
                        }

                        tvinput?.text =
                            removeZeroAfterDot((one.toDouble() * two.toDouble()).toString())
                    } tvvalue . contains ("-")-> {
                        val splitvalue = tvvalue.split("-")
                        var one = splitvalue[0]
                        var two = splitvalue[1]
                        if (prefix.isNotEmpty()) {
                            one = prefix + one
                        }

                        tvinput?.text =
                            removeZeroAfterDot((one.toDouble() - two.toDouble()).toString())
                    } tvvalue . contains ("+")-> {
                        val splitvalue = tvvalue.split("+")
                        var one = splitvalue[0]
                        var two = splitvalue[1]
                        if (prefix.isNotEmpty()) {
                            one = prefix + one
                        }

                        tvinput?.text =
                            removeZeroAfterDot((one.toDouble() + two.toDouble()).toString())

                    }
                }
            } catch (e: ArithmeticException) {
                e.printStackTrace()
            }
        }
    }
    //Removin zero after dot
    private fun removeZeroAfterDot(result: String): String {

        var value = result

        if (result.contains(".0")) {
            value = result.substring(0, result.length - 2)
        }

        return value
    }

    private fun isopetatorAdded(value: String): Boolean {

        return if (value.startsWith("-")) {
            false
        } else {
            (value.contains("/")
                    || value.contains("*")
                    || value.contains("-")
                    || value.contains("+"))
        }
    }
}
