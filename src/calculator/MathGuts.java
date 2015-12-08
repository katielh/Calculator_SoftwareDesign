/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;
import java.io.IOException;
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
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.List;
import java.util.Set;

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
     static ArrayList func = new ArrayList();
     
     //logb(a)
     public static double log(double a, double b){
         double ans = Math.log10(a)/Math.log10(b);
         return ans;
     }
     
     public static double factorial(double a){
        int fact = 1; // this  will be the result
        int n = (int) a;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }


        
    
  
 
     public static String[] tokenize(String s) throws IOException {
  StreamTokenizer tokenizer = new StreamTokenizer(new StringReader(s));
  tokenizer.ordinaryChar('-');  // Don't parse minus as part of numbers.
  List<String> tokBuf = new ArrayList<String>();
  while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
    switch(tokenizer.ttype) {
      case StreamTokenizer.TT_NUMBER:
        tokBuf.add(String.valueOf(tokenizer.nval));
        break;
      case StreamTokenizer.TT_WORD:
        tokBuf.add(tokenizer.sval);
        break;
        default:  // operator
        tokBuf.add(String.valueOf((char) tokenizer.ttype));
    }
  }

         
        String[] tokenArray = tokBuf.toArray(new String[tokBuf.size()]);
        return tokenArray;
     }
    
     public static String[] tokenize1(String s){
         List<String> tokens = new ArrayList<>();
         //System.out.println("Parameter s =" + s);
         String token = "";
         String funtoken = "";
         for (int i = 0; i < s.length(); i++ ){
             //System.out.println("s.charAt(i): " + s.charAt(i));
             //fix this
             if (ops.containsKey(s.charAt(i)+"") || (s.charAt(i)+"").equals("(") || (s.charAt(i)+"").equals(")")){
                 //System.out.println("Adding token 1: " + token);
                 if (!token.equals("")){
                 tokens.add(token);
                 token = "";}
                 if (!funtoken.equals("")){
                 tokens.add(funtoken);
                 funtoken = "";
                 }
                 tokens.add(s.charAt(i)+"");
                 //System.out.println("Adding token 2: " + s.charAt(i));
             }
             else if (s.charAt(i) == ','){
                 if (!token.equals("")){
                 tokens.add(token);
                 token = "";}
                 if (!funtoken.equals("")){
                 tokens.add(funtoken);
                 funtoken = "";
                 }
                
             }
             else if ((s.charAt(i)+"").matches("[0-9.]")){
                 if (!funtoken.equals("")){
                 tokens.add(funtoken);
                 
                 funtoken = "";
                 }
                 token = token + s.charAt(i);
             }
             else if ((s.charAt(i)+"").equals("\u03C0")){
                 tokens.add("3.1415926535897932384626433832795028841971693993751");
             }
             else if ((s.charAt(i)+"").equals("e")){
                 tokens.add("2.718281828459045235360287471352662497757247093699959574966");
             }
             else if((s.charAt(i)+"").matches("[a-z!]")){
                 if (!token.equals("")){
                 tokens.add(token);
                 token = "";}
                 funtoken = funtoken + s.charAt(i);
             }
         }
         if (!token.equals("")){
         tokens.add(token);}
         if (!funtoken.equals("")){
         tokens.add(funtoken);}
         //System.out.println("tokens = " + tokens.toString());
         
        String[] tokenArray = tokens.toArray(new String[tokens.size()]);
        return tokenArray;  
     }
     
 
    
    public static boolean validEq(String check){
        return check.matches(".*[-\\=\\+\\*\\/0-9()!]");
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
            }
        else {
            infix[i+1] = "-" + infix[i+1] ;
            infix = removeElement(infix, i);
    }
            
        }
        else if (infix[i].matches(",")){
            infix = removeElement(infix, i);

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
           else if(func.contains(element)){
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
                        case "max": ans= Math.max(num1, num2);
                            break;
                        case "min": ans = Math.min(num1, num2);
                            break;
                        case "log": ans = log(num1, num2);
                            break;
                        case "nroot": ans = Math.pow(num1, 1/num2);
                            break;
                        case "mod": ans = (num2 % num1);
                            break;
                       }
                     helper.push(ans);
                }
                else if (helper.size() == 1){
                    if (postfix.isEmpty()){
                        break;
                    }
                    else{
                        double num = java.lang.Double.parseDouble(helper.pop().toString());
                        operator = postfix.poll().toString();
                        switch(operator){
                            case "sin": ans = Math.sin(num);
                                break;
                            case "cos": ans = Math.cos(num);
                                break;
                            case "tan": ans = Math.tan(num);
                                break;
                            case "!": ans = factorial(num);
                        }
                        helper.push(ans);
                    }
                    
                }
                          
                    
        } }
        ans = java.lang.Double.parseDouble(helper.pop().toString());
        return ans;
    }
    
}
