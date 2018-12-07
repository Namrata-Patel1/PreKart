package com.example.androidl.prekart.Model;


public class Food {
    private String Name,MenuId,Discount,Price,Image,Description;

    public Food() {
    }

    public Food(String name, String menuId, String discount, String price, String image, String description) {
        Name = name;
        MenuId = menuId;
        Discount = discount;
        Price = price;
        Image = image;
        Description = description;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String menuId) {
        MenuId = menuId;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
