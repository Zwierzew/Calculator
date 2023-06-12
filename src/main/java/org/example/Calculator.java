package org.example;

import java.util.Scanner;
import java.util.Set;

/*
Napisz program realizujący prosty kalkulator. Program powinien:
a. pobrać pierwszą liczbę (typu float)
b. pobrać jeden ze znaków: + - / *
c. pobrać drugą liczbę (typu float)
d. zwrócić wynik pobranego działania
Jeśli użytkownik poda znak inny niż obsługiwane, program powinien wypisać „Błędny znak”.
Jeśli wpisanego działania nie da się zrealizować (tj. jest niezgodne z zasadami matematyki),
to program powinien wypisać napis „Błąd”.
 */
public class Calculator {
    public static void main(String[] args){
        float firstNumber = getFloatNumber("first");
        String mathOperator = getMathOperator();
        float secondNumber =getFloatNumber("second");

        System.out.println(operationResult(firstNumber, secondNumber, mathOperator)); // IF
        System.out.println(operationResult2(firstNumber, secondNumber, mathOperator)); // switch statement
        System.out.println(operationResult3(firstNumber,secondNumber,mathOperator)); // switch expression

    }
    private static float getFloatNumber(String sequence){
        System.out.printf("Provide %s decimal number", sequence).println();
        Scanner scan = new Scanner(System.in);
        return scan.nextFloat();
    }
    private static String getMathOperator(){
        System.out.println("Provide mathematical operator +, -, *, / .");
        Scanner scan = new Scanner(System.in);

        Set<String> mathOperators = Set.of("+", "-","*","/");
        String operator = "";
        while(!mathOperators.contains(operator)){
            operator = scan.nextLine().trim();
            if(!mathOperators.contains(operator)) System.out.println("Incorrect math operator. Pass [+, -, * or /]");
            else break;
        }
//        while(operator != "+" || operator != "-" || operator != "*" || operator != "/"){
//            operator = scan.nextLine().trim();
//            if(operator != "+" || operator != "-" || operator != "*" || operator != "/") System.out.println("Incorrect math operator. Pass [+, -, * or /]");
//            else break;
//        }
        return operator;
    }
    private static float operationResult(float firstNumber, float secondNumber, String mathOperator){
        float result = 0;
        if (mathOperator.equals("+")) result = firstNumber + secondNumber;
        else if (mathOperator.equals("-")) result = firstNumber - secondNumber;
        else if (mathOperator.equals("*")) result = firstNumber * secondNumber;
        else if (mathOperator.equals("/")){
            if (secondNumber == 0) System.out.println("Error. Applied operation is against math laws");
            else result = firstNumber / secondNumber;
        }
        return result;
    }
    private static float operationResult2(float firstNumber, float secondNumber, String mathOperator){
        float result = 0; //muszę zainicijalizować aby móc zwrócić w return (InteliiJ wymusza)
                          // czy mogę to ominąć?
        switch (mathOperator){
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if(secondNumber == 0) System.out.println("Error. Applied operation is against math laws");
                else result = firstNumber / secondNumber;
                break;
        }
        return result;
    }
    private static float operationResult3(float firstNumber, float secondNumber, String mathOperator){
        float result = 0; //jw.
        switch(mathOperator){
            case "+" -> result = firstNumber + secondNumber;
            case "-" -> result = firstNumber - secondNumber;
            case "*" -> result = firstNumber * secondNumber;
            case "/" -> {
                if(secondNumber == 0) System.out.println("Error. Applied operation is against math laws");
                else result = firstNumber / secondNumber;
            }
        }
        return result;
    }
}
