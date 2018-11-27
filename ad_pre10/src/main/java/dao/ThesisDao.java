package dao;

import entity.Thesis;

import java.util.List;

/**
 * @author weisong
 * @date 2018/11/23 11:18 PM
 */
public interface ThesisDao {
    int insertThesis(Thesis thesis);
    List<Thesis> listThesis(Integer id);
    int delThesis(List<Integer> delThesisId);
    int modifierThesis(Thesis thesis);
}
