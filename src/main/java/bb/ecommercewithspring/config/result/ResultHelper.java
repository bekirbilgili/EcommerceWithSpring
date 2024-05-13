package bb.ecommercewithspring.config.result;

public class ResultHelper {
    public static <T> ResultData<T> created(T data) {
        return new ResultData<> (true, Msg.CREATED, "201", data);
    }
}
