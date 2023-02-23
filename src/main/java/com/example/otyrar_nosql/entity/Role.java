package com.example.otyrar_nosql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "Role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    private int id;
    private String name;

    public Role(String name) {
        super();
        this.name = name;
    }

}
