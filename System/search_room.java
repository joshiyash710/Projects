package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class search_room extends javax.swing.JFrame implements ActionListener {
    JButton add,back;
    JCheckBox avail;
    Choice c1;
    JTable table;
    search_room(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JLabel search = new JLabel("Search Room");
        search.setBounds(250,11,186,25);
        search.setForeground(Color.white);
        search.setBackground(new Color(3,45,48));
        search.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(search);

        JLabel bedtype = new JLabel("Bed Type :");
        bedtype.setBounds(50,73,96,18);
        bedtype.setForeground(Color.white);
        bedtype.setBackground(new Color(3,45,48));
        bedtype.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(bedtype);

        JLabel roomno= new JLabel("Room No");
        roomno.setBounds(23,162,100,18);
        roomno.setForeground(Color.white);
        roomno.setBackground(new Color(3,45,48));
        roomno.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(roomno);

        JLabel avail1= new JLabel("Availability");
        avail1.setBounds(175,162,150,18);
        avail1.setForeground(Color.white);
        avail1.setBackground(new Color(3,45,48));
        avail1.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(avail1);

        JLabel cstatus =  new JLabel("Cleaning Status");
        cstatus.setBounds(290,162,180,18);
        cstatus.setForeground(Color.white);
        cstatus.setBackground(new Color(3,45,48));
        cstatus.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(cstatus);

        JLabel price = new JLabel("Price");
        price.setBounds(470,162,180,18);
        price.setForeground(Color.white);
        price.setBackground(new Color(3,45,48));
        price.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(price);

        JLabel bedtype1 = new JLabel("Room Type");
        bedtype1.setBounds(570,162,180,18);
        bedtype1.setForeground(Color.white);
        bedtype1.setBackground(new Color(3,45,48));
        bedtype1.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(bedtype1);
        ;

        avail = new JCheckBox("Only Available");
        avail.setBounds(400,69,205,23);
        avail.setForeground(Color.white);
        avail.setBackground(new Color(3,45,48));
        avail.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(avail);

        c1 =new Choice();
        c1.add("Single-Bed");
        c1.add("Double-Bed");
        c1.setBounds(153,70,120,20);
        c1.setBackground(new Color(16,108,115));
        panel.add(c1);

        table = new JTable();
        table.setBounds(0,187,700,200);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.white);
        table.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(table);

        try{
            connection conn = new connection();
            String q="select * from room";
            ResultSet resultSet = conn.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }

        add = new JButton("Search");
        add.setForeground(Color.white);
        add.setBackground(Color.BLACK);
        add.setBounds(200,400,120,30);
        add.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(add);
        add.addActionListener(this);

        back = new JButton("Back");
        back.setForeground(Color.white);
        back.setBackground(Color.BLACK);
        back.setBounds(380,400,120,30);
        back.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(back);
        back.addActionListener(this);

        setUndecorated(true);
        setLayout(null);
        setSize(700,500);
        setLocation(500,200);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            try{
                String q ="select * from room where Room_type ='"+c1.getSelectedItem()+"'";
                String q1 = "select * from room where Availability = 'Available' and  Room_type ='"+c1.getSelectedItem()+"'";
                connection conn = new connection();
                ResultSet resultSet = conn.statement.executeQuery(q);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
                if(avail.isSelected()){
                    ResultSet resultSet1 = conn.statement.executeQuery(q1);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet1));
                }

            }catch(Exception exp){
                exp.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new search_room();
    }
}

