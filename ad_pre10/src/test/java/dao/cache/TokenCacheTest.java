package dao.cache;

import dto.UserTokenDto;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author weisong
 * @date 2018/12/10 8:41 PM
 */
public class TokenCacheTest {
    TokenCache tokenCache;
    @Test
    public void setUserTokenDto() {
        tokenCache = new TokenCache();
        tokenCache.setUserTokenDto("11");

    }

    @Test
    public void getUserTokenDto() {
        tokenCache = new TokenCache();
        UserTokenDto userTokenDto = tokenCache.getUserTokenDto("11");
        System.out.println(userTokenDto);
    }

    @Test
    public void verifyUserToken() {
        tokenCache = new TokenCache();
        UserTokenDto a = tokenCache.verifyUserToken("MTExNTQ0NDQ2ODQ0MTQ0");
    }
}