package com.ust.jpamanytomany.resources;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    private Date postedAt = new Date();
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdateAt = new Date();

    @ManyToMany(fetch=FetchType.LAZY,
            cascade = { CascadeType.PERSIST,
                    CascadeType.MERGE})
    @JoinTable(name="post_tags",
            joinColumns = {@JoinColumn(name="post_id")},
            inverseJoinColumns = {@JoinColumn(name="tag_id")})
    private Set<Tag> tags =new HashSet<>();





    public Post(String title, String description, String content)
    {

        this.title = title;
        this.description = description;
        this.content = content;
    }
}
