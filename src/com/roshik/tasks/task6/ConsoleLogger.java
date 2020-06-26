package com.roshik.tasks.task6;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsoleLogger implements ILogger{

    @Override
    public void Log(String message){
        message =  new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date())
                +", имя компьютера: "+ConfigLogger.getComputerName()+
                ", имя пользователя: "+ConfigLogger.getUserName()
        +", сообщение: "+message;
        System.out.println(message);
    }

}

