# product
## _Proyecto para consultar la oferta final a partir de fecha, marca y producto._

## Instrucciones
Recomendaciones a tener en cuenta:
- Ambiente Java local en la versión 18 
- Tener instalado el gestor de paquetes Maven.
- Postman, soap ui o insomnia (herramienta para realizar consumos a rest).

## Instalación

Descargue el proyecto del repositorio [GitHub](https://github.com/dpanqueva/product/).

Siguiendo el comando:

```sh
cd carpeta-proyecto
git clone https://github.com/dpanqueva/product/.git
```

Una vez descargo el proyecto encontraremos la carpeta
> product


Ingresamos a cada carpeta, una vez allí en la carpeta (product), es necesario descargar los paquetes correspondientes para su correcto funcionamiento.
Para este proceso seguimos el siguiente comando:

Abrimos la consola en la carpeta y/o proyecto correspondiente, **Importante, se debe hacer antes de correr el proyecto.

```sh
mvn clean install
```
## Run (desplegar proyecto)
Para correr el proyecto, se debe ingresar a la carpeta donde se descargo el código fuente (git), abrir la consola y ejecutar el siguiente comando:
Antes de desdplegar el proyecto, debemos ubicar la carpeta (en la raiz del pryecto) target, allí se encuentra el jar generado por maven con todo lo correspondiente a la ejecución, nos situamos dentro de esta carpeta y ejecutamos en consola:
```sh
java -jar product-0.0.1-SNAPSHOT.jar
```

El proyecto está configurado para que al iniciar, inicie en el puerto
```sh
server.port=8080 #puerto por defecto
```

Ya con esto nuestro proyecto ha quedado desplegado y listo para probar.


## Ejecución
Para la ejecución, en mi caso utilizare [Postman](https://www.postman.com/downloads/), ya en la herramienta debemos tener en cuenta los endposints:

> Tener en cuenta el ambiente al cual se le va a realizar la prueba
> localhost: maquina de desarrollo
> http://localhost:8087/api/v1/search


|Número| Operacion | Endpoint heroku|Endpoint local|
|------ | ------ | ------ | ------ |
|1| GET | http://localhost:8080/prices?applicationDate=2020-06-1621:00:00&productId=35455&brandId=1 |


## Explicación servicio 
Este servicio lo que pretende es consultar información de un producto con el precio, tarifa y fecha de aplicación a partir de una fecha de aplicación, producto y una marca.

Para ver la documentación del servicio [aquí](https://github.com/dpanqueva/commerce-test-dev/wiki)

## Tech
Para la solución de este reto, se implemento:
| Herramienta | Url |
| ------ | ------ |
| Java | [Jdk](https://openjdk.java.net/projects/jdk/18/) |
| Maven | [Maven](https://maven.apache.org/download.cgi) |
| Intellij Idea | [Intellij](https://www.jetbrains.com/es-es/idea/download) |
| GitHub | [https://github.com/](https://github.com/) |
| Spring Boot | [https://start.spring.io/](https://start.spring.io/) |
| Junit5 | [Junit](https://junit.org/junit5/) |

## Gracias!!
