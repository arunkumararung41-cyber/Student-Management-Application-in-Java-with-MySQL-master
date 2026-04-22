package com.sjprogramming.dao;

import com.sjprogramming.db.DBConnection;
import com.sjprogramming.model.Student;

import java.sql.*;

public class StudentDao implements StudentDaoInterface {

    Connection con;

    @Override
    public boolean login(String username, String password) {
        boolean valid = false;
        try {
            con = DBConnection.createConnection();
            String query = "select * from users where username=? and password=?";

            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) valid = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return valid;
    }

    @Override
    public boolean insertStudent(Student s) {
        try {
            con = DBConnection.createConnection();
            String query = "insert into student_details(sname,cname,city,percentage) values(?,?,?,?)";

            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, s.getName());
            pst.setString(2, s.getClgName());
            pst.setString(3, s.getCity());
            pst.setDouble(4, s.getPercentage());

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void showAllStudent() {
        try {
            con = DBConnection.createConnection();
            String query = "select * from student_details";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("sname") + " | " +
                        rs.getString("cname") + " | " +
                        rs.getString("city") + " | " +
                        rs.getDouble("percentage")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean showStudentById(int id) {
        try {
            con = DBConnection.createConnection();
            String query = "select * from student_details where id=?";

            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                System.out.println("Name: " + rs.getString("sname"));
                System.out.println("College: " + rs.getString("cname"));
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            con = DBConnection.createConnection();
            String query = "delete from student_details where id=?";

            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(int id, String value, int choice) {
        try {
            con = DBConnection.createConnection();

            String query = (choice == 1)
                    ? "update student_details set sname=? where id=?"
                    : "update student_details set cname=? where id=?";

            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, value);
            pst.setInt(2, id);

            pst.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean searchByName(String name) {
        boolean found = false;
        try {
            con = DBConnection.createConnection();
            String query = "select * from student_details where sname like ?";

            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, "%" + name + "%");

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("sname"));
                found = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return found;
    }

    @Override
    public void sortByPercentage() {
        try {
            con = DBConnection.createConnection();
            String query = "select * from student_details order by percentage desc";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getString("sname") + " - " + rs.getDouble("percentage"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}