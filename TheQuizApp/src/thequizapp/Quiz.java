package thequizapp;

import java.awt.*; 
import javax.swing.*;
import java.awt.event.*;

public class Quiz extends JFrame implements ActionListener{
    
    JButton next,submit;
    public static int count = 0;
    JLabel q1,ques;
    String q[][] = new String[10][5];
    JRadioButton opt1,opt2,opt3,opt4;
    ButtonGroup opt;
    public static int timer = 15;
    String ansm[][] = new String[10][1];
    public static int ans_given=0; 
    String rans[][]= new String[10][2];
    public static int score=0;
    String username;
    
    Quiz(String username)
    {   
        this.username = username;
        setBounds(300,100,1325,900);
        getContentPane().setBackground(Color.WHITE); 
        setLayout(null); 
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("TQA4.jpg"));
        JLabel l1 = new JLabel(i1);
        l1.setBounds(0,0,1325,350);
        add(l1);
       
        q1 = new JLabel(".");
        q1.setFont(new Font("Tahoma", Font.PLAIN,24));
        q1.setBounds(100,450,60,30);
        add(q1);
        
        ques = new JLabel("");
        ques.setFont(new Font("Tahoma", Font.PLAIN,20));
        ques.setBounds(150,450,850,30);
        add(ques);
        
        q[0][0] = "Who is known as the father of Java Programming Language?";
	q[0][1] = "Charel Babbage";
	q[0][2] = "Blais Pascal";
	q[0][3] = "James Gosling";
	q[0][4] = "Dennis Ritchie";

	q[1][0] = "Whic company owns Java at present?";
	q[1][1] = "Oracle";
	q[1][2] = "Sun Microsystems"; 
	q[1][3] = "IBM ";
	q[1][4] = "MICROSOFT";
 
	q[2][0] = "Java Source Code is compiled into ______";
	q[2][1] = "Source Code";
	q[2][2] = "Obj";
	q[2][3] = "ByteCode";
	q[2][4] = "Exe";

	q[3][0] = "Which of the following is an immediate subclass of the Panel class?";
	q[3][1] = "Applet class";
	q[3][2] = "Window class";
	q[3][3] = "Dialog class";
        q[3][4] = "frame class";
                
	q[4][0] = "_____ is used to find and fix bugs in the Java programs.";
	q[4][1] = "JVM";
	q[4][2] = "JRE";
	q[4][3] = "JDK";
	q[4][4] = "JDB";
	
	q[5][0] = "Which of the following is not a Java features?";
	q[5][1] = "Dynamic";
	q[5][2] = "Architecture Neutral";
	q[5][3] = "Use of pointers";
	q[5][4] = "Object-oriented";

	q[6][0] = "In which memory a String is stored, when we create a string using new operator?";
	q[6][1] = "Stack";
	q[6][2] = "String memory";
	q[6][3] = "Heap memory";
	q[6][4] = "Random storage space";

	q[7][0] = "What is the initial quantity of the ArrayList list?";
	q[7][1] = "5";
	q[7][2] = "10";
	q[7][3] = "0";
	q[7][4] = "100";

	q[8][0] = "In java, jar stands for_____.";
	q[8][1] = "Java Archive Runner";
	q[8][2] = "Java Application Resource";
	q[8][3] = "Java Application Runner";
	q[8][4] = "None of the above";
	
	q[9][0] = "Which one is a template for creating different objects ?";
	q[9][1] = "An Array";
	q[9][2] = "A class";
	q[9][3] = "Interface";
	q[9][4] = "Method";
        
        rans[0][1] = "James Gosling";
	rans[1][1] = "Oracle";
	rans[2][1] = "ByteCode";
	rans[3][1] = "Applet class";
	rans[4][1] = "JDB";
	rans[5][1] = "Use of pointers";
	rans[6][1] = "Heap memory";
	rans[7][1] = "10";
	rans[8][1] = "None of the above";
	rans[9][1] = "A class";
        
