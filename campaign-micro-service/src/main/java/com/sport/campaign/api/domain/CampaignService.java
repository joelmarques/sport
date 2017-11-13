package com.sport.campaign.api.domain;

import java.util.Collection;
import java.util.List;

import com.sport.campaign.api.exception.NoContentException;

public interface CampaignService {

	Collection<Campaign> findAll() throws NoContentException;
	Campaign findById(final Long id) throws NoContentException;
	Campaign save(final Campaign campaign);
	Campaign update(final Campaign campaign);
	void delete(final Long id);
	List<Campaign> allConnect(final Long idCustomer, final Long idSoccerTeam);
	List<Campaign> partialConnect(final Long idCustomer, final Long idSoccerTeam);
}
