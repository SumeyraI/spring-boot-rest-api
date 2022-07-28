package com.spring.example.entities;

import com.spring.example.embedded.Contact;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Getter
@ToString
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERS")
public class User extends BaseEntity{

    private String firstname;
    private String lastName;

    @Embedded
    private Contact contact;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId") // Address tablosu ile ilişki kurulacak sütunumuz !!
    private Address address;

}
