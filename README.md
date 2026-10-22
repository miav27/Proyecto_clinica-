# 🐾 Sistema de Gestión de Clínica Veterinaria (Proyecto_clínica)

Este es un sistema de escritorio desarrollado en **Java** bajo un enfoque arquitectónico profesional utilizando patrones de diseño avanzados para la gestión integral de una clínica veterinaria. El aplicativo permite controlar de manera eficiente los registros de clientes, pacientes (mascotas), citas médicas, diagnósticos y tratamientos.

## 🚀 Arquitectura de Software y Patrones de Diseño

El proyecto implementa una estructura desacoplada y escalable basada en estándares de la industria:
* **Patrón MVC (Modelo-Vista-Controlador):** Separación estricta entre la interfaz gráfica (`vista`), la lógica de control (`Controladores`) y las reglas de negocio (`Entidades`).
* **Patrón DAO (Data Access Object):** Centralización de las operaciones de persistencia a través de interfaces especializadas (`ICrudDao`) y clases de acceso a datos individuales (`ClienteDao`, `MascotaDao`, etc.).
* **Capa de Conexión (`basedatos`):** Módulo centralizado (`conexion.java`) encargado de gestionar la comunicación con el sistema de gestión de bases de datos relacionales.

## 🛠️ Tecnologías y Componentes Utilizados
* **Lenguaje:** Java 
* **Interfaz Gráfica:** Java Swing / AWT (Estructura basada en formularios `.form` de NetBeans).
* **Gestión de Recursos:** Manejo local de recursos gráficos y multimedia (iconos de interfaz).

## 🗂️ Módulos de la Aplicación (Estructura de Entidades)
* **Gestión de Pacientes:** Registro analítico de mascotas, enlazado directamente a su historial de diagnósticos y tratamientos médicos.
* **Control de Clientes:** Mantenimiento de datos personales y de contacto de los propietarios.
* **Flujo de Citas Clínicas:** Programación y asignación de citas médicas vinculadas a un empleado (personal médico o administrativo).
* **Módulo Clínico Avanzado:** Emisión de diagnósticos detallados y prescripción de tratamientos específicos para cada consulta.

## 💻 Ejecución del Sistema
Para iniciar el entorno visual del sistema de forma local, se debe compilar y ejecutar el punto de entrada principal del software:
```bash
src/vista/Loginvet.java
```
*Este comando desplegará la pantalla de inicio de sesión seguro para autenticar a los usuarios del sistema.*
