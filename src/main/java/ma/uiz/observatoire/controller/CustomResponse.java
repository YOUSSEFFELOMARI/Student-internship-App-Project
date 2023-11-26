package ma.uiz.observatoire.controller;

import ma.uiz.observatoire.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CustomResponse {

    public static ResponseEntity<Response> response(String message, HttpStatus status){
        Response response = new Response();
        response.setStatusCode(String.valueOf(status.value()));
        response.setStatusMsg(message);
        return ResponseEntity
                .status(status)
                .body(response);
    }

}
