package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestSecond {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulTest() {
        String firstName = "Dmitry";
        String lastName = "Sn";
        String userEmail = "dshatokhin@godletech.com";
        String userNumber = "1234567891";
        String Address = "Wola";


        open("/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(userEmail);
        $("#genterWrapper").$(byText("Male")).click();
        $("[id=userNumber]").setValue(userNumber);
        $("[id=currentAddress]").setValue(Address);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("1989");
        $("[aria-label = 'Choose Friday, February 3rd, 1989']").click();
        $("#subjectsInput").sendKeys("Arts");
        $("#subjectsInput").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/img1.png"));
        $("[id=currentAddress]").setValue(Address);
        $("[id=react-select-3-input]").setValue("Uttar Pradesh").pressEnter();
        $("[id=react-select-4-input]").setValue("Merrut").pressEnter();
        $("[id=submit]").click();


        $(".table-responsive").shouldHave(
                text("Dmitry"),
                text("Sh"),
                text("dshatokhin@godletech.com"),
                text("Male"),
                text("1234567891"),
                text("03 February,1989"),
                text("Arts"),
                text("Reading"),
                text("img1.png"),
                text("Wola"),
                text("Uttar Pradesh Merrut")
        );

        System.out.println("HAPPY TESTING 2");
    }
}