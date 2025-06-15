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

# Prueba Técnica Nequi (Ejecutar en local)

## Requisitos Previos

- [Java 21](https://adoptopenjdk.net/)
- [Gradle 8+](https://gradle.org/)
- [Docker](https://www.docker.com/)
- [WSL2](https://docs.microsoft.com/en-us/windows/wsl/)
- [PowerShell](https://docs.microsoft.com/en-us/powershell/)

## Montaje Local (WSL + PowerShell)

### 1. Clonar el repositorio

```powershell
git clone https://github.com/BrayanGodoy12/PruebaTecnicaNequi
cd PruebaTecnicaNequi
```

### 2. Levantar la base de datos con Docker

Desde PowerShell o WSL, ejecuta:

```powershell
cd applications/app-service/src/main/resources
docker compose up -d
```

Esto levantará un contenedor de PostgreSQL con la base de datos `franquiciasdb`.

### 3. Crear el esquema y tablas

El archivo `schema.sql` se encuentra en `applications/app-service/src/main/resources/schema.sql`. Puedes ejecutarlo manualmente o configurar tu aplicación para que lo ejecute al iniciar.

Para ejecutarlo manualmente:

```bash
# Desde WSL
psql -h localhost -U postgres -d franquiciasdb -f schema.sql
```
> Usuario: postgres  
> Contraseña: postgres

### 4. Compilar el proyecto

Desde la raíz del proyecto:

```bash
./gradlew clean build
```

### 5. Ejecutar la aplicación

```bash
cd applications/app-service
./gradlew bootRun
```

La aplicación quedará corriendo en el puerto configurado (por defecto 8080).

## Notas

- Puedes modificar la configuración de la base de datos en los archivos de propiedades de Spring Boot.
- Para detener los contenedores de Docker:
  ```powershell
  docker compose down
  ```

## Recursos

- [Clean Architecture — Aislando los detalles](https://medium.com/bancolombia-tech/clean-architecture-aislando-los-detalles-4f9530f35d7a)

---

