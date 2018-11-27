package dto;

/**
 * @author weisong
 * @date 2018/11/24 2:21 PM
 */
public class LoginDto {
    private String studentName;
    private String password;

    public LoginDto() {
    }

    public LoginDto(String studentName, String password) {
        this.studentName = studentName;
        this.password = password;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginDto{" +
                "studentName='" + studentName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
