package dao.impl;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import dao.StudentDao;
import entity.Student;
import util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImpl implements StudentDao {
    @Override
    public int addStudent(Student student) {
        Connection conn = JDBCUtil.getConnection();
        int i=0;
        String sql = "insert into student (student_name,age,sex,password) values(?,?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
//            pstmt.setInt(1, student.getStudentId());
            pstmt.setString(1, student.getStudentName());
            pstmt.setInt(2, student.getAge());
            pstmt.setString(3, student.getSex());
            pstmt.setString(4, student.getPassword());

            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public boolean isExist(String studentName) {
        boolean isExist = false;
        Connection conn = JDBCUtil.getConnection();
        String sql = "select student_name from student where student_name=?";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement)conn.prepareStatement(sql);
            pstmt.setString(1,studentName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                if(studentName.equals(rs.getString(1))){
                    isExist=true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isExist;
    }

    @Override
    public Student getStudent(String name, String password) {
        Connection connection = JDBCUtil.getConnection();
        Student student = null;
        String sql = "select id, student_name , age, sex from student where student_name=? and password=?";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement)connection.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setString(2,password);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                student = new Student();
                student.setId(rs.getInt(1));

                student.setStudentName(rs.getString(2));
                student.setAge(rs.getInt(3));
                student.setSex(rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public int getInsertStudentId(String name) {
        int id = 0;
        Connection connection = JDBCUtil.getConnection();
        String sql = "select id from student where student_name=?";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement)connection.prepareStatement(sql);
            pstmt.setString(1,name);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public int updateStudent(Student student) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "update student set student_name = ?,age = ?,password = ?,sex = ? where id = ?";
        PreparedStatement pstm;
        try {
            pstm = (PreparedStatement) connection.prepareStatement(sql);
            pstm.setString(1,student.getStudentName());
            pstm.setInt(2,student.getAge());
            pstm.setString(3,student.getPassword());
            pstm.setString(4,student.getSex());
            pstm.setInt(5,student.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int delStudent(Student student) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "delete from student where id = ?";
        int count = 0;
        PreparedStatement pstm;
        try {
            pstm = (PreparedStatement) connection.prepareStatement(sql);
            pstm.setInt(1,student.getId());
            count = pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

}
