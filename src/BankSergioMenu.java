import Entity.*;
import Strategy.TransactionStrategy;
import Util.MessageConstants;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankSergioMenu {

    private static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showOptions(MessageConstants.MAIN_MENU);
            showUserOptions(scanner);
        }
    }

    private static void showUserOptions(Scanner scanner) {
        switch (scanner.nextInt()) {
            case 1 -> createUser(scanner);
            case 2 -> System.out.println(users.isEmpty() ? MessageConstants.USER_NOT_FOUND : selectUser(scanner));
            case 3 -> {
                System.out.println(MessageConstants.MESSAGE_EXIT);
                scanner.close();
                System.exit(0);
            }
            default -> System.out.println(MessageConstants.OPTION_ERROR);
        }
    }

    private static void createUser(Scanner scanner) {
        User user = captureUser(scanner);
        showOptions(MessageConstants.MAIN_MENU_ACCOUNTS);
        int accountType = scanner.nextInt();

        System.out.print(MessageConstants.ACCOUNT_PROMPTS[0]);
        String accountNumber = scanner.next();

        System.out.print(MessageConstants.ACCOUNT_PROMPTS[1]);
        double initialBalance = Double.parseDouble(scanner.next());

        if (accountType == 1) {
            System.out.print(MessageConstants.ENTER_INTEREST_RATE);
            double interestRate = scanner.nextDouble();
            SavingsAccount savingsAccount = new SavingsAccount(accountNumber, initialBalance, interestRate);
            user.setSavingsAccount(savingsAccount);
        } else if (accountType == 2) {
            System.out.print(MessageConstants.ENTER_OVERDRAFT_RATE);
            double overdraftLimit = scanner.nextDouble();
            CurrentAccount currentAccount = new CurrentAccount(accountNumber, initialBalance, overdraftLimit);
            user.setCurrentAccount(currentAccount);
        } else {
            System.out.println(MessageConstants.COUNT_ERROR);
            return;
        }

        users.add(user);
        System.out.println("Usuario y cuenta creados exitosamente.");
    }

    private static User captureUser(Scanner scanner) {
        List<String> userInputs = captureUserInputs(MessageConstants.USER_PROMPTS, scanner);
        String userId = userInputs.get(0);
        String accountId = userInputs.get(1);
        String userName = userInputs.get(2);
        String userLastName = userInputs.get(3);
        LocalDate dateOfBirth = validateDate(userInputs);
        String country = userInputs.get(5);
        String numberDocument = userInputs.get(6);
        return new User(userId, accountId, userName, userLastName, dateOfBirth, country, numberDocument);
    }

    private static LocalDate validateDate(List<String> userInputs) {
        LocalDate dateOfBirth = null;
        try {
            dateOfBirth = LocalDate.parse(userInputs.get(4));
        } catch (DateTimeParseException e) {
            System.out.println(MessageConstants.FORMAT_DATE_ERROR + userInputs.get(4));
        }
        return dateOfBirth;
    }

    private static Object selectUser(Scanner scanner) {
        showUsers();
        Integer userIndex = validateUserIndexOption(scanner);
        if (userIndex == null) return null;
        User selectedUser = users.get(userIndex);
        manageUserAccount(scanner, selectedUser);
        return selectedUser;
    }

    private static Integer validateUserIndexOption(Scanner scanner) {
        System.out.print("Seleccione un usuario por número: ");
        int userIndex = scanner.nextInt() - 1;
        if (userIndex < 0 || userIndex >= users.size()) {
            System.out.println("Selección no válida.");
            return null;
        }
        return userIndex;
    }

    private static void showUsers() {
        System.out.println("\n--- Lista de Usuarios ---");
        for (int i = 0; i < users.size(); i++) {
            System.out.println((i + 1) + ". " + users.get(i).getUserId() + " - " + users.get(i).getName());
        }
    }

    private static void manageUserAccount(Scanner scanner, User user) {
        while (true) {
            displayUserMenu(user);
            int option = scanner.nextInt();

            BankAccount account = getUserAccount(user);
            TransactionStrategy strategy = account != null ? account.getOperationStrategy() : null;

            if (strategy == null) {
                System.out.println(MessageConstants.NO_ACCOUNT_ASSIGNED);
                return;
            }

            processUserOption(scanner, user, account, strategy, option);
        }
    }

    private static void displayUserMenu(User user) {
        System.out.printf((MessageConstants.USER_MENU_HEADER) + "%n", user.getName());
        showOptions(MessageConstants.ACCOUNT_COUNT_ACTIONS_PROMPTS);
    }

    private static BankAccount getUserAccount(User user) {
        return user.getCurrentAccount() != null ? user.getCurrentAccount() : user.getSavingsAccount();
    }

    private static void processUserOption(Scanner scanner, User user, BankAccount account, TransactionStrategy strategy, int option) {
        switch (option) {
            case 1 -> handleDeposit(scanner, user, account, strategy);
            case 2 -> handleWithdrawal(scanner, user, account, strategy);
            case 3 -> displayBalance(strategy, account);
            case 4 -> showTransactions(user);
            case 5 -> System.exit(0);
            default -> System.out.println(MessageConstants.INVALID_OPTION);
        }
    }

    private static void handleDeposit(Scanner scanner, User user, BankAccount account, TransactionStrategy strategy) {
        System.out.print(MessageConstants.ENTER_DEPOSIT_AMOUNT);
        double depositAmount = scanner.nextDouble();
        strategy.depositar(account, depositAmount);
        addTransaction(user, account, depositAmount, true);
    }

    private static void handleWithdrawal(Scanner scanner, User user, BankAccount account, TransactionStrategy strategy) {
        System.out.print(MessageConstants.ENTER_WITHDRAWAL_AMOUNT);
        double withdrawalAmount = scanner.nextDouble();
        strategy.retirar(account, withdrawalAmount);
        addTransaction(user, account, withdrawalAmount, false);
    }

    private static void displayBalance(TransactionStrategy strategy, BankAccount account) {
        System.out.println("Saldo actual: $" + strategy.getSaldo(account));
    }



    private static void addTransaction(User user, BankAccount account, double amount, boolean isDeposit) {
        double previousBalance = account.getBalance();
        double newBalance = isDeposit ? amount : previousBalance - amount;
        Transactions transaction = new Transactions(user.getTransactions().size() + 1,
                previousBalance, newBalance, LocalDateTime.now()
        );
        user.getTransactions().add(transaction);
        System.out.println(MessageConstants.TRANSACTION_REGISTERED_SUCCESSFULLY);
    }

    private static void showTransactions(User user) {
        List<Transactions> transactions = user.getTransactions();
        if (transactions.isEmpty()) {
            System.out.println(MessageConstants.NO_TRANSACTIONS_REGISTERED);
            return;
        }

        System.out.println(MessageConstants.TRANSACTION_PROMPT);
        for (Transactions transaction : transactions) {
            System.out.println(MessageConstants.formatTransactionDetails(transaction));
        }

    }

    private static void showOptions(String[] messages) {
        for (String message : messages) {
            System.out.println(message);
        }
    }

    public static List<String> captureUserInputs(String[] prompts, Scanner scanner) {
        List<String> inputs = new ArrayList<>();
        for (String prompt : prompts) {
            System.out.print(prompt);
            inputs.add(scanner.next());
        }
        return inputs;
    }
}
