package DTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class AadharDTO {

	@Id
	private int id;
	private long aadharNumber;
	private String DateOfIssue;

	@OneToOne
	private PersonDTO person;

}
