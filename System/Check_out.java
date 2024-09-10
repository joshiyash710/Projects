package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Check_out extends javax.swing.JFrame {
    public Check_out() {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Check Out");
        label.setBounds(100,20,130,30);
        label.setFont(new Font("Tahoma", Font.BOLD, 20));
        label.setForeground(Color.white);
        label.setBackground(new Color(3,45,48));
        panel.add(label);

        JLabel userid = new JLabel("Customer ID");
        userid.setBounds(30,80,130,30);
        userid.setFont(new Font("Tahoma", Font.BOLD, 14));
        userid.setForeground(Color.white);
        userid.setBackground(new Color(3,45,48));
        panel.add(userid);

        Choice Customer = new Choice();
        Customer.setBackground(new Color(16,108,115));
        Customer.setBounds(200,80,150,25);
        panel.add(Customer);

        JLabel roomno = new JLabel("Room No");
        roomno.setBounds(30,130,130,30);
        roomno.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomno.setForeground(Color.white);
        roomno.setBackground(new Color(3,45,48));
        panel.add(roomno);

        JLabel roomno1 = new JLabel();
        roomno1.setBounds(200,130,130,30);
        roomno1.setFont(new Font("Tahoma", Font.BOLD, 14));
        roomno1.setForeground(Color.white);
        roomno1.setBackground(new Color(3,45,48));
        panel.add(roomno1);

        JLabel checkin = new JLabel("Check In");
        checkin.setBounds(30,180,200,30);
        checkin.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkin.setForeground(Color.white);
        checkin.setBackground(new Color(3,45,48));
        panel.add(checkin);

        JLabel checkin1 = new JLabel();
        checkin1.setBounds(200,180,130,30);
        checkin1.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkin1.setForeground(Color.white);
        checkin1.setBackground(new Color(3,45,48));
        panel.add(checkin1);

        JLabel checkout = new JLabel("Check Out");
        checkout.setBounds(30,230,130,30);
        checkout.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkout.setForeground(Color.white);
        checkout.setBackground(new Color(3,45,48));
        panel.add(checkout);

        Date date = new Date();

        JLabel checkout1 = new JLabel(""+date);
        checkout1.setBounds(200,230,200,30);
        checkout1.setFont(new Font("Tahoma", Font.BOLD, 14));
        checkout1.setForeground(Color.white);
        checkout1.setBackground(new Color(3,45,48));
        panel.add(checkout1);

        try{
            connection conn = new connection();
            ResultSet resultSet= conn.statement.executeQuery("Select * from customer");
            while(resultSet.next()){
                Customer.add(resultSet.getString("Number"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JButton check_out = new JButton("Check Out");
        check_out.setBounds(30,300,120,30);
        check_out.setFont(new Font("Tahoma", Font.BOLD, 14));
        check_out.setForeground(Color.white);
        check_out.setBackground(Color.BLACK);
        panel.add(check_out);
        check_out.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    connection conn = new connection();
                    conn.statement.executeUpdate("delete from customer where Number='"+Customer.getSelectedItem()+"'");
                    conn.statement.executeUpdate("update room set Availability = 'Available' where Room_Number = '"+roomno.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done");
                    setVisible(false);
                }catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        JButton check = new JButton("Check");
        check.setBounds(300,300,120,30);
        check.setFont(new Font("Tahoma", Font.BOLD, 14));
        check.setForeground(Color.white);
        check.setBackground(Color.BLACK);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connection conn = new connection();
                try{
                    ResultSet resultSet= conn.statement.executeQuery("Select * from customer where Number = '"+Customer.getSelectedItem()+"'");
                    while(resultSet.next()){
                        roomno1.setText(resultSet.getString("Room_Number"));
                        checkin1.setText(resultSet.getString("Check_in"));

                    }
                }catch (Exception e2){
                    e2.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(170,300,120,30);
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });



        setUndecorated(true);
        setLayout(null);
        setSize(800,400);
        setLocation(500,210);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Check_out();
    }
}