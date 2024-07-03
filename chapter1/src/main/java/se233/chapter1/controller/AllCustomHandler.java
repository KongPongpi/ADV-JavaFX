package se233.chapter1.controller;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import se233.chapter1.Launcher;
import se233.chapter1.model.DamageType;
import se233.chapter1.model.character.BasedCharacter;
import se233.chapter1.model.character.PhysicalCharacter;
import se233.chapter1.model.item.Armor;
import se233.chapter1.model.item.BasedEquipment;
import se233.chapter1.model.item.Weapon;

import java.util.ArrayList;

public class AllCustomHandler {


    public static class GenCharacterHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent event) {
            Launcher.setMainCharacter(GenCharacter.setUpCharacter());
            if (Launcher.getEquippedWeapon() != null || Launcher.getEquippedArmor() != null ){
                Launcher.setUneqiupItem();
           }
            Launcher.refreshPane();
        }
    }

    // ข้อ 6
    public static void onDragOver(DragEvent event, String type) {
        Dragboard dragborad = event.getDragboard();
        BasedEquipment retrievedEquipment = (BasedEquipment)dragborad.getContent(BasedEquipment.DATA_FORMAT);
        if (dragborad.hasContent(BasedEquipment.DATA_FORMAT) && retrievedEquipment.getClass().getSimpleName().equals(type)) {
            if (retrievedEquipment.getDamageType() != null && retrievedEquipment.getDamageType() == Launcher.getMainCharacter().getType()){
                event.acceptTransferModes(TransferMode.MOVE);
            } else if (retrievedEquipment.getDamageType() == null && Launcher.getMainCharacter().getType() != DamageType.BTM ) {
                event.acceptTransferModes(TransferMode.MOVE);
            } else if (retrievedEquipment.getDamageType() != null && Launcher.getMainCharacter().getType() == DamageType.BTM){
                event.acceptTransferModes(TransferMode.MOVE);

            }
        }


    }
    public static void onDragDropped(DragEvent event, Label lbl, StackPane imgGroup) {
        boolean dragComplete = false;
        Dragboard dragboard = event.getDragboard();
        ArrayList<BasedEquipment> allEquipments = Launcher.getAllEquipments();
        if(dragboard.hasContent(BasedEquipment.DATA_FORMAT)) {
            BasedEquipment retrievedEquipment = (BasedEquipment)dragboard.getContent(BasedEquipment.DATA_FORMAT);
            BasedCharacter character = Launcher.getMainCharacter();
            if(retrievedEquipment.getClass().getSimpleName().equals("Weapon")) {
                if (Launcher.getEquippedWeapon() != null)
                    allEquipments.add(Launcher.getEquippedWeapon());
                Launcher.setEquippedWeapon((Weapon) retrievedEquipment);
                character.equipWeapon((Weapon) retrievedEquipment);
            } else {
                if (Launcher.getEquippedArmor() != null)
                    allEquipments.add(Launcher.getEquippedArmor());
                Launcher.setEquippedArmor((Armor) retrievedEquipment);
                character.equipArmor((Armor) retrievedEquipment);
            }
            Launcher.setMainCharacter(character);
            Launcher.setAllEquipments(allEquipments);
            Launcher.refreshPane();
            ImageView imgView = new ImageView();
            if (imgGroup.getChildren().size()!=1) {
                imgGroup.getChildren().remove(1);
                Launcher.refreshPane();
            }
            lbl.setText(retrievedEquipment.getClass().getSimpleName() + ":\n" + retrievedEquipment.getName());
            imgView.setImage(new Image(Launcher.class.getResource(retrievedEquipment.getImagepath()).toString()));
            imgGroup.getChildren().add(imgView);
            dragComplete = true;
        }
        event.setDropCompleted(dragComplete);
    }

    // ข้อ 3
    public static void onEquipDone(DragEvent event) {
        Dragboard dragboard = event.getDragboard();
        ArrayList<BasedEquipment> allEquipments = Launcher.getAllEquipments();
        BasedEquipment retrievedEquipment = (BasedEquipment)dragboard.getContent(BasedEquipment.DATA_FORMAT);
        int pos = -1;
        for(int i = 0 ; i < allEquipments.size() ; i++) {
            if(allEquipments.get(i).getName().equals(retrievedEquipment.getName())) {
                pos = i;
            }
        }
        if (event.getTransferMode() == TransferMode.MOVE) {
            if (pos != -1) {
                allEquipments.remove(pos);
            }
        }
        Launcher.setAllEquipments(allEquipments);
        Launcher.refreshPane();
    }

    public static void onDragDetected(MouseEvent event, BasedEquipment equipment, ImageView imgView) {
        Dragboard db = imgView.startDragAndDrop(TransferMode.ANY);
        db.setDragView(imgView.getImage());
        ClipboardContent content = new ClipboardContent();
        content.put(equipment.DATA_FORMAT, equipment);
        db.setContent(content);
        event.consume();
    }
}
