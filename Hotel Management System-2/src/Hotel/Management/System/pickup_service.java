package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class pickup_service extends javax.swing.JFrame {
    Choice car_type;
    public pickup_service() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        panel.setBounds(5,5,790,590);
        add(panel);

        JLabel head = new JLabel("Pickup Service");
        head.setBounds(90,11,200,40);
        head.setForeground(Color.white);
        head.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(head);

        JLabel cartype = new JLabel("Car Type");
        cartype.setBounds(32,97,89,20);
        cartype.setForeground(Color.white);
        cartype.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(cartype);

        car_type = new Choice();
        car_type.setBounds(123,94,150,25);
        car_type.setFont(new Font("Tahoma",Font.BOLD,15));
        car_type.setBackground(new Color(16,108,115));
        car_type.setForeground(Color.white);
        panel.add(car_type);

        try{
            connection c = new connection();
            ResultSet resultSet = c.statement.executeQuery("select * from driver ");
            while(resultSet.next()){
                car_type.add(resultSet.getString("Car_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JTable table = new JTable();
        table.setBounds(10,233,800,250);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.white);
        panel.add(table);

        try{
            connection c1 = new connection();
            ResultSet resultSet1 = c1.statement.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(resultSet1));
        }catch(Exception e1){
            e1.printStackTrace();
        }

        JLabel dname = new JLabel("Driver Name");
        dname.setBounds(24,208,100,25);
        dname.setForeground(Color.white);
        dname.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(dname);

        JLabel age = new JLabel("Age");
        age.setBounds(165,208,100,25);
        age.setForeground(Color.white);
        age.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(age);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(265,208,100,25);
        gender.setForeground(Color.white);
        gender.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(gender);

        JLabel company = new JLabel("Company");
        company.setBounds(365,208,100,25);
        company.setForeground(Color.white);
        company.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(company);

        JLabel cname = new JLabel("Car Name");
        cname.setBounds(480,208,100,25);
        cname.setForeground(Color.white);
        cname.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(cname);

        JLabel avail = new JLabel("Availability");
        avail.setBounds(580,208,100,25);
        avail.setForeground(Color.white);
        avail.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(avail);

        JLabel loc = new JLabel("Location");
        loc.setBounds(700,208,100,25);
        loc.setForeground(Color.white);
        loc.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(loc);

        JButton display = new JButton("Display");
        display.setBounds(200,500,120,30);
        display.setForeground(Color.white);
        display.setBackground(Color.BLACK);
        display.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(display);
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q = "select * from driver where Car_name = '"+car_type.getSelectedItem()+"'";
                try{
                    connection c1 = new connection();
                    ResultSet resultSet1 = c1.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet1));
                }catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });


        JButton back = new JButton("Back");
        back.setBounds(420,500,120,30);
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });





        setUndecorated(true);
        setLayout(null);
        setSize(800,600);
        setLocation(500,100);
        setVisible(true);
    }
    public static void main(String[] args) {
        new pickup_service();
    }
}
