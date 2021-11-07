package com.example.kiemtra40;

public class LinhKien {
    int anh;
    String ten;
    String gia;

    public LinhKien(int anh, String ten, String gia) {
        this.anh = anh;
        this.ten = ten;
        this.gia = gia;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
}
