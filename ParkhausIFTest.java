import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkhausIFTest {
    Parkhaus p1;
    @BeforeEach
    void setUp() {
        p1 = new Parkhaus();
    }

    @AfterEach
    void tearDown(){
        p1 = null;
    }

    @Test
    @DisplayName("Auto wird beim ziehen des parktickets zurückgegeben")
    void pulltest(){
        assertEquals(Auto.class, p1.pull().getClass());
    }

    @Test
    @DisplayName("Auto wird rausgelassen")
    void pushtest(){
        assertEquals("Gute Fahrt", p1.push(p1.pull()));
    }

    @Test
    @DisplayName("Es wird richtig angezeigt ob ein Auto bezahlt hat")
    void statusttest(){
        Auto a1 = p1.pull();
        assertFalse(a1.getStatus());
        p1.pay(a1);
        assertTrue(a1.getStatus());
    }

    @Test
    @DisplayName("Auto nur rauslassen wenn es bazahlt hat")
    void bezahlttest(){
        Auto a1 = p1.pull();
        assertEquals("Bitte Ticket bezahlen!",p1.push(a1));
        p1.pay(a1);
        assertEquals("Gute Fahrt",p1.push(a1));
    }
}
