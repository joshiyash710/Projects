package Hotel.Management.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dashboard extends JFrame implements ActionListener {
    JButton admin,recp;
    public dashboard(){
        super("Hotel Management System");
        recp=new JButton("RECEPTION");
        recp.setBounds(425,510,140,30);
        recp.setFont(new Font("Tahoma",Font.BOLD,15));
        recp.setForeground(Color.WHITE);
        recp.setBackground(new Color(255,98,0));
        add(recp);
        recp.addActionListener(this);
        admin=new JButton("ADMIN");
        admin.setBounds(880,510,140,30);
        admin.setFont(new Font("Tahoma",Font.BOLD,15));
        admin.setForeground(Color.WHITE);
        admin.setBackground(new Color(255,98,0));
        add(admin);
        admin.addActionListener(this);
        ImageIcon imageiconb=new ImageIcon(ClassLoader.getSystemResource("icon/boss.png"));
        Image i2=imageiconb.getImage().getScaledInstance(200,195, Image.SCALE_DEFAULT);
        ImageIcon imageicon12=new ImageIcon(i2);
        JLabel label1=new JLabel(imageicon12);
        label1.setBounds(850,300,200,195);
        add(label1);
        ImageIcon imageiconr=new ImageIcon(ClassLoader.getSystemResource("icon/Reception.png"));
        Image i3=imageiconr.getImage().getScaledInstance(200,195, Image.SCALE_DEFAULT);
        ImageIcon imageicon13=new ImageIcon(i3);
        JLabel label2=new JLabel(imageicon13);
        label2.setBounds(400,300,200,195);
        add(label2);
        ImageIcon imageicon=new ImageIcon(ClassLoader.getSystemResource("icon/dashboard.gif"));
        Image i1=imageicon.getImage().getScaledInstance(1950,1090, Image.SCALE_DEFAULT);
        ImageIcon imageicon1=new ImageIcon(i1);
        JLabel label=new JLabel(imageicon1);
        label.setBounds(0,0,1950,1090);
        add(label);
        setLayout(null);
        setSize(1950,1090);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==recp){
            new reception();
        }else{
            new login2();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new dashboard();
    }
}
