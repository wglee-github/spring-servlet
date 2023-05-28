package hello.servlet.web.frontController.v3;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import hello.servlet.web.frontController.ModelView;
import hello.servlet.web.frontController.MyView;
import hello.servlet.web.frontController.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontController.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontController.v3.controller.MemberSaveControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet{

	private Map<String, ControllerV3> controllerMap = new HashMap<>();
	
	public FrontControllerServletV3() {
		controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
		controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
		controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
	}



	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestURI = request.getRequestURI();
		
	 	ControllerV3 controllerV3 = controllerMap.get(requestURI); 
	 	if(controllerV3 == null) {
	 		response.setStatus(HttpServletResponse.SC_NOT_FOUND);
	 		return;
	 	}
	 	
	 	Map<String, String> paramMap = createParamMap(request);
	 	ModelView mv = controllerV3.process(paramMap);
	 	
	 	MyView myView = viewResolver(mv.getViewName());
	 	myView.render(mv.getModel(), request, response);
	}
	
	public Map<String, String> createParamMap(HttpServletRequest request){
		Map<String, String> paramMap = new HashMap<>();
		request.getParameterNames().asIterator().forEachRemaining(param -> paramMap.put(param, request.getParameter(param)));
		return paramMap;
	}
	
	public MyView viewResolver(String viewName) {
		return new MyView("/WEB-INF/views/" + viewName + ".jsp");
	}
}
