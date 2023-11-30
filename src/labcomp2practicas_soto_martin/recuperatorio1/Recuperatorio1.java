
package recuperatorio1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Recuperatorio1 {
    
    private static ArrayList<Profesor> listaProfes = new ArrayList<>();
    private static ArrayList<Estudiante> listaEstudiantes=new ArrayList<>();
    private static ArrayList<Materia> listaMaterias=new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    
    
    
    
    public static void main(String[] args) {
         
        listaProfes.add(new Profesor("Jorge", "Perez", "09/07/1990", 332788, "Comunicacion Linguistica"));
        listaProfes.add(new Profesor("Matias", "Coronel", "09/02/1999", 332258, "Comunicacion Informatica"));
        
        listaEstudiantes.add(new Estudiante("Jorge", "Castanio", "12/07/2001", 442788));
        listaEstudiantes.add(new Estudiante("Daniel", "Gutierrez", "12/07/1978", 142708));
        
        listaMaterias.add(new Materia("a1", 332788));
        listaMaterias.add(new Materia("a2", 332258));
        int opcion;
        
        while(true){                   
            mostrarMenu();
            System.out.print(">>> Seleccionar opcion : ");
            try{
                opcion = sc.nextInt();
            }catch(InputMismatchException ex){
                continue;
            }
            switch(opcion){
                case 1: 
                        listarProfesores();
                        break;
                case 2: 
                        listarAlumnos();
                        break;
                case 3: 
                        listarMaterias();
                        break;
                case 4: 
                        Profesor profe = registrarNuevoProfesor();
                        if(profe!=null){
                            listaProfes.add(profe);
                        }else{
                            System.out.println("No se pudo registrar profesor.");
                        }
                        break;
                case 5: 
                        Estudiante estudiante = registrarNuevoEstudiante();
                        if(estudiante!=null){
                            listaEstudiantes.add(estudiante);
                        }else{
                            System.out.println("No se pudo registrar Estudiante.");
                        }
                        break;
                case 6: 
                        asignarProfesorAMateria();
                        break;
                case 7: 
                        inscribirAlumnoAMateria();
                        break;
                case 8: 
                        System.out.println(" >>> Fin de programa!!!");
                        break;
                case 10:
                        listaProfes = null;
                        listaMaterias = null;
                        listaEstudiantes = null;
                        System.gc();
                        System.exit(1);
            }
        }
    }
    private static void mostrarMenu(){
        System.out.println("Menu : \n1. Listar Profesores\n2. Listar Estudiantes\n3. Listar Materias"+
                "\n4. Registrar un nuevo Profesor\n5. Registrar un nuevo Estudiante\n6. Asignar Profesor a Materia"+
                "\n7. Inscribir Estudiante a Materia\n8. Guardar informacion en Archivo\n9. Cargar informacion desde Archivo"+
                "\n10. Salir");
    }
    
    private static void listarProfesores(){
        listaProfes.forEach(profesor ->System.out.println(profesor.toString()));
    }
    
    private static void listarAlumnos(){
        listaEstudiantes.forEach(alumno ->System.out.println(alumno.toString()));
    }
    
    private static void listarMaterias(){
        listaMaterias.forEach(materia ->System.out.println(materia.toString()));
    }
    
    private static Profesor registrarNuevoProfesor(){
        sc.nextLine();
        //Adquisicion de String.
        System.out.print("Nombre Profesor : >>> ");
        String nombre = sc.nextLine();
        System.out.print("Apellido Profesor : >>> ");
        String apellido = sc.nextLine();
        System.out.print("Fecha de Nacimiento (dd/mm/aaaa) : >>> ");
        String fechaNac = sc.nextLine();
        System.out.print("Especialidad : >>> ");
        String especialidad = sc.nextLine();
        //Adquisicion de int.
        System.out.print("Dni Profesor : >>> ");
        int dni = sc.nextInt();
        sc.nextLine();
        return new Profesor(nombre, apellido ,fechaNac , dni, especialidad);
    }
    
    private static Estudiante registrarNuevoEstudiante(){
        sc.nextLine();
        //Adquisicion de String.
        System.out.print("Nombre Estudiante : >>> ");
        String nombre = sc.nextLine();
        System.out.print("Apellido Estudiante : >>> ");
        String apellido = sc.nextLine();
        System.out.print("Fecha de Nacimiento (dd/mm/aaaa) : >>> ");
        String fechaNac = sc.nextLine();
        //Adquisicion de int.
        System.out.print("Dni Estudiante : >>> ");
        int dni = sc.nextInt();
        sc.nextLine();
        return new Estudiante(nombre, apellido ,fechaNac , dni);
    }
    
       private static Estudiante buscarEstudiante( int dni){   
        for(Estudiante estudiante : listaEstudiantes) if(estudiante.getDni() == dni) return estudiante;
        return null;        
    }
    
    private static void asignarProfesorAMateria(){
        sc.nextLine();
        //Adquisicion de String.
        System.out.print("Nombre Materia : >>> ");
        String nombre = sc.nextLine();
        //Adquisicion de int.
        System.out.print("Dni Profesor : >>> ");
        int dni = sc.nextInt();
        for(Materia materia : listaMaterias){
            if(materia.getNombreMateria()==nombre) materia.setProfesorACargo(dni);
        }
    }
    
    private static void inscribirAlumnoAMateria(){
        //Adquisicion de String.
        System.out.print("Nombre Materia : >>> ");
        String nombre = sc.nextLine();
        //Adquisicion de int.
        System.out.print("Dni Estudiante : >>> ");
        int dni = sc.nextInt();
        try{
            Estudiante estudiante = buscarEstudiante(dni);
            for(Materia materia : listaMaterias){
            if(materia.getNombreMateria()==nombre){
                if(materia.getInscriptos()==null){
                    (materia.setInscriptos(new ArrayList())).getInscriptos().add(estudiante);
                }else{
                    materia.getInscriptos().add(estudiante);
                }
            }
            }
        }catch(NullPointerException npE){
            System.out.println("No se encontro el estudiante.");
        }
  }
            
}

