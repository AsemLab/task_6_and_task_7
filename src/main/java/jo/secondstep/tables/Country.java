package jo.secondstep.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Country {

	@Id
	@Column(name = "country_id",nullable = false)
	private String id;
	
	@Column(name = "country_name")
	private String name;
	
	@Column(name = "region_id",nullable = false)
	private Integer regionId;


	public Country() {
	}

	public Country(String id,String name, Integer regionId) {
		this.id = id;
		this.name = name;
		this.regionId = regionId;
	}
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}


	public Integer getRegionId() {
		return regionId;
	}
	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", regionId=" + regionId + "]";
	}
	
	
	
	
}
