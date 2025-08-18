package programas.calcuradolaAreas;

import java.util.Scanner;
import java.text.Normalizer;

class CalculadoraAreas {
    public double areaCirculo(double radio) {
        return radio * Math.pow(Math.PI, 2);
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
    public double areaPoligonoRegular(int numeroLados, double lado){
        double perimetro = numeroLados * lado;
        double area = (calculoApotema(numeroLados, lado) * perimetro)/2;
        return area;

    }
}

class ModificadorEntrada {
    private static String normalizarEntrada(String entrada) {
        // Con NFD se separa la letra en cuestión del carácter diacrítico (ejemplo: 'á' pasa a ser 'a' '´')
        String entradaNormalizada = Normalizer.normalize(entrada, Normalizer.Form.NFD);
        // Elimina los caracteres diacríticos (como tildes)
        return entradaNormalizada.replaceAll("\\p{M}", "");
    }
    private static String eliminarEspaciosEntrada(String entrada) {
        // Hacemos que la entrada solo tenga un espacio para evitar que falle
        String espaciosEliminados = entrada.replaceAll("\\s+", " ");
        return espaciosEliminados;
    }
    public String procesarEntrada(String entrada) {
        String entradaProcesada = eliminarEspaciosEntrada(normalizarEntrada(entrada.trim().toLowerCase()));
        return entradaProcesada;
    }
}



public class Main {
	public static void main(String[] args) {
        //Entrada figura = new Entrada();
        ModificadorEntrada entrada = new ModificadorEntrada();
        CalculadoraAreas rectangulo = new CalculadoraAreas();
        CalculadoraAreas cuadrado = new CalculadoraAreas();
        CalculadoraAreas triangulo = new CalculadoraAreas();
        CalculadoraAreas poligonoRegular = new CalculadoraAreas();
        CalculadoraAreas circulo = new CalculadoraAreas();
        Scanner sc = new Scanner(System.in);

        	try {
                System.out.println("Bienvenido");
                System.out.println("Si en algún momento desea salir escriba 'salir'");
                while(true) {
                    System.out.println("Introduzca la figura cuya área quiera calcular (círculo, cuadrado, triángulo, rectángulo, polígono regular): ");
                    String figura = entrada.procesarEntrada(sc.nextLine());
                    if(figura.equals("salir")) {
                        System.out.println("Saliendo de la calculadora... ¡Hasta pronto!");
                        sc.close();
                        break;
                    } else if (!figura.isEmpty()) {
                        switch (figura) {
                            case "triangulo":
                                System.out.print("Introduzca el valor de la base: ");
                                double baseT = sc.nextDouble();
                                System.out.print("Introduzca el valor de la altura: ");
                                double alturaT = sc.nextDouble();
                                System.out.println("Área del triángulo: " + triangulo.areaTriangulo(baseT,alturaT));
                                sc.nextLine(); // Limpiar buffer
                                break;
                            case "rectangulo":
                                System.out.print("Introduzca el valor de la base: ");
                                double baseR = sc.nextDouble();
                                System.out.print("Introduzca el valor de la altura: ");
                                double alturaR = sc.nextDouble();
                                System.out.println("Área del rectángulo: " + rectangulo.areaRectangulo(baseR, alturaR));
                                sc.nextLine(); // Limpiar buffer
                                break;
                            case "cuadrado":
                                System.out.print("Introduzca el valor del lado: ");
                                double lado = sc.nextDouble();
                                System.out.println("Área del cuadrado: " + cuadrado.areaCuadrado(lado));
                                sc.nextLine(); // Limpiar buffer
                                break;
                            case "circulo":
                                System.out.println("Introduzca el valor del radio: ");
                                double radio = sc.nextDouble();
                                System.out.println("El área del círculo es: " + circulo.areaCirculo(radio));
                                sc.nextLine(); // Limpiar el buffer
                                break;
                            case "poligono regular":
                                System.out.println("Introduzca el número de lados: ");
                                int numeroLados = sc.nextInt();
                                System.out.println("Introduzca la longitud del lado: ");
                                double ladoP = sc.nextDouble();
                                System.out.println("La apotema se calcula automáticamente");
                                System.out.println("El área del polígono regular en cuestión es: " + poligonoRegular.areaPoligonoRegular(numeroLados, ladoP));
                                sc.nextLine(); // Limpiamos el buffer
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

