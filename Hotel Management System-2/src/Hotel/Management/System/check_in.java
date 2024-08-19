package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class check_in extends javax.swing.JFrame {
    JComboBox j1;
    JTextField t1,t2,t3,t4;
    JRadioButton r1,r2;
    Choice c1;
    JLabel date;
    public check_in() {

        JPanel panel = new JPanel();
        panel.setBackground(new Color(3,45,48));
        panel.setBounds(5,5,840,540);
        panel.setLayout(null);
        add(panel);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("icon/customer.png"));
        Image i=image.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon image1=new ImageIcon(i);
        JLabel label = new JLabel(image1);
        label.setBounds(550,150,200,200);
        panel.add(label);

        JLabel label_name=new JLabel("NEW CUSTOMER FORM");
        label_name.setBounds(116,11,260,53);
        label_name.setFont(new Font("Tahoma",Font.BOLD,20));
        label_name.setForeground(Color.white);
        panel.add(label_name);

        JLabel govID = new JLabel("ID :");
        govID.setBounds(35,76,200,14);
        govID.setForeground(Color.WHITE);
        govID.setFont(new Font("Tahoma",Font.BOLD,17));
        panel.add(govID);

        j1 = new JComboBox(new String[] {"Adhaar Card","Passport","Voter ID","Driving License"});
        j1.setBounds(271,73,150,20);
        j1.setFont(new Font("Tahoma",Font.BOLD,14));
        j1.setForeground(Color.white);
        j1.setBackground(new Color(16,108,115));
        panel.add(j1);

        JLabel name = new JLabel("NAME :");
        name.setBounds(35,111,200,14);
        name.setForeground(Color.white);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        name.setBackground(new Color(16,108,115));
        panel.add(name);

        t1=new JTextField();
        t1.setBounds(271,111,200,20);
        t1.setForeground(Color.white);
        t1.setFont(new Font("Tahoma",Font.BOLD,14));
        t1.setBackground(new Color(16,108,115));
        panel.add(t1);

        JLabel number = new JLabel("NUMBER :");
        number.setBounds(35,151,200,14);
        number.setForeground(Color.white);
        number.setFont(new Font("Tahoma",Font.BOLD,14));
        number.setBackground(new Color(16,108,115));
        panel.add(number);

        t2=new JTextField();
        t2.setBounds(271,145,150,20);
        t2.setForeground(Color.white);
        t2.setFont(new Font("Tahoma",Font.BOLD,14));
        t2.setBackground(new Color(16,108,115));
        panel.add(t2);

        JLabel gender = new JLabel("GENDER :");
        gender.setBounds(35,191,200,14);
        gender.setForeground(Color.white);
        gender.setFont(new Font("Tahoma",Font.BOLD,14));
        gender.setBackground(new Color(16,108,115));
        panel.add(gender);

        r1=new JRadioButton("Male");
        r1.setBounds(271,191,80,14);
        r1.setFont(new Font("Tahoma",Font.BOLD,14));
        r1.setForeground(Color.white);
        r1.setBackground(new Color(3,45,48));
        panel.add(r1);

        r2=new JRadioButton("Female");
        r2.setBounds(350,191,80,14);
        r2.setFont(new Font("Tahoma",Font.BOLD,14));
        r2.setForeground(Color.white);
        r2.setBackground(new Color(3,45,48));
        panel.add(r2);

        JLabel country = new JLabel("COUNTRY :");
        country.setBounds(35,231,200,14);
        country.setForeground(Color.white);
        country.setFont(new Font("Tahoma",Font.BOLD,14));
        country.setBackground(new Color(16,108,115));
        panel.add(country);


        t3=new JTextField();
        t3.setBounds(271,231,200,20);
        t3.setForeground(Color.white);
        t3.setFont(new Font("Tahoma",Font.BOLD,14));
        t3.setBackground(new Color(16,108,115));
        panel.add(t3);

        JLabel room = new JLabel("ALLOCATE ROOM NUMBER :");
        room.setBounds(35,274,250,14);
        room.setForeground(Color.white);
        room.setFont(new Font("Tahoma",Font.BOLD,14));
        room.setBackground(new Color(16,108,115));
        panel.add(room);

        c1=new Choice();
        try{
            connection c =new connection();
            ResultSet resultSet =c.statement.executeQuery("select * from room");
            while(resultSet.next()){
                c1.add(resultSet.getString("Room_Number"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        c1.setBounds(285,274,150,20);
        c1.setFont(new Font("Tahoma",Font.BOLD,14));
        c1.setForeground(Color.white);
        c1.setBackground(new Color(16,108,115));
        panel.add(c1);

        JLabel checkin=new JLabel("CHECK IN");
        checkin.setBounds(35,316,200,14);
        checkin.setForeground(Color.white);
        checkin.setFont(new Font("Tahoma",Font.BOLD,14));
        checkin.setBackground(new Color(16,108,115));
        panel.add(checkin);

        Date date1 = new Date();

        date = new JLabel(""+date1);
        date.setBounds(271,316,200,18);
        date.setForeground(Color.white);
        date.setFont(new Font("Tahoma",Font.BOLD,14));
        date.setBackground(new Color(16,108,115));
        panel.add(date);

        JLabel deposit = new JLabel("DEPOSIT :");
        deposit.setBounds(35,359,200,14);
        deposit.setForeground(Color.white);
        deposit.setFont(new Font("Tahoma",Font.BOLD,14));
        deposit.setBackground(new Color(16,108,115));
        panel.add(deposit);

        t4 = new JTextField();
        t4.setBounds(271,359,150,20);
        t4.setForeground(Color.white);
        t4.setFont(new Font("Tahoma",Font.BOLD,14));
        t4.setBackground(new Color(16,108,115));
        panel.add(t4);

        JButton add = new JButton("ADD");
        add.setForeground(Color.white);
        add.setFont(new Font("Tahoma",Font.BOLD,17));
        add.setBackground(Color.BLACK);
        add.setBounds(100,430,120,30);
        panel.add(add);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    connection c =new connection();
                    String id=(String)j1.getSelectedItem();
                    String name = t1.getText();
                    String number = t2.getText();
                    String gender = null;
                    if(r1.isSelected()){
                        gender = "Male";
                    }else if(r2.isSelected()){
                        gender = "Female";
                    }
                    String country = t3.getText();
                    String room_no = c1.getSelectedItem();
                    String check_in = date.getText();
                    String deposit = t4.getText();

                    String q ="insert into customer values('"+id+"','"+name+"','"+number+"','"+gender+"','"+country+"','"+room_no+"','"+check_in+"','"+deposit+"')";
                    String q1 = "update room set Availability = 'Occupied' where Room_Number ="+room_no;
                    c.statement.executeUpdate(q);
                    c.statement.executeUpdate(q1);
                    JOptionPane.showMessageDialog(null,"Customer Added Successfully");
                    setVisible(false);

                }catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        JButton back = new JButton("BACK");
        back.setForeground(Color.white);
        back.setFont(new Font("Tahoma",Font.BOLD,17));
        back.setBackground(Color.BLACK);
        back.setBounds(260,430,120,30);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setLayout(null);
        setSize(850,550);
        setVisible(true);
        setLocation(500,150);
    }
    public static void main(String[] args) {
        new check_in();
    }
}
