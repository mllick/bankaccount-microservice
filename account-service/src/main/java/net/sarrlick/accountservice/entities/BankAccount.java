package net.sarrlick.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.sarrlick.accountservice.enums.AccountType;
import net.sarrlick.accountservice.model.Customer;

import java.time.LocalDate;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate creatAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;

}
