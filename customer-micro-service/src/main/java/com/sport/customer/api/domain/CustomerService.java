package com.sport.customer.api.domain;

import com.sport.customer.api.exception.DuplicateRegistrationException;

public interface CustomerService {

	Customer save(final Customer customer) throws DuplicateRegistrationException;
	Customer findByEmail(String email);
}