        opt1 = new JRadioButton("");
        opt1.setBounds(160,500,300,30);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 16));
        opt1.setBackground( Color.WHITE);
        add(opt1); 
        
        opt2 = new JRadioButton("");
        opt2.setBounds(160,550,300,30);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 16));
        opt2.setBackground( Color.WHITE);
        add(opt2); 
        
        opt3 = new JRadioButton("");
        opt3.setBounds(160,600,300,30);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 16));
        opt3.setBackground( Color.WHITE);
        add(opt3);
        
        opt4 = new JRadioButton("");
        opt4.setBounds(160,650,300,30);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 16));
        opt4.setBackground( Color.WHITE);
        add(opt4);
        
        opt = new ButtonGroup();
        opt.add(opt1);
        opt.add(opt2);
        opt.add(opt3);
        opt.add(opt4);
        
        next = new JButton("Next");
        next.setBounds(1000,550,200,40);
        next.setBackground(new Color(30,144,255));
        next.setForeground(Color.white);
        next.addActionListener(this);
        next.setFont(new Font("Tahoma", Font.PLAIN,18));
        add(next);
       
        submit = new JButton("Submit");
        submit.setBounds(1000,650,200,40);
        submit.setBackground(new Color(30,144,255));
        submit.setForeground(Color.white);
        submit.setFont(new Font("Tahoma", Font.PLAIN,18));
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);
        
        start(0);
}
    /**
     *
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== next)
        {
            repaint();
            ans_given = 1;
            if(opt.getSelection()== null)
            {
                ansm[count][0]= "";
            }
            else
            {
                ansm[count][0] = opt.getSelection().getActionCommand();   
            }
            
            if(count==8 )
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            
            count++;        //to go count to question and take next option marked value 
            start(count);
        }
        else if(ae.getSource()==submit)
        {   
            ans_given = 1;
            if(opt.getSelection()== null)
            {
                ansm[count][0]= "";
            }
            else
            {
                ansm[count][0]=opt.getSelection().getActionCommand();
            }
            for(int i=0; i<ansm.length;i++)
            {
                if(ansm[i][0].equals(rans[i][1]))
                {
                    score+=10;
                }   
                else
                {
                    score+=0;
                }
            }
            this.setVisible(false);
            new score(username, score).setVisible(true);
        }
    }
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);          //it is used to open next question on the window
        String time = "Time Left - " + timer +" seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,30 ));
     
        if(timer > 0)
        {
            g.drawString(time, 1000, 490);
        }
        else
        {
            g.drawString("Times up!!", 1000, 490);
        }
        timer--;
        try
        {
            Thread.sleep(1000);
            repaint();
        }
        catch(InterruptedException e )
        {
        }
        if(ans_given == 1)
        {
            ans_given = 0; 
            timer=15;
        }
        else if(timer<0)
        {
            timer=15;
            
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
        
            if(count==8 )
            {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if(count==9)
            {
                if(opt.getSelection()== null)
                {
                    ansm[count][0]= "";
                }
                else
                {
                    ansm[count][0]=opt.getSelection().getActionCommand();
                }
                for(int i=0; i<ansm.length;i++)
                {
                    if(ansm[i][0].equals(rans[i][1]))
                    {
                        score+=10;
                    }   
                    else
                    {
                        score+=0;
                    }
                }
                this.setVisible(false); 
                new score(username, score).setVisible(true);
            }
            else
            {
                if(opt.getSelection()== null)
                {
                    ansm[count][0]= "";
                }
                else
                {
                    ansm[count][0]=opt.getSelection().getActionCommand();
                }
                count++;
                start(count);
            }
        }  
    }
    private void start(int count){
        q1.setText("" + (count + 1)+".");
        ques.setText(q[count][0]);
        opt1.setLabel(q[count][1]);
        opt1.setActionCommand(q[count][1]);
        opt2.setLabel(q[count][2]);
        opt2.setActionCommand(q[count][2]);
        opt3.setLabel(q[count][3]);
        opt3.setActionCommand(q[count][3]);
        opt4.setLabel(q[count][4]);
        opt4.setActionCommand(q[count][4]);
        opt.clearSelection();
    }
    public static void main(String[] args) {
     new Quiz("").setVisible(true);
    }
}