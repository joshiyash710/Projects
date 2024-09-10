package Hotel.Management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class add_empl extends JFrame implements ActionListener {
    JTextField t1,t2,t5,t6,t7,t8;
    JRadioButton t3,t4;
    JComboBox j1;
    JButton add,back;
    public add_empl() {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,490);
        panel.setLayout(null);
        panel.setBackground(new Color(3,45,48));
        add(panel);



        JLabel name = new JLabel("NAME :");
        name.setBounds(60,30,150,27);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Serif",Font.BOLD,17));
        panel.add(name);

        t1=new JTextField();
        t1.setBounds(200,30,150,27);
        t1.setBackground(new Color(16,108,115));
        t1.setFont(new Font("Tahoma",Font.BOLD,14));
        t1.setForeground(Color.WHITE);
        panel.add(t1);

        JLabel age = new JLabel("AGE :");
        age.setBounds(60,80,150,27);
        age.setForeground(Color.WHITE);
        age.setFont(new Font("Serif",Font.BOLD,17));
        panel.add(age);

        t2=new JTextField();
        t2.setBounds(200,80,150,27);
        t2.setBackground(new Color(16,108,115));
        t2.setFont(new Font("Tahoma",Font.BOLD,14));
        t2.setForeground(Color.WHITE);
        panel.add(t2);

        JLabel gender=new JLabel("GENDER :");
        gender.setBounds(60,120,150,27);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("Serif",Font.BOLD,17));
        panel.add(gender);

        t3=new JRadioButton("MALE");
        t3.setBounds(200,120,70,27);
        t3.setBackground(new Color(3,45,48));
        t3.setFont(new Font("Tahoma",Font.BOLD,14));
        t3.setForeground(Color.WHITE);
        panel.add(t3);

        t4=new JRadioButton("FEMALE");
        t4.setBounds(280,120,100,27);
        t4.setBackground(new Color(3,45,48));
        t4.setFont(new Font("Tahoma",Font.BOLD,14));
        t4.setForeground(Color.WHITE);
        panel.add(t4);

        JLabel job = new JLabel("JOB :");
        job.setBounds(60,170,150,27);
        job.setFont(new Font("Serif",Font.BOLD,17));
        job.setForeground(Color.WHITE);
        panel.add(job);

        j1=new JComboBox(new String[] {"Front Desk","House Keeping","Kitchen Staff","Room Service","Manager","Accountant","Chef"});
        j1.setBackground(new Color(16,108,115));
        j1.setBounds(200,170,150,30);
        j1.setFont(new Font("Tahoma",Font.BOLD,14));
        j1.setForeground(Color.WHITE);
        panel.add(j1);

        JLabel salary = new JLabel("SALARY :");
        salary.setBounds(60,220,150,27);
        salary.setForeground(Color.WHITE);
        salary.setFont(new Font("Serif",Font.BOLD,17));
        panel.add(salary);

        t5=new JTextField();
        t5.setBounds(200,220,150,27);
        t5.setBackground(new Color(16,108,115));
        t5.setFont(new Font("Tahoma",Font.BOLD,14));
        t5.setForeground(Color.WHITE);
        panel.add(t5);

        JLabel mob = new JLabel("CONTACT NO. :");
        mob.setBounds(60,270,150,27);
        mob.setForeground(Color.WHITE);
        mob.setFont(new Font("Serif",Font.BOLD,17));
        panel.add(mob);

        t6=new JTextField();
        t6.setBounds(200,270,150,27);
        t6.setBackground(new Color(16,108,115));
        t6.setFont(new Font("Tahoma",Font.BOLD,14));
        t6.setForeground(Color.WHITE);
        panel.add(t6);

        JLabel adhaar = new JLabel("ADHAAR NO. :");
        adhaar.setBounds(60,320,150,27);
        adhaar.setForeground(Color.WHITE);
        adhaar.setFont(new Font("Serif",Font.BOLD,17));
        panel.add(adhaar);

        t7=new JTextField();
        t7.setBounds(200,320,150,27);
        t7.setBackground(new Color(16,108,115));
        t7.setFont(new Font("Tahoma",Font.BOLD,14));
        t7.setForeground(Color.WHITE);
        panel.add(t7);

        JLabel email = new JLabel("EMAIL :");
        email.setBounds(60,370,150,27);
        email.setForeground(Color.WHITE);
        email.setFont(new Font("Serif",Font.BOLD,17));
        panel.add(email);

        t8=new JTextField();
        t8.setBounds(200,370,150,27);
        t8.setBackground(new Color(16,108,115));
        t8.setFont(new Font("Tahoma",Font.BOLD,14));
        t8.setForeground(Color.WHITE);
        panel.add(t8);

        JLabel heading = new JLabel("ADD EMPLOYEE DETAILS");
        heading.setBounds(450,24,445,35);
        heading.setFont(new Font("Tahoma", Font.BOLD, 31));
        heading.setForeground(Color.WHITE);
        panel.add(heading);

        add=new JButton("ADD");
        add.setBounds(80,420,100,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(add);
        add.addActionListener(this);

        back=new JButton("BACK");
        back.setBounds(200,420,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(back);
        back.addActionListener(this);

        ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("icon/addemp.png"));
        Image i = image.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon image1=new ImageIcon(i);
        JLabel label=new JLabel(image1);
        label.setBounds(500,100,300,300);
        panel.add(label);

        setUndecorated(true);
        setLayout(null);
        setLocation(60,160);
        setSize(900,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){

            String name=t1.getText();
            String age=t2.getText();
            String gender=null;
            if(t3.isSelected()){
                gender="Male";
            }
            else if(t4.isSelected()){
                gender="Female";
            }
            String job=(String)j1.getSelectedItem();
            String salary=t5.getText();
            String Contact = t6.getText();
            String adhaar=t7.getText();
            String email=t8.getText();
            try{
                connection c = new connection();
                String q="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+Contact+"','"+email+"','"+adhaar+"')";
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"EMPLOYEE ADDED");
                setVisible(false);
            }catch(Exception exp)
            {
                exp.printStackTrace();
            }

        }
        else{
            setVisible(false);
            new admin();
        }
    }

    public static void main(String[] args) {
        new add_empl();
    }
}