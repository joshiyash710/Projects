package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;

public class splash extends JFrame {
    splash(){
        ImageIcon imageIcon= new ImageIcon(ClassLoader.getSystemResource("icon/Hotel Poster.gif"));
        Image i1=imageIcon.getImage().getScaledInstance(845,750, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(i1);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(0,0,850,750);
        add(label);
        setLayout(null);
        setLocation(300,80);
        setSize(858,680);
        setVisible(true);
        try{
            Thread.sleep(3000);
            new login();
            setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new splash();
    }
}
