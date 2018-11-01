package entity;

public class PropertyOfStudent {
    private String userId;
    private int property;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getProperty() {
        return property;
    }

    public void setProperty(int property) {
        this.property = property;
    }

    @Override
    public String toString() {
        return "PropertyOfStudent{" +
                "userId='" + userId + '\'' +
                ", property=" + property +
                '}';
    }
}
