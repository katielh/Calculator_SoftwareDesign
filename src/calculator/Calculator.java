 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;
import calculator.MathGuts;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.lang.Number;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author tud15220
 */
public class Calculator extends JFrame{
     public static String equation;

     
    public static void main(String[] args){
               MathGuts.ops.put("+", 1);
       MathGuts.ops.put("-", 1);
       MathGuts.ops.put("/", 3);
       MathGuts.ops.put("*", 3);
       MathGuts.ops.put("^", 5);
       MathGuts.assoc.put("+", "L");
       MathGuts.assoc.put("-", "L");
       MathGuts.assoc.put("*", "L");
       MathGuts.assoc.put("/", "L");
       MathGuts.assoc.put("^", "R");
       
//       Scanner input = new Scanner(System.in);
//       System.out.println("please enter your equation values separated by spaces");
//        equation = input.nextLine();
//        String[] eqArray = equation.split("(?<=[-+*/()])|(?=[-+*/()])");
//        Boolean validity = Math.validEq(equation);
//        if (validity == true){
//            System.out.println(Arrays.asList(eqArray));
//            System.out.println(Arrays.asList(Math.shuntingYard(eqArray)));
//            System.out.println(Math.shuntingYard(eqArray).poll());
//            System.out.println(Math.problemSolver(Math.shuntingYard(eqArray)));
//        } 
//        else {
//            System.out.println("Not an Equation");
//       }
           javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Window.showWind();
            }
        });
    }
    
}
