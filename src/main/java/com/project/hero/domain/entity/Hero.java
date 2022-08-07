package com.project.hero.domain.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
@Audited
@Getter
@Setter
public class Hero {
    @Id
    private Integer id;
    private String name;
    private String power;
}
