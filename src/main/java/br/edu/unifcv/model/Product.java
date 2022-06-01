package br.edu.unifcv.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String description = "";

    private String fullDescription = "";

    private int buyPrice = 0;

    private int sellPrice = 0;

    private int minAmount = 0;

    private int amount = 0;

    private int soldAmount = 0;

    @Override
    public String toString() {
        return this.description;
    }

}
