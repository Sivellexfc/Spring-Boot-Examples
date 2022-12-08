package org.example.entitiy;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "KisiAdres")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Address implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_kisi_adres",allocationSize = 1)
    @GeneratedValue(generator = "seq_kisi_adres",strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(length = 500,name = "adres")
    private String adres;

    @Enumerated
    private AdresTip adresTip;

    @Column(name = "isActive")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "kisi_adres_id")
    private User user;

    public enum AdresTip{
        EV_ADRESI,
        IS_ADRESI,
        DIGER
    }

}
