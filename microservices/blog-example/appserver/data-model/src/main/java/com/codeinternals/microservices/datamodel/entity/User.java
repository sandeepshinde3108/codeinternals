package com.codeinternals.microservices.datamodel.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_user",
        indexes = {
                @Index(name = "idx_tbl_user_username", columnList = "username"),
                @Index(name = "idx_unique_tbl_user_username", columnList = "username", unique = true),
                @Index(name = "idx_unique_tbl_user_email_address", columnList = "email_address", unique = true)
        })
@EntityListeners(AuditingEntityListener.class)
public final class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;

    @NotNull
    @Column(name = "email_address")
    private String emailId;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @OneToMany(mappedBy = "postedBy", fetch = FetchType.LAZY)
    private Set<Post> posts;
}
