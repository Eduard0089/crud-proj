package com.web.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;

@Entity
@Table(name = "roles")

public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Column(name = "name", nullable = false, length = 20, unique = true, updatable = false, insertable = false)

    private String name;

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    @Override
    public String toString() {return "Role{" + "id=" + id + ", name='" + name +  '}';}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        else if (o == null || getClass() != o.getClass()) return false;
        else {
            Role role = (Role) o;
            return Objects.equals(name, role.name);
        }
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
