package com.sport.campaign.api.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author Joel Marques
 */
@Entity
@Table(name="CAMPAIGN")
public class Campaign {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="ID_SOCCER_TEAM")
	private Long idSoccerTeam;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="INITIAL_PERIOD")
	private Calendar initialPeriod;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="FINAL_PERIOD")
	private Calendar finalPeriod;
	
	public Campaign() {
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

	public Long getIdSoccerTeam() {
		return idSoccerTeam;
	}

	public void setIdSoccerTeam(Long idSoccerTeam) {
		this.idSoccerTeam = idSoccerTeam;
	}

	public Calendar getInitialPeriod() {
		return initialPeriod;
	}

	public void setInitialPeriod(Calendar initialPeriod) {
		this.initialPeriod = initialPeriod;
	}

	public Calendar getFinalPeriod() {
		return finalPeriod;
	}

	public void setFinalPeriod(Calendar finalPeriod) {
		this.finalPeriod = finalPeriod;
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
		Campaign other = (Campaign) obj;
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