/**
 * 
 */
package com.soprasteria.devopsassesmenttool.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author dbkumar
 *
 */

@Entity
@Table(name = "user_details")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	private String username;

	private String usermailid;

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	private String role;

	private String password;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Set<Answer> answers = new HashSet<Answer>();

	public User() {

	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the answers
	 */
	@JsonIgnore
	public Set<Answer> getAnswers() {
		return answers;
	}

	/**
	 * @param answers
	 *            the answers to set
	 */
	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the usermailid
	 */
	public String getUsermailid() {
		return usermailid;
	}

	/**
	 * @param usermailid
	 *            the usermailid to set
	 */
	public void setUsermailid(String usermailid) {
		this.usermailid = usermailid;
	}

	public User get() {
		// TODO Auto-generated method stub
		return null;
	}

}
