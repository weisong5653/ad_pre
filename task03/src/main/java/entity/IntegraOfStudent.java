package entity;

public class IntegraOfStudent {
    private String userId;
    private int integral;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    @Override
    public String toString() {
        return "IntegraOfStudent{" +
                "userId='" + userId + '\'' +
                ", integral=" + integral +
                '}';
    }
}
