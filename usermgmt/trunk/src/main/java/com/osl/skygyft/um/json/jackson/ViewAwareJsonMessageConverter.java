package com.osl.skygyft.um.json.jackson;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

/**
 * Adds support for Jackson's JsonView on methods
 * annotated with a {@link ResponseView} annotation
 * @author Varun Kumar
 *
 */
public class ViewAwareJsonMessageConverter extends
MappingJackson2HttpMessageConverter {

	  public ViewAwareJsonMessageConverter()
	    {
	        super();
	        HibernateAwareObjectMapper defaultMapper = new HibernateAwareObjectMapper();
	        defaultMapper.enable(MapperFeature.DEFAULT_VIEW_INCLUSION );
	        setObjectMapper(defaultMapper);
	    }
	    
	    @Override
	    protected void writeInternal(Object object, HttpOutputMessage outputMessage)
	            throws IOException, HttpMessageNotWritableException {
	        if (object instanceof DataView && ((DataView) object).hasView())
	        {
	            writeView((DataView) object, outputMessage);
	        } else {
	        	writeNormal(object, outputMessage);
//	            super.writeInternal(object, outputMessage);
	        }
	    }
	    
	    protected void writeNormal(Object object, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
	    	JsonEncoding encoding = getJsonEncoding(outputMessage.getHeaders().getContentType());

	        ObjectMapper mapper = new ObjectMapper();
	        Hibernate4Module mod = new Hibernate4Module();
	        mod.configure(Hibernate4Module.Feature.FORCE_LAZY_LOADING, false);
	        mapper.registerModule(mod);
	        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	        
	        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
	        mapper.configure(SerializationFeature.INDENT_OUTPUT, false); //in dev mode, it can be true
	        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	        
	        ObjectWriter objectWriter = mapper.writer();
	        JsonGenerator jsonGenerator =
	                mapper.getJsonFactory().createJsonGenerator(outputMessage.getBody(), encoding);
	        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm a");
	        mapper.setDateFormat(df);
	        try {
	        	objectWriter.writeValue(jsonGenerator, object);
	        }
	        catch (IOException ex) {
	            throw new HttpMessageNotWritableException("Could not write JSON: " + ex.getMessage(), ex);
	        }
		}

		protected void writeView(DataView view, HttpOutputMessage outputMessage)
	            throws IOException, HttpMessageNotWritableException {
	        JsonEncoding encoding = getJsonEncoding(outputMessage.getHeaders().getContentType());

	        ObjectMapper mapper = new ObjectMapper();
	        Hibernate4Module mod = new Hibernate4Module();
	        mod.configure(Hibernate4Module.Feature.FORCE_LAZY_LOADING, true);
	        mapper.registerModule(mod);
	        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
	        mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
	        
	        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
	        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
	        
	        ObjectWriter objectWriter = mapper.writerWithView(view.getView());
	        JsonGenerator jsonGenerator =
	                mapper.getJsonFactory().createJsonGenerator(outputMessage.getBody(), encoding);
	        try {
	        	objectWriter.writeValue(jsonGenerator, view.getData());
	        }
	        catch (IOException ex) {
	            throw new HttpMessageNotWritableException("Could not write JSON: " + ex.getMessage(), ex);
	        }
	    }

}
