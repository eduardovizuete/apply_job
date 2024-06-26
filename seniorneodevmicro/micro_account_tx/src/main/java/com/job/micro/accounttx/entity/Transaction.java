package com.job.micro.accounttx.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.job.micro.accounttx.entity.enumeration.TypeTx;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date")
    private Instant date;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TypeTx type;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "balanceBeforeTx")
    private Double balanceBeforeTx;

    @Column(name = "balance")
    private Double balance;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "client", "transactions" }, allowSetters = true)
    private Account account;

}
