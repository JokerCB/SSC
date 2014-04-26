package com.ssc.demo.web.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: tom
 * Date: 13-9-10
 * Time: 上午10:23
 * To change this template use File | Settings | File Templates.
 */
public class TimestampSerializer extends JsonSerializer<Timestamp> {

    @Override
    public void serialize(Timestamp timestamp, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
         jsonGenerator.writeString(simpleDateFormat.format(timestamp));
    }
}
