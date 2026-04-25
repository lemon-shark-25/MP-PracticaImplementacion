# MP-PracticaImplementacion
Repositorio para el trabajo de MP.

## Tecnología
- Java JDK 21
- Apache Ant
- SonarQube (local)
- SonarScanner CLI

Compilación:
  ant clean compile

Análisis de calidad:
  ant sonar

## Ejecución
Compilcación y ejecución con Ant desde código fuente.
Ejecución del .jar con java.

## Requirements
Dependencias para correr el proyecto:
- JDK 21.0.10 (Oracle): recomendamos instalarlo a través a través del ejecutable (.exe), porque así se asignan las variables de entorno automáticamente.
- Uno de los siguientes:
  - Apache Netbeans: en este caso bastará con abrir el proyecto desde Netbeans y ejecutarlo asegurandose de que el JDK utilizado es la versión especificada anteriormente. Para ello se hace click derecho sobre el nombre del proyecto y se busca la opción Propiedades > Librerias > Plataforma Java y se selecciona la correspondiente.
  - Apache Ant 1.10.17: INCLUIR MÉTODO DE INSTALACIÓN


## Integración Continua

El proyecto utiliza Jenkins como servidor de integración continua.
Cada ejecución del pipeline realiza:

1. Clonado del repositorio desde GitHub
2. Compilación del proyecto mediante Apache Ant
3. Análisis de calidad del código con SonarQube

El análisis de calidad se ejecuta contra una instancia local de SonarQube.
Las credenciales de acceso (token) no se almacenan en el repositorio y se
gestionan externamente.


Nota: Para ejecutar el análisis con SonarQube es necesario definir
la variable de entorno SONAR_TOKEN con un token válido.

Ejemplo (Windows PowerShell):
  $env:SONAR_TOKEN="token"

Ejemplo (Linux/macOS):
  export SONAR_TOKEN=token
