package proiectmaster.proiectmaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proiectmaster.proiectmaster.model.Transaction;
import proiectmaster.proiectmaster.repository.MainRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * SOLID
 *
 */
@Service
public class MainService {

    @Autowired
    private MainRepository mainRepository;

    public List<Transaction> getTransactions() {
        return mainRepository.getTransactions();
    }

    public List<Transaction> addTransaction(Transaction transaction) {
        return mainRepository.addTransaction(transaction);
    }

    public List<Transaction> deleteTransaction(String description) {
        return mainRepository.deleteTransaction(description);
    }

    public Transaction getTransactionByDescription(String description) {
        return mainRepository.getTransactionByDescription(description);
    }

}
