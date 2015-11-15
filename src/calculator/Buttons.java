/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import calculator.TextArea; 
import java.awt.Color;
import java.util.Arrays;

/**
 *
 * @author tud15220
 */
public class Buttons extends JPanel implements ActionListener{
    protected static JButton exit, one, two, three, four, five, six, seven,
            eight, nine, zero, plus, minus, mult, div, equals, clear, ans,
            lparen, rparen, delete, exp;
    Color numbers = new Color(172, 141, 186);
    Color controls = new Color(188, 97, 230);
    Color operations = new Color(195, 62, 254);
    String answer;
    
    
    public Buttons() {
        exit = new JButton("exit");
        exit.setVerticalTextPosition(AbstractButton.CENTER);
        exit.setHorizontalTextPosition(AbstractButton.CENTER);
        exit.setActionCommand("exit");
        exit.addActionListener(this);
        exit.setBackground(controls);
        add(exit);
        
        one = new JButton("1");
        one.setVerticalTextPosition(AbstractButton.CENTER);
        one.setHorizontalTextPosition(AbstractButton.CENTER);
        one.setActionCommand("one");
        one.addActionListener(this);
        one.setBackground(numbers);
        add(one);
        
        two = new JButton("2");
        two.setVerticalTextPosition(AbstractButton.CENTER);
        two.setHorizontalTextPosition(AbstractButton.CENTER);
        two.setActionCommand("two");
        two.addActionListener(this);
        two.setBackground(numbers);
        add(two);
        
        three = new JButton("3");
        three.setVerticalTextPosition(AbstractButton.CENTER);
        three.setHorizontalTextPosition(AbstractButton.CENTER);
        three.setActionCommand("three");
        three.addActionListener(this);
        three.setBackground(numbers);
        add(three);
        
        four = new JButton("4");
        four.setVerticalTextPosition(AbstractButton.CENTER);
        four.setHorizontalTextPosition(AbstractButton.CENTER);
        four.setActionCommand("four");
        four.addActionListener(this);
        four.setBackground(numbers);
        add(four);
        
        five = new JButton("5");
        five.setVerticalTextPosition(AbstractButton.CENTER);
        five.setHorizontalTextPosition(AbstractButton.CENTER);
        five.setActionCommand("five");
        five.addActionListener(this);
        five.setBackground(numbers);
        add(five);
        
        six = new JButton("6");
        six.setVerticalTextPosition(AbstractButton.CENTER);
        three.setHorizontalTextPosition(AbstractButton.CENTER);
        six.setActionCommand("six");
        six.addActionListener(this);
        six.setBackground(numbers);
        add(six);
        
        seven = new JButton("7");
        seven.setVerticalTextPosition(AbstractButton.CENTER);
        seven.setHorizontalTextPosition(AbstractButton.CENTER);
        seven.setActionCommand("seven");
        seven.addActionListener(this);
        seven.setBackground(numbers);
        add(seven);
        
        eight = new JButton("8");
        eight.setVerticalTextPosition(AbstractButton.CENTER);
        eight.setHorizontalTextPosition(AbstractButton.CENTER);
        eight.setActionCommand("eight");
        eight.addActionListener(this);
        eight.setBackground(numbers);
        add(eight);
        
        nine = new JButton("9");
        nine.setVerticalTextPosition(AbstractButton.CENTER);
        nine.setHorizontalTextPosition(AbstractButton.CENTER);
        nine.setActionCommand("nine");
        nine.addActionListener(this);
        nine.setBackground(numbers);
        add(nine);
        
        zero = new JButton("0");
        zero.setVerticalTextPosition(AbstractButton.CENTER);
        zero.setHorizontalTextPosition(AbstractButton.CENTER);
        zero.setActionCommand("zero");
        zero.addActionListener(this);
        zero.setBackground(numbers);
        add(zero);
        
        equals = new JButton("=");
        equals.setVerticalTextPosition(AbstractButton.CENTER);
        equals.setHorizontalTextPosition(AbstractButton.CENTER);
        equals.setActionCommand("eq");
        equals.addActionListener(this);
        equals.setBackground(operations);
        add(equals);
        
        plus = new JButton("+");
        plus.setVerticalTextPosition(AbstractButton.CENTER);
        plus.setHorizontalTextPosition(AbstractButton.CENTER);
        plus.setActionCommand("plus");
        plus.addActionListener(this);
        plus.setBackground(operations);
        add(plus);
        
        minus = new JButton("-");
        minus.setVerticalTextPosition(AbstractButton.CENTER);
        minus.setHorizontalTextPosition(AbstractButton.CENTER);
        minus.setActionCommand("minus");
        minus.addActionListener(this);
        minus.setBackground(operations);
        add(minus);
        
        mult = new JButton("*");
        mult.setVerticalTextPosition(AbstractButton.CENTER);
        mult.setHorizontalTextPosition(AbstractButton.CENTER);
        mult.setActionCommand("mult");
        mult.addActionListener(this);
        mult.setBackground(operations);
        add(mult);
        
        div = new JButton("/");
        div.setVerticalTextPosition(AbstractButton.CENTER);
        div.setHorizontalTextPosition(AbstractButton.CENTER);
        div.setActionCommand("div");
        div.addActionListener(this);
        div.setBackground(operations);
        add(div);
        
        exp = new JButton("^");
        exp.setVerticalTextPosition(AbstractButton.CENTER);
        exp.setHorizontalTextPosition(AbstractButton.CENTER);
        exp.setActionCommand("exp");
        exp.addActionListener(this);
        exp.setBackground(operations);
        add(exp);
        
        ans = new JButton("ans");
        ans.setVerticalTextPosition(AbstractButton.CENTER);
        ans.setHorizontalTextPosition(AbstractButton.CENTER);
        ans.setActionCommand("ans");
        ans.addActionListener(this);
        ans.setBackground(controls);
        add(ans);
        
        clear = new JButton("C");
        clear.setVerticalTextPosition(AbstractButton.CENTER);
        clear.setHorizontalTextPosition(AbstractButton.CENTER);
        clear.setActionCommand("clear");
        clear.addActionListener(this);
        clear.setBackground(controls);
        add(clear);
        
        delete = new JButton("delete");
        delete.setVerticalTextPosition(AbstractButton.CENTER);
        delete.setHorizontalTextPosition(AbstractButton.CENTER);
        delete.setActionCommand("del");
        delete.addActionListener(this);
        delete.setBackground(controls);
        add(delete);
        
        lparen = new JButton("(");
        lparen.setVerticalTextPosition(AbstractButton.CENTER);
        lparen.setHorizontalTextPosition(AbstractButton.CENTER);
        lparen.setActionCommand("lparen");
        lparen.addActionListener(this);
        lparen.setBackground(operations);
        add(lparen);
        
        rparen = new JButton(")");
        rparen.setVerticalTextPosition(AbstractButton.CENTER);
        rparen.setHorizontalTextPosition(AbstractButton.CENTER);
        rparen.setActionCommand("rparen");
        rparen.addActionListener(this);
        rparen.setBackground(operations);
        add(rparen);
        
    }
    
