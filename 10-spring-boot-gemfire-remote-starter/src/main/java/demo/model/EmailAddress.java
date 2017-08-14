package demo.model;

import java.io.Serializable;
import java.util.regex.Pattern;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;


public final class EmailAddress  implements Serializable {

    private static final long serialVersionUID = -2990839949384592331L;

    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern PATTERN = Pattern.compile(EMAIL_REGEX);

    private final String value;

    public EmailAddress(String emailAddress) {
        Assert.isTrue(isValid(emailAddress), "Invalid email address!");
        this.value = emailAddress;
    }

    public static boolean isValid(String source) {
        Assert.hasText(source, "String argument must have text; it must not be null, empty, or blank");
        return PATTERN.matcher(source).matches();
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof EmailAddress)) {
            return false;
        }

        EmailAddress that = (EmailAddress) obj;
        return this.value.equals(that.value);
    }


    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Component
    static class EmailAddressToStringConverter implements Converter<EmailAddress, String> {

        @Override
        public String convert(EmailAddress source) {
            return source == null ? null : source.value;
        }
    }

    @Component
    static class StringToEmailAddressConverter implements Converter<String, EmailAddress> {

        public EmailAddress convert(String source) {
            return StringUtils.hasText(source) ? new EmailAddress(source) : null;
        }
    }
}
