package com.zet.framework.exception;

public class ScyllaException extends Exception {

	private static final long serialVersionUID = 2016808522898828950L;

	public ScyllaException(){
		super();
	}
	
	public ScyllaException(String msg){
		super(msg);
	}
	
	public ScyllaException(String msg,Throwable cause){
		super(msg,cause);
	}
	
	public ScyllaException(Throwable cause){
		super(cause);
	}
	
	
}
