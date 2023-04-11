import java.util.ArrayList;

class Main{
    String id_proceso;
    int cedula;
    int tiempo_cpu;

    public Main(String id_proceso, int cedula, int tiempo_cpu) {
        this.id_proceso = id_proceso;
        this.cedula = cedula;
        this.tiempo_cpu = tiempo_cpu;
    }
}

public class RoundRobin {
    public static void main(String[] args) {
        ArrayList<Proceso> cola_procesos = new ArrayList<Proceso>();
        cola_procesos.add(new Proceso("P1", 1002856059, 100));
        cola_procesos.add(new Proceso("P2", 1714196743, 15));
        cola_procesos.add(new Proceso("P3", 1456756888, 40));

        int cuanto = 20;
        int tiempo = 0;

        while (!cola_procesos.isEmpty()) {
            Proceso proceso = cola_procesos.remove(0);
            System.out.println("Tiempo " + tiempo + ": " + proceso.id_proceso + " entra a ejecución.");

            if (proceso.tiempo_cpu <= cuanto) {
                tiempo += proceso.tiempo_cpu;
                System.out.println("Tiempo " + tiempo + ": " + proceso.id_proceso + " termina su ejecución.");
            } else {
                tiempo += cuanto;
                proceso.tiempo_cpu -= cuanto;
                System.out.println("Tiempo " + tiempo + ": " + proceso.id_proceso + " se conmuta. Pendiente por ejecutar " + proceso.tiempo_cpu + " ms.");
                cola_procesos.add(proceso);
            }
        }
    }
}