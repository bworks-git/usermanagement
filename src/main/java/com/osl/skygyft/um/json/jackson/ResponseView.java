package com.osl.skygyft.um.json.jackson;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ResponseView {
	public Class<? extends BaseView> value();
}
