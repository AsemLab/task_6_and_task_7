package jo.secondstep.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "locations")
public class Location {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "location_id",nullable = false)
	private Integer id;
	
	@Column(name = "street_address")
	private String streetAddress;
	
	@Column(name = "postal_code")
	private String postalCode ;
	
	@Column(name = "city",nullable = false)
	private String city ;
	
	@Column(name = "state_province")
	private String stateProvince ;
	
	@Column(name = "country_id",nullable = false)
	private String countryId;

	
	
	
	public Location() {
	}

	public Location(String streetAddress, String postalCode, String city, String stateProvince,
			String countryId) {
		this.streetAddress = streetAddress;
		this.postalCode = postalCode;
		this.city = city;
		this.stateProvince = stateProvince;
		this.countryId = countryId;
	}

	public Integer getId() {
		return id;
	}

	public String getStreetAddress() {
		return streetAddress;
	}
	public String getPostalCode() {
		return postalCode;
	}

	
	public String getCity() {
		return city;
	}

	
	public String getStateProvince() {
		return stateProvince;
	}

	
	public String getCountryId() {
		return countryId;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", streetAddress=" + streetAddress + ", postalCode=" + postalCode + ", city="
				+ city + ", stateProvince=" + stateProvince + ", countryId=" + countryId + "]";
	}
	
	
	
	
}
