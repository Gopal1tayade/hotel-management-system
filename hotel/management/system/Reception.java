package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener {

    JButton newCustomer,logout,rooms,department,allemployee,manager,customer ,searchroom,update,roomstatus,pickup,checkout;
    Reception(){
        getContentPane().setBackground(Color.white);
        setLayout(null);

         newCustomer = new JButton("New Customer Form");
        newCustomer.setBounds(10,30,200,30);
        newCustomer.setBackground(Color.black);
        newCustomer.setForeground(Color.white);
        newCustomer.addActionListener(this);
        add(newCustomer);

         rooms = new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(Color.black);
        rooms.setForeground(Color.white);
        rooms.addActionListener(this);
        add(rooms);

         department = new JButton("Departments");
        department.setBounds(10,110,200,30);
        department.setBackground(Color.black);
        department.setForeground(Color.white);
        department.addActionListener(this);
        add(department);

         allemployee = new JButton("All employee");
        allemployee.setBounds(10,150,200,30);
        allemployee.setBackground(Color.black);
        allemployee.setForeground(Color.white);
        allemployee.addActionListener(this);
        add(allemployee);

         customer = new JButton("Customer Info");
        customer.setBounds(10,190,200,30);
        customer.setBackground(Color.black);
        customer.setForeground(Color.white);
        customer.addActionListener(this);
        add(customer);

        manager = new JButton("Manager Info");
        manager.setBounds(10,230,200,30);
        manager.setBackground(Color.black);
        manager.setForeground(Color.white);
        manager.addActionListener(this);
        add(manager);

         checkout = new JButton("Checkout");
        checkout.setBounds(10,270,200,30);
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        checkout.addActionListener(this);
        add(checkout);

         update = new JButton("Update Status");
        update.setBounds(10,310,200,30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);

        roomstatus= new JButton("Update Room Status");
        roomstatus.setBounds(10,350,200,30);
        roomstatus.setBackground(Color.black);
        roomstatus.setForeground(Color.white);
        roomstatus.addActionListener(this);
        add(roomstatus);

         pickup= new JButton("Pickup Services");
        pickup.setBounds(10,390,200,30);
        pickup.setBackground(Color.black);
        pickup.setForeground(Color.white);
        pickup.addActionListener(this);
        add(pickup);

         searchroom = new JButton("Search Rooms");
        searchroom.setBounds(10,430,200,30);
        searchroom.setBackground(Color.black);
        searchroom.setForeground(Color.white);
        searchroom.addActionListener(this);
        add(searchroom);

         logout= new JButton("Logout");
        logout.setBounds(10,470,200,30);
        logout.setBackground(Color.black);
        logout.setForeground(Color.white);
        logout.addActionListener(this);
        add(logout);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);

        setBounds(350,200, 800,570);
      setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == newCustomer ){
            setVisible(false);
            new AddCustomer();
        }
        else if(ae.getSource()==rooms){
            setVisible(false);
            new Rooms();
        }else if(ae.getSource()==department){
            setVisible(false);
            new Depaertment();
        }else if(ae.getSource()==allemployee){
            setVisible(false);
            new EmployeeInfo();
        }else if(ae.getSource()==manager){
            setVisible(false);
            new Managerinfo();
        }else if(ae.getSource()==customer){
            setVisible(false);
            new customerinfo();
        }else if(ae.getSource()==searchroom){
            setVisible(false);
            new SearchRoom();
        }else if(ae.getSource()==update){
            setVisible(false);
            new Updatecustomer();
        }else if(ae.getSource()==roomstatus){
            setVisible(false);
            new UpdateRoom();
        }else if(ae.getSource()==pickup){
            setVisible(false);
            new Pickup();
        } else if(ae.getSource()==checkout){
            setVisible(false);
            new Checkout();
        }else if(ae.getSource()==logout){
            setVisible(false);
            System.exit(0);
        }
    }
    public static void main(String args[]){
        new Reception();
    }
}
