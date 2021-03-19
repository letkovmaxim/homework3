package Exceptions;

public class BannedCardNumberTransferException extends BankOnlineException {
    public BannedCardNumberTransferException () {}

    public BannedCardNumberTransferException(String msg) {
        super(msg);
    }
}
