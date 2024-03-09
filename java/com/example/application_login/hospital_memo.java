package com.example.application_login;

public class hospital_memo {
    String hospital;
    String  time;
    String  memo;

    public hospital_memo(){}

    public hospital_memo(String hospital,String time,String memo){
        this.hospital=hospital;
        this.time=time;
        this.memo=memo;
    }

    public  String getHospital(){ return  hospital;}

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }



}
