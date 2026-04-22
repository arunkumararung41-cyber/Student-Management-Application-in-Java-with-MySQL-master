package com.sjprogramming.gui;

import javax.swing.*;

public class DashboardFrame extends JFrame {

    public DashboardFrame() {
        setTitle("Dashboard");
        setSize(400,300);
        setLayout(null);

        JButton addBtn = new JButton("Add Student");
        addBtn.setBounds(100,50,200,30);

        JButton viewBtn = new JButton("View Students");
        viewBtn.setBounds(100,100,200,30);

        add(addBtn);
        add(viewBtn);

        addBtn.addActionListener(e -> new AddStudentFrame());
        viewBtn.addActionListener(e -> new ViewStudentFrame());

        setVisible(true);
    }
}