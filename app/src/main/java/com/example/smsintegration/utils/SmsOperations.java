package com.example.smsintegration.utils;

public class SmsOperations {

    private static String filterMessage(String message) {
        message = message.replace("&", "&amp;");
        message = message.replace("#", ";hash");
        message = message.replace("+", "plus;");
//        message = message.replace(",", "comma;");
        return message;
    }




    public static String getSmsUrl(String templateid,String mobileNo, String message) {
        String msg = filterMessage(message);
        String url = "your_sms_domain_path?apikey=" + Constants.smsapikey /* +"&pass=" + Constants.password*/;
        url = url + "&senderid=" + Constants.senderId  + "&templateid=" + templateid +  "&number=" + mobileNo + "&message=" + msg/* + "&response=Y"*/;
        return url;
    }
}
