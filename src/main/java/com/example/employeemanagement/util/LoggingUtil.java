package com.example.employeemanagement.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("loggingUtil")
@Slf4j
public class LoggingUtil {

    private final ObjectMapper objectMapper;

    public LoggingUtil(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void startController(String controllerName, String methodName, Object headers, Object requestBody) {
        try {
            String headersString = objectMapper.writeValueAsString(headers);
            String requestBodyString = objectMapper.writeValueAsString(requestBody);

            log.info("Start {} - {} with headers {} request: {}", controllerName, methodName, headersString, requestBodyString);
        } catch (Exception exception) {
            log.error("Error occurred while logging controller start: {}", exception.getMessage(), exception);
        }
    }
}
