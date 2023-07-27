package com.hp.utlis;

import lombok.Data;

@Data
public class Result<T>{
    private  String message;
    private  Integer code;
    private  T data;
    public static <T> Result<T> success(){
        Result<T> res = new Result<>();
        res.setCode(200);
        return res;
    }
    public static <T> Result<T> success(T obj){
        Result<T> res = new Result<>();
        res.setCode(200);
        res.setData(obj);
        return res;
    }
    public static <T> Result<T> error(String message){
        Result<T> res = new Result<>();
        res.setCode(505);
        res.setMessage(message);
        return res;
    }
}
