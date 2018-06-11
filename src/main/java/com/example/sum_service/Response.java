package com.example.sum_service;

public class Response {
    private int sum;
    private int code;
    private String description;


    //конструктор для /add, /remove
    public Response(int code, String description) {
        this.code = code;
        this.description = description;
    }

    //конструктор для /sum
    public Response(int sum, int code, String description) {
        this.sum = sum;
        this.code = code;
        this.description = description;
    }


    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }



    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
