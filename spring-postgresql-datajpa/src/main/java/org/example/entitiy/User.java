package org.example.entitiy;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "Kisi")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class User {
    @Id
    @SequenceGenerator(name = "seq_kisi",allocationSize = 1)
    @GeneratedValue(generator = "seq_kisi",strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(length = 100,name = "name")
    private String name;
    @Column(length = 100,name = "lastName")
    private String lastName;

    @OneToMany
    @JoinColumn(name = "kisi_adres_id")
    private List<Address> adresler;



}
