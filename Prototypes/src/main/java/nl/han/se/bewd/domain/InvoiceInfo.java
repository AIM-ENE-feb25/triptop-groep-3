package nl.han.se.bewd.domain;

import java.time.LocalDate;

public class InvoiceInfo {

    private final String invoiceNumber;
    private final LocalDate date;
    private final String accountNumber;
    private final String nameOnAccount;
    private final double amount;
    private final String description;

    public InvoiceInfo(String invoiceNumber, LocalDate date, String accountNumber, String nameOnAccount, double amount, String description) {
        this.invoiceNumber = invoiceNumber;
        this.date = date;
        this.accountNumber = accountNumber;
        this.nameOnAccount = nameOnAccount;
        this.amount = amount;
        this.description = description;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getNameOnAccount() {
        return nameOnAccount;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}