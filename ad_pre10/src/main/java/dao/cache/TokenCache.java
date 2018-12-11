package dao.cache;

import dto.UserTokenDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import util.SerializeUtil;
import util.TokenUtil;

import java.io.Serializable;

/**
 * 将token写入redis
 * @author weisong
 * @date 2018/12/10 10:31 AM
 */
public class TokenCache implements Serializable {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    private static Jedis redis;

    public  UserTokenDto setUserTokenDto(String studentId){
        redis = new Jedis("127.0.0.1", 6379);
        UserTokenDto userTokenDto = null;
        if (studentId != null) {
            userTokenDto = TokenUtil.generateUserToken(studentId);
            redis.set(studentId.getBytes(), SerializeUtil.serialize(userTokenDto));
            redis.expire(studentId,30);
        }
        return userTokenDto;
    }

    public  UserTokenDto getUserTokenDto(String studentId){
        redis = new Jedis("127.0.0.1",6379);
        UserTokenDto userTokenDto = (UserTokenDto) SerializeUtil.unSerialize(redis.get(studentId.getBytes()));
        return userTokenDto;
    }

    public  UserTokenDto verifyUserToken(String token){
        redis = new Jedis("127.0.0.1",6379);
        String studentId = null;
        UserTokenDto userTokenDto = null;
        UserTokenDto decodeUserTokenDto = TokenUtil.decodeToken(token);
        studentId = String.valueOf(decodeUserTokenDto.getId());
        byte[] bytes = redis.get(studentId.getBytes());
        if (bytes != null) {
            userTokenDto = (UserTokenDto) SerializeUtil.unSerialize(bytes);
            logger.debug("token有效,"+userTokenDto);
        } else {
            logger.debug("token无效，"+decodeUserTokenDto);
        }
        if (userTokenDto != null){
            return userTokenDto;
        }
        return null;
    }
}
