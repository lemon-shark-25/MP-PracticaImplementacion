
package domain;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class HunterCharacterBuilder {
    
    public Hunter hunterBuilder(){
        HunterCreator hunterCreator = new HunterCreator();
        Hunter hunter = hunterCreator.create();
        Scanner sc = new Scanner(System.in);
    }
    
    private setName(Hunter hunter, Scanner sc){
        String name;
        do{
            System.out.print("Elige el nombre de tu personaje");
            name = sc.nextLine();
        }while(name.isBlank());
        hunter.setName(name);
    }
    
    private setPower(Hunter hunter, Scanner sc){
        int power;
        do{
            try{
                System.out.print("Elige el poder de tu personaje, debe estar entre 1 y 5");
                power = Integer.parseInt(sc.nextLine());   
            }catch (NumberFormatException e){   
        }while(1);
        hunter.setName(power);
        }
    }
    
}
while (true) {
    try {
        System.out.print("Introduce salud (1-100): ");
        salud = Integer.parseInt(sc.nextLine());
        
        if (salud >= 1 && salud <= 100) {
            break; // Todo bien, salimos del bucle
        } else {
            System.out.println("Error: El número debe estar entre 1 y 100.");
        }
    } catch (NumberFormatException e) {
        System.out.println("¡Eso no es un número! Por favor, introduce solo dígitos.");
    }