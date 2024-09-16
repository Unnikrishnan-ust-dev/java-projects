package org.ust.oauth.model;
import org.ust.oauth.utils.Provider;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Enumerated(EnumType.STRING)
    private Provider provider;
    @Id
    private Long id;

    public User() {
    }

    public User(Provider provider, Long id) {
        this.provider = provider;
        this.id = id;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
