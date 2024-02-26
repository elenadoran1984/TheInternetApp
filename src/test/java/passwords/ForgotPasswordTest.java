package passwords;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.EmailSentPage;
import pages.ForgotPasswordPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ForgotPasswordTest extends BaseTests {

    @Test
    public void testClickRetrievePassword(){
        ForgotPasswordPage forgotPasswordPage =  homePage.clickForgotPassword();
        forgotPasswordPage.enterEmail("test@example.com");
        EmailSentPage emailSentPage = forgotPasswordPage.clickRetrievePassword();
        assertTrue(emailSentPage.getMessage()
                .contains("Your e-mail's been sent!"),
                "Message is incorrect");
    }

    @Test
    public void testRetrievePassword1(){
        var forgetPasswordPage = homePage.clickForgotPassword();
        var emailSentPage = forgetPasswordPage.retrievePassword("tau@example.com");
        assertEquals(emailSentPage.getMessage(), "Your e-mail's been sent!", "Message is incorrect");
    }
}


