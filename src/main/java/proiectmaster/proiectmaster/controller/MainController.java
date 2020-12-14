package proiectmaster.proiectmaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import proiectmaster.proiectmaster.model.Transaction;
import proiectmaster.proiectmaster.service.MainService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transactions")
public class MainController {

    @Autowired
    private MainService mainService;

    @GetMapping("/get")
    public List<Transaction> getTransactions() {
        return mainService.getTransactions();
    }

    @PostMapping("/add")
    public List<Transaction> addTransaction(@RequestBody Transaction transaction) {
        return mainService.addTransaction(transaction);
    }

    @DeleteMapping("/delete/{description}")
    public List<Transaction> deleteTransaction(@PathVariable String description) {
        return mainService.deleteTransaction(description);
    }

    @GetMapping("/getTransaction")
    public Transaction getTransactionByDescription(@RequestParam String description) {
        return mainService.getTransactionByDescription(description);
    }
}
