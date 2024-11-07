package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users") // 클래스 단위로 경로설정 가능
public class MappingClassController {
	
	// 요청매핑 API예시 
	
	// 목록조회
    @GetMapping
    public String user() {
        return "get users";
    }
    
    // 등록
    @PostMapping
    public String addUser() {
        return "post user";
    }
    
    // 단일 조회 
    // @PathVariable 어노테이션으로 변수 경로를 지정 할 수 있다.
    @GetMapping("/{userId}")
    public String findUser(@PathVariable("userId") String userId) {
        return "get userId=" + userId;
    }
    
    // 수정
    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable("userId") String userId) {
        return "update userId=" + userId;
    }
    
    // 삭제
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable("userId") String userId) {
        return "delete userId=" + userId;
    }

}
