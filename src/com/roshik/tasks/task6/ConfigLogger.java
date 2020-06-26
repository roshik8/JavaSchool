package com.roshik.tasks.task6;

import java.net.InetAddress;

 public class ConfigLogger {

    public static String getComputerName(){
        String computerName ="";
        try{
            computerName = InetAddress.getLocalHost().getHostName();
        }catch(Exception ex){
            computerName="имя не определено";
        }
        return computerName;
    }

    public static String getUserName(){

        return System.getProperty("user.name");
    }

}
