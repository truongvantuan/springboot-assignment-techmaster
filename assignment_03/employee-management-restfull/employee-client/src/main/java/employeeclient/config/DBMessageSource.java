package employeeclient.config;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;

import java.util.HashMap;
import java.util.Locale;

public class DBMessageSource implements MessageSource {

    private HashMap<String, LocalizeString> localizeDB;

    public DBMessageSource() {
        localizeDB = new HashMap<>();
        localizeDB.put("english", new LocalizeString("EN", "EN"));
        localizeDB.put("vietnam", new LocalizeString("VN", "VN"));
        localizeDB.put("first_name", new LocalizeString("Tên", "First name"));
        localizeDB.put("last_name", new LocalizeString("Họ", "Last name"));
        localizeDB.put("add", new LocalizeString("Thêm mới", "Add new"));
        localizeDB.put("look_up", new LocalizeString("Tìm kiếm", "Look up"));
        localizeDB.put("search", new LocalizeString("Tìm", "Search"));
        localizeDB.put("passport", new LocalizeString("Số chứng minh thư", "Passport ID"));
        localizeDB.put("operation", new LocalizeString("Thao tác", "Operation"));
        localizeDB.put("lang", new LocalizeString("VN", "EN"));
    }

    @Override
    public String getMessage(String code, Object[] objects, String defaultMessage, Locale locale) {
        LocalizeString localizeString = this.localizeDB.get(code);
        return getString(defaultMessage, locale, localizeString);
    }

    @Override
    public String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException {
        LocalizeString localizeString = localizeDB.get(code);
        return getString(code, locale, localizeString);
    }

    private String getString(String code, Locale locale, LocalizeString localizeString) {
        if (localizeString == null) return code;

        switch (locale.getLanguage()) {
            case "vn":
                return localizeString.getVn();
            case "en":
                return localizeString.getEn();
            default:
                return code;
        }
    }

    @Override
    public String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException {
        return resolvable.getDefaultMessage();
    }
}
