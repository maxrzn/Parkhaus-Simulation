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
        z.setTime("29.05.2023, 12:30");
        assertEquals(29, z.getTag());
        assertEquals(5, z.getMonat());
        assertEquals(2023, z.getJahr());
        assertEquals(12,z.getStunde());
        assertEquals(30, z.getMinute());
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
        assertEquals("1.6.2023, 0:0",z.toString());
    }



    @Disabled("not adjusted")
    @Test
    @DisplayName("Es wird die korrekt addierte Zeit ausgegeben")
    void addTime() {
        /*
        assertEquals("1:0",z.addTime(12,30));
        z.setTime(12,30);
        assertEquals("13:5",z.addTime(0,35));
        assertEquals("0:0",z.addTime(10,55));
         */
    }

}