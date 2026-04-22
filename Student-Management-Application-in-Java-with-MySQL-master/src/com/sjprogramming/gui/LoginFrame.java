package com.sjprogramming.gui;

import com.sjprogramming.dao.*;

import javax.swing.*;
import java.awt.event.*;

public class LoginFrame extends JFrame {

    JTextField userField;
    JPasswordField passField;
    JButton loginBtn;

    StudentDaoInterface dao = new StudentDao();

    public LoginFrame() {
        setTitle("Login");
        setSize(300,200);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(20,20,80,25);
        add(userLabel);

        userField = new JTextField();
        userField.setBounds(100,20,150,25);
        add(userField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(20,60,80,25);
        add(passLabel);

        passField = new JPasswordField();
        passField.setBounds(100,60,150,25);
        add(passField);

        loginBtn = new JButton("Login");
        loginBtn.setBounds(100,100,100,30);
        add(loginBtn);

        loginBtn.addActionListener(e -> {
            String user = userField.getText();
            String pass = new String(passField.getPassword());

            if(dao.login(user, pass)){
                JOptionPane.showMessageDialog(this, "Login Success");
                new DashboardFrame();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginFrame();
    }
}