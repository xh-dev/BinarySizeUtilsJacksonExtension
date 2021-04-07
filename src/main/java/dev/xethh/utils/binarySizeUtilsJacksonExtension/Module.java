package dev.xethh.utils.binarySizeUtilsJacksonExtension;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import dev.xethh.utils.BinarySizeUtils.BinarySize;

public class Module {
    public static SimpleModule _instance =
            new SimpleModule()
                    .addSerializer(BinarySize.class, Serializer._instance)
                    .addDeserializer(BinarySize.class, Deserializer._instance)
            ;

    public static ObjectMapper inject(ObjectMapper om){
        return om.registerModule(_instance);
    }
}
