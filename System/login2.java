package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class login2 extends JFrame implements ActionListener {
    JTextField textfield1;
    JPasswordField textfield2;
    JButton b1,b2;
    public login2() {
        super("Hotel Management System");
        JLabel label1=new JLabel("Username");
        label1.setBounds(40,20,100,30);
        add(label1);
        label1.setFont(new Font("Tahoma", Font.BOLD,16));
        getContentPane().setBackground(new Color(3,45,48));
        label1.setForeground(new Color(212,175,55));
        JLabel label2=new JLabel("Password");
        label2.setBounds(40,70,100,30);
        add(label2);
        label2.setFont(new Font("Tahoma", Font.BOLD,16));
        textfield1=new JTextField();
        textfield1.setBounds(150,20,150,30);
        textfield1.setForeground(new Color(212,175,55));
        textfield1.setFont(new Font("Tahoma", Font.PLAIN,15));
        textfield1.setBackground(new Color(26,104,110));
        add(textfield1);
        textfield2=new JPasswordField();
        textfield2.setBounds(150,70,150,30);
        textfield2.setForeground(new Color(212,175,55));
        textfield2.setBackground(new Color(26,104,110));
        add(textfield2);
        b1=new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("Serif", Font.BOLD,15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
        b1.addActionListener(this);
        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("Serif", Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);
        b2.addActionListener(this);
        ImageIcon login =new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("icon/gulmohar1.gif")).getImage().getScaledInstance(255,300,Image.SCALE_DEFAULT));
        JLabel label3=new JLabel(login);
        label3.setBounds(318,-30,255,300);
        add(label3);

        getContentPane().setBackground(new Color(3,45,48));
        label2.setForeground(new Color(212,175,55));
        setLayout(null);
        setSize(600,300);
        setVisible(true);
        setLocation(400,270);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            try{
                connection c=new connection();
                String username=textfield1.getText();
                String password=textfield2.getText();

                String q="select * from login2 where Username='"+username+"' and Password='"+password+"'";
                ResultSet resultSet=c.statement.executeQuery(q);
                if(resultSet.next()){
                    new admin();
                    setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                }
            }catch(Exception E){
                E.printStackTrace();
            }
        }
        else {
            new dashboard();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new login2();
    }
}