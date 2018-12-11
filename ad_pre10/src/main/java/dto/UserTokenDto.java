package dto;

import java.io.Serializable;

/**
 * @author weisong
 * @date 2018/12/10 10:19 AM
 */
public class UserTokenDto implements Serializable {
    private Integer id;
    private String token;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserTokenDto{" +
                "id=" + id +
                ", token='" + token + '\'' +
                '}';
    }
}
