package com.sparta.springmvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.springmvc.response.Star;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JacksonTest {

    // objectMapper 를 사용하려면 해당 클래스에 get method 를 명시해주거나 @Getter 를 사용해 직렬화를 할 수 있게 해주어야 한다.
    @Test
    @DisplayName("Object to JSON : get Method 필요")
    void test1() throws JsonProcessingException {
        Star star = new Star("Robbie", 95);

        ObjectMapper objectMapper = new ObjectMapper(); // Jackson 라이브러리의 ObjectMapper
        String json = objectMapper.writeValueAsString(star);

        System.out.println("json = " + json);
    }

    // Json 의 key 값과 Java Entity 의 필드 변수명은 반드시 같게 해주어야 오류가 발생하지 않는다.
    @Test
    @DisplayName("JSON To Object : 기본 생성자 & (get OR set) Method 필요")
    void test2() throws JsonProcessingException {
        String json = "{\"name\":\"Robbie\",\"age\":95}"; // JSON 타입의 String

        ObjectMapper objectMapper = new ObjectMapper(); // Jackson 라이브러리의 ObjectMapper

        Star star = objectMapper.readValue(json, Star.class);
        System.out.println("star.getName() = " + star.getName());
        System.out.println("star.getAge() = " + star.getAge());
    }
}
