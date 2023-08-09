package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField jname,jage,jsalary,jphone,jemail,jaadhar;
    JRadioButton rbmale,rbfemale;
    JButton submit;
    JComboBox cbjob;
    AddEmployee(){
        setLayout(null);
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60,30,120,30);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblname);

         jname = new JTextField();
        jname.setBounds(200,30,150,30);
        add(jname);

        JLabel lblage = new JLabel("Age");
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblage);

        jage = new JTextField();
        jage.setBounds(200,80,150,30);
        add(jage);

        JLabel lgender = new JLabel("Gender");
        lgender.setBounds(60,130,120,30);
        lgender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lgender);

         rbmale = new JRadioButton("Male");
        rbmale.setBounds(200,130,70,30);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbmale.setBackground(Color.white);
        add(rbmale);

        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280,130,70,30);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbfemale.setBackground(Color.white);
        add(rbfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rbfemale);
        bg.add(rbmale);

        JLabel ljob = new JLabel("JOB");
        ljob.setBounds(60,180,120,30);
        ljob.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(ljob);

        String str[] = {"Front Desk Clerk", "Porters","Houskeeping","Kitchen Staff","Room Services","Chefs","Manager","Accountant","Water/Wateres"};
         cbjob = new JComboBox(str);
        cbjob.setBounds(200,180,150,30);
        cbjob.setBackground(Color.white);
        add(cbjob);

        JLabel lsalary = new JLabel("Salary");
        lsalary.setBounds(60,230,120,30);
        lsalary.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lsalary);

         jsalary = new JTextField();
        jsalary.setBounds(200,230,150,30);
        add(jsalary);

        JLabel lphone = new JLabel("Phone");
        lphone.setBounds(60,280,120,30);
        lphone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lphone);

         jphone = new JTextField();
        jphone.setBounds(200,280,150,30);
        add(jphone);

        JLabel lemail = new JLabel("E-mail");
        lemail.setBounds(60,330,120,30);
        lemail.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lemail);

         jemail = new JTextField();
        jemail.setBounds(200,330,150,30);
        add(jemail);

        JLabel laadhar = new JLabel("Aadhar");
        laadhar.setBounds(60,380,120,30);
        laadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(laadhar);

        jaadhar = new JTextField();
        jaadhar.setBounds(200,380,150,30);
        add(jaadhar);

         submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setBounds(200,430,150,30);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380,60,450,370);
        add(image);

        setBounds(350,200,850,540);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        //jname,jage,jsalary,jlphone,jemail

        String name = jname.getText();
        String age = jage.getText();
        String salary = jsalary.getText();
        String phone = jphone.getText();
        String email = jemail.getText();
        String aadhar = jaadhar.getText();

        String gender = null;

        if(rbmale.isSelected()){
            gender = "Male";
         }else if(rbfemale.isSelected()){
            gender = "Female";
          }

        String job = (String) cbjob.getSelectedItem();

        try{
            Connection_ con = new Connection_();
            String query = "insert into addemployee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
            con.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Employee added Successfully");
            setVisible(false);
        }catch (Exception e){
            e.printStackTrace();
        }


    }



    public static void main(String[] args) {
        new AddEmployee();
    }
}
