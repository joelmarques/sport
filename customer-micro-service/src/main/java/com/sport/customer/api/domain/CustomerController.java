package com.sport.customer.api.domain;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.sport.customer.api.exception.DuplicateRegistrationException;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping
	public ResponseEntity<Response> save(@RequestBody final Customer customer) {
		
		try {
			
			final Customer c = this.customerService.save(customer);
			
			final List<Campaign> campaigns = this.connectAllCampaign(c);
			
			return new ResponseEntity<Response>(new Response(Constants.SUCCESS, campaigns), HttpStatus.CREATED);
			
		} catch (DuplicateRegistrationException e) {
			final List<Campaign> campaigns = this.connectPartialCampaign(this.customerService.findByEmail(customer.getEmail()));
			return new ResponseEntity<Response>(new Response(Constants.DUPLICATE, campaigns), HttpStatus.OK);
		}		
	}

	private List<Campaign> connectAllCampaign(Customer c) {
		
		URI uri = UriComponentsBuilder.fromUriString(Constants.URI_CAMPAIGN)
									 .path("/connect/all")
									 .queryParam("idCustomer", c.getId())
									 .queryParam("idSoccerTeam", c.getIdSoccerTeam())
									 .build()
									 .toUri();
		
		return this.restTemplate.getForObject(uri, List.class);
	}
	
	private List<Campaign> connectPartialCampaign(Customer c) {
		
		URI uri = UriComponentsBuilder.fromUriString(Constants.URI_CAMPAIGN)
				 .path("/connect/partial")
				 .queryParam("idCustomer", c.getId())
				 .queryParam("idSoccerTeam", c.getIdSoccerTeam())
				 .build()
				 .toUri();

		return this.restTemplate.getForObject(uri, List.class);
	}

}
