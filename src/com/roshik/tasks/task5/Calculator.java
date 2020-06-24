package com.roshik.tasks.task5;

public class Calculator
{
    public BaseBinaryOperator[] binaryoperators;
    public BaseUnaryOperator[] unaryoperators;

    public Calculator()
    {
        binaryoperators = new BaseBinaryOperator[] {new Plus(),new Minus(),new Multiply(),new Divide(),new Pow()};
        unaryoperators = new BaseUnaryOperator[] {new Sqrt()};
    }

    public double calculate(String expression)
    {
        expression = normalExpression(expression);

        return parseNormal(expression);
    }

    private static String normalExpression(String expression)
    {
        expression = expression.replace(" ","");
        return expression;
    }

    private double parseNormal(String expression)
    {
        for(BaseBinaryOperator operator: binaryoperators)
        {
            //поиск оператора в строке
            int index = expression.lastIndexOf(operator.symbol);
            if (index > 0)
            {
                String leftArgStr = expression.substring(0, index);
                String rightArgStr = expression.substring(index + operator.symbol.length());

                double leftArg = parseNormal(leftArgStr);
                double rightArg = parseNormal(rightArgStr);

                double result = operator.operation(leftArg, rightArg);
                return result;
            }
        }
        for(BaseUnaryOperator operator: unaryoperators)
        {
            //поиск оператора в строке
            int index = expression.lastIndexOf(operator.symbol);
            if (index >=0)
            {
                String rightArgStr = expression.substring(index + operator.symbol.length());

                double rightArg = parseNormal(rightArgStr);

                double result = operator.operation(rightArg);
                return result;
            }
        }

        return Double.parseDouble(expression);
    }
}

