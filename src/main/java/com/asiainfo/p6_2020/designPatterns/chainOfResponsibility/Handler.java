package com.asiainfo.p6_2020.designPatterns.chainOfResponsibility;

public abstract class Handler {
	private Handler nextHandler;

	public Handler getNextHandler() {
		return nextHandler;
	}

	public void setNextHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	protected abstract boolean handle(User user);
}
