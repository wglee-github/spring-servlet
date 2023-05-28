package hello.servlet.web.frontController.v1.controller;

import java.io.IOException;

import hello.servlet.web.frontController.v1.ControllerV1;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberFormControllerV1 implements ControllerV1{

	@Override
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewpath = "/WEB-INF/views/new-form.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewpath);
		dispatcher.forward(request, response);
	}

}
