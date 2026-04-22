package com.sjprogramming.dao;

import com.sjprogramming.model.Student;

public interface StudentDaoInterface {

    boolean login(String username, String password);

    boolean insertStudent(Student s);
    void showAllStudent();
    boolean showStudentById(int id);
    boolean delete(int id);
    boolean update(int id, String value, int choice);

    boolean searchByName(String name);
    void sortByPercentage();
}