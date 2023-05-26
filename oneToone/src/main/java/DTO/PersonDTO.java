package DTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class PersonDTO {

	@Id
	private int id;
	private String name;
	private long mobile;
	private String Address;

	@OneToOne
	private AadharDTO aadhar;

}
