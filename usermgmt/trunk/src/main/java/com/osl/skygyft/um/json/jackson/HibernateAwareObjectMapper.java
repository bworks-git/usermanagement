package com.osl.skygyft.um.json.jackson;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
 
public class HibernateAwareObjectMapper extends ObjectMapper {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HibernateAwareObjectMapper() {
        Hibernate4Module hm = new Hibernate4Module();
        registerModule(hm);
 
        hm.configure(Hibernate4Module.Feature.FORCE_LAZY_LOADING, true);
        
        this.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
		this.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	    this.enable(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS);
	    this.disable(MapperFeature.DEFAULT_VIEW_INCLUSION );
    }
}