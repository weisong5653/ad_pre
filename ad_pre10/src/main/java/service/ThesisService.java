package service;

import dto.ResultDto;
import entity.Thesis;

import java.util.List;

/**
 * @author weisong
 * @date 2018/11/24 12:15 AM
 */
public interface ThesisService {
    void insertThesis(Thesis thesis);
    ResultDto<Thesis> getListThesis(Integer studentId);
    void deleteThesis(List<Integer> delThesisId);
    void modifierThesis(Thesis thesis);
}
