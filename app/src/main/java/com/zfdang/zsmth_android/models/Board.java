package com.zfdang.zsmth_android.models;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by zfdang on 2016-3-14.
 */
public class Board implements Externalizable{

    // for Externalizable
    static final long serialVersionUID = 20160322L;

    // 具体的版面
    // http://www.newsmth.net/nForum/#!board/DrivingStudy
    private String boardID;
    private String boardEngName;  // Android
    private String boardChsName;  // 安卓系统设备
    private String categoryName;  // 电脑技术
    private String moderator; // 版主

    // 可能是个版面的目录，而不是具体的版面
    // http://www.newsmth.net/nForum/#!section/Automobile
    private boolean isFolder;
    private String folderName;  // 汽车
    private String folderID;    // Automobile

    // http://stackoverflow.com/questions/21966784/reading-object-from-file-throws-illegalaccessexception
    // used by readObject
    public Board(){
    }

    public Board(String id, String chsName, String enName) {
        isFolder = false;
        this.boardID = id;
        this.boardChsName = chsName;
        this.boardEngName = enName;
    }


    public Board(String folderID, String folderName) {
        isFolder = true;
        this.folderID = folderID;
        this.folderName = folderName;
        this.categoryName = "目录";
    }

    public String getBoardID() {
        return boardID;
    }

    public String getBoardEngName() {
        return boardEngName;
    }

    public String getBoardChsName() {
        return boardChsName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getModerator() {
        return moderator;
    }

    public boolean isFolder() {
        return isFolder;
    }

    public String getFolderName() {
        return folderName;
    }

    public String getFolderID() {
        return folderID;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setModerator(String moderator) {
        this.moderator = moderator;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardID='" + boardID + '\'' +
                ", boardEngName='" + boardEngName + '\'' +
                ", boardChsName='" + boardChsName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", moderator='" + moderator + '\'' +
                ", isFolder=" + isFolder +
                ", folderName='" + folderName + '\'' +
                ", folderID='" + folderID + '\'' +
                '}';
    }

    @Override
    public void readExternal(ObjectInput input) throws IOException, ClassNotFoundException {
        boardID = (String) input.readObject();
        boardEngName = (String) input.readObject();
        boardChsName = (String) input.readObject();
        categoryName = (String) input.readObject();
        moderator = (String) input.readObject();

        isFolder = input.readBoolean();
        folderID = (String) input.readObject();
        folderName = (String) input.readObject();
    }

    @Override
    public void writeExternal(ObjectOutput output) throws IOException {
        output.writeObject(boardID);
        output.writeObject(boardEngName);
        output.writeObject(boardChsName);
        output.writeObject(categoryName);
        output.writeObject(moderator);

        output.writeBoolean(isFolder);
        output.writeObject(folderID);
        output.writeObject(folderName);
    }
}
