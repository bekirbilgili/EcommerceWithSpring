package bb.ecommercewithspring.config;

import bb.ecommercewithspring.config.result.Msg;
import bb.ecommercewithspring.config.result.ResultData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResultData<List<String>>> handleValidationErrors(MethodArgumentNotValidException e) {

        List<String> validationErrorList = e.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());
        ResultData<List<String>> resultData = new ResultData<>(false, Msg.VALIDATION_ERROR, "400", validationErrorList);
        return new ResponseEntity<>(resultData, HttpStatus.BAD_REQUEST);
    }
}
