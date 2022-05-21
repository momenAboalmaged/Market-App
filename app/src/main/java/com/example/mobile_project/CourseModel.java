package com.example.mobile_project;

import java.io.Serializable;

public class CourseModel implements Serializable {

    private int item_img;
    private String item_name;
    private String item_disc;
    private String item_price;
    private int plus_img;
    private String cart_quantity;
    private int minus_img;


    public CourseModel (int item_img,String item_name, String item_disc,String item_price, int plus_img ,int minus_img)
    {
        this.item_img = item_img;
        this.item_name= item_name;
        this.item_disc= item_disc;
        this.item_price= item_price;
        this.plus_img = plus_img;
        this.cart_quantity="1";
        this.minus_img= minus_img;




    }
    public int getItem_img()
    {
        return item_img;
    }
    public void setItem_img(int item_img)
    {
        this.item_img= item_img;
    }

    public String getItem_name()
    {
        return item_name;
    }
    public void setItem_name(String item_name)
    {
        this.item_name= item_name;
    }

    public String getItem_disc()
    {
        return item_disc;
    }
    public void setItem_disc(String item_disc)
    {
        this.item_disc= item_disc;
    }

    public String getItem_price()
    {
        return item_price;
    }
    public void setItem_price(String item_price)
    {
        this.item_price= item_price;
    }

    public int getPlus_img()
    {
        return plus_img;
    }
    public void setPlus_img(int plus_img)
    {
        this.plus_img= plus_img;
    }

    public String getItem_count()
    {
        return cart_quantity;
    }
    public void setItem_count(String cart_quantity)
    {
        this.cart_quantity=cart_quantity;
    }

    public int getMinus_img() {return minus_img;}
    public void setCart_quantity(int minus_img) {this.minus_img=minus_img;}




}
