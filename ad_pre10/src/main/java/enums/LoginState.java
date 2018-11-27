package enums;

/**
 * @author weisong
 * @date 2018/11/24 2:59 PM
 */
public enum LoginState {
    LOGIN_SUCCESS(true,"登陆成功"),
    LOGIN_FAILURE(false,"登陆失败");
    private boolean state;
    private String stateMessage;

    LoginState(boolean state, String stateMessage) {
        this.state = state;
        this.stateMessage = stateMessage;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getStateMessage() {
        return stateMessage;
    }

    public void setStateMessage(String stateMessage) {
        this.stateMessage = stateMessage;
    }
}