//Inicio clase Persona----------------------------------------------------------
abstract class Persona implements Serializable{
    protected String nombre;
    protected String apellido;
    protected String fechaNac;
    protected int dni;
    
    public Persona(){}
    public Persona(String nombre, String apellido, String fechaNac, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
}
//Fin clase Persona-------------------------------------------------------------

//Inicio clase Profesor-----------------------------------------------------------
class Profesor extends Persona implements Serializable{
    
    private String especialidad;
    
    public Profesor(){
        super();
    }
    public Profesor(String nombre, String apellido, String fechaNac, int dni, String especialidad){
        super(nombre, apellido, fechaNac, dni);
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
        return ("Profesor : "+this.nombre+"; Apellido : "+this.apellido+"; especialidad : "+this.especialidad+"; dni : "+this.dni);
    }
}
//Fin clase Profesor--------------------------------------------------------------

//Inicio clase Estudiante-------------------------------------------------------
class Estudiante extends Persona implements Serializable{
    
    public Estudiante() {
        super();
    }

    public Estudiante(String nombre, String apellido, String fechaNac, int dni) {
        super(nombre, apellido, fechaNac, dni);
    }
    
    @Override
    public String toString() {
        return ("Estudiante : "+this.nombre+"; Apellido : "+this.apellido+"; dni : "+this.dni);
    }
    
}
//Fin clase Estudiante----------------------------------------------------------

//Inicio clase Materia----------------------------------------------------------
class Materia implements Serializable{
    private ArrayList<Estudiante> inscriptos;
    private String nombreMateria;
    private int profesorACargo;

    public Materia(){}
    public Materia(String nombreMateria, int profesorACargo) {
        this.nombreMateria = nombreMateria;
        this.profesorACargo = profesorACargo;
        this.inscriptos = null;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getProfesorACargo() {
        return profesorACargo;
    }

    public void setProfesorACargo(int profesorACargo) {
        this.profesorACargo = profesorACargo;
    }

    public ArrayList<Estudiante> getInscriptos() {
        return inscriptos;
    }

    public Materia setInscriptos(ArrayList<Estudiante> inscriptos) {
        this.inscriptos = inscriptos;
        return this;
    }
    
    

    @Override
    public String toString() {
        return "Materia{" + "nombreMateria=" + nombreMateria + ", profesorACargo=" + profesorACargo + '}';
    }
    
}
//Fin clase Materia----------------------------------------------------------