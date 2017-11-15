package com.sport.campaign.api.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("campaignCustomerRepository")
public interface CampaignCustomerRepository extends JpaRepository<CampaignCustomer, Long> {
	
	List<CampaignCustomer> findByIdCustomerAndIdSoccerTeam(Long idCustomer, Long idSoccerTeam); 
}
