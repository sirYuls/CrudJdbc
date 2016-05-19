package com.mx.flisol.vo;

import java.lang.reflect.ParameterizedType;


public abstract class InterfaceObject<T> {
	protected final Class<T> type ;
	 
	@SuppressWarnings("unchecked")
	public InterfaceObject(){
		 this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class<T> getType() {
		return type;
	}
	
	
	 
	
}
