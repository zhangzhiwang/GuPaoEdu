package com.asiainfo.p6_2020.designPatterns.chainOfResponsibility;

public abstract class Handler {
	protected Handler nextHandler;

	public Handler getNextHandler() {
		return nextHandler;
	}

	public void setNextHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	protected abstract boolean handle(User user);
	
	static class Builder {
		public Handler head;// 维护一个单向链表
		private Handler tail;
		
		public Builder addHandler(Handler h) {// 使用链式编程
			if(h == null) {
				throw new NullPointerException("Param handler is null");
			}
			
			if(head == null) {
				head = tail = h;
				return this;
			}
			
			Handler t = tail;
			t.setNextHandler(h);
			tail = h;
			return this;
		}
	}
}
