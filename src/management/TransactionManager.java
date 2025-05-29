package management;

import library.Transaction;
import datastructures.lists.CustomArrayList;

public class TransactionManager {
    private CustomArrayList transactions;

    public TransactionManager() {
        transactions = new CustomArrayList();
    }

    public Transaction addTransaction(String bookTitle, String memberName, String type) {

        Transaction transaction = new Transaction(
                "TXN-" + System.currentTimeMillis(),
                bookTitle,
                memberName,
                type
        );

        transactions.add(transaction);
        return transaction;
    }

    public Transaction getTransactionByIndex(int index) {
        if (index < 0 || index >= transactions.size()) {
            return null;
        }
        return (Transaction) transactions.get(index);
    }
}
