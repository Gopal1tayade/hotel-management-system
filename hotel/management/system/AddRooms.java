package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends JFrame implements ActionListener {
    JButton add,cancle;
    JTextField tfroom,tfprice;
    JComboBox bedcombo,availabelecombo,cleancombo;
    AddRooms(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);

        JLabel lblroomno = new JLabel(" Room Number");
        lblroomno.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblroomno.setBounds(60,80,120,30);
        add(lblroomno);

        tfroom = new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);

        JLabel lblavailable = new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblavailable.setBounds(60,130,120,30);
        add(lblavailable);

        String availabeloption [] ={"Available","Occupied"};
         availabelecombo = new JComboBox(availabeloption);
        availabelecombo.setBounds(200,130,150,30);
        availabelecombo.setBackground(Color.white);
        add(availabelecombo);

        JLabel lblclean = new JLabel("Cleaning Status");
        lblclean.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblclean.setBounds(60,180,120,30);
        add(lblclean);

        String cleanoption [] ={"Cleaned","Dirty"};
         cleancombo = new JComboBox(cleanoption);
        cleancombo.setBounds(200,180,150,30);
        cleancombo.setBackground(Color.white);
        add(cleancombo);

        JLabel lblprice = new JLabel("Price");
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
        lblprice.setBounds(60,230,120,30);
        add(lblprice);

         tfprice = new JTextField();
        tfprice.setBounds(200,230,150,30);
        add(tfprice);

        JLabel lbltype = new JLabel("Bed Type");
        lbltype.setFont(new Font("Tahoma",Font.PLAIN,16));
        lbltype.setBounds(60,280,120,30);
        add(lbltype);

        String bedoption [] ={"Single Bed","Double Bed"};
         bedcombo = new JComboBox(bedoption);
        bedcombo.setBounds(200,280,150,30);
        bedcombo.setBackground(Color.white);
        add(bedcombo);

         add = new JButton("Add Room");
        add.setForeground(Color.white);
        add.setBackground(Color.black);
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add(add);

         cancle = new JButton("Cancle");
        cancle.setForeground(Color.white);
        cancle.setBackground(Color.black);
        cancle.setBounds(220,350,130,30);
        cancle.addActionListener(this);
        add(cancle);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);



        setBounds(330,200,940,470);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String roomnumber = tfroom.getText();
            String availablility = (String) availabelecombo.getSelectedItem();
            String status = (String) cleancombo.getSelectedItem();
            String price = tfprice.getText();
            String type = (String) bedcombo.getSelectedItem();

            try{
                Connection_ con = new Connection_();
                String query = "insert into addroom values('"+roomnumber+"','"+availablility+"','"+status+"','"+price+"','"+type+"')";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Room Added Successfully");
                setVisible(false);
                new Dashboard();
            }catch(Exception e){
                e.printStackTrace();
            }

        }else if(ae.getSource()==cancle){
            setVisible(false);
        }
    }







    public static void main(String args[]){
        new AddRooms();
    }
}
