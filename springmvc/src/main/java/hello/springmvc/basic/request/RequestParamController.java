package hello.springmvc.basic.request;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RequestParamController {
	
	// 기존 서블릿으로 파라미터 받기
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));


        response.getWriter().write("ok");
    }
    
    // 에노테이션으로 파라미터 받기
    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge) {

        log.info("username={}, age={}", memberName, memberAge);
        return "ok";
    }
    
    // 에노테이션 value 값 생략가능 (스프링 3.2버전 기준)
    // 현재 버전은 파라미터 value 값을 지정하지 않으면 에러가 생길 수 있다.
    // -parameters 옵션을 추가 해야 value 생략가능 
    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age) {

        log.info("username={}, age={}", username, age);
        return "ok";
    }

    // 에노테이션과 벨류값 둘가 생략가능 (스프링 3.2버전 기준)
    // 마찬가지로 현재 버전은 파라미터 value 값을 지정하지 않으면 에러가 생길 수 있다.
    // 에노테이션 생략시 객체형:참조형(Reference Type) 은 @ModelAttribute 가 자동으로 붙고 
    // 					 기본형(Primitive Type) 은 @RequestParam 이 자동으로 붙는다. 
    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }
    
    // required로 필수 값 설정 가능 
    // required = true 일시 값이 무조건 들어와야 함
    // int 는 null 을 담을 수 없기 때문에 Integer로 받음
    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "age", required = false) Integer age) {

        log.info("username={}, age={}", username, age);
        return "ok";
    }
    
    // defaultValue 로 기본값 설정 가능 
    // 때문에 int 에 1을 기본값으로 받아 Integer 가 아니어도 값 전달 가능
    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(value = "username", required = true, defaultValue = "guest") String username,
            @RequestParam(value = "age", required = false, defaultValue = "1") int age) {

        log.info("username={}, age={}", username, age);
        return "ok";
    }
    
    // 파라미터를 Map 으로 받을 수 있음
    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }
    
    // 데이터 매핑 @ModelAttribute
    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }
    
    // 에노테이션 생략시 객체형:참조형(Reference Type) 은 @ModelAttribute 가 자동으로 붙고 
    // 					 기본형(Primitive Type) 은 @RequestParam 이 자동으로 붙는다. 
    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }
}
