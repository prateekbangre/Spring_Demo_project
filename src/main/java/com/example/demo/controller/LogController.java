package com.example.demo.controller;

import com.example.demo.controller.request.LogRequest;
import com.example.demo.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

/**
 * @author prateek.bangre on 08/11/21.
 * @Project demo
 */

@RestController
@RequestMapping("v1/log")
public class LogController {

    @Autowired
    LogService logService;

    @PostMapping
    public ResponseEntity<String> newLog(@RequestBody LogRequest logRequest) throws ParseException {

        logService.publishToSubs(logRequest);
        return  new ResponseEntity<>("done", HttpStatus.OK);
    }



}
