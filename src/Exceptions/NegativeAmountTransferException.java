package Exceptions;

public class NegativeAmountTransferException extends BankOnlineException {
    public NegativeAmountTransferException() {}

    public NegativeAmountTransferException(String msg) {
        super(msg);
    }
}
