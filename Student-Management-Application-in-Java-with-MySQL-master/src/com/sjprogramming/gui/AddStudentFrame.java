package com.sjprogramming.gui;

import com.sjprogramming.dao.*;
import com.sjprogramming.model.Student;

import javax.swing.*;

public class AddStudentFrame extends JFrame {

    JTextField name, clg, city, per;
    JButton addBtn;

    StudentDaoInterface dao = new StudentDao();

    public AddStudentFrame() {
        setTitle("Add Student");
        setSize(400,300);
        setLayout(null);

        name = new JTextField();
        name.setBounds(150,20,150,25);

        clg = new JTextField();
        clg.setBounds(150,60,150,25);

        city = new JTextField();
        city.setBounds(150,100,150,25);

        per = new JTextField();
        per.setBounds(150,140,150,25);

        add(new JLabel("Name")).setBounds(50,20,100,25);
        add(new JLabel("College")).setBounds(50,60,100,25);
        add(new JLabel("City")).setBounds(50,100,100,25);
        add(new JLabel("Percentage")).setBounds(50,140,100,25);

        add(name); add(clg); add(city); add(per);

        addBtn = new JButton("Add");
        addBtn.setBounds(150,180,100,30);
        add(addBtn);

        addBtn.addActionListener(e -> {
            Student s = new Student(
                    name.getText(),
                    clg.getText(),
                    city.getText(),
                    Double.parseDouble(per.getText())
            );

            if(dao.insertStudent(s)){
                JOptionPane.showMessageDialog(this, "Added!");
            } else {
                JOptionPane.showMessageDialog(this, "Error!");
            }
        });

        setVisible(true);
    }
}