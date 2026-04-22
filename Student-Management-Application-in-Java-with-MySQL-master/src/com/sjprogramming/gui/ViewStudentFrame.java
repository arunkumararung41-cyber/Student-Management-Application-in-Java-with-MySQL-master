package com.sjprogramming.gui;

import com.sjprogramming.db.DBConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.sql.*;

public class ViewStudentFrame extends JFrame {

    JTable table;
    DefaultTableModel model;

    public ViewStudentFrame() {
        setTitle("All Students");
        setSize(700,400);
        setLayout(null);

        String[] cols = {"ID","Name","College","City","Percentage"};
        model = new DefaultTableModel(cols,0);
        table = new JTable(model);

        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(20,20,650,200);
        add(pane);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setBounds(150,250,100,30);

        JButton updateBtn = new JButton("Update Name");
        updateBtn.setBounds(350,250,150,30);

        add(deleteBtn);
        add(updateBtn);

        loadData();

        // DELETE
        deleteBtn.addActionListener((ActionEvent e) -> {
            int row = table.getSelectedRow();

            if(row == -1){
                JOptionPane.showMessageDialog(this,"Select a row first!");
                return;
            }

            int id = (int) model.getValueAt(row,0);

            try {
                Connection con = DBConnection.createConnection();
                PreparedStatement pst = con.prepareStatement(
                        "delete from student_details where id=?"
                );
                pst.setInt(1,id);
                pst.executeUpdate();

                model.removeRow(row);
                JOptionPane.showMessageDialog(this,"Deleted!");

            } catch(Exception ex){
                ex.printStackTrace();
            }
        });

        // UPDATE
        updateBtn.addActionListener(e -> {
            int row = table.getSelectedRow();

            if(row == -1){
                JOptionPane.showMessageDialog(this,"Select a row first!");
                return;
            }

            int id = (int) model.getValueAt(row,0);

            String newName = JOptionPane.showInputDialog("Enter new name:");

            try {
                Connection con = DBConnection.createConnection();
                PreparedStatement pst = con.prepareStatement(
                        "update student_details set sname=? where id=?"
                );
                pst.setString(1,newName);
                pst.setInt(2,id);

                pst.executeUpdate();

                model.setValueAt(newName,row,1);
                JOptionPane.showMessageDialog(this,"Updated!");

            } catch(Exception ex){
                ex.printStackTrace();
            }
        });

        setVisible(true);
    }

    private void loadData() {
        try {
            Connection con = DBConnection.createConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from student_details");

            while(rs.next()){
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("sname"),
                        rs.getString("cname"),
                        rs.getString("city"),
                        rs.getDouble("percentage")
                });
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}