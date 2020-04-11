package com.jwala.recyclerviewbasicexampleonclick;

import android.os.Parcel;
import android.os.Parcelable;

public class EmployeeModel implements Parcelable {

    private int id;
    private String name;
    private int image;

    public EmployeeModel(int id) {
        this.id = id;
    }

    public EmployeeModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public EmployeeModel(int id, String name, int image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    protected EmployeeModel(Parcel in) {
        id = in.readInt();
        name = in.readString();
        image = in.readInt();
    }

    public static final Creator<EmployeeModel> CREATOR = new Creator<EmployeeModel>() {
        @Override
        public EmployeeModel createFromParcel(Parcel in) {
            return new EmployeeModel(in);
        }

        @Override
        public EmployeeModel[] newArray(int size) {
            return new EmployeeModel[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {

        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeInt(image);
    }
}
