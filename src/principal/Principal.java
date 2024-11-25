package principal;

import conversorMoneda.Conversor;
import conversorMoneda.TasaDeCambio;
import conversorMoneda.HistorialConversion;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    private static final String[] MONEDAS = {"ARS", "BOB", "BRL", "COP", "CLP", "EUR", "USD", "MXN", "CNY"};
    private static final String MONEDA_BASE_DEFAULT = "COP";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String monedaBase = MONEDA_BASE_DEFAULT;
        Map<String, Double> tasasDeCambio = new HashMap<>();
        TasaDeCambio tasaDeCambio = new TasaDeCambio();
        List<HistorialConversion> historial = new ArrayList<>();

        while (true) {
            // Selección de la moneda base
            monedaBase = Conversor.seleccionarMonedaBase(scanner, monedaBase, MONEDAS);
            if (monedaBase == null) {
                System.out.println("Programa terminado.");
                break;
            }

            // Para obtener las tasas de cambio
            try {
                tasasDeCambio = tasaDeCambio.obtenerTasasDeCambio(monedaBase, MONEDAS);
            } catch (Exception e) {
                System.out.println("Error al obtener las tasas de cambio: " + e.getMessage());
                continue;
            }

            // Ingreso de la cantidad a convertir
            double cantidadBase = Conversor.ingresarCantidad(scanner, monedaBase);
            if (cantidadBase == -1) {
                System.out.println("Programa terminado.");
                break;
            }

            // Selección de la moneda objetivo
            String monedaObjetivo = Conversor.seleccionarMonedaObjetivo(scanner, monedaBase, MONEDAS);
            if (monedaObjetivo == null) {
                System.out.println("Programa terminado.");
                break;
            }

            // Realizar la conversión y agregar al historial
            Conversor.realizarConversion(monedaBase, monedaObjetivo, cantidadBase, tasasDeCambio, historial);


            // Preguntar si el usuario desea ver el historial de conversiones
            System.out.println("¿Deseas ver el historial de conversiones? (s/n)");
            String verHistorial = scanner.next();
            if (verHistorial.equalsIgnoreCase("s")) {
                mostrarHistorial(historial);
            }
            System.out.println("¿Deseas realizar otra conversión? (s/n)");
            String continuar = scanner.next();
            if (!continuar.equalsIgnoreCase("s")) {
                System.out.println("Programa terminado.");
                break;
            }
        }

        scanner.close();
    }

    // Metodo para mostrar el historial de conversiones
    private static void mostrarHistorial(List<HistorialConversion> historial) {
        if (historial.isEmpty()) {
            System.out.println("No se ha realizado ninguna conversión aún.");
        } else {
            System.out.println("Historial de conversiones:");
            for (HistorialConversion conversion : historial) {
                System.out.println(conversion);
            }
        }
    }
}