package com.soprasteria.devopsassesmenttool.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "category_details")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cId;

	private String categoryName;

	public Category() {
	}

	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	private Set<Question> Questions = new HashSet<Question>();

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the questions
	 */
	public Set<Question> getQuestions() {
		return Questions;
	}

	/**
	 * @param questions the questions to set
	 */

	public void setQuestions(Set<Question> questions) {
		Questions = questions;
	}

	/**
	 * @return the id
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @return the cId
	 */
	public Integer getcId() {
		return cId;
	}

	/**
	 * @param cId the cId to set
	 */
	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
