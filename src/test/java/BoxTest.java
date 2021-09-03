import boxapp.Box;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest(classes={BoxTest.class})
class BoxTest {

    @Test
    void test_init_box(){
        Box box = new Box();
        assertEquals(true, box.isEmpty());
    }

    @Test
    void test_log(){
        Box box = new Box();
        box.log("event1");
        assertEquals(false, box.isEmpty());
        assertEquals("event1", box.readLogs());
    }

    @Test
    void test_logs(){
        Box box = new Box();
        box.log("event1");
        box.log("event2");
        assertEquals(false, box.isEmpty());
        assertEquals("event1-event2", box.readLogs());
    }

    @Test
    void test_secure_mode(){
        Box box = new Box("S");
        box.decrypt("ZXZlbnQxLWV2ZW50Mi1ldmVudDM=");
        assertEquals(false, box.isEmpty());
        assertEquals(3, box.count());
        assertEquals("Secure(event1-event2-event3)", box.readLogs());
    }

    @Test
    void test_rest_secure_mode(){
        Box box = new Box("R");
        box.decrypt("ZXZlbnQxLWV2ZW50Mi1ldmVudDM=");
        assertEquals(false, box.isEmpty());
        assertEquals(3, box.count());
        assertEquals("[{\"id\":\"event1\"},{\"id\":\"event2\"},{\"id\":\"event3\"}]", box.readLogs());
    }

}
