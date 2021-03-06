/**
 * 
 */
package com.soprasteria.devopsassesmenttool.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	private Long userId;

	@Column(unique = true)
	private String username;

	private String usermailid;

	private String password;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@org.hibernate.annotations.OrderBy(clause = "answerId")
	private Set<Answer> answers = new HashSet<Answer>();

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
	private Account account;

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
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
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

	
	private String loginName;
	private String accountName;
	@Transient
	private String DevopsStatus;
	@Transient
	private String AgileStatus;


	/**
	 * @return the devopsStatus
	 */
	public String getDevopsStatus() {
		return DevopsStatus;
	}

	/**
	 * @param devopsStatus the devopsStatus to set
	 */
	public void setDevopsStatus(String devopsStatus) {
		DevopsStatus = devopsStatus;
	}

	/**
	 * @return the agileStatus
	 */
	public String getAgileStatus() {
		return AgileStatus;
	}

	/**
	 * @param agileStatus the agileStatus to set
	 */
	public void setAgileStatus(String agileStatus) {
		AgileStatus = agileStatus;
	}

	/**
	 * @return the loginName
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * @param accountName the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public User() {

	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the answers
	 */
	@JsonIgnore
	public Set<Answer> getAnswers() {
		return answers;
	}

	/**
	 * @param answers the answers to set
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
	 * @param username the username to set
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
	 * @param usermailid the usermailid to set
	 */
	public void setUsermailid(String usermailid) {
		this.usermailid = usermailid;
	}





}
