import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;
import java1.Zeit;

import static org.junit.jupiter.api.Assertions.*;

class ZeitTest {
    Zeit z;

    @BeforeEach
    void setUp() {
        z = new Zeit();
    }

    @AfterEach
    void tearDown() {
        z = null;
    }

    @Test
    @DisplayName("Zeit wird mit 29.05.2023, 12:30 gesetzt ")
    void zeit_setzen() {
        z.setTime("29.06.2023, 12:30");
        assertEquals(29, z.getTag());
        assertEquals(6, z.getMonat());
        assertEquals(2023, z.getJahr());
        assertEquals(12,z.getStunde());
        assertEquals(30, z.getMinute());
        assertThrows(IllegalArgumentException.class, () -> {
           z.setTime("29.05.2023, 12:00");
        });
    }
    @Test
    @DisplayName("flasche stunde und minute eingaben werfen exception")
    void zeit_wrong_format() {
        assertThrows(NumberFormatException.class, ()->{
            z.setTime("29.05.2023, 24:30");
        });
    }

    @Test
    @DisplayName("Es wird 1.6.2023, 0:0 als Zeit ausgegeben")
    void zeittoString() {
        assertEquals("01.06.2023, 00:00",z.toString());
    }

    @Test
    @DisplayName("Es wird die korrekt addierte Zeit ausgegeben")
    void addTime() {
        z.setTime("29.06.2023, 00:00");
        z.addTime(2,30);
        assertEquals("29.06.2023, 02:30", z.toString());
        z.setTime("29.07.2023, 00:00");
        z.addTime(74,30);
        assertEquals("01.08.2023, 02:30", z.toString());
    }

    @Test
    @DisplayName("Zeit lässt sich korrekt vergleichen")
    void comparetime(){
        z.setTime("2.6.2023, 0:0");
        assertEquals(1,z.compareTo(new Zeit()));
        z.setTime("2.6.2023, 12:30");
        Zeit y = new Zeit();
        y.setTime("2.6.2023, 12:31");
        assertEquals(-1,z.compareTo(y));
        assertEquals(0, new Zeit().compareTo(new Zeit()));
        z.setTime("2.6.2023, 13:30");
        assertEquals(1,z.compareTo(y));
    }

    @Test
    @DisplayName("Zeit wird richtig subtrahiert")
    void testsubtract(){
        Zeit z = new Zeit();
        z.setTime("3.6.2023, 10:20");
        Zeit y = new Zeit();
        y.setTime("1.6.2023, 10:20");
        int a = 48*60;
        assertEquals(a,z.subtract(y));
    }

    @Test
    @DisplayName("to String test")
    void toStringtest(){
        Zeit z = new Zeit();
        z.setTime("03.06.2023, 10:20");
        assertEquals("3.6.2023, 10:20", z.toString());
    }

}