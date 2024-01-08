package ua.kushnir.petproject.models.user;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "username", nullable = false)
    @NotEmpty(message = "Login should not be empty")
    @Size(min = 3, message = "Login should be more than 2  characters")
    private String username;
    @Column(name = "password", nullable = false)
    @NotEmpty(message = "Password should not be empty")
    @Size(min = 6, message = "Password should be more than 5  characters")
    private String password;
    @Column(name = "email", nullable = false)
    @Email(message = "Email should be valid")
    private String email;
    @ManyToMany
    @JoinTable(name="users_roles",
               joinColumns = @JoinColumn(name="user_id"),
               inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;
}
