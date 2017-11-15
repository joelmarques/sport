package com.sport.campaign.api.domain;

import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.campaign.api.exception.NoContentException;

@Service("campaignService")
public class DefaultCampaignService implements CampaignService {
	
	@Autowired
	private CampaignRepository campaignRepository;
	
	@Autowired
	private CampaignCustomerRepository campaignCustomerRepository;
	
	@Override
	public Collection<Campaign> findAll() throws NoContentException {
		
		final Collection<Campaign> campaigns = this.campaignRepository.findByFinalPeriodGreaterThanEqual(Calendar.getInstance());
		
		if (campaigns.isEmpty()) {
			throw new NoContentException();
		}
		
		return campaigns;
	}

	@Override
	public Campaign findById(final Long id) throws NoContentException {
		
		final Campaign campaign = this.campaignRepository.findByIdAndFinalPeriodGreaterThanEqual(id, Calendar.getInstance());
		
		if (Objects.isNull(campaign)) {
			throw new NoContentException();
		}
		
		return campaign;
	}

	@Override
	public Campaign save(final Campaign campaign) {
		
		this.verifyFinalPeriod(campaign);
		
		return this.campaignRepository.save(campaign);
	}

	private void verifyFinalPeriod(final Campaign campaign) {
		
		final List<Campaign> campaigns = this.campaignRepository.findByFinalPeriodEquals(campaign.getFinalPeriod());
		
		campaigns.stream().forEach(c -> save(addOneDayInFinalPeriod(c)));
	}
	
	private Campaign addOneDayInFinalPeriod(final Campaign campaign) {
		
		Calendar calendar = campaign.getFinalPeriod();
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		campaign.setFinalPeriod(calendar);
		return campaign;
	}

	@Override
	public Campaign update(final Campaign campaign) {
		return this.campaignRepository.save(campaign);
	}

	@Override
	public void delete(final Long id) {
		this.campaignRepository.delete(id);
	}

	@Override
	public List<Campaign> allConnect(final Long idCustomer, final Long idSoccerTeam) {
		
		final List<Campaign> campaigns = this.findByIdSoccerTeam(idSoccerTeam);
		
		this.connectCampaigns(idCustomer, idSoccerTeam, campaigns);
		
		return campaigns;
	}
	
	private List<Campaign> findByIdSoccerTeam(final Long idSoccerTeam) {
		return this.campaignRepository.findByIdSoccerTeamAndFinalPeriodGreaterThanEqual(idSoccerTeam, Calendar.getInstance());
	}
	
	private void connectCampaigns(final Long idCustomer, final Long idSoccerTeam, final List<Campaign> campaigns) {
		
		campaigns.stream().forEach(c -> campaignCustomerRepository.save(new CampaignCustomer(idCustomer, c.getId(), idSoccerTeam)));
	}

	@Override
	public List<Campaign> partialConnect(final Long idCustomer, final Long idSoccerTeam) {
		
		final List<CampaignCustomer> campaignCustomers = this.campaignCustomerRepository.findByIdCustomerAndIdSoccerTeam(idCustomer, idSoccerTeam);
		
		final List<Campaign> campaigns = this.findByIdSoccerTeam(idSoccerTeam, this.getCampaignsIds(campaignCustomers));
		
		this.connectCampaigns(idCustomer, idSoccerTeam, campaigns);
		
		return campaigns;
	}
	
	private List<Long> getCampaignsIds(final List<CampaignCustomer> campaignCustomers) {
		return campaignCustomers.stream().map(CampaignCustomer::getIdCampaign).collect(Collectors.toList());
	}
	
	private List<Campaign> findByIdSoccerTeam(final Long idSoccerTeam, final List<Long> campaignsIds) {
		return this.campaignRepository.findByIdSoccerTeamAndFinalPeriodGreaterThanEqualAndIdNotIn(idSoccerTeam, Calendar.getInstance(), campaignsIds);
	}
}
