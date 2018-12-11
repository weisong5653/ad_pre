package util;

import dto.UserTokenDto;

/**
 * @author weisong
 * @date 2018/12/10 10:17 AM
 */
public class TokenUtil {

    /**
     * 生成tokenDto
     * @param studentId
     * @return
     */
    public static UserTokenDto generateUserToken(String studentId) {
        String token = generateToken(studentId);
        UserTokenDto userTokenDto = null;
        if (studentId != null) {
            userTokenDto = new UserTokenDto();
            userTokenDto.setId(Integer.valueOf(studentId));
            userTokenDto.setToken(token);
        }
        return userTokenDto;
    }

    /**
     * token生成规则
     * token = studentId+curretnTime
     * @param studentId
     * @return
     */
    public static String generateToken(String studentId){
        String token = null;
        if (studentId != null) {
            long currentTime = System.currentTimeMillis();
            token = studentId+currentTime;
            token= Base64Util.getBase64(token);
        }
        return token;
    }

    /**
     * 解码token
     * @param token
     * @return
     */
    public static UserTokenDto decodeToken(String token){
        UserTokenDto userTokenDto = null;
        String studentId = null;
        if (token != null) {
            userTokenDto = new UserTokenDto();
            token = Base64Util.getFromBase64(token);
            studentId = token.substring(0,2);
            userTokenDto.setId(Integer.valueOf(studentId));
            userTokenDto.setToken(token);
        }
        return userTokenDto;
    }


}
