# Bank Sergio Menu

Este proyecto implementa un sistema de gestión de usuarios y cuentas bancarias en Java. Permite a los usuarios realizar operaciones bancarias como depósitos, retiros, consulta de saldo y administración de cuentas.

## Características

- Gestión de usuarios:
    - Creación de nuevos usuarios.
    - Selección de usuarios existentes.
- Gestión de cuentas:
    - Creación de cuentas corrientes o de ahorros con saldo inicial.
    - Realización de depósitos y retiros.
    - Consulta de saldo actual.
- Registro de transacciones:
    - Cada transacción realizada (depósito o retiro) se almacena y es accesible para consulta.
- Sistema basado en estrategias:
    - Soporte para cuentas corrientes y de ahorros con diferentes reglas de operación.

## Arquitectura del Proyecto

# BankSergioMenu - Sistema Bancario Interactivo

Este proyecto implementa un sistema bancario interactivo en Java utilizando el patrón de diseño Strategy para manejar las operaciones de las cuentas bancarias. A continuación, se describen las principales clases y componentes del proyecto.

## Funcionalidades

1. **Crear usuarios y cuentas bancarias**.
2. **Seleccionar un usuario y administrar su cuenta bancaria**:
    - Depósitos.
    - Retiros.
    - Consulta de saldo.
    - Historial de transacciones.
3. **Soporte para dos tipos de cuentas bancarias**:
    - Cuentas de ahorro.
    - Cuentas corrientes.
4. **Gestión de transacciones con estrategias específicas según el tipo de cuenta**.

---

## Clases Principales

### `BankSergioMenu`
- Clase principal que ejecuta el menú interactivo para los usuarios.
- Gestiona la creación de usuarios y cuentas, así como las operaciones bancarias.
- Utiliza menús dinámicos para interactuar con los usuarios.

### `User`
- Representa a un usuario del sistema y hereda de la clase `Person`.
- Contiene información del usuario, como su cuenta y un historial de transacciones.

### `SavingsAccount` y `CurrentAccount`
- Clases que representan los dos tipos de cuentas bancarias soportadas:
    - **Cuentas de Ahorro**: Incluyen una tasa de interés.
    - **Cuentas Corrientes**: Incluyen un límite de sobregiro.

### `TransactionStrategy`
- Interfaz que define las operaciones básicas para una cuenta bancaria:
    - `retirar`: Realiza un retiro de la cuenta.
    - `depositar`: Realiza un depósito en la cuenta.
    - `getSaldo`: Obtiene el saldo de la cuenta.
    - `getNumeroCuenta`: Obtiene el número de cuenta.

### `SavingsAccountStrategy` y `CurrentAccountStrategy`
- Implementaciones específicas de la estrategia de transacciones para cuentas de ahorro y cuentas corrientes.
- Proveen lógica personalizada para depósitos y retiros según el tipo de cuenta.

### `Transactions`
- Clase que almacena información sobre una transacción (depósito o retiro).
- Registra:
    - Saldo anterior.
    - Nuevo saldo.
    - Fecha y hora de la transacción.

---

## Patrón Strategy

El proyecto implementa el **Patrón Strategy** para manejar las operaciones bancarias de forma flexible.

### Definición
El patrón Strategy permite definir una familia de algoritmos (en este caso, las operaciones bancarias) y encapsularlas en clases separadas, de forma que puedan ser intercambiables.

### Implementación en el Proyecto
1. **Interfaz Base**:
    - `TransactionStrategy`: Define los métodos comunes para todas las estrategias de transacciones.

2. **Clases Concretas**:
    - `SavingsAccountStrategy`: Implementa la lógica para cuentas de ahorro.
    - `CurrentAccountStrategy`: Implementa la lógica para cuentas corrientes.

3. **Integración**:
    - Cada usuario tiene asignada una estrategia de transacción según su tipo de cuenta.
    - El método `getOperationStrategy` retorna la estrategia asociada a la cuenta.

### Ventajas del Patrón Strategy en este Proyecto
- **Flexibilidad**: Cada tipo de cuenta tiene su propia lógica para manejar transacciones.
- **Reusabilidad**: Se pueden agregar nuevos tipos de cuentas con estrategias personalizadas sin modificar el código existente.
- **Mantenimiento**: La lógica para depósitos y retiros está desacoplada del resto del sistema.

---

## Diagrama de Clases Simplificado

```plaintext
+-------------------+
|   TransactionStrategy   |
|-------------------|
| +retirar()         |
| +depositar()       |
| +getSaldo()        |
| +getNumeroCuenta() |
+-------------------+
          ^
          |
+--------------------+       +---------------------+
| SavingsAccountStrategy |   | CurrentAccountStrategy |
+--------------------+       +---------------------+
          ^
          |
+------------------+
|   BankAccount   |
|------------------|
| +setBalance()    |
| +getBalance()    |
+------------------+
          ^
          |
+--------------------+
| SavingsAccount     |
+--------------------+
| CurrentAccount     |
+--------------------+
```

### Menú Interactivo

El menú interactivo incluye las siguientes opciones:

1. **Crear usuario**: Permite crear un usuario y asignarle una cuenta bancaria.
2. **Seleccionar usuario**: Permite seleccionar un usuario existente para realizar operaciones en su cuenta.
3. **Salir**: Finaliza el programa.

### Gestión de Cuentas

Los usuarios pueden tener uno de los siguientes tipos de cuenta:

- **Cuenta de Ahorros**:
    - Soporta depósitos y retiros dentro del saldo disponible.
    - Incluye una tasa de interés.
- **Cuenta Corriente**:
    - Permite retirar fondos más allá del saldo disponible utilizando un límite de sobregiro.

## Instalación

1. Clonar este repositorio:
   ```bash
   git clone https://github.com/SergioAyalaHernandez/BankSergio


### Ejemplo de ejecución

Bienvenido al sistema bancario
1. Crear usuario
2. Seleccionar usuario
3. Salir
   Ingrese una opción: 1

Ingrese los siguientes datos:
ID de usuario: 12345
Nombre: Juan
Apellido: Pérez
Fecha de nacimiento (YYYY-MM-DD): 1990-01-01
País: Colombia
Número de documento: 987654321

Seleccione el tipo de cuenta:
1. Ahorros
2. Corriente
   Ingrese una opción: 1

Ingrese el número de cuenta: 10001
Ingrese el saldo inicial: 5000
Ingrese la tasa de interés: 2.5
Usuario y cuenta creados exitosamente.
