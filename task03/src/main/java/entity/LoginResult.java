package entity;

public class LoginResult {
    private int schoolId;
    private String teacherName;
    private String password;

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginResult{" +
                "schoolId=" + schoolId +
                ", teacherName='" + teacherName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
