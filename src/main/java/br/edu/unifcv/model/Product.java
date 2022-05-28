package br.edu.unifcv.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(min = 3, max = 60)
    private String description;

    @NotBlank
    @Size(max = 255)
    private String fullDescription;

    @NotNull
    private double buyPrice;

    @NotNull
    private double sellPrice;

    @NotNull
    private int minAmount;

    @NotNull
    private int amount;

    @NotNull
    private int soldAmount;

    @NotNull
    private OffsetDateTime expirationDate;

}
