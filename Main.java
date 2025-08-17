package programas.calcuradolaAreas;

import java.util.Scanner;
import java.text.Normalizer;

public class Main {
	public static String normalizar(String texto) {
        // Con NFD se separa la letra en cuestión del carácter diacrítico (ejemplo 'á' pasa a ser 'a' '´')
		String textoNormalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
	    // Elimina los caracteres diacríticos (como tildes)
		return textoNormalizado.replaceAll("\\p{M}", "");
	}

    static double areaCirculo(double radio) {
            return radio * Math.pow(Math.PI, 2);
    }

	static double areaTriangulo(double base, double altura) {
        	return (base * altura)/2;
    }
    static double areaRectangulo(double base, double altura) {
    		return base * altura;
    }
    static double areaCuadrado(double lado) {
    		double elevarCuadrado = Math.pow(lado, 2);
    		return elevarCuadrado;
   	}

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        	try {
                System.out.println("Bienvenido");
                System.out.println("Si en algún momento desea salir escriba 'salir'");
                while(true) {
                    System.out.println("Introduce el polígono cuya área quieras calcular (círculo, cuadrado, triángulo, rectángulo): ");
                    String poligono = normalizar(sc.nextLine().trim());
                    if(poligono.trim().equalsIgnoreCase("salir")) {
                        System.out.println("Saliendo de la calculadora... ¡Hasta pronto!");
                        sc.close();
                        break;
                    } else if (!poligono.trim().isEmpty()) {
                        switch (poligono.toLowerCase()) {
                            case "triangulo":
                                System.out.print("Introduce el valor de la base: ");
                                double baseT = sc.nextDouble();
                                System.out.print("Introduce el valor de la altura: ");
                                double alturaT = sc.nextDouble();
                                System.out.println("Área del triángulo: " + areaTriangulo(baseT, alturaT));
                                sc.nextLine(); // Limpiar buffer
                                break;
                            case "rectangulo":
                                System.out.print("Introduce el valor de la base: ");
                                double baseR = sc.nextDouble();
                                System.out.print("Introduce el valor de la altura: ");
                                double alturaR = sc.nextDouble();
                                System.out.println("Área del rectángulo: " + areaRectangulo(baseR, alturaR));
                                sc.nextLine(); // Limpiar buffer
                                break;
                            case "cuadrado":
                                System.out.print("Introduce el valor del lado: ");
                                double lado = sc.nextDouble();
                                System.out.println("Área del cuadrado: " + areaCuadrado(lado));
                                sc.nextLine(); // Limpiar buffer
                                break;
                            case "circulo":
                                System.out.println("Introduce el valor del radio: ");
                                double radio = sc.nextDouble();
                                System.out.println("El área del círculo es: " + areaCirculo(radio));
                                sc.nextLine(); // Limpiar el buffer
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

