package dev.xethh.utils.binarySizeUtilsJacksonExtension;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import dev.xethh.utils.BinarySizeUtils.BinarySize;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    public static class A{
        private BinarySize b;

        public BinarySize getB() {
            return b;
        }

        public void setB(BinarySize b) {
            this.b = b;
        }
    }

    public static ObjectMapper om = new ObjectMapper();
    @BeforeClass
    public static void before(){
        Module.inject(om);
    }

    @Test
    public void testNull() throws JsonProcessingException {
        A a = new A();
        String s = om.writeValueAsString(a);
        assertEquals("{\"b\":null}",s);
        A b = om.readValue(s, A.class);
        assertNull(b.b);
    }

    @Test
    public void testNoneNull() throws JsonProcessingException {
        A a = new A();
        a.setB(BinarySize.ofByte(1000l));
        String s = om.writeValueAsString(a);
        assertEquals("{\"b\":1000}",s);
        A b = om.readValue(s, A.class);
        assertEquals(1000l, b.b.inBytes().longValue());
    }

    @Test
    public void testError() throws JsonProcessingException {
        String s = "{\"b\":\"\"}";
        assertThrows(JsonMappingException.class, ()->om.readValue(s, A.class));
    }
}
