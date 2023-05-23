package hello.servlet.basic;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 
 * @WebServlet 서블릿 애노테이션
	name: 서블릿 이름
	urlPatterns: URL 매핑
 */
@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet{

	/**
	 * HTTP 요청을 통해 매핑된 URL이 호출되면 서블릿 컨테이너는 다음 메서드를 실행한다.
		protected void service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HelloServlet.service");
		
		// 출력결과(Tomcat lib) : request = org.apache.catalina.connector.RequestFacade@7e979c05 ( HttpServletRequest 의 구현체 )
		System.out.println("request = " + request);
		// 출력결과(Tomcat lib) : response = org.apache.catalina.connector.ResponseFacade@1ddfbb4d ( HttpServletResponse 의 구현체 )
		System.out.println("response = " + response);
		
		String username = request.getParameter("username");
		System.out.println("username = " + username);
		
		response.setContentType("text/plan");	// 응답 헤더에 추가
		response.setCharacterEncoding("utf-8"); // 응답 헤더에 추가
		response.getWriter().write("hello " + username); // 응답 body에 데이터를 담아서 클라이언트에게 보내준다.
		
	}
}
