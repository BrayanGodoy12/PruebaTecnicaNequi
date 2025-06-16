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

Este proyecto puede ejecutarse fácilmente utilizando Docker o directamente desde IntelliJ. A continuación te explicamos cómo hacerlo paso a paso.

---

## 1️⃣ Pre-requisitos

Asegúrate de tener instalado:

* [Docker](https://www.docker.com/get-started) (versión 20+ recomendada)
* [Git](https://git-scm.com/) (para clonar el proyecto si deseas construir localmente)
* [Java 21 SDK](https://adoptium.net/) (si vas a correr desde IntelliJ)

---

## 2️⃣ Ejecutar desde IntelliJ 🧠

### 2.1. Variables de entorno necesarias

Agrega las siguientes variables de entorno a tu configuración de ejecución:

```
DATABASE_HOST=localhost
DATABASE_USERNAME=postgres
DATABASE_PASSWORD=postgres
```

### 2.2. Montar PostgreSQL en Docker

Puedes usar el siguiente comando para levantar una base de datos PostgreSQL local:

```bash
docker run --name postgres-franquicias -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres:14
```

### 2.3. Inicializar el esquema de base de datos

En el proyecto encontrarás un script en `deployment/init-db.sql`. Puedes cargarlo usando alguna herramienta como DBeaver, TablePlus o con el siguiente comando:

```bash
docker exec -i postgres-franquicias psql -U postgres -d postgres < deployment/init-db.sql
```

### 2.4. Deshabilitar SSL para pruebas locales

En el archivo de configuración donde se establece la conexión a la base de datos (por ejemplo, `application.yml` o `application.properties`), asegúrate de que el adaptador de PostgreSQL tenga SSL deshabilitado:

```yaml
PostgreSQLConnectionPool.java
```

---

## 3️⃣ Clonar el proyecto y construir la imagen localmente (opcional)

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

## 4️⃣ Descargar la imagen desde Docker Hub (opcional)

Si no deseas construir localmente, simplemente puedes descargar la imagen ya publicada:

```bash
docker pull brayang112/microservicio-franquicias:latest
```

---

## 5️⃣ Ejecutar el contenedor

Puedes ejecutar el contenedor con las variables necesarias de configuración:

```bash
docker run -d --name franquicias -p 8080:8080 -e DATABASE_HOST=franquicias-db.cgps4ca6uu8j.us-east-1.rds.amazonaws.com -e DATABASE_USERNAME=postgres  -e DATABASE_PASSWORD=postgres brayang112/microservicio-franquicias:latest
```

> 🧠 **Nota:** Asegúrate de ajustar las variables de entorno según lo que necesite tu aplicación (como credenciales, URLs, perfiles, etc).

---

## 6️⃣ Ver logs de ejecución (opcional)

```bash
docker logs -f franquicias
```

---

## 7️⃣ Parar y eliminar el contenedor (opcional)

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


# ☁️ Despliegue de infraestructura con Terraform en AWS

Este proyecto incluye una infraestructura automatizada que puede desplegarse usando Terraform.

---

## 1️⃣ Pre-requisitos

Antes de iniciar, asegúrate de tener instalado:

* [Terraform](https://www.terraform.io/) (versión 1.3+)
* Una cuenta en [AWS](https://aws.amazon.com/)
* Tener configurado el AWS CLI con tus credenciales:

```bash
aws configure
```

---

## 2️⃣ Configuración del entorno AWS

Crea un archivo `terraform.tfvars` con los siguientes valores:

```hcl
region        = "us-east-1"
db_username   = "postgres"
db_password   = "postgres"
```

También puedes definirlos como variables de entorno si lo prefieres.

---

## 3️⃣ Inicializar y desplegar infraestructura

### 3.1. Inicializa Terraform

```bash
terraform init
```

### 3.2. Visualiza los recursos que se van a crear

```bash
terraform plan 
```

### 3.3. Aplica los cambios

```bash
terraform apply 
```

Esto creará:

* Un RDS PostgreSQL
* Security groups
* Un EC2 con el contenedor Docker
* Parámetros necesarios para conexión

---

## 4️⃣ Verifica los recursos creados

Terraform mostrará las salidas configuradas como:

* Endpoint de RDS
* IP pública de la EC2

Puedes acceder a la IP pública para verificar que el contenedor esté corriendo correctamente.

---

## 5️⃣ Destruir la infraestructura

Para eliminar todos los recursos creados por Terraform:

```bash
terraform destroy
```

⚠️ Asegúrate de detener o eliminar manualmente cualquier recurso que esté impidiendo la destrucción, como instancias que aún usen grupos de parámetros (por ejemplo, RDS debe estar apagado antes de eliminar el DB Parameter Group).

---

## 🧠 Notas importantes

* Si usas RDS con certificados SSL, asegúrate de configurar la instancia correctamente.
* Asegúrate de que las variables en Terraform coincidan con las del contenedor Docker si lo ejecutas manualmente.
* Si haces pruebas locales, recuerda desactivar `ssl` en la configuración del adaptador de PostgreSQL.

---

Este README cubre desde el despliegue con Terraform hasta la eliminación completa. Para instrucciones de ejecución local con Docker o IntelliJ, consulta las secciones anteriores.

