package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class customer_info extends javax.swing.JFrame {
    public customer_info() {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,40,900,450);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.white);
        panel.add(table);

        try{
            connection c = new connection();
            String q = "select * from customer";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel id = new JLabel("ID");
        id.setBounds(31,11,100,14);
        id.setForeground(Color.white);
        id.setBackground(new Color(3,45,48));
        id.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(id);

        JLabel name = new JLabel("NAME");
        name.setBounds(150,11,100,14);
        name.setForeground(Color.white);
        name.setBackground(new Color(3,45,48));
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(name);


        JLabel number = new JLabel("NUMBER");
        number.setBounds(270,11,100,14);
        number.setForeground(Color.white);
        number.setBackground(new Color(3,45,48));
        number.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(number);

        JLabel gender = new JLabel("GENDER");
        gender.setBounds(360,11,100,14);
        gender.setForeground(Color.white);
        gender.setBackground(new Color(3,45,48));
        gender.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(gender);

        JLabel country = new JLabel("COUNTRY");
        country.setBounds(480,11,100,14);
        country.setForeground(Color.white);
        country.setBackground(new Color(3,45,48));
        country.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(country);


        JLabel room = new JLabel("ROOM NO.");
        room.setBounds(600,11,100,14);
        room.setForeground(Color.white);
        room.setBackground(new Color(3,45,48));
        room.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(room);

        JLabel checkin = new JLabel("TIME");
        checkin.setBounds(700,11,100,14);
        checkin.setForeground(Color.white);
        checkin.setBackground(new Color(3,45,48));
        checkin.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(checkin);

        JLabel deposit = new JLabel("DEPOSIT");
        deposit.setBounds(800,11,100,14);
        deposit.setForeground(Color.white);
        deposit.setBackground(new Color(3,45,48));
        deposit.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(deposit);

        JButton back =new JButton("BACK");
        back.setBounds(450,510,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setFont(new Font("Tahoma",Font.BOLD,12));
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });





        setUndecorated(true);
        setLayout(null);
        setSize(900,600);
        setLocation(500,100);
        setVisible(true);
    }
    public static void main(String[] args) {
        new customer_info();
    }
}
