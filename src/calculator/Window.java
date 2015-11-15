/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;
import javax.swing.undo.*;
import java.util.HashMap;
/**
 *
 * @author tud15220
 */
//you need it to be divided by spaces to account for two digit numbers
//or figure out another way

public class Window extends JFrame{
       
        
public static void showWind(){    
    JFrame frame = new JFrame("Calculator");
    Buttons butts = new Buttons();
    TextArea text = new TextArea();
    text.setVisible(true);
    butts.setVisible(true);
    Color purple = new Color(108, 38, 140);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JLabel p = new JLabel();
    p.setBackground(purple);
    p.setLayout(new GridLayout(0,4, 10, 10));
    JLabel write = new JLabel("Write Equation");
    write.setForeground(Color.black);
    JLabel ans = new JLabel("Answer");
    ans.setForeground(Color.black);
    p.add(write);
    p.add(ans);
    p.add(new JLabel());
    p.add(new JLabel());
    p.add(text.textField);
    p.add(text.ansArea);
    p.add(butts.clear);
    p.add(butts.exit);
    p.add(butts.one);
    p.add(butts.two);
    p.add(butts.three);
    p.add(butts.plus);
    p.add(butts.four);
    p.add(butts.five);
    p.add(butts.six);
    p.add(butts.minus);
    p.add(butts.seven);
    p.add(butts.eight);
    p.add(butts.nine);
    p.add(butts.mult);
    p.add(butts.ans);
    p.add(butts.zero);
    p.add(butts.equals);
    p.add(butts.div);
    p.add(butts.lparen);
    p.add(butts.rparen);
    p.add(butts.delete);
    p.add(butts.exp);
    p.setOpaque(true);
    p.setPreferredSize(new Dimension(600,300));
    frame.getContentPane().add(p, BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);
}
}
