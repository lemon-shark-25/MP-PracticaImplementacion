package interaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Vista encargada de renderizar la interfaz gráfica de los combates en consola.
 * Su responsabilidad es mostrar el registro (log) de lo que ocurre en la arena.
 * @author Miguel Pradillo Bartolomé
 */
public class BattleScreen implements Screen {

    // Lista para almacenar el registro de eventos del combate (daño, muertes, etc.)
    private List<String> battleLog;

    public BattleScreen() {
        this.battleLog = new ArrayList<>();
    }

    /**
     * Permite al BattleMode (Controlador) inyectar texto con lo que va pasando en la ronda.
     */
    public void addLogEntry(String logMessage) {
        this.battleLog.add(logMessage);
    }

    /**
     * Limpia el registro para futuros combates.
     */
    public void clearLog() {
        this.battleLog.clear();
    }

    @Override
    public char show() {
        System.out.println("\n=========================================================");
        System.out.println("                   ARENA DE COMBATE                      ");
        System.out.println("=========================================================");
        
        if (battleLog.isEmpty()) {
            System.out.println(" [ Los contendientes se preparan... El combate va a comenzar ]");
        } else {
            // Imprimimos todo el historial de la batalla
            for (String log : battleLog) {
                System.out.println(" " + log);
            }
        }
        
        System.out.println("=========================================================\n");
        
        // Al ser un combate automático, devolvemos un carácter de control genérico.
        // El BattleMode puede usar un Thread.sleep() entre rondas y volver a llamar a show()
        return 'B'; 
    }
}