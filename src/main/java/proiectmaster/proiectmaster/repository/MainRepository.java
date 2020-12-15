package proiectmaster.proiectmaster.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import proiectmaster.proiectmaster.model.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MainRepository {
    private static final Logger logger = LoggerFactory.getLogger(MainRepository.class);
    private static  List<Transaction> transactionList = new ArrayList<>();

    public MainRepository() {
//        transactionList.add(Transaction.builder()
//                            .value(2323)
//                            .description("test").unit("USD").build());
        transactionList.add(new Transaction(12, "Test1", "USD"));
        transactionList.add(new Transaction(23, "Test2", "EUR"));
        transactionList.add(new Transaction(200, "Test3", "RON"));

    }
    public List<Transaction> getTransactions() {
        logger.info("Se vor prelua din repo tranzactiile: {}", transactionList);
        return transactionList;
    }

    public List<Transaction> addTransaction(Transaction transaction) {
        transactionList.add(transaction);
        logger.info("S-a adaugat la lista tranzactia: {}", transaction);
        return transactionList;
    }

    public List<Transaction> deleteTransaction(String description) {
        transactionList = transactionList.stream()
                          .filter(transaction -> !transaction.getDescription().equals(description))
                          .collect(Collectors.toList());
        logger.info("S-a sters din lista tranzactia cu descrierea: {}", description);
        return transactionList;
    }

    public Transaction getTransactionByDescription(String description) {
        logger.info("S-a cerut tranzactia cu descrierea: {}", description);
        return transactionList.stream()
                .filter(transaction -> transaction.getDescription().equals((description)))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Tranzactia cautata nu exista!"));
    }

}
