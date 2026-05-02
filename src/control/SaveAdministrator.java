/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
/**
 *
 * @author dezqu
 */
public class SaveAdministrator {
    private static SaveAdministrator instance;
    private final String FILE_NAME = "save_data.txt";
    
    private SaveAdministrator(){
    }
    
    public static SaveAdministrator getInstance() {
        if (instance == null) {
            instance = new SaveAdministrator();
        }
        return instance;
    }
    
    public void saveState(String state) {
        try (FileWriter writer = new FileWriter(FILE_NAME)) {
            writer.write(state);
        } catch (Exception e) {
           
        }
    }

    public String loadState() {
        String content = "";
        try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
            
            if (scanner.hasNextLine()) {
                content = scanner.useDelimiter("\\Z").next();
            }
        } catch (Exception e) {}
        return content;
        }
}
