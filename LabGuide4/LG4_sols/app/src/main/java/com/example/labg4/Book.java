package com.example.labg4;


import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {

    String name;
    int id;
    int price;
    int imgId;

    public Book(String name, int id, int price,int imgId) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.imgId = imgId;
    }

    protected Book(Parcel in) {
        name = in.readString();
        id = in.readInt();
        price = in.readInt();
        imgId = in.readInt();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(id);
        dest.writeInt(price);
        dest.writeInt(imgId);
    }
}
