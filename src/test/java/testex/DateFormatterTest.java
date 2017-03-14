/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testex;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Kim
 */
public class DateFormatterTest {
    @Test
    public void TestValidTimeZone() throws Exception {
        IDateFormatter dateFormatter = mock(IDateFormatter.class);
        when(dateFormatter.getFormattedDate(anyObject(), eq("Europe/Copenhagen"))).thenReturn("14 March 2017 11:00 PM");

        String result = dateFormatter.getFormattedDate(new Date(), "Europe/Copenhagen");
        assertEquals("14 March 2017 11:00 PM", result);
    }
    
    @Test(expected=JokeException.class)
    public void TestInvalidTimeZone() throws Exception {
        IDateFormatter dateFormatter = new DateFormatter();
        dateFormatter.getFormattedDate(new Date(), "Invalid TimeZone");
    }    
}