    public void actionPerformed(ActionEvent e){
        if ("exit".equals(e.getActionCommand())){
            System.exit(0);
        }
        if("one".equals(e.getActionCommand())){
            TextArea.textField.setText(TextArea.textField.getText()+ "1");
        }
         if("two".equals(e.getActionCommand())){
            TextArea.textField.setText(TextArea.textField.getText()+ "2");
        }
         if("three".equals(e.getActionCommand())){
            TextArea.textField.setText(TextArea.textField.getText()+ "3");
        }
        if("four".equals(e.getActionCommand())){
            TextArea.textField.setText(TextArea.textField.getText()+ "4");
        }
        if("five".equals(e.getActionCommand())){
            TextArea.textField.setText(TextArea.textField.getText()+ "5");
        }
        if("six".equals(e.getActionCommand())){
            TextArea.textField.setText(TextArea.textField.getText()+ "6");
        }
        if("seven".equals(e.getActionCommand())){
            TextArea.textField.setText(TextArea.textField.getText()+ "7");
        }
        if("eight".equals(e.getActionCommand())){
            TextArea.textField.setText(TextArea.textField.getText()+ "8");
        }
        if("nine".equals(e.getActionCommand())){
            TextArea.textField.setText(TextArea.textField.getText()+ "9");
        }
        if("zero".equals(e.getActionCommand())){
            TextArea.textField.setText(TextArea.textField.getText()+ "0");
        }
        
        if("plus".equals(e.getActionCommand())){
            TextArea.textField.setText(TextArea.textField.getText()+ "+");
        }
        
        if("minus".equals(e.getActionCommand())){
            TextArea.textField.setText(TextArea.textField.getText()+ "-");
        }
        
        if("mult".equals(e.getActionCommand())){
            TextArea.textField.setText(TextArea.textField.getText()+ "*");
        }
        
        if("div".equals(e.getActionCommand())){
            TextArea.textField.setText(TextArea.textField.getText()+ "/");
           
        }
        
        if("lparen".equals(e.getActionCommand())){
            TextArea.textField.setText(TextArea.textField.getText()+ "(");
        }
        
        if("rparen".equals(e.getActionCommand())){
            TextArea.textField.setText(TextArea.textField.getText()+ ")");
        }
        
        
        if("ans".equals(e.getActionCommand())){
            TextArea.textField.setText(answer);
        }
                
        if("clear".equals(e.getActionCommand())){
            TextArea.textField.setText("");
            TextArea.ansArea.setText("");
        }
        
          if("del".equals(e.getActionCommand())){
            TextArea.textField.setText(TextArea.textField.getText().substring(0, TextArea.textField.getText().length()-1));
          
        }
          
        if("exp".equals(e.getActionCommand())){
            TextArea.textField.setText(TextArea.textField.getText()+"^");
          
        }
       
        
        
        if ("eq".equals(e.getActionCommand())){
            if (MathGuts.validEq(TextArea.textField.getText()) == true){
                //testing output
            //System.out.println(Arrays.toString(TextArea.textField.getText().split("(?<=[-+*/()])|(?=[-+*/()])")));
           //System.out.println("shutingyard completed: " + MathGuts.shuntingYard(TextArea.textField.getText().split("(?<=[-+*/()^])|(?=[-+*/()^])")));
           //System.out.println("this is after problemsolver: " + MathGuts.problemSolver(MathGuts.shuntingYard(TextArea.textField.getText().split("(?<=[-+*/()^])|(?=[-+*/()^])"))));
           String[] eqString = TextArea.textField.getText().split("(?<=[-+*/()^])|(?=[-+*/()^sin])");
           System.out.print(eqString);
           double ansDouble = MathGuts.problemSolver(MathGuts.shuntingYard(eqString));
//            System.out.println(ans);
            String ansString = Double.toString(ansDouble);
            TextArea.ansArea.setText(ansString);
            answer = TextArea.ansArea.getText();
            }
            else{
            TextArea.ansArea.setText("invalid");
        }
            
                
        }
    }
    
}

