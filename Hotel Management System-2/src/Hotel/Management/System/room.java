package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class room extends javax.swing.JFrame implements ActionListener {
    JTable table;
    JButton back;
    public room(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
        Image i = image.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon image1 = new ImageIcon(i);
        JLabel label = new JLabel(image1);
        label.setBounds(600,200,200,200);
        panel.add(label);

        table = new JTable();
        table.setBounds(10,40,500,400);
        table.setBackground(new Color(3,45,48));
        table.setForeground(Color.white);
        table.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(table);

        try{
            connection c = new connection();
            String room_info = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(room_info);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        back=new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setBounds(200,500,120,30);
        panel.add(back);
        back.addActionListener(this);

        JLabel room_no=new JLabel("ROOM NO.");
        room_no.setForeground(Color.white);
        room_no.setFont(new Font("Tahoma",Font.BOLD,14));
        room_no.setBounds(10,15,80,19);
        panel.add(room_no);

        JLabel avail = new JLabel("AVAILABLE");
        avail.setBounds(119,15,80,19);
        avail.setForeground(Color.white);
        avail.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(avail);

        JLabel clean = new JLabel("CLEAN STATUS");
        clean.setBounds(216,15,150,19);
        clean.setForeground(Color.white);
        clean.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(clean);

        JLabel price = new JLabel("PRICE");
        price.setBounds(330,15,80,19);
        price.setForeground(Color.white);
        price.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(price);

        JLabel bed = new JLabel("BED TYPE");
        bed.setBounds(417,15,80,19);
        bed.setForeground(Color.white);
        bed.setFont(new Font("Tahoma",Font.BOLD,15));
        panel.add(bed);


        setUndecorated(true);
        setSize(900,600);
        setLayout(null);
        setLocation(500,100);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new room();
    }
}
