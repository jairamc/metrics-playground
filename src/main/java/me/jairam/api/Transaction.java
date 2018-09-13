package me.jairam.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;

public class Transaction {

    public Transaction() {
        // For Jackson
    }

    public Transaction(String id, String firstname, String lastname, String item, double amount) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.item = item;
        this.amount = amount;
    }

    private String id;

    @NotEmpty
    private String firstname;

    @NotEmpty
    private String lastname;

    private String item;

    @Min(0)
    private double amount;

    @JsonProperty
    public String getId() {
        return id;
    }

    @JsonProperty
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty
    public String getFirstname() {
        return firstname;
    }

    @JsonProperty
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @JsonProperty
    public String getLastname() {
        return lastname;
    }

    @JsonProperty
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @JsonProperty
    public String getItem() {
        return item;
    }

    @JsonProperty
    public void setItem(String item) {
        this.item = item;
    }

    @JsonProperty
    public double getAmount() {
        return amount;
    }

    @JsonProperty
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
