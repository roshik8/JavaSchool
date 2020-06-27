package com.roshik.tasks.task6;

public class ConsoleLogger extends BaseLogger {

    @Override
    public void logToTarget(String message){
        System.out.println(message);
    }

}

