package employeemanager.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
        String message = ex.getMessage();
        detail.add(request.getDescription(true));
        ErrorDetail errorDetail = new ErrorDetail(message, detail);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetail);
    }


    //
//    @ResponseBody
//    @ExceptionHandler(RuntimeException.class)
//    ResponseEntity<ErrorDetail> handleGlobalException(RuntimeException ex, WebRequest request) {
//        List<String> detail = Arrays.stream(ex.getStackTrace())
//                .map(Objects::toString)
//                .collect(Collectors.toList());
////        detail.add(ex.getMessage());
//        ErrorDetail errorDetail = new ErrorDetail("Exception!", detail);
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetail);
//    }
//
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return super.handleMethodArgumentNotValid(ex, headers, status, request);
    }
}
