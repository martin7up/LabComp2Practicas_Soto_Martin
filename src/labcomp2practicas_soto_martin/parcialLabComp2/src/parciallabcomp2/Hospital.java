
package parciallabcomp2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


public class Hospital {
    static Scanner sc = new Scanner(System.in);
    
   
    public static void main(String[] args) {
        ArrayList<Paciente> pacientes = new ArrayList();
     int opcion = 0;
        Doctor doctor1 = new Doctor("Juan","06/09/1980",445213,"Neumonologo");
        Doctor doctor2 = new Doctor("Pedro","02/09/1981",433213,"Clinico");
        Doctor doctor3 = new Doctor("Daio","02/06/1999",421213,"Cardiologo");
        ArrayList<Doctor> doctores = new ArrayList();
        doctores.add(doctor1);
        doctores.add(doctor2);
        doctores.add(doctor3);
    
        while(opcion!=8){
            switch(opcion){
                case 1: Hospital.mostrarDoctores(doctores);
                        System.out.println("\n");
                        break;
                case 2: //
                        System.out.print("Nombe paciente : >>> ");
                        String nombre = sc.nextLine();
                        System.out.print("Dni paciente : >>> ");
                        int dni = sc.nextInt();
                        System.out.print("Fecha de Nacimiento (dd/mm/aaaa) paciente : >>> ");
                        String fechaNac = sc.nextLine();
                        System.out.print("Num Tel paciente : >>> ");
                        int numTel = sc.nextInt();
                        System.out.print("Tipo Sange paciente : >>> ");
                        int sngre = sc.nextInt();
                        //
                        Paciente pacienteNuevo = new Paciente(nombre, fechaNac, dni, numTel, sngre, null);
                        pacientes.add(pacienteNuevo);
                        System.out.println("Paciente Agregado.");
                        //
                        break;
                case 3: System.out.print("Dni : >>> ");
                        int dniBuscado = sc.nextInt();
                        for(int i = 0; i<pacientes.size(); i++){
                            if(pacientes.get(i).getDni() == dniBuscado){
                                
                                System.out.print("Nombe paciente : >>> ");
                                String nnombre = sc.nextLine();
                                System.out.print("Num Tel paciente : >>> ");
                                int nnumTel = sc.nextInt();
                                System.out.print("Fecha de Nacimiento (dd/mm/aaaa) paciente : >>> ");
                                String nfechaNac = sc.nextLine();
                                System.out.print("Tipo Sange paciente : >>> ");
                                int nsngre = sc.nextInt();
                                Paciente pacienteMod = new Paciente(nnombre, nfechaNac, dniBuscado, nnumTel, nsngre, pacientes.get(i).getHistorial());
                                pacientes.remove(pacientes.get(i).getDni());
                                pacientes.add(pacienteMod);
                                System.out.println("Paciente Actualizado!");
                            }                             
                        }                       
                        break;
                case 4: System.out.println("Indique el DNI del paciente a buscar ");
                        dni = sc.nextInt();
                        for(int i = 0; i<pacientes.size(); i++){
                            if(pacientes.get(i).getDni() == dni){
                                if(pacientes.get(i).getDni() == dni){
                                    pacientes.get(i).verHistorialDeEventos();
                                }
                            }}
                        break;
                case 5: System.out.println("Indique el DNI del paciente a buscar ");
                        dni = sc.nextInt();
                        for(int i = 0; i<pacientes.size(); i++){
                            if(pacientes.get(i).getDni() == dni){
                                System.out.println("Nuevo Historial");
                                System.out.print("Fecha : ");
                                String fecha = sc.nextLine();
                                System.out.print("Evento : ");
                                String obsevacion = sc.nextLine();
                                Evento nuevoEvento = new Evento(fecha, obsevacion);
                                ArrayList<Evento> histoialNuevo = new ArrayList();
                                histoialNuevo = pacientes.get(i).getHistorial();
                                histoialNuevo.add(nuevoEvento);
                                pacientes.get(i).setHistorial(histoialNuevo);
                            }
                        }
                        break;
                case 6: 
                      
                    
                        break;
                case 7: break;
                case 8: break;
                default: System.out.println("Opcion no valida");break;
                        
        }
    }
    }   
    public static void mostrarMenu(){
        System.out.println("Hospital Julio C. Perrando - Av 9 de Julio 1100 - 0362 444-2399\n"+
                           "Menu :\n"+
                            "1. Listar Doctores.\n"+
                            "2. Registrar un nuevo paciente.\n"+
                            "3. Actualiza informacion personal de un paciente.\n"+
                            "4. Consulta el historia medico de un paciente.\n"+
                            "5. Nuevo historial de un paciente.\n"+
                            "6. Guadar Historial de pacientes desde achivo.\n"+
                            "7. Cargar Historial de pacientes desde archivo.\n"+
                            "9. Sali.\n");
    }
    public static void mostrarDoctores(ArrayList<Doctor> doctores){
        for(Doctor aux : doctores){
            System.out.println(aux.toString());
        }
    }
}

