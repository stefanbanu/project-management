package com.stefanbanu.pma.entities;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BaseEntityProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long project_id;
}
