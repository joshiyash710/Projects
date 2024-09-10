package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Update_room extends javax.swing.JFrame {
    public Update_room() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        panel.setBounds(5,5,940,590);
        add(panel);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
        Image i = image.getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT);
        ImageIcon image1=new ImageIcon(i);
        JLabel label = new JLabel(image1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel head = new JLabel("Update Room Status");
        head.setBounds(124,11,222,25);
        head.setFont(new Font("Tahoma",Font.BOLD,20));
        head.setForeground(Color.WHITE);
        head.setBackground(new Color(3,45,48));
        panel.add(head);

        JLabel label1 = new JLabel("ID :");
        label1.setBounds(25,88,46,14);
        label1.setFont(new Font("Tahoma",Font.BOLD,15));
        label1.setForeground(Color.WHITE);
        label1.setBackground(new Color(3,45,48));
        panel.add(label1);

        Choice c1 = new Choice();
        c1.setBounds(248,85,140,20);
        c1.setForeground(Color.WHITE);
        c1.setBackground(new Color(16,108,115));
        panel.add(c1);

        try{
            connection con=new connection();
            ResultSet resultSet = con.statement.executeQuery("select * from customer");
            while(resultSet.next()){
                c1.add(resultSet.getString("Number"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        JLabel label2 = new JLabel("Room Number :");
        label2.setBounds(25,129,125,14);
        label2.setFont(new Font("Tahoma",Font.BOLD,15));
        label2.setForeground(Color.WHITE);
        label2.setBackground(new Color(3,45,48));
        panel.add(label2);

        JTextField textField1 = new JTextField();
        textField1.setBounds(248,129,140,20);
        textField1.setFont(new Font("Tahoma",Font.BOLD,15));
        textField1.setForeground(Color.WHITE);
        textField1.setBackground(new Color(16,108,115));
        panel.add(textField1);

        JLabel label3 = new JLabel("Availability :");
        label3.setBounds(25,174,125,25);
        label3.setFont(new Font("Tahoma",Font.BOLD,15));
        label3.setForeground(Color.WHITE);
        label3.setBackground(new Color(3,45,48));
        panel.add(label3);

        JTextField textfield2 = new JTextField();
        textfield2.setBounds(248,174,140,20);
        textfield2.setFont(new Font("Tahoma",Font.BOLD,15));
        textfield2.setForeground(Color.WHITE);
        textfield2.setBackground(new Color(16,108,115));
        panel.add(textfield2);

        JLabel label4 = new JLabel("Clean Status :");
        label4.setBounds(25,216,125,14);
        label4.setFont(new Font("Tahoma",Font.BOLD,15));
        label4.setForeground(Color.WHITE);
        label4.setBackground(new Color(3,45,48));
        panel.add(label4);

        JTextField textfield3 = new JTextField();
        textfield3.setBounds(248,216,140,20);
        textfield3.setFont(new Font("Tahoma",Font.BOLD,15));
        textfield3.setForeground(Color.WHITE);
        textfield3.setBackground(new Color(16,108,115));
        panel.add(textfield3);

        JButton update = new JButton("Update");
        update.setBounds(56,378,89,23);
        update.setFont(new Font("Tahoma",Font.BOLD,15));
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    connection con1 = new connection();
                    String status = textfield3.getText();
                    con1.statement.executeUpdate("update room set Cleaning_Status = '"+status+"' where Room_Number = "+textField1.getText());
                    JOptionPane.showMessageDialog(null,"Updated Successfully");
                    setVisible(false);
                }catch(Exception exp1){
                    exp1.printStackTrace();
                }
            }
        });

        JButton check = new JButton("Check");
        check.setBounds(168,378,89,23);
        check.setFont(new Font("Tahoma",Font.BOLD,15));
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = c1.getSelectedItem();
                String q = "select * from customer where Number = '"+id+"'";
                try{
                    connection con = new connection();
                    ResultSet resultSet = con.statement.executeQuery(q);
                    while(resultSet.next()){
                        textField1.setText(resultSet.getString("Room_Number"));


                    }
                    ResultSet resultSet1 = con.statement.executeQuery("select * from room where Room_Number='"+textField1.getText()+"'");
                    while(resultSet1.next()){
                        textfield2.setText(resultSet1.getString("Availability"));
                        textfield3.setText(resultSet1.getString("Cleaning_Status"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(285,378,89,23);
        back.setFont(new Font("Tahoma",Font.BOLD,15));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        setUndecorated(true);
        setLayout(null);
        setSize(950,450);
        setLocation(400,200);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Update_room();
    }
}