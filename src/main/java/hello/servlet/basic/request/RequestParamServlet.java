package hello.servlet.basic.request;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "RequestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[전체 파라미터 조회] - start");
		/*
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			System.out.println(paramName + "=" + 
			request.getParameter(paramName));
		}
		*/
		/**
		 *  실제 URL은 http://localhost:8080/request-param?username=kim&age=20&username=lee
		 *  하지만 getParameterNames은 name 값 받는 메소드이다. request.getParameter 는 중복된 name이 있는 경우 첫번째 파라미터name에 해당되는 value만 나온다.
		 */
		request.getParameterNames().asIterator().forEachRemaining(paramName -> System.out.println(paramName + "=" + request.getParameter(paramName)));
		System.out.println("[전체 파라미터 조회] - end");
		System.out.println();

		System.out.println("[단일 파라미터 조회]");
		System.out.println("request.getParameter(username) = " + request.getParameter("username"));
		System.out.println("request.getParameter(age) = " + request.getParameter("age"));
		System.out.println();
		
		System.out.println("[이름이 같은 복수 파라미터 조회]");
		System.out.println("request.getParameterValues(username)");
		String[] usernames = request.getParameterValues("username");
		for (String name : usernames) {
				System.out.println("username=" + name);
		}
		
		response.getWriter().write("ok");
	
	}	
}
