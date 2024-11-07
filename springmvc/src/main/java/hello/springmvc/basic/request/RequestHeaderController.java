package hello.springmvc.basic.request;

import java.util.Locale;

import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RequestHeaderController {

    @RequestMapping("/headers")
    public String headers(HttpServletRequest request,
                          HttpServletRequest response,
                          HttpMethod httpMethod,
                          Locale locale,
                          @RequestHeader MultiValueMap<String, String> headerMap,
                          @RequestHeader("host") String host,
                          @CookieValue(value = "myCookie", required = false) String cookie
                          ) {

        log.info("request={}", request); // 요청정보
        log.info("response={}", response); // 응답정보
        log.info("httpMethod={}", httpMethod); // HTTP 메서드
        log.info("locale={}", locale); 		// 지역, 자주사용우선
        log.info("headerMap={}", headerMap); // 헤더 정보
        log.info("header host={}", host);	// 호스트
        log.info("myCookie={}", cookie); 	// 쿠키 정보
        return "ok";
    }
}
