package dev.xethh.utils.binarySizeUtilsJacksonExtension;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import dev.xethh.utils.BinarySizeUtils.BinarySize;

import java.io.IOException;

public class Serializer extends StdSerializer<BinarySize> {
    public static Serializer _instance = new Serializer();

    private Serializer() {
        super(BinarySize.class);
    }

    @Override
    public void serialize(BinarySize binarySize, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if(binarySize == null){
            jsonGenerator.writeNull();
        }
        else{
            jsonGenerator.writeRawValue(Long.toString(binarySize.inBytes().toBigInteger().longValue()));
        }
    }
}
