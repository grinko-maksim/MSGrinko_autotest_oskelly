import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthTest {

    @Test
    void successfulAuthTest() {
        // Установка пути к chromedriver
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        open("https://oskelly.ru/women");

        $(".osk-header-top-actions__link").click();
        $(".osk-input__input").setValue("grinko@mail.ru");
        $(".osk-input__input[type='password']").click();
        $(".osk-input__input[type='password']").setValue("Qwer1234");

        // Клик на кнопку "Войти"
        $("button.osk-button.osk-button_color-primary.osk-button_size-m.osk-button_full-width.osk-sign-in-form__button").click();

        // Дождаться, пока произойдет авторизация по кнопке "Вход"
        $("button.osk-button.osk-button_color-primary.osk-button_size-m.osk-button_full-width.osk-sign-in-form__button").shouldBe(Condition.enabled);

        Selenide.sleep(10000);
    }
}
