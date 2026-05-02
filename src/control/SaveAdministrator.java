/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author dezqu
 */
public class SaveAdministrator {
    private static SaveAdministrator instance;
    
    private SaveAdministrator(){
    }
    
    public static SaveAdministrator getInstance() {
        if (instance == null) {
            instance = new SaveAdministrator();
        }
        return instance;
    }
    
    public void saveState(String state) {
    }

    public void loadState() {
        
    }
}
