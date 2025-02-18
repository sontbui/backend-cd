package com.demo.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "photo", catalog = "music_store")
public class Photo implements Serializable {

    private Integer id;
    private String name;
    private Boolean status;
    private Cd cd;

    public Photo() {
    }

    public Photo(String name, Boolean status, Cd cd) {
        this.name = name;
        this.status = status;
        this.cd = cd;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", length = 250)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "status")
    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cd_id", nullable = false)
    public Cd getCd() {
        return this.cd;
    }

    public void setCd(Cd cd) {
        this.cd = cd;
    }
}
