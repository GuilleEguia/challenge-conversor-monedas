# Conversor de Monedas

Este proyecto es una aplicación de consola en Java que permite convertir montos entre diferentes monedas utilizando una API de tipo de cambio. El usuario puede seleccionar las monedas de origen y destino, ingresar un monto y obtener el resultado de la conversión.

## Características

- Conversión entre las siguientes monedas:
  - Dólar estadounidense (USD)
  - Peso argentino (ARS)
  - Real brasileño (BRL)
  - Peso colombiano (COP)
- Interfaz de usuario basada en consola.

## Requisitos

- **Java 17** o superior.
- Conexión a Internet para interactuar con la API de tipo de cambio.
- Una clave de API válida para la API de tipo de cambio (por ejemplo, [ExchangeRate-API](https://www.exchangerate-api.com/)).

## Instalación

1. Clona este repositorio en tu máquina local:
   ```
   git clone https://github.com/GuilleEguia/challenge-conversor-monedas.git
   ```

2. Tener Java 17 o superior instalado.

    Para verificarlo ejecuta:

    ```
    java -version
    ```

3. En el archivo `ExchangeConversor.java` cambia el valor de la constante `API_KEY` por tu API KEY.

## Uso

1. Al iniciar la aplicación, se mostrará un menú con las opciones de conversión disponibles.
2. Selecciona una opción ingresando el número correspondiente.
3. Ingresa el monto que deseas convertir.
4. La aplicación mostrará el resultado de la conversión o un mensaje de error si ocurre algún problema.

Ejemplo de ejecución:

```
Bienvenido al conversor de divisas.
1. Dolar -> Peso Argentino
2. Peso Argentino -> Dolar
3. Dolar -> Real Brasileño
4. Real Brasileño -> Dolar
5. Dolar a Peso Colombiano
6. Peso Colombiano -> Dolar
7. Salir
Elija una opción valida: 1
Ingrese el monto a convertir: 100
El valor $100.00 de USD/ARS es: $23000.00
```

