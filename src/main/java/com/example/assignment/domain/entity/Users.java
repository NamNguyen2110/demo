package com.example.assignment.domain.entity;

import com.example.assignment.domain.converter.UserStatusConverter;
import com.example.assignment.domain.enums.UserStatus;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.UUIDGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users extends AbstractEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "username")
    private String username;
//    @Column(name = "status")
//    @Convert(converter = UserStatusConverter.class)
//    private UserStatus status;
}
