package Exceptions;

public class BankOnlineException extends Exception {
    String message;

    public BankOnlineException() {}

    public BankOnlineException(String msg) {
        this.message = msg;
    }

    public void getExceptionMessage() {
        System.out.println("Ошибка: " + message);
    }
}
