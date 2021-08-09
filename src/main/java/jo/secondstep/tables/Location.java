package jo.secondstep.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "country_id")
	private Country country;

	
	
	
	public Location() {
	}

	public Location(String streetAddress, String postalCode, String city, String stateProvince,
			Country country) {
		this.streetAddress = streetAddress;
		this.postalCode = postalCode;
		this.city = city;
		this.stateProvince = stateProvince;
		this.country = country;
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

	
	public Country getCountry() {
		return country;
	}

	
	
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", streetAddress=" + streetAddress + ", postalCode=" + postalCode + ", city="
				+ city + ", stateProvince=" + stateProvince + ", country=" + country.getId() + "]";
	}
	
	
	
	
}
