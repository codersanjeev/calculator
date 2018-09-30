package com.developersanjeev.calculator;

import bsh.EvalError;
import bsh.Interpreter;

public class ExpressionEvaluator {

    static boolean checkValidity(String expression){
        return !(expression.endsWith("+") || expression.endsWith("-") || expression.endsWith("x")
                || expression.endsWith("/"));
    }

    static Object evaluateExpression(String expression) throws EvalError {
        expression = expression.replace('x', '*');
        Interpreter interpreter = new Interpreter();
        return interpreter.eval(expression);
    }

}
