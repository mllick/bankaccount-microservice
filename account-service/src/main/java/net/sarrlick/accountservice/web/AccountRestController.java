package net.sarrlick.accountservice.web;

import net.sarrlick.accountservice.clients.CustomerRestClient;
import net.sarrlick.accountservice.entities.BankAccount;
import net.sarrlick.accountservice.model.Customer;
import net.sarrlick.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {

    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;
    public AccountRestController(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }


    @GetMapping("/accounts")
    public List<BankAccount> bankAccountList() {
        List<BankAccount> bankAccountList = bankAccountRepository.findAll();
        bankAccountList.forEach(acc -> {
            acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));

        });
        return bankAccountList;
    }
    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id) {
        BankAccount bankAccount= bankAccountRepository.findById(id).get();
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
