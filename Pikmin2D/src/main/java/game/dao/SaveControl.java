package game.dao;

import game.ui.ItemUI;
import game.ui.pikmin.PikminUI;

import java.io.FileWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SaveControl {
    private final int saveNumber;
    private final String mapName;
    
    public SaveControl(int saveNumber, String mapName) {
        this.saveNumber = saveNumber;
        this.mapName = mapName;
    }
    
    public void save(ArrayList<ItemUI> collectedItemUIs, ArrayList<PikminUI> collectedPikminUIs) {
       try (FileWriter writer = new FileWriter(this.saveFileName(), true)) {
           for (ItemUI itemUI : collectedItemUIs) {
               if (!itemUI.isSaved()) {
                   itemUI.markAsSaved();
                   writer.append("Item," + itemUI.getId()); 
                   writer.append("\n");
               }        
           }          
           for (PikminUI pikminUI : collectedPikminUIs) {
               if (!pikminUI.isSaved()) {
                   pikminUI.markAsSaved();
                   writer.append("Pikmin," + pikminUI.getId()); 
                   writer.append("\n");
               }        
           }  
           writer.close();
       } catch (Exception e) {
           System.out.println("Error: " + e.getMessage());
       }
    }
    
    
    
    public void emptySave() {
        try (FileWriter writer = new FileWriter(this.saveFileName(), false)) {
           writer.close();
       } catch (Exception e) {
           System.out.println("Error: " + e.getMessage());
       }
    }
    
    public boolean hasBeenCollected(int id) {
        
        try (Scanner fReader = new Scanner(new File(this.saveFileName()))) {
            
            while (fReader.hasNextLine()) {
                String row = fReader.nextLine();
                String[] rowData = row.split(",");
                
                if (rowData[0].equals("Item")) {
                    if (Integer.valueOf(rowData[1]) == id) {
                        return true;
                    }
                } else if (rowData[0].equals("Pikmin")) {
                    if (Integer.valueOf(rowData[1]) == id) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return false;
    }
    
    public String saveFileName() {
        return "saves/save" + this.saveNumber + "/" + this.mapName + ".pkmps";
    }
    
    public String mapFileName() {
        return "maps/" + this.mapName + ".pkmp";
    }
}
