import java1.Auto;
import java1.Parkhaus;
import org.junit.jupiter.api.*;
import java1.Zeit;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class ParkhausIFTest {
    Parkhaus p1;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @BeforeEach
    void setUp() {
        p1 = new Parkhaus(100, 0.01, new Zeit(30,05,2023,12,0));
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown(){
        p1 = null;
    }

    @Test
    @DisplayName("Auto wird beim ziehen des parktickets zurückgegeben")
    void pulltest(){
        assertEquals(Auto.class, p1.pull().getClass());
        Auto a = p1.pull();
        assertEquals("Auto: 2", a.toString());
    }

    @Disabled
    @Test
    @DisplayName("auto wird aus liste gelöscht und log wird angezeigt")
    void pushtest(){
        Auto a = p1.pull();
        a.setParkende(new Zeit(30,05,2023,14,0));
        p1.timeskip(2,0);
        Auto a1 = p1.pull();
        a1.setParkende(new Zeit(30,05,2023,16,30));
        Auto a2 = p1.pull();
        a2.setParkende(new Zeit(30,05,2023,17,0));
        Auto a3 = p1.pull();
        a3.setParkende(new Zeit(30,05,2023,17,30));
        p1.timeskip(48,0);
        assertEquals("Auto: 3, Dauer: 120min, Preis: 1.2€\n" +
                "Auto: 4, Dauer: 30min, Preis: 0.3€\n" +
                "Auto: 5, Dauer: 60min, Preis: 0.6€\n" +
                "Auto: 6, Dauer: 90min, Preis: 0.9€\n",outContent.toString());

    }



}
