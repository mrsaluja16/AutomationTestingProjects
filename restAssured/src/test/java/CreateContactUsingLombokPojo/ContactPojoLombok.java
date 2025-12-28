package CreateContactUsingLombokPojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactPojoLombok {
	
	private String firstName; 
	private String lastName;
	private String birthdate;
	private String email; 
	private String phone;
	private String street1;
	private String street2;
	private String city;
	private String stateProvince;
	private String postalCode;
	private String country;

}
