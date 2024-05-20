import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Interface extends JFrame {

    public Interface() {
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
                    if(buttonText!="<")
                        screen.setText(screen.getText()+buttonText);
                    else {
                        String deletedText=screen.getText().substring(0,screen.getText().length()-1);
                        screen.setText(deletedText);
                    }
                    if(screen.getText().contains("+")&&screen.getText().contains("=")){
                        int index=screen.getText().indexOf("+");
                        int num1=Integer.parseInt(screen.getText().substring(0,index));
                        int num2=Integer.parseInt(screen.getText().substring(index+1,screen.getText().length()-1));
                        int sum=num1+num2;
                        screen.setText(Integer.toString(sum));
                    }
                    else if(screen.getText().contains("-")&&screen.getText().contains("=")){
                        int indis=screen.getText().indexOf("-");
                        int num1=Integer.parseInt(screen.getText().substring(0,indis));
                        int num2=Integer.parseInt(screen.getText().substring(indis+1,screen.getText().length()-1));
                        int dif=num1-num2;
                        screen.setText(Integer.toString(dif));
                    }
                    else if(screen.getText().contains("x")&&screen.getText().contains("=")){
                        int indis=screen.getText().indexOf("x");
                        int num1=Integer.parseInt(screen.getText().substring(0,indis));
                        int num2=Integer.parseInt(screen.getText().substring(indis+1,screen.getText().length()-1));
                        int mul=num1*num2;
                        screen.setText(Integer.toString(mul));
                    }
                    else if(screen.getText().contains("/")&&screen.getText().contains("=")){
                        int indis=screen.getText().indexOf("/");
                        int num1=Integer.parseInt(screen.getText().substring(0,indis));
                        int num2=Integer.parseInt(screen.getText().substring(indis+1,screen.getText().length()-1));
                        double div=num1/num2;
                        screen.setText(Double.toString(div));
                    }

                }
            });
            button.setBackground(Color.white);
            
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
        Interface inf = new Interface();
        inf.setVisible(true);
    }

}
