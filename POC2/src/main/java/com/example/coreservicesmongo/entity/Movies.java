package com.example.coreservicesmongo.entity;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "movies")
public class Movies {

    @Transient
    public static final String SEQUENCE_NAME = "sequence";

    @Id
    private String id;
    private String tenantid;
    public String name;
    public String genres;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenantid() {
        return tenantid;
    }

    public void setTenantid(String tenantid) {
        this.tenantid = tenantid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "id='" + id + '\'' +
                ", tenantid='" + tenantid + '\'' +
                ", name='" + name + '\'' +
                ", genres='" + genres + '\'' +
                '}';
    }
}
