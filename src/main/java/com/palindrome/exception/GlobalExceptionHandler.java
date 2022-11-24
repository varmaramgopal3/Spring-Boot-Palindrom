package com.palindrome.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.palindrome.controller.PalindromeController;
import com.palindrome.model.ErrorDetails;
import com.palindrome.model.ResponseMessage;

/**
 * @author RamGopalVarma
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger logger = LoggerFactory.getLogger(PalindromeController.class);
	
    /**
     * @param ex
     * @param request
     * @return ResponseEntity Object
     */
    @ExceptionHandler({ ConstraintViolationException.class })
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
    	logger.info("Entered into GlobalExceptionHandler::handleConstraintViolation");
    	List<String> errors = new ArrayList<String>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.add(violation.getRootBeanClass().getName() + " " + violation.getPropertyPath() + ": " + violation.getMessage());
        }
        ResponseMessage apiError =  new ResponseMessage(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
        logger.info("End of GlobalExceptionHandler::handleConstraintViolation");
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }	
    /**
     * @param ex
     * @param request
     * @return ResponseEntity Object
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
    	logger.info("Entered into GlobalExceptionHandler::handleAllExceptions");
    	ErrorDetails exceptionResponse = new ErrorDetails(new Date(), "Allows Only Numbers", request.getDescription(false));
    	logger.info("End of GlobalExceptionHandler::handleAllExceptions");
    	return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
