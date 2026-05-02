package control;

import domain.*;
import interaction.BattleScreen;
import interaction.Screen;

import java.util.Random;

/**
 * Controlador encargado de gestionar la lógica y el flujo de los combates.
 * Aplica las reglas matemáticas de dados, la absorción de daño por esbirros
 * y el resultado final de los desafíos.
 * @author Miguel Pradillo Bartolomé
 */
public class BattleMode implements Mode {

    private SaveAdministrator saveAdmin;
    private Random dice;

    public BattleMode() {
        this.saveAdmin = new SaveAdministrator();
        this.dice = new Random();
    }

    /**
     * Método principal que ejecuta la lógica de un combate entre dos jugadores.
     * @param challenge El desafío validado y aceptado que se va a resolver.
     */
    public void executeCombat(Challenge challenge) {
        Player j1 = challenge.getChallenger();
        Player j2 = challenge.getChallenged();

        GameCharacter c1 = j1.getCharacter();
        GameCharacter c2 = j2.getCharacter();

        int round = 1;
        boolean combatEnded = false;

        // Instanciamos la pantalla para ir imprimiendo el Log (opcional según cómo gestionéis la UI)
        BattleScreen screen = new BattleScreen();

        while (!combatEnded) {
            // 1. Calcular potenciales de Ataque y Defensa (Poder + Equipo + Habilidad + Modificadores)
            // Nota: Aquí delegaríamos en StatsCalculator o en el propio GameCharacter
            int attackPotentialC1 = calculateAttackPotential(c1);
            int defensePotentialC1 = calculateDefensePotential(c1);
            
            int attackPotentialC2 = calculateAttackPotential(c2);
            int defensePotentialC2 = calculateDefensePotential(c2);

            // 2. Lanzamiento de dados y cálculo de éxitos (Resultados de 5 o 6)
            int successesAttackC1 = rollDiceAndCountSuccesses(attackPotentialC1);
            int successesDefenseC1 = rollDiceAndCountSuccesses(defensePotentialC1);
            
            int successesAttackC2 = rollDiceAndCountSuccesses(attackPotentialC2);
            int successesDefenseC2 = rollDiceAndCountSuccesses(defensePotentialC2);

            // 3. Resolución simultánea de la ronda
            int damageToC2 = Math.max(0, successesAttackC1 - successesDefenseC2);
            int damageToC1 = Math.max(0, successesAttackC2 - successesDefenseC1);

            applyDamage(c2, damageToC2);
            applyDamage(c1, damageToC1);

            // 4. Comprobación de fin de combate
            if (c1.getHealth() <= 0 || c2.getHealth() <= 0) {
                combatEnded = true;
                resolveCombatResults(j1, j2, c1, c2, challenge.getGoldBet());
            }
            round++;
        }
    }

    /**
     * Lanza N dados (caras 1-6) y cuenta cuántos son éxitos (5 o 6).
     */
    private int rollDiceAndCountSuccesses(int potential) {
        int successes = 0;
        for (int i = 0; i < potential; i++) {
            int roll = dice.nextInt(6) + 1; // Genera número entre 1 y 6
            if (roll >= 5) {
                successes++;
            }
        }
        return successes;
    }

    /**
     * Aplica el daño siguiendo la regla de negocio: Primero sufren los esbirros.
     */
    private void applyDamage(GameCharacter character, int damage) {
        for (int i = 0; i < damage; i++) {
            Minion minion = character.getMinion();
            
            // Si tiene esbirro y está vivo, el daño va al esbirro
            if (minion != null && minion.getHealth() > 0) {
                minion.setHealth(minion.getHealth() - 1);
            } else {
                // Si no hay esbirros o están muertos, el daño va al personaje
                character.setHealth(character.getHealth() - 1);
            }
        }
    }

    /**
     * Resuelve el final del combate, reparte el oro y guarda el estado.
     */
    private void resolveCombatResults(Player j1, Player j2, GameCharacter c1, GameCharacter c2, int goldBet) {
        if (c1.getHealth() <= 0 && c2.getHealth() <= 0) {
            // Empate: Ambos mueren en la misma ronda. No se transfiere oro.
            System.out.println("¡El combate ha terminado en EMPATE!");
        } else if (c1.getHealth() > 0) {
            // Gana J1
            j1.setGold(j1.getGold() + goldBet);
            System.out.println("¡El vencedor es " + j1.getNick() + "!");
        } else {
            // Gana J2
            j2.setGold(j2.getGold() + goldBet);
            System.out.println("¡El vencedor es " + j2.getNick() + "!");
        }

        // Guardamos los cambios en el sistema de persistencia
        saveAdmin.saveState();
    }

    // --- Métodos dummy de cálculo  ---
    private int calculateAttackPotential(GameCharacter c) {
        return c.getPower() + 2; // Ejemplo simplificado (Poder + Equipo + Modificadores)
    }

    private int calculateDefensePotential(GameCharacter c) {
        return c.getPower() + 1; // Ejemplo simplificado
    }

    // --- Métodos obligatorios de la interfaz Mode ---
    @Override
    public char showScreen(Screen screen) {
        screen.show();
        return '0'; // Carácter de control de flujo
    }

    @Override
    public Screen doAction(char action) {
        // Aquí se rutearía a la pantalla de menú correspondiente tras el combate
        return null; 
    }
}