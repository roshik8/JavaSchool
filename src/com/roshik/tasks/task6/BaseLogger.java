package com.roshik.tasks.task6;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BaseLogger implements ILogger{

    public void log(String message){
        message =  new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date())
                +", имя компьютера: "+ConfigLogger.getComputerName()+
                ", имя пользователя: "+ConfigLogger.getUserName()
                +", сообщение: "+message;
        logToTarget(message);
    }

    protected abstract void logToTarget(String message);
}
