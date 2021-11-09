package com.example.kiemtra40;

public class LinhKien {
    private String anh;
    private String ten;
    private String gia;

    public LinhKien(String anh, String ten, String gia) {
        this.anh = anh;
        this.ten = ten;
        this.gia = gia;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
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
