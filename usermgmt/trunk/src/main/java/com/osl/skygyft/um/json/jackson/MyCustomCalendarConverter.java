package com.osl.skygyft.um.json.jackson;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class MyCustomCalendarConverter extends JsonSerializer<Calendar>{

	@Override
	public void serialize(Calendar cal, JsonGenerator jsonGenerator,
			SerializerProvider serProvider) throws IOException,
			JsonProcessingException {
		// TODO Auto-generated method stub
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm a");
		String format = df.format(cal);
		jsonGenerator.writeStartObject();
        jsonGenerator.writeString(format);
        jsonGenerator.writeEndObject();
	}

}
