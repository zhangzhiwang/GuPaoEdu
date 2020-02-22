package com.asiainfo.p5.designPatterns.lsp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class Father {
	public void met1(Map m) {}
	
	public Map met2() {
		return null;
	}
	
//	public abstract Map met3(Map m) throws IOException;
	
	public Map met4(HashMap m) {
		System.out.println("com.asiainfo.p5.designPatterns.lsp.Father.met4(Map)");
		return null;
	}
	
	public List getUserList() {
		List list =new ArrayList();
		
		try {
			System.out.println("do sth...");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
