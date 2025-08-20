package programas.calcuradolaAreas;
import java.util.Scanner;
import java.text.Normalizer;

class CalculadoraAreas {
    public double areaCirculo(double radio) {
        return Math.PI * Math.pow(radio, 2);
    }
    public double areaTriangulo(double base, double altura) {
        return (base * altura)/2;
    }
    public double areaRectangulo(double base, double altura) {
        return base * altura;
    }
    public double areaCuadrado(double lado) {
        double elevarCuadrado = Math.pow(lado, 2);
        return elevarCuadrado;
    }
    private static double calculoApotema (int numerolados, double lado){
        double apotema = lado/ (2 * Math.tan(Math.PI/numerolados));
        return apotema;
    }
    public Number areaPoligonoRegular(int numeroLados, double lado){
        double perimetro = numeroLados * lado;
        double area = (calculoApotema(numeroLados, lado) * perimetro)/2;
        return area;
    }
}

class ProcesarFiguras {
    CalculadoraAreas figura = new CalculadoraAreas();
    EntradaDatos parametros = new EntradaDatos();

    public double procesarTriangulo() {
        double [] datos = parametros.parametrosTriangulo();
        double area = figura.areaTriangulo(datos[0], datos[1]);
        System.out.println("Área del triángulo: ");
        System.out.println(area);
        return area;
    }
    public double procesarCuadrado() {
        double [] datos = parametros.parametrosCuadrado();
        double area = figura.areaCuadrado(datos[0]);
        System.out.println("Área del cuadrado: ");
        System.out.println(area);
        return area;
    }
    public double procesarRectangulo() {
        double[] datos = parametros.parametrosRectangulo();
        double area = figura.areaRectangulo(datos[0], datos[1]);
        System.out.println("Área del rectángulo: ");
        System.out.println(area);
        return area;
    }
    public double procesarCirculo() {
        double[] datos = parametros.parametrosCirculo();
        double area = figura.areaCirculo(datos[0]);
        System.out.println("Área del círculo: ");
        System.out.println(area);
        return area;
    }
    public double procesarPoligonoRegular() {
        Object[] datos = parametros.parametrosPoligonoRegular();
        int numeroLados = (int) datos[0];
        double lado = (double) datos[1];
        double area = figura.areaPoligonoRegular(numeroLados, lado).doubleValue();
        System.out.println("Área del polígono regular: ");
        System.out.println(area);
        return area;
    }
}

class EntradaDatos {
    Scanner sc = new Scanner(System.in);
    ModificadorEntradaDatos EntradaDatos = new ModificadorEntradaDatos();

    public String elegirFigura() {
        System.out.println("Introduzca la figura cuya área quiera calcular (círculo, cuadrado, triángulo, rectángulo, polígono regular): ");
        String figura = EntradaDatos.procesarEntradaDatos(sc.nextLine());
        return figura;
    }

    public double[] parametrosTriangulo() {
        System.out.println("Introduzca el valor de la base: ");
        double baseT = Math.abs(Double.parseDouble(sc.nextLine()));
        System.out.println("Introduzca el valor de la altura: ");
        double alturaT = Math.abs(Double.parseDouble(sc.nextLine()));
        return new double[]{baseT, alturaT};
    }

    public double[] parametrosCuadrado() {
        System.out.println("Introduzca el valor del lado: ");
        double lado = Math.abs(Double.parseDouble(sc.nextLine()));
        return new double [] {lado};
    }
    public double [] parametrosRectangulo() {
        System.out.println("Introduzca el valor de la base: ");
        double baseR = Math.abs(Double.parseDouble(sc.nextLine()));
        System.out.println("Introduzca el valor de la altura: ");
        double alturaR = Math.abs(Double.parseDouble(sc.nextLine()));
        return new double[] {baseR, alturaR};
    }
    public double[] parametrosCirculo() {
        System.out.println("Introduzca el valor del radio: ");
        double radio = Math.abs(Double.parseDouble(sc.nextLine()));
        return new double[]{radio};
    }
    public Object [] parametrosPoligonoRegular() {
        System.out.println("Introduzca el número de lados: ");
        int numeroLados = Math.abs(Integer.parseInt(sc.nextLine()));
        System.out.println("Introduzca la longitud del lado: ");
        double ladoP = Math.abs(Double.parseDouble(sc.nextLine()));
        System.out.println("La apotema se calcula automáticamente");
        return new Object[]{numeroLados, ladoP};
    }
}

class ModificadorEntradaDatos {
    private static String normalizarEntradaDatos(String EntradaDatos) {
        // Con NFD se separa la letra en cuestión del carácter diacrítico (ejemplo: 'á' pasa a ser 'a' '´')
        String EntradaDatosNormalizada = Normalizer.normalize(EntradaDatos, Normalizer.Form.NFD);
        // Elimina los caracteres diacríticos (como tildes)
        return EntradaDatosNormalizada.replaceAll("\\p{M}", "");
    }
    private static String eliminarEspaciosEntradaDatos(String EntradaDatos) {
        // Hacemos que la EntradaDatos solo tenga un espacio para evitar que falle
        String espaciosEliminados = EntradaDatos.replaceAll("\\s+", " ");
        return espaciosEliminados;
    }
    public String procesarEntradaDatos(String EntradaDatos) {
        String EntradaDatosProcesada = eliminarEspaciosEntradaDatos(normalizarEntradaDatos(EntradaDatos.trim().toLowerCase()));
        return EntradaDatosProcesada;
    }
}

public class Main {
    public static void main(String[] args) {
        EntradaDatos figura = new EntradaDatos();
        Scanner sc = new Scanner(System.in);
        ProcesarFiguras procesador = new ProcesarFiguras();
        try {
            System.out.println("Bienvenido");
            System.out.println("Si en algún momento desea salir escriba 'salir'");
            while (true) {
                // Almacenamos la solicitud en una variable
                String figuraElegida = figura.elegirFigura();
                if (figuraElegida.equals("salir")) {
                    System.out.println("Saliendo de la calculadora... ¡Hasta pronto!");
                    sc.close();
                    break;
                } else if (!figuraElegida.isEmpty()) {
                    switch (figuraElegida) {
                        case "triangulo":
                            procesador.procesarTriangulo();
                            break;
                        case "rectangulo":
                            procesador.procesarRectangulo();
                            break;
                        case "cuadrado":
                            procesador.procesarCuadrado();
                            break;
                        case "circulo":
                            procesador.procesarCirculo();
                            break;
                        case "poligono regular":
                            procesador.procesarPoligonoRegular();
                            break;
                        default:
                            System.out.println("Entrada no válida. Por favor, inténtelo de nuevo.");
                            continue;
                    }
                    break;
                } else {
                    System.out.println("Entrada vacía.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error de entrada: " + e.getMessage());
        }
        sc.close();
    }
}

