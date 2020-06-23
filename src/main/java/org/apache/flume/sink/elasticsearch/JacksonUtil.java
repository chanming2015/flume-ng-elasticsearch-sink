package org.apache.flume.sink.elasticsearch;

import java.io.IOException;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;

public class JacksonUtil
{
    private static final Logger log = LoggerFactory.getLogger(JacksonUtil.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static String toJsonString(Object obj)
    {
        try
        {
            return OBJECT_MAPPER.writeValueAsString(obj);
        }
        catch (IOException e)
        {
            log.error("toJsonString IOException");
        }
        return null;
    }

    public static <T> T toJsonObject(Class<T> cls, String str)
    {
        try
        {
            return OBJECT_MAPPER.readValue(str, cls);
        }
        catch (JsonParseException e)
        {
            log.error("toJsonObject JsonParseException");
        }
        catch (JsonMappingException e)
        {
            log.error("toJsonObject JsonMappingException");
        }
        catch (IOException e)
        {
            log.error("toJsonObject IOException");
        }
        return null;
    }
}
