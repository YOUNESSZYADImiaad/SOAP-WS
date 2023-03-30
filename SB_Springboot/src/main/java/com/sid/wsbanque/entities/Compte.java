package com.sid.wsbanque.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import java.util.Date;
@XmlRootElement
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Compte {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double solde;
    private Date datecreation;
    @ManyToOne()
    private Client client;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

}
