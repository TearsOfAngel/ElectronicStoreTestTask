package ru.isands.test.estore.dao.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "store_purchase")
public class Purchase implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Идентификатор покупки
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "purchase_counter")
	@TableGenerator(name = "purchase_counter", pkColumnName = "name", pkColumnValue = "ru.isands.test.estore.dao.entity.Purchase", table = "counter", valueColumnName = "currentid", allocationSize = 1)
	@Column(name = "id", unique = true, nullable = false)
	Long id;
	
	/**
	 * Идентификатор товара
	 */
	@Column(name = "electroId", nullable = false)
	Long electroId;
	
	/**
	 * Идентификатор сотрудника
	 */
	@ManyToOne
	@JoinColumn(name = "employeeId", nullable = false)
	private Employee employeeId;
	
	/**
	 * Идентификатор магазина
	 */
	@ManyToOne
	@JoinColumn(name = "shopId", nullable = false)
	private Shop shopId;
	
	/**
	 * Дата совершения покупки
	 */
	@Column(name = "purchaseDate", nullable = false)
	private Date purchaseDate;
	
	/**
	 * Способ оплаты
	 */
	@ManyToOne
	@JoinColumn(name = "typeId", nullable = false)
	private PurchaseType typeId;
	
}