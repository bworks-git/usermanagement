package com.osl.skygyft.um.json.jackson;

public interface DataView {
	boolean hasView();
	Class<? extends BaseView> getView();
	Object getData();
}
