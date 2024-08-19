package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class admin extends JFrame implements ActionListener {
    JButton add_emp,add_room,add_drivers,log_out,back;
    public admin(){
        setLayout(null);
        getContentPane().setBackground(new Color(3,45,48));
        setSize(1950,1090);
        setVisible(true);
        add_emp = new JButton("Add Employee");
        add_emp.setBounds(250,230,200,30);
        add_emp.setBackground(Color.BLACK);
        add_emp.setForeground(Color.WHITE);
        add_emp.setFont(new Font("Tahoma",Font.BOLD,15));
        add_emp.addActionListener(this);
        add(add_emp);

        add_room = new JButton("Add Room");
        add_room.setBounds(250,380,200,30);
        add_room.setBackground(Color.BLACK);
        add_room.setForeground(Color.WHITE);
        add_room.setFont(new Font("Tahoma",Font.BOLD,15));
        add_room.addActionListener(this);
        add(add_room);

        add_drivers = new JButton("Add Drivers");
        add_drivers.setBounds(250,530,200,30);
        add_drivers.setBackground(Color.BLACK);
        add_drivers.setForeground(Color.WHITE);
        add_drivers.setFont(new Font("Tahoma",Font.BOLD,15));
        add_drivers.addActionListener(this);
        add(add_drivers);

        log_out=new JButton("Log Out");
        log_out.setBounds(10,800,95,30);
        log_out.setBackground(Color.BLACK);
        log_out.setForeground(Color.WHITE);
        log_out.setFont(new Font("Tahoma",Font.BOLD,15));
        log_out.addActionListener(this);
        add(log_out);

        back = new JButton("Back");
        back.setBounds(110,800,95,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma",Font.BOLD,15));
        back.addActionListener(this);
        add(back);

        ImageIcon image1 = new ImageIcon(ClassLoader.getSystemResource("icon/employees.png"));
        Image i = image1.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon image2=new ImageIcon(i);
        JLabel label = new JLabel(image2);
        label.setBounds(70,180,120,120);
        add(label);

        ImageIcon image12 = new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
        Image i1=image12.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon image13 = new ImageIcon(i1);
        JLabel label1=new JLabel(image13);
        label1.setBounds(70,340,120,120);
        add(label1);

        ImageIcon image14= new ImageIcon(ClassLoader.getSystemResource("icon/driver.png"));
        Image i2= image14.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon image15=new ImageIcon(i2);
        JLabel label12=new JLabel(image15);
        label12.setBounds(70,500,120,120);
        add(label12);

        ImageIcon image16= new ImageIcon(ClassLoader.getSystemResource("icon/gulmohar1.gif"));
        Image i3 = image16.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon image17=new ImageIcon(i3);
        JLabel label13=new JLabel(image17);
        label13.setBounds(1000,250,400,400);
        add(label13);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add_emp){
            new add_empl();
        }
        else if(e.getSource()==add_room){
            new add_room();
        }
        else if(e.getSource()==add_drivers){
            new add_driver();
        }
        else if(e.getSource()==log_out){
            System.exit(710);
        }
        else{
            new dashboard();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new admin();
    }
}
