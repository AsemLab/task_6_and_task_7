package jo.secondstep.tables;

import javax.persistence.*;

@Entity
@Table(name = "regions")
public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "region_id",nullable = false)
	private Integer id;
	
	@Column(name = "region_name")
	private String name;

	
	public Region() {
	}
	
	

	public Region(String name) {
		this.name = name;
	}



	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Region [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
