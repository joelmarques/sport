package com.sport.campaign.api.domain;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sport.campaign.api.exception.NoContentException;

@RestController
@RequestMapping("/api/campaigns")
public class CampaignController {
	
	@Autowired
	private CampaignService campaignService;

	@GetMapping
	public ResponseEntity<Collection<Campaign>> findAll() {
		
		try {
			
			final Collection<Campaign> campaigns = this.campaignService.findAll();
			return new ResponseEntity<>(campaigns, HttpStatus.OK);
			
		} catch (NoContentException e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Campaign> findById(@PathVariable("id") final Long id) {
		
		try {
			
			final Campaign campaign = this.campaignService.findById(id);
			return new ResponseEntity<Campaign>(campaign, HttpStatus.OK);
			
		} catch (NoContentException e) {
			return new ResponseEntity<Campaign>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping
	public ResponseEntity<Campaign> save(@RequestBody final Campaign campaign) {
		
		return new ResponseEntity<Campaign>(this.campaignService.save(campaign), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Campaign> update(@RequestBody final Campaign campaign) {
		
		return new ResponseEntity<Campaign>(this.campaignService.update(campaign), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") final Long id) {
		
		this.campaignService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/connect/all")
	public List<Campaign> allConnect(@Param("idCustomer") final Long idCustomer, @Param("idSoccerTeam") final Long idSoccerTeam) {
		return this.campaignService.allConnect(idCustomer, idSoccerTeam);
	}
	
	@GetMapping("/connect/partial")
	public List<Campaign> partialConnect(@Param("idCustomer") final Long idCustomer, @Param("idSoccerTeam") final Long idSoccerTeam) {
		return this.campaignService.partialConnect(idCustomer, idSoccerTeam);
	}
}
