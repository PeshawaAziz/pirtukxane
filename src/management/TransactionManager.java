package management;

import datastructures.lists.CustomArrayList;
import java.util.Date;
import library.Transaction;

public class TransactionManager {
    private CustomArrayList<Transaction> transactions;

    public TransactionManager() {
        transactions = new CustomArrayList<>();
    }

    public Transaction addTransaction(String bookTitle, String memberName, String type) {
        Transaction transaction = new Transaction(
                "TXN-" + new Date().getTime(),
                bookTitle,
                memberName,
                type);

        transactions.add(transaction);

        return transaction;
    }

    public Transaction getTransactionByIndex(int index) {
        return transactions.get(index);
    }
}
