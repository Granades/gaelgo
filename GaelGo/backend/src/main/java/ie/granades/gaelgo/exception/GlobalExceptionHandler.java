package ie.granades.gaelgo.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ApiError handleIllegalArgument(IllegalArgumentException ex, HttpServletRequest req) {

        return new ApiError(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                req.getRequestURI(),
                LocalDateTime.now()
        );
    }

    @ExceptionHandler(RuntimeException.class)
    public ApiError handleRuntime(RuntimeException ex, HttpServletRequest req) {
        return new ApiError(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                req.getRequestURI(),
                LocalDateTime.now()
        );

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiError handleValidation(MethodArgumentNotValidException ex, HttpServletRequest req) {
        String message = ex.getBindingResult().getFieldErrors().stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .findFirst()
                .orElse("Validation error");

        return new ApiError(
                HttpStatus.BAD_REQUEST.value(),
                message,
                req.getRequestURI(),
                LocalDateTime.now()


        );
    }



}
