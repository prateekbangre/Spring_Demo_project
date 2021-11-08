package com.example.demo.service;

import com.example.demo.controller.request.LogRequest;

import java.text.ParseException;

/**
 * @author prateek.bangre on 08/11/21.
 * @Project demo
 */
public interface LogService {
    void publishToSubs(LogRequest logRequest) throws ParseException;
}
