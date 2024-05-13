package bb.ecommercewithspring.config.result;

import lombok.Getter;

@Getter
public class ResultData<T> extends Result {
    T data;

    public ResultData(boolean status, String message, String code, T data) {
        super(status, message, code);
        this.data = data;
    }
}
