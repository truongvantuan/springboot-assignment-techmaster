package employeemanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<ErrorDetail> employeeNotFoundHandler(ResourceNotFoundException ex, WebRequest request) {
        List<String> detail = new ArrayList<>();
        detail.add(ex.getLocalizedMessage());
        ErrorDetail errorDetail = new ErrorDetail("Employee không tìm thấy!", detail);
        return new ResponseEntity<>(errorDetail, HttpStatus.ACCEPTED);
    }
}
