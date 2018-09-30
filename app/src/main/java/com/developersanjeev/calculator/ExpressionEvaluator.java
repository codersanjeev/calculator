package com.developersanjeev.calculator;

import bsh.EvalError;
import bsh.Interpreter;

/**
 * Utility class to evaluate the expression
 */
public class ExpressionEvaluator {

    /**
     * checks the validity of expression
     * @param expression
     * @return
     */
    static boolean checkValidity(String expression){
        return !(expression.endsWith("+") || expression.endsWith("-") || expression.endsWith("x")
                || expression.endsWith("/"));
    }

    /**
     * Evaluates the expression using bsh Interpreter
     * @param expression
     * @return
     * @throws EvalError
     */
    static Object evaluateExpression(String expression) throws EvalError {
        expression = expression.replace('x', '*');
        Interpreter interpreter = new Interpreter();
        return interpreter.eval(expression);
    }

}
