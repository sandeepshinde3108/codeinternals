package com.codeinternals.microservices.datamodel.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

/**
 * 1. @EntityListeners is to listen on insert or update events and
 *    AuditingEntityListener class - updates the createdDate and updatedDate fields in BaseEntity
 */

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_post",
indexes = {
        @Index(name = "idx_tbl_post_posted_date", columnList = "posted_date")
})
@EntityListeners(AuditingEntityListener.class)
public final class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String title;
    @NotNull
    private String description;

    @ManyToOne
    @JoinColumn(name = "posted_by", referencedColumnName = "id")
    private User postedBy;

    @Column(name = "posted_date")
    private Timestamp postedDate;

    @OneToOne(mappedBy = "post", fetch = FetchType.LAZY)
    private Like likes;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private Set<Comment> comments;
}
