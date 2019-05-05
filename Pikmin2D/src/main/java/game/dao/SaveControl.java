package game.dao;

import game.ui.ItemUI;

import java.io.FileWriter;
import java.util.ArrayList;

public class SaveControl {
    
    public static void save(int saveNumber, String mapName, ArrayList<ItemUI> collectedItemUIs) {
       try (FileWriter writer = new FileWriter("saves/save" + saveNumber + "/" + mapName + ".pkmps", true)) {
           for (ItemUI itemUI : collectedItemUIs) {
               if (!itemUI.isSaved()) {
                   itemUI.markAsSaved();
                   writer.append("Item," + itemUI.getId()); 
                   writer.append("\n");
               }        
           }          
           writer.close();
       } catch (Exception e) {
           System.out.println("Error: " + e.getMessage());
       }
    }
}
