package thequizapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class Rules extends JFrame implements ActionListener{
    JButton b1,b2;
    String username;
    Rules(String username )
   {
        this.username = username;
        setBounds(400,200,950,600);
        getContentPane().setBackground(Color.WHITE); 
        setLayout(null); 
        
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("TQAR2.jpg"));
       JLabel l0 = new JLabel(i1);
       l0.setBounds(10,0,420,550);
       add(l0);
       
       
       JLabel l1 = new JLabel("Welcome " + username + " to the Quiz");
       l1.setForeground(new Color(10,150,255));
       l1.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,32));
       l1.setBounds(450, 20,650,30);
       add(l1);
       
       JLabel l2 = new JLabel("Quiz Rules");
       l2.setForeground(Color.MAGENTA);
       l2.setFont(new Font("Standard",Font.PLAIN,26));
       l2.setBounds(450,90,600,30);
       add(l2);
       
       JLabel l3 = new JLabel("12");
       l3.setFont(new Font("Standard",Font.PLAIN,18));
       l3.setBounds(480,140,500,300);
       l3.setText(
            "<html>"+
               "1. Attempting all the question is not compulsary."+ "<br><br>"+
               "2. Their is time limit of 15 sec, so do question fast." + "<br><br>"+
               "3. No negative marking." + "<br><br>"+
               "4. you can skip question if you don't know the answer." + "<br><br>"+
               "5. Their are 10 Questions and each have 4 options. " + "<br><br>"+
               "<html>" 
            );
       add(l3);
       
       b1 = new JButton("BACK");
       b1.setBounds(500,460,100,30);
       b1.setBackground(new Color(30,144,255));
       b1.setForeground(Color.WHITE);
       b1.addActionListener(this);
       add(b1);
       
       b2 = new JButton("START");
       b2.setBounds(750,460,100,30);
       b2.setBackground(new Color(30,144,255));
       b2.setForeground(Color.WHITE);
       b2.addActionListener(this);
       add(b2);
       
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            
            this.setVisible(false);
            new TheQuizApp().setVisible(true);
        }
        else if(ae.getSource()==b2){
            this.setVisible(false);
            new Quiz(username).setVisible(true);
            
        }
    }

    public static void main(String[] args) {
        new Rules("");
    }
}
