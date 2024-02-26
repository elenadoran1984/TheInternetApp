package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertTests extends BaseTests {

    @Test
    public void testAcceptAlert(){
       var alertsPage =  homePage.clickJavaScriptAlerts();
       alertsPage.triggerAlert();
       String text = alertsPage.alert_getText();
       alertsPage.alert_clickToAccept();
       assertEquals(text, "I am a JS Alert", "Alert text incorrect" );
       assertEquals(alertsPage.getResult(), "You successfully clicked an alert", "Results text incorrect");
    }

    @Test
    public void testAcceptConfirm(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
        String text = alertsPage.alert_getText();
        alertsPage.alert_clickToAccept();
        assertEquals(text, "I am a JS Confirm", "Alert text incorrect" );
        assertEquals(alertsPage.getResult(), "You clicked: Ok", "Results text incorrect");
    }

    @Test
    public void testDismissConfirm(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerConfirm();
        String text = alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        assertEquals(text, "I am a JS Confirm", "Alert text incorrect" );
        assertEquals(alertsPage.getResult(), "You clicked: Cancel", "Results text incorrect");
    }

    @Test
    public void testSetInputInAlertAcceptPrompt(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerPrompt();
        String text1 = alertsPage.alert_getText();
        String text2 = "TAU rocks";
        alertsPage.alert_setInput(text2);
        alertsPage.alert_clickToAccept();
        assertEquals(text1, "I am a JS prompt", "Alert text incorrect" );
        assertEquals(alertsPage.getResult(), "You entered: " + text2, "Results text incorrect");
    }

    @Test
    public void testSetInputInAlertDismissPrompt(){
        var alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.triggerPrompt();
        String text1 = alertsPage.alert_getText();
        String text2 = "TAU rocks";
        alertsPage.alert_setInput(text2);
        alertsPage.alert_clickToDismiss();
        assertEquals(text1, "I am a JS prompt", "Alert text incorrect" );
        assertEquals(alertsPage.getResult(), "You entered: null", "Results text incorrect");
    }
}
