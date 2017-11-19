package com.learning.kotlincalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import com.learning.kotlincalculator.R.string.operation
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var x:Double? = null
    private var y:Double? = null
    private var op:String? = null
    private var opText:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_one.setOnClickListener { constructNumber("1") }
        bt_two.setOnClickListener{ constructNumber("2") }
        bt_three.setOnClickListener{ constructNumber("3") }
        bt_four.setOnClickListener{ constructNumber("4") }
        bt_five.setOnClickListener{ constructNumber("5") }
        bt_six.setOnClickListener{ constructNumber("6") }
        bt_seven.setOnClickListener{ constructNumber("7") }
        bt_eight.setOnClickListener{ constructNumber("8") }
        bt_nine.setOnClickListener{ constructNumber("9") }

        bt_add.setOnClickListener{ constructOp("+") }
        bt_sub.setOnClickListener{ constructOp("-") }
        bt_mult.setOnClickListener{ constructOp("*") }
        bt_div.setOnClickListener{ constructOp("/") }

        bt_dot.setOnClickListener{ constructNumber(".") }
        bt_equals.setOnClickListener{ performOperation() }

        et_screen.setOnLongClickListener{ clear() }
    }

    private fun constructNumber(s:String){
        opText += s
        setTextScreen()
    }

    private fun constructOp(s:String){
        op = s
        opText += s
        setTextScreen()
    }

    private fun performOperation(){
        val s = opText.split(op!!)
        x = s[0].toDouble()
        y = s[1].toDouble()

        opText = operation(x!!,y!!,op!!).toString()
        setTextScreen();
    }

    private fun setTextScreen(){
        et_screen.setText(opText)
    }

    private fun operation(x:Double, y:Double, op:String):Double{

        var result = 0.0

        when(op){
            "+" -> result = x+y
            "-" -> result = x-y
            "*" -> result = x*y
            "/" -> result = x/y
        }
        return result
    }

    private fun clear():Boolean{
        x = null
        y = null
        op = null
        opText = ""
        setTextScreen()

        return false;
    }
}
