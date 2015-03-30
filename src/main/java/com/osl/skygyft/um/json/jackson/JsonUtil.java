package com.osl.skygyft.um.json.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class JsonUtil {

	private ObjectWriter objectWriter;

	public JsonUtil() {
		ObjectMapper mapper = new ObjectMapper();
		Hibernate4Module mod = new Hibernate4Module();
		mod.configure(Hibernate4Module.Feature.FORCE_LAZY_LOADING, true);
		mapper.registerModule(mod);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		objectWriter = mapper.writer();
	}

	public String toJson(Object object) {
		String json = "";
		try {

			PrettyPrinter prettyPrinter = new DefaultPrettyPrinter();
			json = objectWriter.with(prettyPrinter).writeValueAsString(object);
			json = json.substring(1, json.length() - 1);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}

}
