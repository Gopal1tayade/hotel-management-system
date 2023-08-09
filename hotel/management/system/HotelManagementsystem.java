package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelManagementsystem  extends JFrame implements ActionListener {
    HotelManagementsystem(){
        setSize(1366,565);
        setLocation(100,100);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        setLayout(null);
        add(image);
        image.setBounds(0,0,1366,565);

        JLabel text = new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20,420,1000,90);
        text.setForeground(Color.white);
        text.setFont(new Font("serif",Font.PLAIN, 50));
        image.add(text);



        JButton next = new JButton("Next");
        next.setBounds(1150,450,150,50);
        next.setFont(new Font("serif",Font.PLAIN, 24));
        next.addActionListener(this);
        setBackground(Color.white);
        image.add(next);



        setVisible(true);

        while (true){
           text.setVisible(false);
            try {
                Thread.sleep(600);
            }catch (Exception e){
                e.printStackTrace();
            }
       text.setVisible(true);
            try {
                Thread.sleep(600);
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public void actionPerformed(ActionEvent e){
        setVisible(false);
        new Login();
   }

    public  static void main(String [] args){
        new HotelManagementsystem();
    }
}
