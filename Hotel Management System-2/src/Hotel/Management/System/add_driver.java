package Hotel.Management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class add_driver extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4,t5;
    JComboBox j1,j2;
    JButton add,back;
    public add_driver(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,490);
        panel.setBackground(new Color(3,45,48));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("ADD DRIVERS");
        label.setBounds(194,10,200,22);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Tahoma",Font.BOLD,22));
        panel.add(label);

        JLabel name=new JLabel("NAME :");
        name.setBounds(64,70,110,22);
        name.setFont(new Font("Tahoma",Font.BOLD,17));
        name.setForeground(Color.WHITE);
        panel.add(name);

        t1=new JTextField();
        t1.setBounds(174,70,156,20);
        t1.setBackground(new Color(16,108,115));
        t1.setFont(new Font("Tahoma",Font.BOLD,14));
        t1.setForeground(Color.WHITE);
        panel.add(t1);

        JLabel age=new JLabel("AGE :");
        age.setBounds(64,110,110,22);
        age.setFont(new Font("Tahoma",Font.BOLD,17));
        age.setForeground(Color.WHITE);
        panel.add(age);

        t2=new JTextField();
        t2.setBounds(174,110,156,20);
        t2.setBackground(new Color(16,108,115));
        t2.setFont(new Font("Tahoma",Font.BOLD,14));
        t2.setForeground(Color.WHITE);
        panel.add(t2);

        JLabel gender=new JLabel("GENDER :");
        gender.setBounds(64,150,110,22);
        gender.setFont(new Font("Tahoma",Font.BOLD,17));
        gender.setForeground(Color.WHITE);
        panel.add(gender);

        j1=new JComboBox(new String[]{"Male","Female"});
        j1.setBounds(176,150,154,20);
        j1.setBackground(new Color(16,108,115));
        j1.setFont(new Font("Tahoma",Font.BOLD,14));
        j1.setForeground(Color.WHITE);
        panel.add(j1);

        JLabel company=new JLabel("COMPANY :");
        company.setBounds(64,190,110,22);
        company.setFont(new Font("Tahoma",Font.BOLD,17));
        company.setForeground(Color.WHITE);
        panel.add(company);

        t3=new JTextField();
        t3.setBounds(174,190,156,20);
        t3.setBackground(new Color(16,108,115));
        t3.setFont(new Font("Tahoma",Font.BOLD,14));
        t3.setForeground(Color.WHITE);
        panel.add(t3);

        JLabel cname=new JLabel("CAR NAME :");
        cname.setBounds(64,230,110,22);
        cname.setFont(new Font("Tahoma",Font.BOLD,17));
        cname.setForeground(Color.WHITE);
        panel.add(cname);

        t4=new JTextField();
        t4.setBounds(174,230,156,20);
        t4.setBackground(new Color(16,108,115));
        t4.setFont(new Font("Tahoma",Font.BOLD,14));
        t4.setForeground(Color.WHITE);
        panel.add(t4);

        JLabel avail=new JLabel("AVAILABLE :");
        avail.setBounds(64,280,110,22);
        avail.setFont(new Font("Tahoma",Font.BOLD,17));
        avail.setForeground(Color.WHITE);
        panel.add(avail);

        j2=new JComboBox(new String[]{"YES","NO"});
        j2.setBounds(176,280,156,20);
        j2.setBackground(new Color(16,108,115));
        j2.setFont(new Font("Tahoma",Font.BOLD,14));
        j2.setForeground(Color.WHITE);
        panel.add(j2);

        JLabel location=new JLabel("LOCATION :");
        location.setBounds(64,330,110,22);
        location.setFont(new Font("Tahoma",Font.BOLD,17));
        location.setForeground(Color.WHITE);
        panel.add(location);

        t5=new JTextField();
        t5.setBounds(174,330,156,20);
        t5.setBackground(new Color(16,108,115));
        t5.setFont(new Font("Tahoma",Font.BOLD,14));
        t5.setForeground(Color.WHITE);
        panel.add(t5);

        add=new JButton("ADD");
        add.setBounds(64,380,111,33);
        add.setBackground(Color.BLACK);
        add.setFont(new Font("Tahoma",Font.BOLD,17));
        add.setForeground(Color.WHITE);
        panel.add(add);
        add.addActionListener(this);

        back=new JButton("BACK");
        back.setBounds(198,380,111,33);
        back.setBackground(Color.BLACK);
        back.setFont(new Font("Tahoma",Font.BOLD,17));
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(this);

        ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("icon/license.png"));
        Image i=image.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon image1=new ImageIcon(i);
        JLabel label1 = new JLabel(image1);
        label1.setBounds(500,60,300,300);
        panel.add(label1);






        setUndecorated(true);
        setLocation(20,200);
        setLayout(null);
        setSize(900,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            String name=t1.getText();
            String age=t2.getText();
            String gender=j1.getSelectedItem().toString();
            String company=t3.getText();
            String car_name=t4.getText();
            String avail=j2.getSelectedItem().toString();
            String location=t5.getText();
            try{
                connection c=new connection();

                String q = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+car_name+"','"+avail+"','"+location+"')";
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"DRIVER ADDED");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else{
            new admin();
        }
    }

    public static void main(String[] args) {
        new add_driver();
    }
}
