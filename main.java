package calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame {

    public static int equalsCounter(String str){
        int eC = 0;
        for(int i=0; i<str.length();i++){
            if(str.charAt(i)=='=') eC++;
        }
        return eC;
    }
    public static int plusCounter(String str){
        int pC = 0;
        for(int i=0; i<str.length();i++){
            if(str.charAt(i)=='+') pC++;
        }
        return pC;
    }
    public static int minusCounter(String str){
        int mC = 0;
        for(int i=0; i<str.length();i++){
            if(str.charAt(i)=='-') mC++;
        }
        return mC;
    }
    public static int slashCounter(String str){
        int sC = 0;
        for(int i=0; i<str.length();i++){
            if(str.charAt(i)=='/') sC++;
        }
        return sC;
    }
    public static int xCounter(String str){
        int xC = 0;
        for(int i=0; i<str.length();i++){
            if(str.charAt(i)=='x') xC++;
        }
        return xC;
    }
    public Calculator() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.lightGray);
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        JTextField screen=new JTextField();        
        screen.setPreferredSize(new Dimension(240,60));
        screen.setEditable(false);
        screen.setFont(new Font("Arial",Font.PLAIN,20));
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(screen,gbc);
        
        String[] buttonLabels={
            "1","2","3","+",
            "4","5","6","-",
            "7","8","9","x",
            "<","0","=","/"
        };
        
        int gridx = 0;
        int gridy = 1;
        Dimension buttonSize = new Dimension(60, 60);
        
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setPreferredSize(buttonSize);
            button.setMinimumSize(buttonSize);
            button.setMaximumSize(buttonSize);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String buttonText = ((JButton)e.getSource()).getText();
                    if(buttonText!="<"&&equalsCounter(screen.getText())<1&&plusCounter(screen.getText())<=1&&minusCounter(screen.getText())<=1
                            &&slashCounter(screen.getText())<=1&&xCounter(screen.getText())<=1)
                        screen.setText(screen.getText()+buttonText);
                    else {
                        String deletedText=screen.getText().substring(0,screen.getText().length()-1);
                        screen.setText(deletedText);
                    }
                    //----------------------------------------------------------------------
                    if(screen.getText().contains("+")&&screen.getText().contains("=")){
                        int index=screen.getText().indexOf("+");
                        if(screen.getText().substring(0,index).contains(".")||screen.getText().substring(index+1,screen.getText().length()-1).contains(".")){
                            double num1=Double.parseDouble(screen.getText().substring(0,index));
                            double num2=Double.parseDouble(screen.getText().substring(index+1,screen.getText().length()-1));
                            double sum=num1+num2;
                            screen.setText(Double.toString(sum));
                        }
                        else{
                            int num1=Integer.parseInt(screen.getText().substring(0,index));
                            int num2=Integer.parseInt(screen.getText().substring(index+1,screen.getText().length()-1));
                            int sum=num1+num2;
                            screen.setText(Integer.toString(sum));
                        }
                        
                    }
                    //----------------------------------------------------------------------
                    else if(screen.getText().contains("-")&&screen.getText().contains("=")){
                        int index=screen.getText().indexOf("-");
                        if(screen.getText().substring(0,index).contains(".")||screen.getText().substring(index+1,screen.getText().length()-1).contains(".")){
                            double num1=Double.parseDouble(screen.getText().substring(0,index));
                            double num2=Double.parseDouble(screen.getText().substring(index+1,screen.getText().length()-1));
                            double dif=num1-num2;
                            screen.setText(Double.toString(dif));
                        }
                        else{
                            int num1=Integer.parseInt(screen.getText().substring(0,index));
                            int num2=Integer.parseInt(screen.getText().substring(index+1,screen.getText().length()-1));
                            int dif=num1-num2;
                            screen.setText(Integer.toString(dif));
                        }
                    }
                    //----------------------------------------------------------------------
                    else if(screen.getText().contains("x")&&screen.getText().contains("=")){
                        int index=screen.getText().indexOf("x");
                        if(screen.getText().substring(0,index).contains(".")||screen.getText().substring(index+1,screen.getText().length()-1).contains(".")){
                            double num1=Double.parseDouble(screen.getText().substring(0,index));
                            double num2=Double.parseDouble(screen.getText().substring(index+1,screen.getText().length()-1));
                            double mul=num1*num2;
                            screen.setText(Double.toString(mul));
                        }
                        else{
                            int num1=Integer.parseInt(screen.getText().substring(0,index));
                            int num2=Integer.parseInt(screen.getText().substring(index+1,screen.getText().length()-1));
                            int mul=num1*num2;
                            screen.setText(Integer.toString(mul));
                        }
                    }
                    //----------------------------------------------------------------------
                    else if(screen.getText().contains("/")&&screen.getText().contains("=")){
                        int index=screen.getText().indexOf("/");
                        if(screen.getText().substring(0,index).contains(".")||screen.getText().substring(index+1,screen.getText().length()-1).contains(".")){
                           double num1=Double.parseDouble(screen.getText().substring(0,index));
                           double num2=Double.parseDouble(screen.getText().substring(index+1,screen.getText().length()-1));
                           double div=num1/num2;
                           screen.setText(Double.toString(div));
                        }                            
                        else{      
                           double num1=Double.parseDouble(screen.getText().substring(0,index));
                           double num2=Double.parseDouble(screen.getText().substring(index+1,screen.getText().length()-1));
                           if(num1%num2==0){
                              int div=(int)(num1/num2);
                              screen.setText(Integer.toString(div));
                           }
                           else{
                               double div=num1/num2;
                               screen.setText(Double.toString(div));
                           }
                        }
                    }

                }
            });
            button.setBackground(Color.white);
            button.setFont(new Font("Arial",Font.PLAIN,40));
            
            gbc.gridx = gridx;
            gbc.gridy = gridy;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.NONE;
            gbc.anchor = GridBagConstraints.CENTER;
            panel.add(button, gbc);
            
            gridx++;
            if (gridx > 3) { 
                gridx = 0;
                gridy++;
            }
        }
        add(panel);
        
    }

    public static void main(String[] args) {
        Calculator cal = new Calculator();
        cal.setVisible(true);
    }

    

}
