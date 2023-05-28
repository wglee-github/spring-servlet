package hello.servlet.web.frontController.v4;

import java.util.Map;

import hello.servlet.web.frontController.ModelView;

public interface ControllerV4 {

	String process(Map<String, String> paramMap, Map<String, Object> model);
}
