/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.lang.Number;
import java.util.HashMap;
import java.util.Map;
import java.lang.Math;
import java.util.ArrayList;
/**
 *
 * @author tud15220
 */
public class MathGuts {
  
    public static double num1;
    public static double num2;
    public static String operator;
    final int inputMode = 0;
    final int resultMode = 1;
    final int errMode = 2;
    int displayMode;
    
    
     static Map<String, Integer> ops = new HashMap<String, Integer>();
     static Map<String, String> assoc = new HashMap<String, String>();
  
 
    
 
    
    public static boolean validEq(String check){
        return check.matches(".*[-\\=\\+\\*xX\\/0-9()]");
    }
    
    public static String[] removeElement(String[] a, int del) {
       String[] output = new String[a.length-1];
       System.arraycopy(a,del+1,a,del,a.length-1-del);
       System.arraycopy(a, 0, output, 0, a.length-1);
       return output;
}
    
    public static Queue shuntingYard(String[] infix) {
    
    for (int i = 0; i < infix.length; i++){ 
        if (infix[i].matches("-")) {
            if (i > 0 && infix[i-1].matches(".*[0-9.]")){
                //add functions
            }
        else {
            infix[i+1] = "-" + infix[i+1] ;
            infix = removeElement(infix, i);
    }
        }
        }
    //   System.out.println("this is in shuntingyard" + Arrays.asList(infix));
       Stack operators = new Stack();
       Queue output = new LinkedList();
       for (String element : infix){
           if (ops.containsKey(element)) {
                while (operators.empty() == false){
                  /*while there is an operator token, o2, at the top of the operator stack, and either
o1 is left-associative and its precedence is less than or equal to that of o2, or
o1 is right associative, and has precedence less than that of o2,*/
                 if (ops.containsKey(operators.peek().toString()))
                 {
                     if (assoc.get(element).matches("L") && ops.get(element) <= ops.get(operators.peek().toString()) ){
                    output.add(operators.pop());}
                    
                     else {
                         break;
                     }

                 
                 }
                 
                 else{
                     break;
              }
                }
                operators.push(element);
                
           }
           
                       // left parenthesis
            else if (element.equals("(")) {
                operators.push(element);
                
            }

            // right parenthesis
            else if (element.equals(")")) {
                while ( !operators.peek().equals("("))
                    output.add(operators.pop());
                operators.pop();
            }
            
            // digit
             else {
                output.add(element);
            }
           }
       
        while (operators.empty() == false){
            output.add(operators.pop());
            
        }
       
       
       return output; 
    
    }
    
    public static double problemSolver(Queue postfix){
        double ans = 0;
        Stack helper = new Stack();
        while (postfix.peek() != null){
            if (postfix.peek().toString().matches(".*[0-9\\.]")){
                helper.push(java.lang.Double.parseDouble(postfix.poll().toString()));
            }
            else{
                if (helper.size()>= 2){
                    num1 = java.lang.Double.parseDouble(helper.pop().toString());
                    num2 = java.lang.Double.parseDouble(helper.pop().toString());
                    operator = postfix.poll().toString();
                    switch (operator){
                        case "+": ans = num1 + num2;
                           break;
                        case "*": ans = num1 * num2;
                            break;
                        case "/": ans = num2/num1;
                            break;
                        case "x": ans = num1 * num2;
                            break;
                        case "X": ans = num1 * num2;
                            break;
                        case "-": ans = num2 - num1;
                            break;
                        case "^": ans = Math.pow(num2, num1);
                            break;
                       }
                     helper.push(ans);
                }
                          
                    
        } }
        ans = java.lang.Double.parseDouble(helper.pop().toString());
        return ans;
    }
    
}
