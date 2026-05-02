package interaction;

/**
 * Vista encargada de renderizar la interfaz de creación de personajes.
 * Implementa la interfaz Screen de la arquitectura principal.
 * @author Miguel Pradillo Bartolomé
 */
public class CharacterCreationScreen implements Screen {

    // Atributo opcional por si el Controlador (Mode) necesita pasarle un mensaje de error a la Vista
    private String feedbackMessage; 

    public CharacterCreationScreen() {
        this.feedbackMessage = "";
    }

    /**
     * Permite al controlador actualizar el mensaje de la pantalla antes de mostrarla
     * (útil si el usuario introduce un dato mal y hay que volver a repintar la pantalla).
     */
    public void setFeedbackMessage(String feedbackMessage) {
        this.feedbackMessage = feedbackMessage;
    }

    @Override
    public char show() {
        System.out.println("\n=========================================================");
        System.out.println("               FORJA DE NUEVO PERSONAJE                  ");
        System.out.println("=========================================================");
        System.out.println(" Bienvenido al abismo. El destino de tu linaje comienza aquí.");
        
        // Si hay algún mensaje del controlador (ej. "Nombre ya en uso"), lo mostramos
        if (feedbackMessage != null && !feedbackMessage.isEmpty()) {
            System.out.println("\n [!] AVISO: " + feedbackMessage);
        }
        
        System.out.println("\n Sigue las instrucciones del sistema para dar forma a tu campeón...");
        System.out.println("=========================================================\n");
        
        // Como el CharacterCreationMode (Controlador) es quien se encarga de usar el Scanner 
        // para pedir el nombre, estadísticas, etc., aquí simplemente devolvemos un carácter 
        // de control genérico para cumplir con la firma de la interfaz Screen.
        return 'C'; 
    }
}