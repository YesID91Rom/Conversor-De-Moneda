package conversorMoneda;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Conversor {
    public static String seleccionarMonedaBase(Scanner scanner, String monedaBaseActual, String[] monedas) {
        System.out.println("*******************************************");
        System.out.println("Bienvenido al conversor de monedas de Yesid");
        System.out.println("Tu moneda actual es: " + monedaBaseActual);
        System.out.println("¿Deseas hacer la conversion de moneda? (s/n)");
        System.out.println("*******************************************");
        String cambiarMonedaBase = scanner.next();
        if (cambiarMonedaBase.equalsIgnoreCase("s")) {
            System.out.println("*******************************************");
            System.out.println("Seleccione la nueva moneda base: ");
            for (int i = 0; i < monedas.length; i++) {
                System.out.println((i + 1) + ". " + monedas[i]);
            }
            System.out.println("*******************************************");
            int opcionBase = -1;
            while (opcionBase < 1 || opcionBase > monedas.length) {
                System.out.print("Ingrese el número correspondiente a la moneda: ");

                // para verificar que la entrada sea un número entero
                if (scanner.hasNextInt()) {
                    opcionBase = scanner.nextInt();
                    if (opcionBase < 1 || opcionBase > monedas.length) {
                        System.out.println("Opción no válida. Por favor, elige un número entre 1 y " + monedas.length + ".");
                    }
                } else {
                    // Si no es un número entero, mostrara un mensaje de error y descartara la entrada
                    System.out.println("Entrada no válida. Por favor ingresa un número acorde a la lista.");
                    scanner.next();
                }
            }
            return monedas[opcionBase - 1];
        }

        return monedaBaseActual;
    }

    public static double ingresarCantidad(Scanner scanner, String monedaBase) {
        double cantidad = -1;
        while (cantidad == -1) {
        System.out.print("Ingrese la cantidad en: " + monedaBase + " que quieres convertir (o 'salir' para terminar): ");
        String input = scanner.next();

        if (input.equalsIgnoreCase("salir")) {
            return -1;
        }
            try {
                cantidad = Double.parseDouble(input);
                if (cantidad < 0) {
                    System.out.println("Por favor ingrese una cantidad positiva.");
                    cantidad = -1; // Repetir el proceso si la cantidad es negativa
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor ingrese un número válido.");
            }
        }

        return cantidad;
    }
    public static String seleccionarMonedaObjetivo(Scanner scanner, String monedaBase, String[] monedas) {
        System.out.println("*******************************************");
        System.out.println("Seleccione la moneda a la que desea hacer la conversion: ");
        for (int i = 0; i < monedas.length; i++) {
            if (!monedas[i].equals(monedaBase)) {
                System.out.println((i + 1) + ". " + monedas[i]);
            }
        }
        System.out.println("*******************************************");
        int opcionObjetivo = scanner.nextInt();
        if (opcionObjetivo < 1 || opcionObjetivo > monedas.length || monedas[opcionObjetivo - 1].equals(monedaBase)) {
            System.out.println("Opción no válida.");
            return null;
        }
        return monedas[opcionObjetivo - 1];
    }

    public static void realizarConversion(String monedaBase, String monedaObjetivo, double cantidadBase, Map<String, Double> tasasDeCambio, List<HistorialConversion> historial) {
        if (!tasasDeCambio.containsKey(monedaObjetivo)) {
            System.out.println("La tasa de cambio para " + monedaObjetivo + " no está disponible.");
            return;
        }

        double tasaDeCambio = tasasDeCambio.get(monedaObjetivo);
        double cantidadConvertida = cantidadBase * tasaDeCambio;

        // Crear una nueva entrada en el historial de conversiones
        HistorialConversion conversion = new HistorialConversion(monedaBase, monedaObjetivo, cantidadBase, cantidadConvertida);
        historial.add(conversion);

        System.out.printf("Resultado: %.2f %s%n", cantidadConvertida, monedaObjetivo);
    }
    }