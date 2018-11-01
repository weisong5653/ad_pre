package dao;

import org.apache.ibatis.annotations.Param;

public interface CreateDao {
    public int createPropertyOfStudent(@Param("userId") String userId,@Param("property")int property);
    public int createIntegraOfStudent(@Param("userId") String userId,@Param("integral")int integral);

}