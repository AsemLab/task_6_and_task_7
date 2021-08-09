package jo.secondstep.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Country {

	@Id
	@Column(name = "country_id", nullable = false)
	private String id;

	@Column(name = "country_name")
	private String name;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "region_id")
	private Region region;

	public Country() {
	}

	public Country(String id, String name, Region region) {
		this.id = id;
		this.name = name;
		this.region = region;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Region getRegion() {
		return region;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", region=" + region.getId() + "]";
	}

}
