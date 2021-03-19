package Exceptions;

public class LimitAmountTransferException extends BankOnlineException {
    public LimitAmountTransferException() {}

    public LimitAmountTransferException(String msg) {
        super(msg);
    }
}
