package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class update_check extends javax.swing.JFrame {
    public update_check() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        panel.setBounds(5,5,940,590);
        add(panel);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image i = image.getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT);
        ImageIcon image1=new ImageIcon(i);
        JLabel label = new JLabel(image1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel head = new JLabel("Check-in Details");
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

        JLabel label3 = new JLabel("Name :");
        label3.setBounds(25,174,97,14);
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

        JLabel label4 = new JLabel("Checked In :");
        label4.setBounds(25,216,97,14);
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


        JLabel label5 = new JLabel("Amount Paid :");
        label5.setBounds(25,261,127,14);
        label5.setFont(new Font("Tahoma",Font.BOLD,15));
        label5.setForeground(Color.WHITE);
        label5.setBackground(new Color(3,45,48));
        panel.add(label5);

        JTextField textfield4 = new JTextField();
        textfield4.setBounds(248,261,140,20);
        textfield4.setFont(new Font("Tahoma",Font.BOLD,15));
        textfield4.setForeground(Color.WHITE);
        textfield4.setBackground(new Color(16,108,115));
        panel.add(textfield4);

        JLabel label6 = new JLabel("Pending Amount :");
        label6.setBounds(25,302,150,25);
        label6.setFont(new Font("Tahoma",Font.BOLD,15));
        label6.setForeground(Color.WHITE);
        label6.setBackground(new Color(3,45,48));
        panel.add(label6);

        JTextField textfield5 = new JTextField();
        textfield5.setBounds(248,302,140,20);
        textfield5.setFont(new Font("Tahoma",Font.BOLD,15));
        textfield5.setForeground(Color.WHITE);
        textfield5.setBackground(new Color(16,108,115));
        panel.add(textfield5);

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
                    String q = c1.getSelectedItem();
                    String room_number = textField1.getText();
                    String name = textfield2.getText();
                    String checkin = textfield3.getText();
                    String amount = textfield4.getText();

                    con1.statement.executeUpdate("update customer set Room_Number ='"+room_number+"' , Name ='"+name+"' , Check_in ='"+checkin+"', Deposit ='"+amount+"'  where Number = '"+q+"'");
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
                        textfield2.setText(resultSet.getString("Name"));
                        textfield3.setText(resultSet.getString("Check_in"));
                        textfield4.setText(resultSet.getString("Deposit"));
                    }
                    ResultSet resultSet1 = con.statement.executeQuery("select * from room where Room_Number='"+textField1.getText()+"'");
                    while(resultSet1.next()){
                        String price = resultSet1.getString("Price");
                        int Amount_paid = Integer.parseInt(price) - Integer.parseInt(textfield4.getText());
                        textfield5.setText(""+Amount_paid);
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
        setSize(950,500);
        setLocation(400,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new update_check();
    }
}
