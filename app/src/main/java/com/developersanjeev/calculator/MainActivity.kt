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

        // set on click listener for every button
        button_one.setOnClickListener(buttonClickListener)
        button_two.setOnClickListener(buttonClickListener)
        button_three.setOnClickListener(buttonClickListener)
        button_four.setOnClickListener(buttonClickListener)
        button_five.setOnClickListener(buttonClickListener)
        button_six.setOnClickListener(buttonClickListener)
        button_seven.setOnClickListener(buttonClickListener)
        button_eight.setOnClickListener(buttonClickListener)
        button_nine.setOnClickListener(buttonClickListener)
        button_zero.setOnClickListener(buttonClickListener)
        button_clear.setOnClickListener(buttonClickListener)
        button_change_sign.setOnClickListener(buttonClickListener)
        button_plus.setOnClickListener(buttonClickListener)
        button_minus.setOnClickListener(buttonClickListener)
        button_multiply.setOnClickListener(buttonClickListener)
        button_divide.setOnClickListener(buttonClickListener)
        button_change_sign.setOnClickListener(buttonClickListener)
        button_dot.setOnClickListener(buttonClickListener)
        button_percentage.setOnClickListener(buttonClickListener)
        button_equals.setOnClickListener(buttonClickListener)

    }

    private val buttonClickListener = View.OnClickListener { view ->
        when(view.id){

            // Button one is clicked
            R.id.button_one -> {
                // get current string from display
                val str:String = display_view.text.toString()
                if(str == "0"){
                    // display 1 instead of 01
                    display_view.text = "1"
                }
                else {
                    display_view.text = str + "1"
                }
            }

            // Button two is clicked
            R.id.button_two -> {
                val str:String = display_view.text.toString()
                if(str == "0"){
                    display_view.text = "2"
                }
                else {
                    display_view.text = str + "2"
                }
            }

            // Button three is clicked
            R.id.button_three -> {
                val str:String = display_view.text.toString()
                if(str == "0"){
                    display_view.text = "3"
                }
                else {
                    display_view.text = str + "3"
                }
            }

            // Button four is clicked
            R.id.button_four -> {
                val str:String = display_view.text.toString()
                if(str == "0"){
                    display_view.text = "4"
                }
                else {
                    display_view.text = str + "4"
                }
            }

            // Button five is clicked
            R.id.button_five -> {
                val str:String = display_view.text.toString()
                if(str == "0"){
                    display_view.text = "5"
                }
                else {
                    display_view.text = str + "5"
                }
            }

            // Button six is clicked
            R.id.button_six -> {
                val str:String = display_view.text.toString()
                if(str == "0"){
                    display_view.text = "6"
                }
                else {
                    display_view.text = str + "6"
                }
            }

            // Button seven is clicked
            R.id.button_seven -> {
                val str:String = display_view.text.toString()
                if(str == "0"){
                    display_view.text = "7"
                }
                else {
                    display_view.text = str + "7"
                }
            }

            // Button eight is clicked
            R.id.button_eight -> {
                val str:String = display_view.text.toString()
                if(str == "0"){
                    display_view.text = "8"
                }
                else {
                    display_view.text = str + "8"
                }
            }

            // Button nine is clicked
            R.id.button_nine -> {
                val str:String = display_view.text.toString()
                if(str == "0"){
                    display_view.text = "9"
                }
                else {
                    display_view.text = str + "9"
                }
            }

            // Button zero is clicked
            R.id.button_zero -> {
                val str:String = display_view.text.toString()
                if(str == "0"){
                    display_view.text = "0"
                }
                else {
                    display_view.text = str + "0"
                }
            }

            // Button clear is clicked
            R.id.button_clear -> {
                display_view.text = "0"
            }

            // Button plus is clicked
            R.id.button_plus -> {
                val str:String = display_view.text.toString()
                // checks if there is already an operator in the end
                if(ExpressionEvaluator.checkValidity(str)){
                    display_view.text = str + "+"
                }
            }

            // Button minus is clicked
            R.id.button_minus -> {
                val str:String = display_view.text.toString()
                if(ExpressionEvaluator.checkValidity(str)){
                    display_view.text = str + "-"
                }
            }

            // Button multiply is clicked
            R.id.button_multiply -> {
                val str:String = display_view.text.toString()
                if(ExpressionEvaluator.checkValidity(str)){
                    display_view.text = str + "x"
                }
            }

            // Button divide is clicked
            R.id.button_divide -> {
                val str:String = display_view.text.toString()
                if(ExpressionEvaluator.checkValidity(str)){
                    display_view.text = str + "/"
                }
            }

            // Button change sign is clicked
            R.id.button_change_sign -> {
                val str:String = display_view.text.toString()
                if(ExpressionEvaluator.checkValidity(str)){
                    try {
                        // evaluate the current expression
                        // multiply it by (-1) to change the sign
                        val x = Integer.parseInt(ExpressionEvaluator.evaluateExpression(str).toString())
                        display_view.text = (-1*x).toString()
                    }
                    catch (error:EvalError){
                        // do nothing as expression can't be evaluated
                    }
                }
            }

            // Button dot is clicked
            R.id.button_dot -> {
                val str:String = display_view.text.toString()
                // if condition to check the validity of expression
                // as dot can't come after '+', '-', 'x', '/' or '.'
                if(!(str.endsWith("+") || str.endsWith("-")
                                || str.endsWith("x") || str.endsWith("/") || str.endsWith("."))){
                    display_view.text = str + "."
                }
            }

            // Button percentage is clicked
            R.id.button_percentage -> {
                val str:String = display_view.text.toString()
                // first check the validity of expression
                if(ExpressionEvaluator.checkValidity(str)){
                    try{
                        // evaluate the current expression
                        // divide it by 100.0 to find percent
                        // again evaluate it
                        display_view.text = ExpressionEvaluator.evaluateExpression(
                                ExpressionEvaluator.evaluateExpression(str).toString() + "/100.0")
                                .toString()
                    }
                    catch(error:EvalError){
                        display_view.text = "INVALID"
                    }
                }
            }

            // Button equals is clicked
            R.id.button_equals -> {
                val str:String = display_view.text.toString()
                // Simply check the validity and evaluate the expression
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
