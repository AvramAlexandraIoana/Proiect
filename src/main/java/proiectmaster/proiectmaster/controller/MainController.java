package proiectmaster.proiectmaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;
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
    public ResponseEntity<List<Transaction>> getTransactions() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(mainService.getTransactions());
    }

//    @PostMapping("/add")
//    public List<Transaction> addTransaction(@RequestBody Transaction transaction) {
//        return mainService.addTransaction(transaction);
//    }
    @PostMapping("/add")
    public ResponseEntity<List<Transaction>> addTransaction(@RequestBody Transaction transaction) {
        /*
        ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString()
        => localhost:8080/transactions/add
         */
        return ResponseEntity.created(UriComponentsBuilder.
                fromHttpUrl(ServletUriComponentsBuilder.
                        fromCurrentRequestUri().
                        toUriString())
                .path("").query("description={description}").build(transaction.getDescription()))
                .body(mainService.addTransaction(transaction));
    }

    /*
    Resource Server
    Authorization Server
     */
    @DeleteMapping("/delete/{description}")
    public List<Transaction> deleteTransaction(@PathVariable String description) {
        return mainService.deleteTransaction(description);
    }

    @GetMapping("/getTransaction")
    public Transaction getTransactionByDescription(@RequestParam String description) {
        return mainService.getTransactionByDescription(description);
    }

}
