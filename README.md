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

Resultados:
  Accesibles desde http://localhost:9000
## Ejecución
Compilcación y ejecución con Ant desde código fuente.
Ejecución del .jar con java.

## Requirements (dependencias a parte del JDK)
Dependencias para correr el proyecto:
- JDK 21.0.10 (Oracle): recomendamos instalarlo a través a través del ejecutable (.exe), porque así se asignan las variables de entorno automáticamente.
- Uno de los siguientes:
  - Apache Netbeans: en este caso bastará con abrir el proyecto desde Netbeans y ejecutarlo asegurandose de que el JDK utilizado es la versión especificada anteriormente. Para ello se hace click derecho sobre el nombre del proyecto y se busca la opción Propiedades > Librerias > Plataforma Java y se selecciona la correspondiente.
  - Apache Ant 1.10.17: INCLUIR MÉTODO DE INSTALACIÓN

Nota: Para ejecutar el análisis con SonarQube es necesario definir
la variable de entorno SONAR_TOKEN con un token válido.

Ejemplo (Windows PowerShell):
  $env:SONAR_TOKEN="token"

Ejemplo (Linux/macOS):
  export SONAR_TOKEN=token
