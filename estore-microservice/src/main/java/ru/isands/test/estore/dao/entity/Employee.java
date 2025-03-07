package ru.isands.test.estore.dao.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "store_employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Идентификатор сотрудника
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "employee_counter")
	@TableGenerator(name = "employee_counter", pkColumnName = "name", pkColumnValue = "ru.isands.test.estore.dao.entity.Employee", table = "counter", valueColumnName = "currentid", allocationSize = 2)
	@Column(name = "id", unique = true, nullable = false)
	Long id;
	
	/**
	 * Фамилия сотрудника
	 */
	@Column(name = "lastname", nullable = false, length = 100)
	String lastName;
	
	/**
	 * Имя сотрудника
	 */
	@Column(name = "firstname", nullable = false, length = 100)
	String firstName;
	
	/**
	 * Отчество сотрудника
	 */
	@Column(name = "patronymic", nullable = false, length = 100)
	String patronymic;
	
	/**
	 * Дата рождения сотрудника
	 */
	@Column(name = "birthDate", nullable = false)
	Date birthDate;
	
	/**
	 * Ссылка на должность сотрудника
	 */
	@ManyToOne
	@JoinColumn(name = "positionId", nullable = false)
	private PositionType positionId;

	/**
	 * Магазин, где работает сотрудник
	 */
	@ManyToOne
	@JoinColumn(name = "shopId", nullable = false)
	private Shop shopId;
	
	/**
	 * Пол сотрудника (true - мужской, false - женский)
	 */
	@Column(name = "gender", nullable = false)
	boolean gender;

}