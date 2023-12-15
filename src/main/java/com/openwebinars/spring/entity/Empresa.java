package com.openwebinars.spring.entity;

import java.util.Objects;

import jakarta.persistence.*;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String job;
    private String description;
    private String location;

    public Empresa() {}

    public Empresa(String name, String job, String description, String location) {
        this.name = name;
        this.job = job;
        this.description = description;
        this.location = location;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getJob() {
        return this.job;
    }

    public String getDescription() {
        return this.description;
    }

    public String getLocation() {
        return this.location;
    }


    public void setId(Long id) {
        this.id = id;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Empresa empresa)) return false;
        return Objects.equals(this.id, empresa.id) &&
                Objects.equals(this.name, empresa.name) &&
                Objects.equals(this.job, empresa.job) &&
                Objects.equals(this.description, empresa.description) &&
                Objects.equals(this.location, empresa.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.job, this.description, this.location);
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", job='" + this.job + '\'' +
                ", description='" + this.description + '\'' +
                ", location='" + this.location + '\'' +
                '}';
    }
}
