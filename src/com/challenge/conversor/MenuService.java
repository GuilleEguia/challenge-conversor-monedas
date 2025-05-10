package com.challenge.conversor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuService {
    Scanner scanner = new Scanner(System.in);
    private final List<String> CODES = new ArrayList<>(List.of("USD", "ARS", "BRL", "COP"));

    private final String menu = """
            \n
            Bienvenido al conversor de divisas.
            1. Dolar -> Peso Argentino
            2. Peso Argentino -> Dolar
            3. Dolar -> Real Brasileño
            4. Real Brasileño -> Dolar
            5. Dolar a Peso Colombiano
            6. Peso Colombiano -> Dolar
            7. Salir
            Elija una opción valida: 
            """;

    public void showMenu() {
        String option;
        do {
            System.out.print(menu);
            option = scanner.nextLine();

            if (!option.equals("7")) {
                String codePath = getCodePath(option);
                if (codePath != null) {
                    double amount = getAmount();
                    String response = ExchangeConversor.urlExchange(codePath, String.valueOf(amount));
                    if (response != null) {
                        System.out.printf("El valor $%.2f de %s es: $%s", amount, codePath, response);
                    } else {
                        System.out.println("Error al obtener la respuesta de la API.");
                    }
                }
            } else {
                System.out.println("Saliendo...");
            }
        } while (!option.equals("7"));

        scanner.close();
    }

    private String getCodePath(String option) {
        switch (option) {
            case "1" -> {
                return formatCodes(CODES.get(0), CODES.get(1));
            }
            case "2" -> {
                return formatCodes(CODES.get(1), CODES.get(0));
            }
            case "3" -> {
                return formatCodes(CODES.get(0), CODES.get(2));
            }
            case "4" -> {
                return formatCodes(CODES.get(2), CODES.get(0));
            }
            case "5" -> {
                return formatCodes(CODES.get(0), CODES.get(3));
            }
            case "6" -> {
                return formatCodes(CODES.get(3), CODES.get(0));
            }
            default -> {
                System.out.println("Opción no válida. Por favor, elija una opción del menú.");
                return null;
            }
        }
    }

    private double getAmount() {
        System.out.print("Ingrese el monto a convertir: ");
        while (true) {
            try {
                double amount = Double.parseDouble(scanner.nextLine());
                if (amount <= 0) {
                    System.out.print("El monto debe ser mayor a cero. Intente nuevamente: ");
                    continue;
                }
                return amount;
            } catch (NumberFormatException e) {
                System.out.print("Monto inválido. Por favor, ingrese un número válido: ");
            }
        }
    }

    private String formatCodes(String c1, String c2) {
        return String.format("%s/%s", c1, c2);
    }
}
