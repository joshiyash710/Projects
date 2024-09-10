package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class all_emp extends javax.swing.JFrame {
    JTable table;
    public all_emp() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        panel.setBounds(5,5,990,590);
        add(panel);

        table = new JTable();
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.white);
        table.setBounds(10,34,980,450);
        table.setFont(new Font("Tahoma", Font.BOLD, 10));
        panel.add(table);

        try{
            connection c = new connection();
            String q = "Select * from employee";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch(Exception e){
            e.printStackTrace();
        }

        JButton back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(350,500,120,30);
        back.setFont(new Font("Tahoma", Font.BOLD, 17));
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JLabel name = new JLabel("Name");
        name.setForeground(Color.white);
        name.setFont(new Font("Tahoma", Font.BOLD, 15));
        name.setBounds(41,11,70,19);
        panel.add(name);

        JLabel age = new JLabel("Age");
        age.setForeground(Color.white);
        age.setBounds(159,11,70,17);
        age.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(age);

        JLabel gender = new JLabel("Gender");
        gender.setForeground(Color.white);
        gender.setBounds(273,11,70,17);
        gender.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(gender);

        JLabel job = new JLabel("Job");
        job.setForeground(Color.white);
        job.setBounds(416,11,70,17);
        job.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(job);

        JLabel salary = new JLabel("Salary");
        salary.setForeground(Color.white);
        salary.setBounds(536,11,70,17);
        salary.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(salary);

        JLabel phone = new JLabel("Contact");
        phone.setForeground(Color.white);
        phone.setBounds(656,11,70,17);
        phone.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(phone);

        JLabel gmail = new JLabel("Email ID");
        gmail.setForeground(Color.white);
        gmail.setBounds(786,11,70,17);
        gmail.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(gmail);

        JLabel adhaar = new JLabel("Adhaar");
        adhaar.setForeground(Color.white);
        adhaar.setBounds(896,11,70,17);
        adhaar.setFont(new Font("Tahoma", Font.BOLD, 15));
        panel.add(adhaar);

        setUndecorated(true);
        setLocation(430,100);
        setLayout(null);
        setSize(1000,600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new all_emp();
    }
}