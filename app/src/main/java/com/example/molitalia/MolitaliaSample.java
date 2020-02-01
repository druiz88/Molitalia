package com.example.molitalia;

import java.io.Serializable;

class MolitaliaSample implements Serializable {
    private int Code;
    private String Text;
    private int Pal;

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public int getPal() {
        return Pal;
    }

    public void setPal(int pal) {
        Pal = pal;
    }

    @Override
    public String toString() {
        return "MolitaliaSample{" +
                "Code=" + Code +
                ", Text=" + Text +
                ", Pal=" + Pal +
                '}';
    }
}
