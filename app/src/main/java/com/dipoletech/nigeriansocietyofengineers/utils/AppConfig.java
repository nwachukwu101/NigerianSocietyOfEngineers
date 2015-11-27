package com.dipoletech.nigeriansocietyofengineers.utils;
/**
 * Created by DABBY(3pleMinds) on 23-Nov-15.
 */

/**
 * DABBY(3pleMinds) 23-Nov-15 8:10 AM 2015 11
 * 23 08 10 NigerianSocietyOfEngineers
 **/
public class AppConfig {

    //holds the base url
    private static final String URL_BASE = "http://192.168.42.254/api/public/";
    // Server user login url
    public static String URL_LOGIN = "http://api.openweathermap.org/data/2.5/weather?lat=35&lon=139&APPID=ad544e8d71b8c89491e2080d6d8ae1ac";
    //public static String URL_LOGIN = URL_BASE + "v1/auth/login";

    // Server user register url
    public static String URL_REGISTER = URL_BASE+"v1/auth/register";
}
