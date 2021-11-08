package com.example.demo.controller.request;


import lombok.Data;

import java.util.Date;

/**
 * @author prateek.bangre on 08/11/21.
 * @Project demo
 */
@Data
public class LogRequest {
    String dateTime;
    String type;
    String data;
}
