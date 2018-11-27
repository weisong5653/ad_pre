package dao.impl;

import com.mysql.jdbc.PreparedStatement;
import dao.ThesisDao;
import entity.Thesis;
import util.AutoFillBeanUtil;
import util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author weisong
 * @date 2018/11/23 11:19 PM
 */
public class ThesisDaoImpl implements ThesisDao {
    Connection conn;
    @Override
    public int insertThesis(Thesis thesis) {
        conn = JDBCUtil.getConnection();
        int i=0;
        String sql = "insert into thesis (student_id,title,content,public_time) values(?,?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
//            pstmt.setInt(1, student.getStudentId());
            pstmt.setInt(1, thesis.getStudentId());
            pstmt.setString(2, thesis.getTitle());
            pstmt.setString(3, thesis.getContent());
            pstmt.setString(4, thesis.getPublicTime());
            i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public List<Thesis> listThesis(Integer studentid) {
        conn = JDBCUtil.getConnection();
        String sql = "select student_id, id, title, content, public_time from thesis where student_id=?";
        List<Thesis> thesisList = AutoFillBeanUtil.fillBeanFromSQL(conn, Thesis.class, sql, studentid);
        return thesisList;
    }

    @Override
    public int delThesis(List<Integer> delThesisId) {
        conn = JDBCUtil.getConnection();
        String sql = "delete from thesis where id=?";
        Integer count = 0;
        PreparedStatement pstmt;
        for (Integer index : delThesisId){
            try {
                pstmt = (PreparedStatement) conn.prepareStatement(sql);
                pstmt.setInt(1,index);
                pstmt.executeUpdate();
                count++;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    @Override
    public int modifierThesis(Thesis thesis) {
        conn = JDBCUtil.getConnection();
        int count = 0;
        String sql = "update thesis set title=?, content=?, public_time=? WHERE id=?";
        try {
            PreparedStatement pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1,thesis.getTitle());
            pstmt.setString(2,thesis.getContent());
            pstmt.setString(3,thesis.getPublicTime());
            pstmt.setInt(4,thesis.getId());
            pstmt.executeUpdate();
            count++;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }
}
