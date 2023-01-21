package com.jdc.async.demo.interceptor;

public class ActionDispatcher {
	
	private Action action;
	private ActionInterceptor interceptor;
	
	public ActionDispatcher(Action action, ActionInterceptor ... interceptor) {
		super();
		this.action = action;
		this.interceptor = new ActionInterceptorChain(interceptor);
	}
	
	public void invokeAction() {
		try {
			//other concerns
			interceptor.preProcess(action);
			
			// Business Logic
			action.action();
			
			//other concerns
			interceptor.postProcess();
						
		} catch (Exception e) {
			//other concerns
			interceptor.onError();
		} finally {
			// other concerns
			interceptor.onFinish();
		}
		
	}
	
	public static void main(String[] args) {
		var interceptor1 = new CommonInterceptor();
		var interceptor2 = new OtherInterceptor();	
		
		var myAction = new MyAction();
		var dispatcher = new ActionDispatcher(myAction, interceptor1, interceptor2);
		dispatcher.invokeAction();
	}

}
