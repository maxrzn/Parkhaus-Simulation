import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
