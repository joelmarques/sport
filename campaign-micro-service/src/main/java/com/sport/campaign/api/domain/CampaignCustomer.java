package com.sport.campaign.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Joel Marques
 */
@Entity
@Table(name="CAMPAIGN_CUSTOMER")
public class CampaignCustomer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Long id;
	
	@Column(name="ID_CUSTOMER")
	private Long idCustomer;
	
	@Column(name="ID_CAMPAIGN")
	private Long idCampaign;
	
	@Column(name="ID_SOCCER_TEAM")
	private Long idSoccerTeam;
	
	public CampaignCustomer() {
		super();
	}
	
	public CampaignCustomer(Long idCustomer, Long idCampaign, Long idSoccerTeam) {
		super();
		this.idCustomer = idCustomer;
		this.idCampaign = idCampaign;
		this.idSoccerTeam = idSoccerTeam;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}

	public Long getIdCampaign() {
		return idCampaign;
	}

	public void setIdCampaign(Long idCampaign) {
		this.idCampaign = idCampaign;
	}

	public Long getIdSoccerTeam() {
		return idSoccerTeam;
	}
	
	public void setIdSoccerTeam(Long idSoccerTeam) {
		this.idSoccerTeam = idSoccerTeam;
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
		CampaignCustomer other = (CampaignCustomer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("CustomerId: ");
		sb.append(this.getIdCustomer());
		sb.append(" CampaignId: " + this.getIdCampaign());
		return sb.toString();
	}

}