package by.onliner;

public class LoginLocator {
    public static final String LOGIN_FIELD = "//div[@class='auth-form__line auth-form__line_condensed']//input[@type='text']";
    public static final String PASSWORD_FIELD = "//div[@class='auth-form__line auth-form__line_condensed']//input[@type='password']";
    public static final String SIGN_IN_BUTTON = "//button[@type='submit']";
    public static final String EMPTY_NICKNAME_OR_EMAIL_ERROR_MESSAGE = "//div[@class='auth-form__description auth-form__description_error auth-form__description_base auth-form__description_extended-other']";
    public static final String EMPTY_PASSWORD_ERROR_MESSAGE = "(//div[@class='auth-form__description auth-form__description_error auth-form__description_base auth-form__description_extended-other'])[last()]";
}
