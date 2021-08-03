package ru.smsoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.smsoft.non_rookie.soap.*;

@Endpoint
public class ContactEndpoint {
	private static final String NAMESPACE_URI = "http://smsoft.ru/non-rookie/soap";

	private ContactData contactData;

	@Autowired
	public ContactEndpoint(ContactData contactData) {
		this.contactData = contactData;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getByLastNameRequest")
	@ResponsePayload
	public GetByLastNameResponse getByLastName(@RequestPayload GetByLastNameRequest request) {
		var response = new GetByLastNameResponse();
		response.getContacts().addAll(contactData.findByLastName(request.getLastName()));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getByFirstNameAndLastNameRequest")
	@ResponsePayload
	public GetByFirstNameAndLastNameResponse getByName(@RequestPayload GetByFirstNameAndLastNameRequest request) {
		var response = new GetByFirstNameAndLastNameResponse();
		response.getContacts().addAll(contactData.findByFirstNameAndLastName(request.getLastName(), request.getFirstName()));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getByEducationRequest")
	@ResponsePayload
	public GetByEducationResponse getByEducation(@RequestPayload GetByEducationRequest request) {
		var response = new GetByEducationResponse();
		response.getContacts().addAll(contactData.findByEducation(request.getEducation()));
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getByOldestOrYoungestRequest")
	@ResponsePayload
	public GetByOldestOrYoungestResponse getByOldestOrYoungest(@RequestPayload GetByOldestOrYoungestRequest request) {
		var response = new GetByOldestOrYoungestResponse();
		response.setContact(contactData.findByAgeExtremum(request.getExtremum()));
		return response;
	}
}
