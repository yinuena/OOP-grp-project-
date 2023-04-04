import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginForm extends JDialog {
    private JTextField tfEmail;
    private JPasswordField pfPassword;
    private JButton btnLogin;
    private JButton btnCancel;
    private JPanel loginPanel;
    private JButton registerButton;

    public LoginForm(JFrame parent){
        super(parent);
        setTitle("Login");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(458, 474));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = tfEmail.getText();
                String password = String.valueOf(pfPassword.getPassword());

                user = getAuthenticatedUser(email, password);

                if(user != null){
                    dispose();
                }
                //else{
                  //  JOptionPane.showMessageDialog(LoginForm.this,
                    //        "Email or Password Invalid",
                      //      "Try again",
                        //    JOptionPane.ERROR_MESSAGE);
               // }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setVisible(true);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public User user;
    private User getAuthenticatedUser(String email, String password){
        User user = null;

        final String DB_URL = "jdbc:mysql://localhost:3306/app";
        final String USERNAME = "root";
        final String PASSWORD = "Ayam*010";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                user = new User();
                user.username = resultSet.getString("username");
                user.email = resultSet.getString("email");
                user.password = resultSet.getString("password");
                user.age = resultSet.getString("age");
                user.fname = resultSet.getString("fname");
                user.mname = resultSet.getString("mname");
                user.lname = resultSet.getString("lname");
            }

            stmt.close();
            conn.close();

        } catch(Exception e){
            e.printStackTrace();
        }


        return user;
    }

    public static void main(String[] args){
        LoginForm loginForm = new LoginForm(null);
        User user = loginForm.user;
        if(user != null){
            System.out.println("Successful Authentication of: "+user.username);
            System.out.println("        Email: " +user.email);
            System.out.println("        Age:  "  +user.age);
            System.out.println("        First name: " +user.fname);
            System.out.println("        Middle name: " +user.mname);
            System.out.println("        Last name: " +user.lname);
        }
        else{
            System.out.println("Authentication cancelled");
        }
    }
}
