package dto;

import entity.User;

import java.util.List;

public class QueryResultDto<T> {
    private List<T> data;

    public QueryResultDto(List<T> data) {
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
        return "QueryResultDto{" +
                "data=" + data +
                '}';
    }
}
