package com.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by asouqi on 3/13/18.
 */
public class StudentDAO {
    private String url;
    private String userName;
    private String passWord;

    public StudentDAO(String url, String userName, String passWord) {
        this.url = url;
        this.userName = userName;
        this.passWord = passWord;
    }

    public List<Student> getStudents(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url,userName,passWord);
            Statement statement=connection.createStatement();
            ResultSet set=statement.executeQuery("select * from Servlet.student;");
            List<Student> students =new ArrayList<>();

            while (set.next()){
                students.add(new Student(set.getInt(1),set.getString(2),
                        set.getString(3),set.getDouble(4),
                        set.getString(5)));
            }
            return students;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addStudent(Student student){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url,userName,passWord);
            PreparedStatement ps=connection.prepareStatement("INSERT INTO Servlet.student VALUE(?,?,?,?,?)");

            ps.setInt(1, student.getId());
            ps.setString(2, student.getFirst_name());
            ps.setString(3, student.getLast_name());
            ps.setDouble(4, student.getAvrg());
            ps.setString(5, student.getUnvirsty());
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void editStudent(Student student){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url,userName,passWord);
            PreparedStatement ps=connection.prepareStatement("update Servlet.student set  " +
                                      "student_id=?, first_name=?, last_name=?, avrg=?, Unv=?" +
                                       "where student_id=?;");
            System.out.println(student);
            ps.setInt(1, student.getId());
            ps.setString(2, student.getFirst_name());
            ps.setString(3, student.getLast_name());
            ps.setDouble(4, student.getAvrg());
            ps.setString(5, student.getUnvirsty());
            ps.setInt(6, student.getId());
            System.out.println(ps.execute());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(long id){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection= DriverManager.getConnection(url,userName,passWord);
            PreparedStatement ps=connection.prepareStatement("DELETE FROM Servlet.student WHERE student_id=?");

            ps.setLong(1,id);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
