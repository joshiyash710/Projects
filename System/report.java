package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class report extends JFrame {
    JTextField t1, t2;
    JTable table;

    public report() {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 5, 690, 490);
        panel.setBackground(new Color(3, 45, 48));
        add(panel);

        JLabel From = new JLabel("From (yyyy-MM-dd):");
        From.setBounds(50, 11, 200, 25);
        From.setBackground(new Color(3, 45, 48));
        From.setFont(new Font("Times New Roman", Font.BOLD, 20));
        From.setForeground(Color.WHITE);
        panel.add(From);

        t1 = new JTextField();
        t1.setBounds(250, 11, 125, 25);
        t1.setBackground(new Color(16, 108, 115));
        t1.setForeground(Color.WHITE);
        t1.setFont(new Font("Times New Roman", Font.BOLD, 20));
        panel.add(t1);

        JLabel To = new JLabel("To (yyyy-MM-dd) :");
        To.setBounds(50, 50, 200, 25);
        To.setBackground(new Color(3, 45, 48));
        To.setFont(new Font("Times New Roman", Font.BOLD, 20));
        To.setForeground(Color.WHITE);
        panel.add(To);

        t2 = new JTextField();
        t2.setBounds(250, 50, 125, 25);
        t2.setBackground(new Color(16, 108, 115));
        t2.setForeground(Color.WHITE);
        t2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        panel.add(t2);

        table = new JTable();
        table.setBounds(10, 190, 900, 200);
        table.setBackground(new Color(3, 45, 48));
        table.setForeground(Color.white);
        panel.add(table);

        JLabel[] labels = {
                new JLabel("ID"), new JLabel("NAME"), new JLabel("NUMBER"),
                new JLabel("GENDER"), new JLabel("COUNTRY"), new JLabel("ROOM NO."),
                new JLabel("TIME"), new JLabel("DEPOSIT")
        };

        int[] labelBounds = {31, 150, 270, 360, 480, 600, 700, 800};

        for (int i = 0; i < labels.length; i++) {
            JLabel label = labels[i];
            label.setBounds(labelBounds[i], 90, 100, 14);
            label.setForeground(Color.white);
            label.setBackground(new Color(3, 45, 48));
            label.setFont(new Font("Tahoma", Font.BOLD, 14));
            panel.add(label);
        }

        JButton get = new JButton("GENERATE");
        get.setBounds(30, 390, 120, 30);
        get.setBackground(Color.BLACK);
        get.setForeground(Color.white);
        get.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(get);

        JButton back = new JButton("BACK");
        back.setBounds(180, 390, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.white);
        back.setFont(new Font("Tahoma", Font.BOLD, 14));
        panel.add(back);

        // Action Listener for the GENERATE button
        get.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fromDate = t1.getText();
                String toDate = t2.getText();

                if (fromDate.isEmpty() || toDate.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter both start and end dates!");
                    return;
                }

                try {
                    connection c = new connection();
                    // Use connection to prepare a statement, not the statement object
                    String query = "SELECT * FROM customer WHERE check_in BETWEEN ? AND ?";
                    PreparedStatement pst = c.con.prepareStatement(query);  // use c.con instead of c.statement
                    pst.setString(1, fromDate);
                    pst.setString(2, toDate);

                    ResultSet rs = pst.executeQuery();

                    // Using DbUtils to populate the JTable
                    table.setModel(DbUtils.resultSetToTableModel(rs));

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error generating report");
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setLayout(null);
        setSize(700, 500);
        setLocation(500, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new report();
    }
}
