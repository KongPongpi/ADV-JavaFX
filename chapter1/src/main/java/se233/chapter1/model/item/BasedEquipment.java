package se233.chapter1.model.item;

import javafx.application.Application;
import javafx.scene.input.DataFormat;
import javafx.stage.Stage;
import se233.chapter1.model.DamageType;

import java.io.Serializable;

public class BasedEquipment implements Serializable {
    public static final DataFormat DATA_FORMAT = new DataFormat("src.main.java.se233.chapter1.model.item.BasedEquipment");
    protected  String name;
    protected  String imgpath;
    protected  DamageType DamageType;
    public String getName() {return name;}
    public DamageType getDamageType() {return DamageType;}
    public String getImagepath() {return imgpath;}
    public void setImgpath(String imgpath) {this.imgpath = imgpath;}
}
