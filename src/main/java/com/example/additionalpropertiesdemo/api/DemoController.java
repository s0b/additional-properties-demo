package com.example.additionalpropertiesdemo.api;

import com.example.mock.api.MockApi;
import com.example.mock.client.ApiException;
import com.example.mock.model.MockResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/")
public class DemoController {

  @GetMapping(path="load", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody MockResponseDto getTestData() throws ApiException {
      return new MockApi().getMockData();
  }

  @GetMapping(path = "mock", produces = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody Object getMockObject() throws IOException {
    Resource resource = new ClassPathResource("/static/data.json");
    ObjectMapper mapper = new ObjectMapper();

    return mapper.readValue(resource.getInputStream(), Object.class);
  }

}
