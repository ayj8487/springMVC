package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

	// request (요청) 의  3가지 방식(1.쿼리파라미터,2.form데이터,3.httpMessageBody) 와 같이 
	// response(응답) 또한 3가지 방식이 존재한다. 
	// 1. 정적리소스  : HTML,CSS,js 를 제공할 때 쓰는 정적리소스
	// 2. 뷰템플릿   : 웹 브라우저에 동적인 HTML을 제공할 때 뷰 템플릿 사용
	// 3. HTTP 메시지 사용 : HTTP API 를 제공하는 경우에는 HTML 이 아니라 데이터를 전달해야 하므로, 
	//					  HTTP 메시지 바디에 JSON 같은 형식으로 데이터를 실어서 보낸다. 
	
	// 정적리소스 경로 : src/main/resources/static 하위로 브라우저에서 실행 
	// 뷰 템플릿 경로 : src/main/resources/templates 
	
	// 컨트롤러에서 thymeleaf 로 응답 
	
	// 1. ModelAndView 로 반환
	// ModelAndView 객체를 이용하여 data라는 이름으로 hello! 텍스트를 매핑
	// response/hello 에서 <p th:text="${data}">empty</p> data에 매핑된 데이터가 태그에 치환
	@RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!");
        return mav;
    }
	
	// 2. String 으로 반환
	// model 에 값을 저장하여 view 로 반환
    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "hello!");
        return "response/hello";
    }
    
    // 3. @RequestMapping 으로 직접 경로를 입력하여 view를 반환
    // * 권장하지 않음 
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello!");
    }

}
