package hello.servlet.basic.response;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ResponseHeaderServlet", urlPatterns = "/reponse-header")
public class ResponseHeaderServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//[status-line]
		response.setStatus(HttpServletResponse.SC_OK);

		//[response-headers]
//		response.setHeader("Content-Type", "text/plan;charset=utf-8");	// charset을 utf-8로 지정하지 않으면 한글 깨짐
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");	// 캐시 무효화
		response.setHeader("Pragma", "no-cache");
		response.setHeader("my-header", "hello");
		
		//[Header 편의 메서드]
		content(response);
		cookie(response);
		redirect(response); 
		
		//[message body]
		PrintWriter writer = response.getWriter();
		writer.print("안녕하세요");
		
	}
	
	// content 편의 메소드
	private void content(HttpServletResponse response) {
		//Content-Type: text/plain;charset=utf-8
		//Content-Length: 2
		//response.setHeader("Content-Type", "text/plain;charset=utf-8");
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");
		//response.setContentLength(2); //(생략시 자동 생성)
	}
	
	/**
	 *  쿠키 편의 메소드
	 *  최초 응답 시 쿠키를 헤더에 넣어서 보내면 다음 요청 시 무조건 Cookie 정보를 담아서 요청한다.
	 */
	private void cookie(HttpServletResponse response) {
		 //Set-Cookie: myCookie=good; Max-Age=600;
//		 response.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
		 Cookie cookie = new Cookie("myCookie", "good");
		 cookie.setMaxAge(600); //600초
		 response.addCookie(cookie);
	}
	
	/**
	 * redirect 편의 메소드 
	 * 
	 * 응답 받는 브라우저에서 302코드를 받으면 응답 헤더의 Location 값으로 요청을 전환한다.
	 */
	private void redirect(HttpServletResponse response) throws IOException {
		/**
		* 응답 메세지
		* Status Code 302
		* Location: /basic/hello-form.html
		*/
//		response.setStatus(HttpServletResponse.SC_FOUND); //302
//		response.setHeader("Location", "/basic/hello-form.html");
		
		/**
		 *  sendRedirect 메소드를 사용하면 자동으로 302 값이 들어간다.
		 */
		response.sendRedirect("/basic/hello-form.html");
	}
}
