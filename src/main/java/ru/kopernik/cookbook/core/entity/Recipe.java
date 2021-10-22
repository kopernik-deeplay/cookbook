package ru.kopernik.cookbook.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Рецепт
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "recipes")
public class Recipe {
    //Идентификатор рецепта
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //Название
    @Column(name = "title")
    private String title;
    //Описание
    @Column(name = "description")
    private String description;
}
