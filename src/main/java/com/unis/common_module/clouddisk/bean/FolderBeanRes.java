package com.unis.common_module.clouddisk.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class FolderBeanRes implements Parcelable {
    //"directoryNumber":0,"fileNumber":2,"directorySize":40005
    private int directoryNumber;
    private int fileNumber;
    private long directorySize;
    private String fileConversionSize;
    ;


    protected FolderBeanRes(Parcel in) {
        directoryNumber = in.readInt();
        fileNumber = in.readInt();
        directorySize = in.readLong();
        fileConversionSize = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(directoryNumber);
        dest.writeInt(fileNumber);
        dest.writeLong(directorySize);
        dest.writeString(fileConversionSize);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<FolderBeanRes> CREATOR = new Creator<FolderBeanRes>() {
        @Override
        public FolderBeanRes createFromParcel(Parcel in) {
            return new FolderBeanRes(in);
        }

        @Override
        public FolderBeanRes[] newArray(int size) {
            return new FolderBeanRes[size];
        }
    };

    public String getFileConversionSize() {
        return fileConversionSize;
    }

    public void setFileConversionSize(String fileConversionSize) {
        this.fileConversionSize = fileConversionSize;
    }

    public int getDirectoryNumber() {
        return directoryNumber;
    }

    public void setDirectoryNumber(int directoryNumber) {
        this.directoryNumber = directoryNumber;
    }

    public int getFileNumber() {
        return fileNumber;
    }

    public void setFileNumber(int fileNumber) {
        this.fileNumber = fileNumber;
    }

    public long getDirectorySize() {
        return directorySize;
    }

    public void setDirectorySize(long directorySize) {
        this.directorySize = directorySize;
    }
}
