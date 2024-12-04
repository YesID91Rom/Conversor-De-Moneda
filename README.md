[![Badge-Conversor.png](https://i.postimg.cc/kMVDnh6q/Badge-Conversor.png)](https://postimg.cc/8sST44m0)

<h1 align="center"> Challenge-Conversor-de-Monedas :dollar: </h1>

Este programa es una aplicación de consola en Java diseñada para convertir cantidades entre diferentes monedas utilizando una API de tasas de cambio en tiempo real. Proporciona una interfaz de usuario simple en la consola para que los usuarios seleccionen la conversión de moneda deseada e ingresen la cantidad que desean convertir.
## :hammer: Características
- `Funcionalidad 1`: Selección de Moneda: Permite a los usuarios elegir entre varias combinaciones de monedas para realizar la conversión. Las opciones disponibles incluyen ARS, BOB, BRL, COP, CLP, EUR, USD, MXN, CNY.
- `Funcionalidad 2`: Conversión en Tiempo Real: Utiliza una API de tasas de cambio para obtener las tasas de conversión más recientes y calcular el valor convertido en tiempo real.
- `Funcionalidad 3`: Manejo de Errores: Incluye manejo básico de errores para entradas no válidas.
- `Funcionalidad 4`: Historial de conversiones: puedes consultar el historial de las converiones realidas en la cual arroja la fecha y hora de la consulta. 

## :white_check_mark: Tecnologías Usadas 
- Java: El lenguaje de programación principal utilizado para desarrollar la lógica de la aplicación y la interfaz de usuario.
- API de Tasas de Cambio: Se utiliza una API de tasas de cambio para obtener las tasas de conversión actualizadas entre diferentes divisas. En este proyecto, se hace uso de solicitudes - HTTP para acceder a la API y obtener los datos de conversión. Algunas opciones populares incluyen ExchangeRate-API y Open Exchange Rates.
- Gson: Una biblioteca de Java para convertir objetos Java en su representación JSON y viceversa. Se utiliza para analizar la respuesta JSON de la API de tasas de cambio y extraer la información relevante.
- Git: Se utiliza Git como sistema de control de versiones para el desarrollo colaborativo del proyecto.
- IntelliJ IDEA: El IDE utilizado para desarrollar y administrar el proyecto.

## :pencil2: Instrucciones de Configuración</h4>
- Clona el repositorio o descarga los archivos del proyecto.
- Importa el proyecto en tu IDE de Java (por ejemplo, IntelliJ IDEA).
- Configura las dependencias y ajusta la configuración según sea necesario.
- inicializa en el menu principal y siga las instrucciones en pantalla.


## :bookmark_tabs: Uso
Para usar este programa, siga estos pasos:
- El programa le preguntara si desea hacer la conversion de moneda (S/N): S = Si ; N = No
- Cuando se le presente el menú de opciones, seleccione la moneda Origen de la cual desea realizar la conversion ingresando el número correspondiente. O si lo desea puede escribir Salir para finalizar el programa
- Ingrese la cantidad de dinero que desea convertir cuando se le solicite.
- El programa mostrará el resultado de la conversión utilizando la tasa de cambio más reciente
- Se le preguntara Si desea ver el historial de conversiones si ingresa (S): el sistema le dara un reporte con las consultas realizadas, si la respuesta del Usuario es (N) el sistema terminara
- Cada vez que el Usuario realice una conversion y esta finalice se le pregutara si desea realizar otra convrrion o si de lo contrario desea finalizarlo.

## :warning: Requisitos
- Java 17 o superior.
- Acceso a Internet para las consultas de la API de tasas de cambio.

## :+1: Contribuyendo
Las contribuciones para mejorar la herramienta son bienvenidas. No dudes en enviar una solicitud de extracción o abrir un problema para cualquier error o solicitud de características.
