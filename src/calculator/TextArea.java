/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author tud15220
 */
    public class TextArea extends JPanel implements ActionListener {
    protected static TextField textField, ansArea;
    public final static String newline = "\n";
    public static String text;

    public TextArea() {

        textField = new TextField(20);
        textField.addActionListener(this);
        textField.setEditable(true);
        add(textField);
        
        ansArea = new TextField(20);
        ansArea.addActionListener(this);
        ansArea.setEditable(false);
        add(ansArea);

                }

    public void actionPerformed(ActionEvent evt) {
        text = textField.getText();
        textField.selectAll();
        
        
        //Make sure the new text is visible, even if there
        //was a selection in the text area.
     
    }

}
