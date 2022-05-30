package notepad;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class aboutUsFrame extends JFrame implements ActionListener
{
    myFrame f;
    
    aboutUsFrame(myFrame f){
        super("About Notepad");
        this.f = f;
        ImageIcon windows = new ImageIcon(ClassLoader.getSystemResource("notepad/windows.png"));
        Image i1 = windows.getImage().getScaledInstance(350, 80, Image.SCALE_DEFAULT);
        JLabel j1 = new JLabel(new ImageIcon(i1));
        j1.setBounds(120, 40, 350, 80);
        add(j1);
        
        ImageIcon notepad = new ImageIcon(ClassLoader.getSystemResource("notepad/meIcon.jpg"));
        Image i2 = notepad.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
        JLabel j2 = new JLabel(new ImageIcon(i2));
        j2.setBounds(50, 180, 80, 80);
        add(j2);
        
        JLabel j3 = new JLabel("<html>This <b>Notepad Software</b> is a text writing desktop application developed on <b><i>13/07/2021</b></i>.<br><p>Developed <b><u>Using JDK 14 in NetBeans IDE 12.0</u>.<b><br> It has All features of the Windows Notepad .<br> Hope you will enjoy.</p></html>");
        j3.setFont(new Font("SANS_SERIF",Font.PLAIN,16));
        j3.setBounds(160, 75, 400, 300);
        add(j3);
        
        JButton jb = new JButton("OK");
        jb.setBounds(250,370,68,30);
        add(jb);
        jb.addActionListener(this);
        jb.setBorder(BorderFactory.createLineBorder(Color.white));
        setBounds(600,200,580,500);
        setLayout(null);
        setLocation(515,180);
        setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e)
        {
            if("OK".equals(e.getActionCommand()))
            {
               this.setVisible(false);
            }
        }
}
