package com.developersanjeev.calculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import bsh.EvalError
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_one.setOnClickListener(numButtonClickListener)
        button_two.setOnClickListener(numButtonClickListener)
        button_three.setOnClickListener(numButtonClickListener)
        button_four.setOnClickListener(numButtonClickListener)
        button_five.setOnClickListener(numButtonClickListener)
        button_six.setOnClickListener(numButtonClickListener)
        button_seven.setOnClickListener(numButtonClickListener)
        button_eight.setOnClickListener(numButtonClickListener)
        button_nine.setOnClickListener(numButtonClickListener)
        button_zero.setOnClickListener(numButtonClickListener)
        button_clear.setOnClickListener(numButtonClickListener)
        button_change_sign.setOnClickListener(numButtonClickListener)
        button_plus.setOnClickListener(numButtonClickListener)
        button_minus.setOnClickListener(numButtonClickListener)
        button_multiply.setOnClickListener(numButtonClickListener)
        button_divide.setOnClickListener(numButtonClickListener)
        button_change_sign.setOnClickListener(numButtonClickListener)
        button_dot.setOnClickListener(numButtonClickListener)
        button_percentage.setOnClickListener(numButtonClickListener)
        button_equals.setOnClickListener(numButtonClickListener)

    }

    private val numButtonClickListener = View.OnClickListener { view ->
        when(view.id){

            R.id.button_one -> {
                val str:String = display_view.text.toString()
                if(str == "0"){
                    display_view.text = "1"
                }
                else {
                    display_view.text = str + "1"
                }
            }

            R.id.button_two -> {
                val str:String = display_view.text.toString()
                if(str == "0"){
                    display_view.text = "2"
                }
                else {
                    display_view.text = str + "2"
                }
            }

            R.id.button_three -> {
                val str:String = display_view.text.toString()
                if(str == "0"){
                    display_view.text = "3"
                }
                else {
                    display_view.text = str + "3"
                }
            }

            R.id.button_four -> {
                val str:String = display_view.text.toString()
                if(str == "0"){
                    display_view.text = "4"
                }
                else {
                    display_view.text = str + "4"
                }
            }

            R.id.button_five -> {
                val str:String = display_view.text.toString()
                if(str == "0"){
                    display_view.text = "5"
                }
                else {
                    display_view.text = str + "5"
                }
            }

            R.id.button_six -> {
                val str:String = display_view.text.toString()
                if(str == "0"){
                    display_view.text = "6"
                }
                else {
                    display_view.text = str + "6"
                }
            }

            R.id.button_seven -> {
                val str:String = display_view.text.toString()
                if(str == "0"){
                    display_view.text = "7"
                }
                else {
                    display_view.text = str + "7"
                }
            }

            R.id.button_eight -> {
                val str:String = display_view.text.toString()
                if(str == "0"){
                    display_view.text = "8"
                }
                else {
                    display_view.text = str + "8"
                }
            }

            R.id.button_nine -> {
                val str:String = display_view.text.toString()
                if(str == "0"){
                    display_view.text = "9"
                }
                else {
                    display_view.text = str + "9"
                }
            }

            R.id.button_zero -> {
                val str:String = display_view.text.toString()
                if(str == "0"){
                    display_view.text = "0"
                }
                else {
                    display_view.text = str + "0"
                }
            }

            R.id.button_clear -> {
                display_view.text = "0"
            }

            R.id.button_plus -> {
                val str:String = display_view.text.toString()
                if(!(str.endsWith("+") || str.endsWith("-") ||
                        str.endsWith("x") || str.endsWith("/"))){
                    display_view.text = str + "+"
                }
            }

            R.id.button_minus -> {
                val str:String = display_view.text.toString()
                if(!(str.endsWith("+") || str.endsWith("-") ||
                                str.endsWith("x") || str.endsWith("/"))){
                    display_view.text = str + "-"
                }
            }

            R.id.button_multiply -> {
                val str:String = display_view.text.toString()
                if(!(str.endsWith("+") || str.endsWith("-") ||
                                str.endsWith("x") || str.endsWith("/"))){
                    display_view.text = str + "x"
                }
            }

            R.id.button_divide -> {
                val str:String = display_view.text.toString()
                if(!(str.endsWith("+") || str.endsWith("-") ||
                                str.endsWith("x") || str.endsWith("/"))){
                    display_view.text = str + "/"
                }
            }

            R.id.button_change_sign -> {
                val str:String = display_view.text.toString()
                if(ExpressionEvaluator.checkValidity(str)){
                    try {
                        val x = Integer.parseInt(ExpressionEvaluator.evaluateExpression(str).toString())
                        display_view.text = (-1*x).toString()
                    }
                    catch (error:EvalError){
                        // do nothing
                    }
                }
            }

            R.id.button_dot -> {
                val str:String = display_view.text.toString()
                if(!(str.endsWith("+") || str.endsWith("-")
                                || str.endsWith("x") || str.endsWith("/") || str.endsWith("."))){
                    display_view.text = str + "."
                }
            }

            R.id.button_percentage -> {
                val str:String = display_view.text.toString()
                if(ExpressionEvaluator.checkValidity(str)){
                    try{
                        display_view.text = ExpressionEvaluator.evaluateExpression(
                                ExpressionEvaluator.evaluateExpression(str).toString() + "/100.0")
                                .toString()
                    }
                    catch(error:EvalError){
                        display_view.text = "INVALID"
                    }
                }
            }

            R.id.button_equals -> {
                val str:String = display_view.text.toString()
                if(ExpressionEvaluator.checkValidity(str)){
                    try {
                        display_view.text = ExpressionEvaluator.evaluateExpression(str).toString()
                    }
                    catch(error:EvalError){
                        display_view.text = "INVALID"
                    }
                }
            }
        }
    }
}