abstract class Persona{
    protected String nombre;
    protected String fechaNac;
    protected int dni;
    
    public Persona(){}
    public Persona(String nombre, String fechaNac, int dni) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }     
}
class Doctor extends Persona{
    private String especialidad;
    
    public Doctor(){
        super();
    }
    public Doctor(String nombre, String fechaNac, int dni, String especialidad){
        super(nombre, fechaNac, dni);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
    @Override
    public String toString() {
        return ("Doctor : "+this.nombre+"; especialidad : "+this.especialidad);
    }
    
}
class Paciente extends Persona implements Informacion{

    private int numTel;
    private int tipoSangre;
    private ArrayList<Evento> historial; 
    
        public Paciente(){}
        public Paciente(String nombre, String fechaNac, int dni, int numTel, int tipoSangre){
            super(nombre, fechaNac, dni);
            this.numTel = numTel;
            this.tipoSangre = tipoSangre;
            this.historial = null;
        }
        public Paciente(String nombre, String fechaNac, int dni, int numTel, int tipoSangre, ArrayList historial){
            super(nombre, fechaNac, dni);
            this.numTel = numTel;
            this.tipoSangre = tipoSangre;
            this.historial = historial;
        }

    public int getNumTel() {
        return numTel;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    public int getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(int tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public ArrayList<Evento> getHistorial() {
        return historial;
    }

    public void setHistorial(ArrayList<Evento> historial) {
        this.historial = historial;
    }
    
    @Override
    public void verHistorialDeEventos() {
        for(Evento aux : this.getHistorial()){
            System.out.println(aux.toString());
        }
    }
    
}
class Evento{
    private String fecha;
    private String observaciones;
    
    public Evento(){}
    public Evento(String fecha, String observaciones){
        this.fecha = fecha;
        this.observaciones = observaciones;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return (this.getFecha()+" - "+this.getObservaciones());
    }
    
    
    
}
interface Informacion{
    void verHistorialDeEventos();
}
class Serializador{
    public void serializar(ArrayList<Paciente> pacientes ) {
        try {
            // Crear un flujo de salida para escribir en un archivo llamado "curso.txt"
            FileOutputStream archivoSalida = new FileOutputStream("datos.txt");
            // Crear un flujo de objeto para escribir objetos en el flujo de salida
            ObjectOutputStream flujoSalida = new ObjectOutputStream(archivoSalida);
            // Escribir el objeto "curso" en el flujo de salida
            flujoSalida.writeObject(pacientes);
            // Importante: cerrar el flujo de salida para liberar recursos
            flujoSalida.close();
        } catch (Exception e) {
            e.printStackTrace(); // En caso de error, imprimir información de la excepción
        }
    }

    public ArrayList deserializar() {
        ArrayList<Paciente> pacientes = null;
        try {
            // Abrir un flujo de entrada para leer desde el archivo "curso.txt"
            FileInputStream archivoEntrada = new FileInputStream("habitacionesRyNR.txt");
            // Crear un flujo de objeto para leer objetos desde el flujo de entrada
            ObjectInputStream flujoEntrada = new ObjectInputStream(archivoEntrada);
            // Leer el objeto serializado desde el flujo de entrada y convertirlo a un objeto Curso
            pacientes = (ArrayList) flujoEntrada.readObject();
            // Importante: cerrar el flujo de entrada para liberar recursos
            flujoEntrada.close();
        } catch (Exception e) {
            e.printStackTrace(); // En caso de error, imprimir información de la excepción
        }
        return pacientes; // Devolver el objeto Curso deserializado
    }
}