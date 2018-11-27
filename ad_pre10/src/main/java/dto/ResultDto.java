package dto;

import java.util.List;

/**
 * @author weisong
 * @date 2018/11/25 10:19 AM
 */
public class ResultDto<T> {
    private List<T> data;

    public ResultDto() {
    }

    public ResultDto(List<T> data) {
        this.data = data;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultDto{" +
                "data=" + data +
                '}';
    }
}
