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
    
    /**
     * Creates save control object for specific file and map combination.
     * @param saveNumber The number of the save file
     * @param mapName The name of the map without file ending
     */
    public SaveControl(int saveNumber, String mapName) {
        this.saveNumber = saveNumber;
        this.mapName = mapName;
    }
    
    /**
     * Saves game progress to the save file.
     * @param collectedItemUIs The items colected by the recovey area
     * @param collectedPikminUIs  The Pikmin collected by the player
     */
    public void save(ArrayList<ItemUI> collectedItemUIs, ArrayList<PikminUI> collectedPikminUIs) {
        this.saveItemUI(collectedItemUIs);
        this.savePikminUI(collectedPikminUIs);
    }
    
    private void saveItemUI(ArrayList<ItemUI> collectedItemUIs) {
        try (FileWriter writer = new FileWriter(this.saveFileName(), true)) {
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
    
    private void savePikminUI(ArrayList<PikminUI> collectedPikminUIs) {
        try (FileWriter writer = new FileWriter(this.saveFileName(), true)) {
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
    
    /**
     * Removes all the text from the save file.
     */
    public void emptySave() {
        try (FileWriter writer = new FileWriter(this.saveFileName(), false)) {
            writer.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    /**
     * Tells wheter or not the object has been saved in the file.
     * @param id Object's id, refer's to the postion in the map file
     * @return Has object been saved to the file
     */
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
    
    /**
     * Returns the save file name in the form in which it is usable by methods.
     * @return The save file name with the file ending and required references to the position in the memory
     */
    public String saveFileName() {
        return "saves/save" + this.saveNumber + "/" + this.mapName + ".pkmps";
    }
    
    /**
     * Returns the map file name in the form in which it is usable by methods.
     * @return The map file name with the file ending and required references to the position in the memory
     */
    public String mapFileName() {
        return "maps/" + this.mapName + ".pkmp";
    }
}
