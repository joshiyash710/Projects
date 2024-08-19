package Hotel.Management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class reception extends JFrame {
    public reception(){
        super("Hotel Management System");
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(280,5,1238,820);
        panel.setBackground(new Color(3,45,48));
        add(panel);

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_1.setBackground(new Color(3,45,48));
        panel_1.setBounds(5,5,270,820);
        add(panel_1);
        JPanel panel_2 = new JPanel();

        ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("icon/gulmohar1.gif"));
        Image i1=image.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon image1=new ImageIcon(i1);
        JLabel lable=new JLabel(image1);
        lable.setBounds(300,20,800,800);
        panel.add(lable);

        ImageIcon image2=new ImageIcon(ClassLoader.getSystemResource("icon/gulmohar1.gif"));
        Image i2=image2.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon image3=new ImageIcon(i2);
        JLabel lable1=new JLabel(image3);
        lable1.setBounds(5,530,250,250);
        panel_1.add(lable1);

        JButton btnNCF = new JButton("New Customer Form");
        btnNCF.setBounds(30,30,200,30);
        btnNCF.setBackground(Color.BLACK);
        btnNCF.setForeground(Color.WHITE);
        panel_1.add(btnNCF);
        btnNCF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    new check_in();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        JButton btnroom = new JButton("Room");
        btnroom.setBounds(30,70,200,30);
        btnroom.setBackground(Color.BLACK);
        btnroom.setForeground(Color.WHITE);
        panel_1.add(btnroom);
        btnroom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    new room();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        JButton btndpt = new JButton("Department");
        btndpt.setBounds(30,110,200,30);
        btndpt.setBackground(Color.BLACK);
        btndpt.setForeground(Color.WHITE);
        panel_1.add(btndpt);
        btndpt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    new department();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        JButton btnall = new JButton("All Employees Info");
        btnall.setBounds(30,150,200,30);
        btnall.setBackground(Color.BLACK);
        btnall.setForeground(Color.WHITE);
        panel_1.add(btnall);
        btnall.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    new all_emp();

                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        JButton btnCI = new JButton("Customer Information");
        btnCI.setBounds(30,190,200,30);
        btnCI.setBackground(Color.BLACK);
        btnCI.setForeground(Color.WHITE);
        panel_1.add(btnCI);
        btnCI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    new customer_info();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        JButton btnMI = new JButton("Manager Information");
        btnMI.setBounds(30,230,200,30);
        btnMI.setBackground(Color.BLACK);
        btnMI.setForeground(Color.WHITE);
        panel_1.add(btnMI);
        btnMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    new manager_info();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        JButton btnCO = new JButton("Check Out");
        btnCO.setBounds(30,270,200,30);
        btnCO.setBackground(Color.BLACK);
        btnCO.setForeground(Color.WHITE);
        panel_1.add(btnCO);
        btnCO.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    new Check_out();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        JButton btnUC = new JButton("Update check-in Details");
        btnUC.setBounds(30,310,200,30);
        btnUC.setBackground(Color.BLACK);
        btnUC.setForeground(Color.WHITE);
        panel_1.add(btnUC);
        btnUC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    new update_check();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        JButton btnRS = new JButton("Update Room Status");
        btnRS.setBounds(30,350,200,30);
        btnRS.setBackground(Color.BLACK);
        btnRS.setForeground(Color.WHITE);
        panel_1.add(btnRS);
        btnRS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    new Update_room();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        JButton btnPS = new JButton("Pick-up Service");
        btnPS.setBounds(30,390,200,30);
        btnPS.setBackground(Color.BLACK);
        btnPS.setForeground(Color.WHITE);
        panel_1.add(btnPS);
        btnPS.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    new pickup_service();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });

        JButton btnSR = new JButton("Search Room");
        btnSR.setBounds(30,430,200,30);
        btnSR.setBackground(Color.BLACK);
        btnSR.setForeground(Color.WHITE);
        panel_1.add(btnSR);
        btnSR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    new search_room();
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        });
        setUndecorated(false);
        setLayout(null);
        setSize(1950,1090);
        setVisible(true);
        getContentPane().setBackground(Color.white);
    }
    public static void main(String[] args) {
        new reception();
    }
}
