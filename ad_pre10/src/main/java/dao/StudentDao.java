package dao;

import entity.Student;


public interface StudentDao {
    int addStudent(Student student);
    boolean isExist(String name);
    Student getStudent(String name,String password);
    int getInsertStudentId(String name);
    int updateStudent(Student student);
    int delStudent(Student student);
}
