package com.jdc.async;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/async", asyncSupported = true)
public class HelloAsync extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var out = resp.getWriter();

		var asyncContext = req.startAsync();
		asyncContext.setTimeout(2000);
		
		asyncContext.addListener(new HelloAsyncListener());
		
		if (null != req.getParameter("error")) {
			throw new RuntimeException("Error in Parameter!");	// If RuntimeException is throw, Asynchronous Event Listener will handle 
		}

		out.append("""
				<html>
				<head>
				<title>Async Servlet</title>
				</head>
				</body>
				<h1>Hello Async Servlet</h1>
				""");

		asyncContext.start(getTask("Job 1"));

		out.append("""
				<p>This is heavy weight process</p>
				<a href="async">Request Again</a>
				</html>
				""");
	}

	private Runnable getTask(String name) {
		return () -> {

			try {
				System.out.println("Heavy Weight Process %s Start!".formatted(name));
				Thread.sleep(10000);
				System.out.println("Heavy Weight Process %s end!".formatted(name));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		};
	}

}
