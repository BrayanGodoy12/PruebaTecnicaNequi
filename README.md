# Proyecto Base Implementando Clean Architecture

## Antes de Iniciar

Empezaremos por explicar los diferentes componentes del proyectos y partiremos de los componentes externos, continuando con los componentes core de negocio (dominio) y por último el inicio y configuración de la aplicación.

Lee el artículo [Clean Architecture — Aislando los detalles](https://medium.com/bancolombia-tech/clean-architecture-aislando-los-detalles-4f9530f35d7a)

# Arquitectura

![Clean Architecture](https://miro.medium.com/max/1400/1*ZdlHz8B0-qu9Y-QO3AXR_w.png)

## Domain

Es el módulo más interno de la arquitectura, pertenece a la capa del dominio y encapsula la lógica y reglas del negocio mediante modelos y entidades del dominio.

## Usecases

Este módulo gradle perteneciente a la capa del dominio, implementa los casos de uso del sistema, define lógica de aplicación y reacciona a las invocaciones desde el módulo de entry points, orquestando los flujos hacia el módulo de entities.

## Infrastructure

### Helpers

En el apartado de helpers tendremos utilidades generales para los Driven Adapters y Entry Points.

Estas utilidades no están arraigadas a objetos concretos, se realiza el uso de generics para modelar comportamientos
genéricos de los diferentes objetos de persistencia que puedan existir, este tipo de implementaciones se realizan
basadas en el patrón de diseño [Unit of Work y Repository](https://medium.com/@krzychukosobudzki/repository-design-pattern-bc490b256006)

Estas clases no puede existir solas y debe heredarse su compartimiento en los **Driven Adapters**

### Driven Adapters

Los driven adapter representan implementaciones externas a nuestro sistema, como lo son conexiones a servicios rest,
soap, bases de datos, lectura de archivos planos, y en concreto cualquier origen y fuente de datos con la que debamos
interactuar.

### Entry Points

Los entry points representan los puntos de entrada de la aplicación o el inicio de los flujos de negocio.

## Application

Este módulo es el más externo de la arquitectura, es el encargado de ensamblar los distintos módulos, resolver las dependencias y crear los beans de los casos de use (UseCases) de forma automática, inyectando en éstos instancias concretas de las dependencias declaradas. Además inicia la aplicación (es el único módulo del proyecto donde encontraremos la función “public static void main(String[] args)”.

**Los beans de los casos de uso se disponibilizan automaticamente gracias a un '@ComponentScan' ubicado en esta capa.**

# 🐳 Despliegue local usando Docker

Este proyecto puede ejecutarse fácilmente utilizando Docker. A continuación te explicamos cómo hacerlo paso a paso.

---

## 1️⃣ Pre-requisitos

Asegúrate de tener instalado:

* [Docker](https://www.docker.com/get-started) (versión 20+ recomendada)
* [Git](https://git-scm.com/) (para clonar el proyecto si deseas construir localmente)

---

## 2️⃣ Clonar el proyecto y construir la imagen localmente (opcional)

Si deseas construir la imagen desde el código fuente localmente:

```bash
git clone https://github.com/BrayanGodoy12/PruebaTecnicaNequi
cd PruebaTecnicaNequi
./gradlew clean build # o el comando que uses para generar el JAR
```

Asegúrate de que el `.jar` generado esté en la misma ruta donde está tu `Dockerfile`. Luego, construye la imagen:

```bash
docker build -t brayang112/microservicio-franquicias:latest .
```

---

## 3️⃣ Descargar la imagen desde Docker Hub (opcional)

Si no deseas construir localmente, simplemente puedes descargar la imagen ya publicada:

```bash
docker pull brayang112/microservicio-franquicias:latest
```

---

## 4️⃣ Ejecutar el contenedor

Puedes ejecutar el contenedor con las variables necesarias de configuración (por ejemplo, las variables de conexión a base de datos, entorno, etc.).

Ejemplo:

```bash
docker run -d --name franquicias -p 8080:8080 -e DATABASE_HOST=franquicias-db.cgps4ca6uu8j.us-east-1.rds.amazonaws.com -e DATABASE_USERNAME=postgres  -e DATABASE_PASSWORD=postgres brayang112/microservicio-franquicias:latest
```

> 🧠 **Nota:** Asegúrate de ajustar las variables de entorno según lo que necesite tu aplicación (como credenciales, URLs, perfiles, etc).

---

## 5️⃣ Ver logs de ejecución (opcional)

```bash
docker logs -f franquicias
```

---

## 6️⃣ Parar y eliminar el contenedor (opcional)

```bash
docker stop franquicias
docker rm franquicias
```

---

## 🔎 Probar la API con Postman (opcional)

Hemos incluido una colección de Postman que contiene ejemplos de las peticiones disponibles en el microservicio.

### 📅 Descargar la colección

Puedes encontrar el archivo `.json` en la raíz del proyecto:

```
postman/FranquiciasCollection.postman_collection.json
```

### 📂 Importar en Postman

1. Abre Postman
2. Haz clic en `Import`
3. Selecciona el archivo `.json` de la colección
4. Ejecuta las peticiones desde ahí 🚀

---

## ℹ️ Notas adicionales

* Si necesitas regenerar la imagen localmente, puedes seguir las instrucciones en el archivo `Dockerfile`.
* Si el contenedor tiene problemas de certificado SSL al conectarse con RDS, revisa que esté importado correctamente el certificado en la imagen.

---


