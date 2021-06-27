package com.example.min2;

public class thoiTiet {

    private String ngay;
    private int img;
    private String nhiet;

    public thoiTiet( String ngay,int img, String nhiet) {

        this.ngay = ngay;
        this.img = img;
        this.nhiet = nhiet;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getNhiet() {
        return nhiet;
    }

    public void setNhiet(String nhiet) {
        this.nhiet = nhiet;
    }
}
