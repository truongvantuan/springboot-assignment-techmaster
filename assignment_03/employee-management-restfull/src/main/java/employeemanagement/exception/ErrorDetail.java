package employeemanagement.exception;

import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ErrorDetail {

    private String errorTime;
    private String message;
    private List<String> detail;

    public ErrorDetail(String message, List<String> detail) {
        this.errorTime = newDate();
        this.message = message;
        this.detail = detail;
    }

    public static String newDate() {
        String pattern = "dd-M-yyyy hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(new Date());
    }
}
