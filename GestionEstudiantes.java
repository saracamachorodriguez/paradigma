import java.util.Scanner;

public class GestionEstudiantes {

    static String[] nombres = new String[100];
    static double[] notas = new double[100];
    static int contador = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Mostrar estudiantes");
            System.out.println("3. Calcular promedio");
            System.out.println("4. Mayor nota");
            System.out.println("5. Estudiantes aprobados");
            System.out.println("6. Buscar estudiante");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    registrar(sc);
                    break;
                case 2:
                    mostrar();
                    break;
                case 3:
                    promedio();
                    break;
                case 4:
                    mayorNota();
                    break;
                case 5:
                    aprobados();
                    break;
                case 6:
                    buscar(sc);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 0);

        sc.close();
    }

    // 1. Registrar estudiante
    public static void registrar(Scanner sc) {
        System.out.print("Nombre: ");
        nombres[contador] = sc.nextLine();

        System.out.print("Nota: ");
        notas[contador] = sc.nextDouble();

        contador++;
        System.out.println("Estudiante registrado.");
    }

    // 2. Mostrar listado
    public static void mostrar() {
        for (int i = 0; i < contador; i++) {
            System.out.println(nombres[i] + " - " + notas[i]);
        }
    }

    // 3. Promedio
    public static void promedio() {
        double suma = 0;

        for (int i = 0; i < contador; i++) {
            suma += notas[i];
        }

        if (contador > 0) {
            System.out.println("Promedio: " + (suma / contador));
        } else {
            System.out.println("No hay estudiantes.");
        }
    }

    // 4. Mayor nota
    public static void mayorNota() {
        if (contador == 0) {
            System.out.println("No hay datos.");
            return;
        }

        double mayor = notas[0];
        String nombreMayor = nombres[0];

        for (int i = 1; i < contador; i++) {
            if (notas[i] > mayor) {
                mayor = notas[i];
                nombreMayor = nombres[i];
            }
        }

        System.out.println("Mayor nota: " + nombreMayor + " - " + mayor);
    }

    // 5. Aprobados
    public static void aprobados() {
        for (int i = 0; i < contador; i++) {
            if (notas[i] >= 3.0) {
                System.out.println(nombres[i] + " - " + notas[i]);
            }
        }
    }

    // 6. Buscar estudiante
    public static void buscar(Scanner sc) {
        System.out.print("Nombre a buscar: ");
        String buscado = sc.nextLine();

        for (int i = 0; i < contador; i++) {
            if (nombres[i].equalsIgnoreCase(buscado)) {
                System.out.println("Encontrado: " + nombres[i] + " - " + notas[i]);
                return;
            }
        }

        System.out.println("No encontrado.");
    }
}