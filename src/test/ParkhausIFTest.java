import java1.Auto;
import java1.Parkhaus;
import org.junit.jupiter.api.*;

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
    @DisplayName("src.main.java.Auto wird beim ziehen des parktickets zurückgegeben")
    void pulltest(){
        assertEquals(Auto.class, p1.pull().getClass());
    }

    @Disabled
    @Test
    @DisplayName("src.main.java.Auto wird rausgelassen")
    void pushtest(){
        assertEquals("Gute Fahrt", p1.push(p1.pull()));
    }

    @Test
    @DisplayName("Parkhaus checkt parkende der Autos")
    void endeparkzeitTest() {

    }

}
