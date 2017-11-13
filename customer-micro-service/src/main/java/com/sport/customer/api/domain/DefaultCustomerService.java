package com.sport.customer.api.domain;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.customer.api.exception.DuplicateRegistrationException;

@Service("customerService")
public class DefaultCustomerService implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer save(Customer customer) throws DuplicateRegistrationException {
		
		this.checkDuplicateRegistration(customer.getEmail());
		
		return this.customerRepository.save(customer);
	}
	
	private void checkDuplicateRegistration(final String email) {
		
		final Customer customer = this.findByEmail(email);
		
		if (Objects.nonNull(customer)) {
			throw new DuplicateRegistrationException();
		}
	}

	@Override
	public Customer findByEmail(String email) {
		return this.customerRepository.findByEmail(email);
	}

}
