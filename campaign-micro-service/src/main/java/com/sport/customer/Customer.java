package com.sport.customer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.sport.campaign.api.domain.Campaign;

@Entity
@Table(name="CUSTOMER")
public class Customer {
	
	@Id
	@Column(name="ID")
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="EMAIL", unique = true)
	private String email;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATE_OF_BIRTH")
	private Calendar dateOfBirth;
	
	@Column(name="ID_SOCCER_TEAM")
	private Long idSoccerTeam;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "CUSTOMER_CAMPAIGN", 
		joinColumns = @JoinColumn(name = "ID_CUSTOMER", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "ID_CAMPAIGN", referencedColumnName = "id"))
	private List<Campaign> campaigns = new ArrayList<Campaign>();
	
	public Customer() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Long getIdSoccerTeam() {
		return idSoccerTeam;
	}

	public void setIdSoccerTeam(Long idSoccerTeam) {
		this.idSoccerTeam = idSoccerTeam;
	}
	
	public List<Campaign> getCampaigns() {
		return campaigns;
	}
	
	public void setCampaigns(List<Campaign> campaigns) {
		this.campaigns = campaigns;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return this.getName();
	}
}
