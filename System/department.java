package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class department extends javax.swing.JFrame {
    JTable table;
    public department() {
        super("Hotel Management System");
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        panel.setBounds(5,5,690,490);
        add(panel);

        table = new JTable();
        table.setBackground(new Color(3,45,48));
        table.setBounds(0,40,700,350);
        table.setForeground(Color.white);
        table.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(table);

        try{
            connection c =new connection();
            String q = "select * from Hotel_Department";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JButton back = new JButton("Back");
        back.setBounds(400,410,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JLabel department = new JLabel("DEPARTMENT");
        department.setForeground(Color.white);
        department.setFont(new Font("Tahoma", Font.BOLD, 17));
        department.setBounds(145,11,120,20);
        panel.add(department);

        JLabel budget = new JLabel("BUDGET");
        budget.setForeground(Color.white);
        budget.setFont(new Font("Tahoma", Font.BOLD, 17));
        budget.setBounds(490,15,120,20);
        panel.add(budget);

        setUndecorated(true);
        setLayout(null);
        setSize(700,500);
        setVisible(true);
        setLocation(550,150);
    }
    public static void main(String[] args) {
        new department();
    }
}