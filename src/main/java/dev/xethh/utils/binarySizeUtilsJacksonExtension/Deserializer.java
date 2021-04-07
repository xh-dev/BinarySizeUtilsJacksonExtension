package dev.xethh.utils.binarySizeUtilsJacksonExtension;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import dev.xethh.utils.BinarySizeUtils.BinarySize;

import java.io.IOException;

public class Deserializer extends StdDeserializer<BinarySize> {
    public static Deserializer _instance = new Deserializer();

    private Deserializer() {
        super(BinarySize.class);
    }

    @Override
    public BinarySize deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        if( "null".equals(jsonParser.getValueAsString())){
            return null;
        }
        else{
            return BinarySize.ofByte(jsonParser.getBigIntegerValue().longValue());
        }
    }
}
