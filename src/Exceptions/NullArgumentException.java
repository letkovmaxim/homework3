package Exceptions;

public class NullArgumentException extends BankOnlineException {
    public NullArgumentException() {}

    public NullArgumentException(String msg) {
        super(msg);
    }
}
