package com.unis.common_module.clouddisk.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class MoveCopyFileReqBean implements Parcelable {
    //    {
//  "reqType":"0",
//  "data":[
//    {"id": 20001,"type": "1"},
//    {"id": 10002,"type": "0"}
//  ],
//  "dirId": 20002
//    }
// reqType  0：移动 1：复制
    public static final String MOVE = "0";
    public static final String COPY = "1";

    private String reqType;
    private long dirId;
    private List<MoveChildFile> data;

    public MoveCopyFileReqBean(String reqType, long dirId, List<MoveChildFile> data) {
        this.reqType = reqType;
        this.dirId = dirId;
        this.data = data;
    }

    protected MoveCopyFileReqBean(Parcel in) {
        reqType = in.readString();
        dirId = in.readLong();
        data = in.createTypedArrayList(MoveChildFile.CREATOR);
    }

    public MoveCopyFileReqBean() {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(reqType);
        dest.writeLong(dirId);
        dest.writeTypedList(data);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MoveCopyFileReqBean> CREATOR = new Creator<MoveCopyFileReqBean>() {
        @Override
        public MoveCopyFileReqBean createFromParcel(Parcel in) {
            return new MoveCopyFileReqBean(in);
        }

        @Override
        public MoveCopyFileReqBean[] newArray(int size) {
            return new MoveCopyFileReqBean[size];
        }
    };

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }

    public long getDirId() {
        return dirId;
    }

    public void setDirId(long dirId) {
        this.dirId = dirId;
    }

    public List<MoveChildFile> getData() {
        return data;
    }

    public void setData(List<MoveChildFile> data) {
        this.data = data;
    }

    public static class MoveChildFile implements Parcelable {
        private String id;
        private String type;

        public MoveChildFile(String id, String type) {
            this.id = id;
            this.type = type;
        }

        protected MoveChildFile(Parcel in) {
            id = in.readString();
            type = in.readString();
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(type);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<MoveChildFile> CREATOR = new Creator<MoveChildFile>() {
            @Override
            public MoveChildFile createFromParcel(Parcel in) {
                return new MoveChildFile(in);
            }

            @Override
            public MoveChildFile[] newArray(int size) {
                return new MoveChildFile[size];
            }
        };

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

}
