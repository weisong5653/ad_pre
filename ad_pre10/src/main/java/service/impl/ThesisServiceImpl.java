package service.impl;

import dao.ThesisDao;
import dao.impl.ThesisDaoImpl;
import dto.ResultDto;
import entity.Thesis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import service.ThesisService;

import java.util.List;

/**
 * @author weisong
 * @date 2018/11/24 12:16 AM
 */
public class ThesisServiceImpl implements ThesisService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    ThesisDao thesisDao;
    @Override
    public void insertThesis(Thesis thesis) {
        thesisDao = new ThesisDaoImpl();
        int count = thesisDao.insertThesis(thesis);
        if(count != 0) {
            logger.debug(thesis.getStudentId() + "号学生创建了标题为:" + thesis.getTitle() + "论文");
        } else {
            logger.debug("创建论文失败,count=0");
        }
    }

    @Override
    public ResultDto<Thesis> getListThesis(Integer studentId) {
        thesisDao = new ThesisDaoImpl();
        List<Thesis> data = thesisDao.listThesis(studentId);
        if (data != null){
            logger.debug("查询了"+studentId+"号学生的论文列表,有"+data.size()+"篇论文");
            return new ResultDto<Thesis>(data);
        } else {
            logger.debug("查询到"+studentId+"号学生的论文数为0");
            return null;
        }
    }

    @Override
    public void deleteThesis(List<Integer> delThesisId) {
        thesisDao = new ThesisDaoImpl();
        int count = thesisDao.delThesis(delThesisId);
        if (count != 0) {
            logger.debug("删除了"+delThesisId+"论文");
        } else {
            logger.debug("论文不存在，count=0");
        }
    }

    @Override
    public void modifierThesis(Thesis thesis){
        thesisDao = new ThesisDaoImpl();
        thesisDao.modifierThesis(thesis);
        logger.debug("更新了"+thesis.getId()+"号论文");
    }
}
