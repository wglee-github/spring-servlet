package hello.servlet.basic.request;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.util.StreamUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "RequestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// request.getInputStream() 는 request의 body 내용을 byte 코드로 불러온다.
		ServletInputStream inputStream = request.getInputStream();
		// > inputStream은 byte 코드를 반환한다. byte 코드를 우리가 읽을 수 있는 문자(String)로 보려면 문자표 (Charset)를 지정해주어야 한다.
		String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
		System.out.println("messageBody = " + messageBody);
		
		response.getWriter().write("okd");
	}
}
