import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RegistrationForm extends JDialog {
    private JTextField tfName;
    private JTextField tfEmail;
    private JPasswordField pfPassword;
    private JTextField tfAge;
    private JTextField tfFname;
    private JTextField tfMname;
    private JTextField tfLname;
    private JButton btnRegister;
    private JButton btnCancel;
    private JPanel registerPanel;

    public RegistrationForm(JFrame parent){
        super(parent);
        setTitle("Create a new account");
        setContentPane(registerPanel);
        setMinimumSize(new Dimension(458,458));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerUser();
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    private void registerUser() {
        String username = tfName.getText();
        String email = tfEmail.getText();
        String password = String.valueOf(pfPassword.getPassword());
        String age = tfAge.getText();
        String fname = tfFname.getText();
        String mname = tfMname.getText();
        String lname = tfLname.getText();

        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || age.isEmpty() || fname.isEmpty() || mname.isEmpty() || lname.isEmpty()){
            JOptionPane.showMessageDialog(this,
                    "Please enter all fields",
                    "Try Again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        user = addUserToDatabase(username, email, password, age, fname, mname, lname);
        if(user != null){
            dispose();
        }
        else{
            //JOptionPane.showMessageDialog(this,
              //      "Failed to register new user",
                //    "Try again",
                  //or  JOptionPane.ERROR_MESSAGE);
        }
    }

    public User user;
    private User addUserToDatabase(String username, String email, String password, String age, String fname, String mname, String lname){
        User user = null;
        final String DB_URL = "jdbc:mysql://localhost:3306/app";
        final String USERNAME = "root";
        final String PASSWORD = "Ayam*010";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            //connected successfully

            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO users (username, email, password, age, fName, mName, lName)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, age);
            preparedStatement.setString(5, fname);
            preparedStatement.setString(6, mname);
            preparedStatement.setString(7, lname);

            //insert into table
            int addedRows = preparedStatement.executeUpdate();
            if (addedRows > 0) {
                user = new User();
                user.username = username;
                user.email = email;
                user.password = password;
                user.age = String.valueOf(Integer.parseInt(age));
                user.fname = fname;
                user.mname = mname;
                user.lname = lname;
            }
            stmt.close();
            conn.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

        public static void main(String[] args) {
        RegistrationForm myForm = new RegistrationForm(null);
        User user = myForm.user;
        if(user != null){
            System.out.println("Succesful registration of: " +user.username);
        }
        else{
            System.out.println("Registration canceled");

        }
    }
}
