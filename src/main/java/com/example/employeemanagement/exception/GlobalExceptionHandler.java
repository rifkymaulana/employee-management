package com.example.employeemanagement.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.employeemanagement.util.LoggingUtil;
import com.example.employeemanagement.util.ResponseUtil;
import jakarta.annotation.Nonnull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private final LoggingUtil loggingUtil;
    private final ResponseUtil responseUtil;

    @Autowired
    public GlobalExceptionHandler(LoggingUtil loggingUtil, ResponseUtil responseUtil) {
        this.loggingUtil = loggingUtil;
        this.responseUtil = responseUtil;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request
    ) {
        try {
            loggingUtil.startController("GlobalExceptionHandler", "handleMethodArgumentNotValid", headers, request);

            Map<String, List<String>> body = new HashMap<>();

            List<String> errors = ex.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
            body.put("errors", errors);

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(responseUtil.error("Validation error", HttpStatus.BAD_REQUEST, body));
        } catch (Exception exception) {
            log.error("Error occurred while handling method argument not valid: {}", exception.getMessage(), exception);
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(responseUtil.error(exception.getMessage()));
        }
    }
}
