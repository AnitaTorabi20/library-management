package library;

import datastructures.lists.CustomArrayList;

public class Member {
    private String memberId;
    private String name;
    private CustomArrayList transactions;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.transactions = new CustomArrayList();
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public Transaction getLastTransaction() {
        int size = transactions.size();
        if (size == 0) {
            return null;
        }
        return (Transaction) transactions.get(size - 1);
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}