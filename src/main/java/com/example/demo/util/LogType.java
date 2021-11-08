package com.example.demo.util;

import javax.swing.*;

/**
 * @author prateek.bangre on 08/11/21.
 * @Project demo
 */
public enum LogType {
    INFO("Info",5,5,10),
    WARNING("Warning", 10, 10, 20),
    CRITICAL("Critical", 10, 100, 100),
    BLOCKER("Blocker",10, 50, 50);

    public String name;
    public int maxFreq;
    public int diffTime;
    public int waitTime;

    LogType(String name, int maxFreq, int diffTime, int waitTime) {
        this.name = name;
        this.maxFreq = maxFreq;
        this.diffTime = diffTime;
        this.waitTime = waitTime;
    }

    public static int getDiffTimeByType(String type) {
        for(LogType log : LogType.values()){
            if (log.name.equals(type))
                return log.diffTime;
        }
        return 0;
    }
}
