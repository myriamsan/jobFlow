error id: file:///C:/Users/myria/Documents/Angular/JobFlow/src/main/java/com/example/JobFlow/Exceptions/GlobalExceptionHandler.java:_empty_/CompanyNotFoundException#
file:///C:/Users/myria/Documents/Angular/JobFlow/src/main/java/com/example/JobFlow/Exceptions/GlobalExceptionHandler.java
empty definition using pc, found symbol in pc: _empty_/CompanyNotFoundException#
semanticdb not found
empty definition using fallback
non-local guesses:

offset: 600
uri: file:///C:/Users/myria/Documents/Angular/JobFlow/src/main/java/com/example/JobFlow/Exceptions/GlobalExceptionHandler.java
text:
```scala
package com.example.JobFlow.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ApplicationNotFoundException.class)
    public ResponseEntity<String> handleCandidatureNotFound(ApplicationNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(@@CompanyNotFoundException.class)
    public ResponseEntity<String> handleCandidatureNotFound(ApplicationNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: _empty_/CompanyNotFoundException#