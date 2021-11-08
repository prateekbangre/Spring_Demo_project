package com.example.demo.service;

import com.example.demo.controller.request.LogRequest;
import com.example.demo.model.Log;
import com.example.demo.repository.LogRepository;
import com.example.demo.util.LogType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author prateek.bangre on 08/11/21.
 * @Project demo
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    LogRepository logRepository;
//    Publiser obj;
    @Override
    public void publishToSubs(LogRequest logRequest) throws ParseException {

        //save in db
        Log log = new Log();
        log.setType(logRequest.getType());
        log.setDateTime(logRequest.getDateTime());
        log.setData(logRequest.getData());
        logRepository.save(log);

        //get data or count by current time diff if achieve max send msg to sub else nothing need to be done
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(dateFormat.parse(logRequest.getDateTime()));
        LogType logType = LogType.valueOf(logRequest.getType().toUpperCase(Locale.ROOT));
        c.add(Calendar.SECOND, logType.diffTime);
        String endDateTime = dateFormat.format(c.getTime());
        int logCount = logRepository.getCountOfType(logRequest.getType(), logRequest.getDateTime(), endDateTime);

        //call inform subscriber or not
        if(logCount >= logType.maxFreq){
            System.out.println("publish the message to all the subscriber with the log type");
//            obj.message(logRequest.getType(), logRequest.getData());
        }
    }
}
