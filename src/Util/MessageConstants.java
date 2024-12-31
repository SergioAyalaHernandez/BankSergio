package Util;

import Entity.Transactions;

public class MessageConstants {
    public static final String[] MAIN_MENU = {
            "\n--- MENÚ PRINCIPAL ---",
            "1. Crear Usuario",
            "2. Seleccionar Usuario",
            "3. Salir",
            "Seleccione una opción: "
    };
    public static final String[] MAIN_MENU_ACCOUNTS = {
            "\n--- Tipo de Cuenta ---",
            "1. Cuenta de Ahorros",
            "2. Cuenta Corriente",
            "Seleccione el tipo de cuenta: "
    };
    public static final String[] USER_PROMPTS = {
            "Ingrese el ID del usuario: ",
            "Ingrese el ID de la cuenta: ",
            "Ingrese el nombre del usuario: ",
            "Ingrese el apellido del usuario: ",
            "Ingrese la fecha de nacimiento del usuario (YYYY-MM-DD): ",
            "Ingrese el país de nacimiento del usuario: ",
            "Ingrese el número de documento del usuario: "
    };

    public static final String[] ACCOUNT_PROMPTS = {
            "Ingrese el número de cuenta: ",
            "Ingrese el saldo inicial: "
    };
    public static final String[] ACCOUNT_ACTIONS_PROMPTS = {
            "1. Depositar", "2. Retirar", "3. Consultar Saldo", "4. Ver Transacciones",
            "5. Volver al Menú Principal", "Seleccione una opción: "
    };

    public static final String USER_NOT_FOUND = "No hay usuarios registrados. Cree uno primero.";

    public static final String OPTION_ERROR = "Opción no válida. Intente nuevamente.";

    public static final String ENTER_INTEREST_RATE = "Ingrese la tasa de interés: ";

    public static final String ENTER_OVERDRAFT_RATE = "Ingrese la tasa de interés: ";

    public static final String COUNT_ERROR = "Tipo de cuenta no válido. Usuario no creado.";

    public static final String FORMAT_DATE_ERROR = "El formato de la fecha es inválido: ";

    public static final String MESSAGE_EXIT = "Gracias por visitar BankSergio. ¡Hasta luego!";

    public static final String TRANSACTION_DETAILS_TEMPLATE =
            "ID: %d\n" +
                    "Monto Anterior: $%.2f\n" +
                    "Monto Nuevo: $%.2f\n" +
                    "Fecha: %s\n" +
                    "---";

    public static String formatTransactionDetails(Transactions transaction) {
        return String.format(
                TRANSACTION_DETAILS_TEMPLATE,
                transaction.getTransactionId(),
                transaction.getPreviousAmount(),
                transaction.getNewAmount(),
                transaction.getTransactionDate()
        );
    }

    public static final String TRANSACTION_REGISTERED_SUCCESSFULLY = "Transacción registrada exitosamente.";
    public static final String NO_TRANSACTIONS_REGISTERED = "No hay transacciones registradas.";
    public static final String TRANSACTION_PROMPT = "--- Transacciones ---";
    public static final String USER_MENU_HEADER = "\n--- Menú de Usuario (%s) ---";
    public static final String NO_ACCOUNT_ASSIGNED = "El usuario no tiene una cuenta asignada.";
    public static final String ENTER_DEPOSIT_AMOUNT = "Ingrese el monto a depositar: ";
    public static final String ACCOUNT_USERS_ACTIONS_PROMPTS = "\nSeleccione una acción:\n1. Depositar\n2. Retirar\n3. Mostrar saldo\n4. Mostrar transacciones\n5. Salir";
    public static final String ENTER_WITHDRAWAL_AMOUNT = "Ingrese el monto a retirar: ";
    public static final String INVALID_OPTION = "Opción no válida. Intente nuevamente.";
    public static final String[] ACCOUNT_COUNT_ACTIONS_PROMPTS = {
            "Seleccione una acción:",
            "1. Depositar",
            "2. Retirar",
            "3. Mostrar saldo",
            "4. Mostrar transacciones",
            "5. Salir"
    };

}

