import java.io.*;
import java.sql.SQLOutput;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //instancias útiles:
        Scanner input = new Scanner(System.in);
        int opc = 1;
        System.out.println("Bienvenido al gestor de pacientes del centro medico");
        VectorHeap<Patient> hospitalTurns = new VectorHeap<>();
        System.out.println("Ingrese el path del archivo de texto");
        String path = input.next();
        String cadena;
        String texto = "";
        try {
            FileReader f = new FileReader(path);
            BufferedReader b = new BufferedReader(f);
            while ((cadena = b.readLine()) != null) {
                texto = texto + cadena + ",";
            }
            b.close();
        } catch (IOException e) {
            System.out.println("No se puede leer el archivo!");
        }

        //agregar la lectura del archivo


        String[] patientsData = texto.split(",");
        for (int i = 0; i < patientsData.length; i += 3) {
            hospitalTurns.add(new Patient(patientsData[i], patientsData[i + 1], patientsData[i + 2]));
        }

        do {
            if (!hospitalTurns.isEmpty()) {
                System.out.println("Presion 1 para llamar al siguiente paciente");
                int nextPatient = input.nextInt();
                if (nextPatient == 1) {
                    Patient next = hospitalTurns.remove();
                    System.out.println("Paciente : \n" + next.getInfo() + " prioridad: " + next);
                }

                System.out.println("Presione un numero distinto a 1 para salir del programa ");
                opc = input.nextInt();

            } else {
                System.out.println("No hay pacientes en la sala");
                opc = 0;
            }
        } while (opc == 1);

    }

}
