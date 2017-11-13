package com.sport.campaign.api.domain;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("campaignRepository")
public interface CampaignRepository extends JpaRepository<Campaign, Long> {

	List<Campaign> findByFinalPeriodGreaterThanEqual(Calendar date);	
	List<Campaign> findByFinalPeriodEquals(Calendar date);
	Campaign findByIdAndFinalPeriodGreaterThanEqual(Long id, Calendar date);	
	List<Campaign> findByIdSoccerTeamAndFinalPeriodGreaterThanEqual(Long idSoccerTeam, Calendar date);
	List<Campaign> findByIdSoccerTeamAndFinalPeriodGreaterThanEqualAndIdNotIn(Long idSoccerTeam, Calendar date, List<Long> campaignsIds);
}
