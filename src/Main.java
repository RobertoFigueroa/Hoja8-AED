import java.io.*;
import java.sql.SQLOutput;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        //instancias útiles:
        VectorHeap<Patient> hospitalTurns = new VectorHeap<>();
        Scanner input = new Scanner(System.in);
        int opc = 1;
        Window w1 = new Window();
        w1.setVisible(true);



        System.out.println("Bienvenido al gestor de pacientes del centro medico");
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
        }
        catch(IOException e){
            System.out.println("No se puede leer el archivo!");
        }

        //agregar la lectura del archivo


        String[] patientsData =  texto.split(",");
        for(int i=0;i<patientsData.length;i+=3){
            hospitalTurns.add(new Patient(patientsData[i],patientsData[i+1],patientsData[i+2]));
        }/*

        do{
            if(!hospitalTurns.isEmpty()){
                System.out.println("Presion 1 para llamar al siguiente paciente");
                int nextPatient = input.nextInt();
                if(nextPatient == 1){
                    Patient next = hospitalTurns.remove();
                    System.out.println("Paciente : \n" + next.getInfo() + " prioridad: " + next);
                }

                System.out.println("Presione un numero distinto a 1 para salir del programa ");
                opc = input.nextInt();

            }

            else{
                System.out.println("No hay pacientes en la sala");
                opc = 0;
            }
        }while(opc == 1); */

      /*  PriorityQueue<Patient> fila = new PriorityQueue<>();

        Patient p1 = new Patient("carlos","dolor","C");
        Patient p2 = new Patient("carlos","dolor","A");
        Patient p3 = new Patient("carlos","dolor","B");
        Patient p4 = new Patient("carlos","dolor","E");
        fila.add(p1);
        fila.add(p2);
        fila.add(p3);
        fila.add(p4);


        System.out.println(fila.remove());
        System.out.println(fila.remove());

*/
    }

}
