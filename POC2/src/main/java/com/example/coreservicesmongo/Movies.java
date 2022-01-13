package com.example.coreservicesmongo;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "movies")
public class Movies {

    @Id
    private String id;
    public String name;
    public String genres;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
                ", name='" + name + '\'' +
                ", genres='" + genres + '\'' +
                '}';
    }
}
