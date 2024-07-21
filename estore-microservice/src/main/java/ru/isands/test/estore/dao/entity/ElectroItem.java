package ru.isands.test.estore.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "ElectroItem")
public class ElectroItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Название товара
     */
    @Column(length = 150, nullable = false)
    private String name;

    /**
     * Тип товара
     */
    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private ElectronicType electronicType;

    /**
     * Цена товара за штуку
     */
    private Long price;

    /**
     * Общее кол-во
     */
    private int count;

    /**
     * Доступность товара (true - доступен, false - недоступен
     */
    private boolean archive;

    /**
     * Описание товара
     */
    private String description;
}
