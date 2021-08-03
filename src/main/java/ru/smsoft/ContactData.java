package ru.smsoft;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import ru.smsoft.non_rookie.soap.AgeExtremum;
import ru.smsoft.non_rookie.soap.Contact;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ContactData {
	private static List<Contact> contacts;

	@PostConstruct
	public void initData() throws IOException {
		byte[] bytes = getClass().getResourceAsStream("/contacts.json").readAllBytes();
		String json = new String(bytes);
		ObjectMapper mapper = new ObjectMapper();
		try {
			contacts = Arrays.asList(mapper.readValue(json,Contact[].class));
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	public List<Contact> findByLastName(String lastName) {
		Assert.notNull(lastName, "LastName must not be null");
		return contacts
				.stream()
				.filter(contact -> lastName.equals(contact.getLastName()))
				.collect(Collectors.toList());
	}

	public List<Contact> findByFirstNameAndLastName(String lastName,String firstName) {
		Assert.notNull(lastName, "LastName must not be null");
		Assert.notNull(firstName, "FirstName must not be null");
		return contacts
				.stream()
				.filter(contact -> lastName.equals(contact.getLastName())&& firstName.equals(contact.getFirstName()))
				.collect(Collectors.toList());
	}

	public List<Contact> findByEducation(String education) {
		Assert.notNull(education, "Education must not be null");
		return contacts
				.stream()
				.filter(contact -> education.equals(contact.getEducation()))
				.collect(Collectors.toList());
	}

	public Contact findByAgeExtremum(AgeExtremum extremum) {
		Assert.notNull(extremum, "Extremum must not be null");
		Contact retContact;
		if(extremum==AgeExtremum.OLDEST){
			retContact = contacts
					.stream()
					.max(Comparator.comparingInt(Contact::getAge))
					.get();
		}else if(extremum==AgeExtremum.YOUNGEST){
			retContact = contacts
					.stream()
					.min(Comparator.comparingInt(Contact::getAge))
					.get();
		}else retContact = null;

		return retContact;
	}
}
