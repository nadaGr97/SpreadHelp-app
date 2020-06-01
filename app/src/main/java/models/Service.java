package models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Service implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Date DatePublication;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    @ManyToMany
    List<Gouvernorat> Gouvernorats = new ArrayList<>();

    @OneToOne(cascade=CascadeType.ALL)
    private Type type;

    public Service(){

    }
    public Service(Long id, String description, Date datePublication, Date createdAt, Date updatedAt, List<Gouvernorat> gouvernorats) {
        this.id = id;
        this.description = description;
        DatePublication = datePublication;
        Gouvernorats = gouvernorats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatePublication() {
        return DatePublication;
    }

    public void setDatePublication(Date datePublication) {
        DatePublication = datePublication;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Gouvernorat> getGouvernorats() {
        return Gouvernorats;
    }

    public void setGouvernorats(List<Gouvernorat> Gouvernorats) {
        this.Gouvernorats = Gouvernorats;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
