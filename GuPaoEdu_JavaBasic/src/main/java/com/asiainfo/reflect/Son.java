package com.asiainfo.reflect;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
@MyAnnotation
public class Son extends Father implements GrandFather, Cloneable, Serializable {
	private String sonName;
	int sonAge;
	protected String sonAddr;
	public Date sonDate;

	private static String sonStaticName;
	static int sonStaticAge;
	protected static String sonStaticAddr;
	public static Date sonStaticDate;

	private final String sonFinalName = "";
	final int sonFinalAge = 0;
	protected final String sonFinalAddr = "";
	public final Date sonFinalDate = new Date();

	private static final String sonStaticFinalName = "";
	static final int sonStaticFinalAge = 0;
	protected static final String sonStaticFinalAddr = "";
	public static final Date sonStaticFinalDate = new Date();
	
	public Son() {}
	
	public Son(String sonName) {
		
	}
	
	public Son(String sonName, Date sonStaticDate) {
		
	}

	private String sonMet1(String s) {
		return "sonMet1";
	}

	String SonMet2(String s) {
		return "SonMet2";
	}

	protected String SonMet3(String s) {
		return "SonMet3";
	}

	public String SonMet4(String s) {
		return "SonMet4";
	}
	

	
	
	private static String staticsonMet1(String s) {
		return "statisonMet1";
	}
	
	static String staticSonMet2(String s) {
		return "staticSonMet2";
	}
	
	protected static String staticSonMet3(String s) {
		return "staticSonMet3";
	}
	
	public static String staticSonMet4(String s) {
		return "staticSonMet4";
	}
	
	
	
	
	
	private final String finalsonMet1(String s) {
		return "finalsonMet1";
	}
	
	final String finalSonMet2(String s) {
		return "finalSonMet2";
	}
	
	protected final String finalSonMet3(String s) {
		return "finalSonMet3";
	}
	
	public final String finalSonMet4(String s) {
		return "finalSonMet4";
	}
	
	
	
	
	
	private static final String staticFinalsonMet1(String s) {
		return "staticFinalsonMet1";
	}
	
	static final String staticFinalSonMet2(String s) {
		return "staticFinalSonMet2";
	}
	
	protected static final String staticFinalSonMet3(String s) {
		return "staticFinalSonMet3";
	}
	
	public static final String staticFinalSonMet4(String s) {
		return "staticFinalSonMet4";
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
