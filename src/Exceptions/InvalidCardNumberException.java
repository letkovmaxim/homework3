package Exceptions;

public class InvalidCardNumberException extends BankOnlineException {
    public InvalidCardNumberException() {}

    public InvalidCardNumberException(String msg) {
        super(msg);
    }
}
