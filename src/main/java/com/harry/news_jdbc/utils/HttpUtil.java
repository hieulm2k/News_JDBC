package com.harry.news_jdbc.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpUtil {
    private String value;

    public HttpUtil(String value){
        this.value = value;
    }

    public<T> T toModel(Class<T> tClass){
        try {
            return new ObjectMapper().readValue(value, tClass);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static HttpUtil of (BufferedReader reader){
        StringBuffer sb = new StringBuffer();
        String line;
        while(true){
            try {
                if (!((line = reader.readLine())!=null)) break;
                sb.append(line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new HttpUtil(sb.toString());
    }
}
