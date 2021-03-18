import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class BankOnlineException extends Exception {
    String message;

    public BankOnlineException() {}

    public BankOnlineException(String msg) {
        this.message = msg;
    }

    public void getExceptionMessage() {
        System.out.println("Ошибка: "+message);
    }
}

class InvalidCardNumberException extends BankOnlineException {
    InvalidCardNumberException() {}

    InvalidCardNumberException(String msg) {
        super(msg);
    }
}

class BannedCardNumberTransferException extends BankOnlineException {
    BannedCardNumberTransferException () {}

    BannedCardNumberTransferException(String msg) {
        super(msg);
    }
}

class NegativeAmountTransferException extends BankOnlineException {
    NegativeAmountTransferException() {}

    NegativeAmountTransferException(String msg) {
        super(msg);
    }
}

class LimitAmountTransferException extends BankOnlineException {
    LimitAmountTransferException() {}

    LimitAmountTransferException(String msg) {
        super(msg);
    }
}

class NullArgumentException extends BankOnlineException {
    NullArgumentException() {}

    NullArgumentException(String msg) {
        super(msg);
    }
}

public class BankOnline{

    private static boolean isCardNumberBanned(String cardNumber) {
        boolean isNumbersEqual = false;

        try (BufferedReader reader = new BufferedReader(new FileReader("Resources\\BannedCardNumbers.txt"))) {
            String number = "";

            while (reader.ready()) {
                number = reader.readLine();
                if (number.equals(cardNumber)) {
                    isNumbersEqual = true;
                }
            }

        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        return isNumbersEqual;
    }

    private static boolean isCardNumberInvalid(String cardNumber) {
        boolean isCharactersDigits = true;

        for (char i : cardNumber.toCharArray()) {
            if (Character.isDigit(i)) {
                isCharactersDigits = false;
            }
        }
        return isCharactersDigits;
    }

    public static void send(String cardNumber, Double transferAmount) throws BankOnlineException{
        if ((cardNumber == null) | (transferAmount == null)) {
            throw new NullArgumentException("Один из аргументов равен null");
        }
        if (cardNumber.length() != 16 | isCardNumberInvalid(cardNumber)) {
            throw new InvalidCardNumberException("Неправильно введен номер карты");
        }
        if (isCardNumberBanned(cardNumber)) {
            throw new BannedCardNumberTransferException("Номер карты заблокирован");
        }
        if (transferAmount < 0) {
            throw new NegativeAmountTransferException("Введена отрицательная сумма перевода");
        }
        if (transferAmount > 50000) {
            throw new LimitAmountTransferException("Превышен лимит в 50 000");
        }

        System.out.println("Перевод прошёл успешно!");
    }

    public static void main(String[] args) throws BankOnlineException {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите номер карты >> ");
        String cardNumber = input.nextLine();
        System.out.print("Введите размер перевода >> ");
        Double transferAmount = input.nextDouble();

        try {
            send(cardNumber, transferAmount);
        } catch (NullArgumentException | InvalidCardNumberException | BannedCardNumberTransferException |
                NegativeAmountTransferException | LimitAmountTransferException e) {
            e.getExceptionMessage();
        }
    }

}
