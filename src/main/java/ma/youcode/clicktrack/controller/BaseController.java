package ma.youcode.clicktrack.controller;

import ma.youcode.clicktrack.dto.ApiError;
import ma.youcode.clicktrack.exception.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

public abstract class BaseController {
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiError> handleApi(ApiException error) {
        return ResponseEntity.status(error.getStatus()).body(
                new ApiError(error.getStatus(), error.getMessage()));
    }
    @ExceptionHandler({HttpMessageNotReadableException.class,
            MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ApiError> handleBadRequest(Exception error) {
        return ResponseEntity.badRequest().body(
                new ApiError(400, "JSON ou identifiant invalide"));
    }
}