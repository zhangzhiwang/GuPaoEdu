package com.asiainfo.reflect;

import java.util.Date;

public class Father {
	private String fatherName;
	int fatherAge;
	protected String fatherAddr;
	public Date fatherDate;

	private static String fatherStaticName;
	static int fatherStaticAge;
	protected static String fatherStaticAddr;
	public static Date fatherStaticDate;

	private final String fatherFinalName = "";
	final int fatherFinalAge = 0;
	protected final String fatherFinalAddr = "";
	public final Date fatherFinalDate = new Date();

	private static final String fatherStaticFinalName = "";
	static final int fatherStaticFinalAge = 0;
	protected static final String fatherStaticFinalAddr = "";
	public static final Date fatherStaticFinalDate = new Date();

	private String met1(String s) {
		return "met1";
	}

	String met2(String s) {
		return "met2";
	}

	protected String met3(String s) {
		return "met3";
	}

	public String met4(String s) {
		return "met4";
	}
	

	
	
	private static String staticMet1(String s) {
		return "statiMet1";
	}
	
	static String staticMet2(String s) {
		return "staticMet2";
	}
	
	protected static String staticMet3(String s) {
		return "staticMet3";
	}
	
	public static String staticMet4(String s) {
		return "staticMet4";
	}
	
	
	
	
	
	private final String finalMet1(String s) {
		return "finalMet1";
	}
	
	final String finalMet2(String s) {
		return "finalMet2";
	}
	
	protected final String finalMet3(String s) {
		return "finalMet3";
	}
	
	public final String finalMet4(String s) {
		return "finalMet4";
	}
	
	
	
	
	
	private static final String staticFinalMet1(String s) {
		return "staticFinalMet1";
	}
	
	static final String staticFinalMet2(String s) {
		return "staticFinalMet2";
	}
	
	protected static final String staticFinalMet3(String s) {
		return "staticFinalMet3";
	}
	
	public static final String staticFinalMet4(String s) {
		return "staticFinalMet4";
	}
}
