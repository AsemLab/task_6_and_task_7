package jo.secondstep.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id", nullable = false)
	private Integer id;

	@Column(name = "department_name", nullable = false)
	private String name;

	@Column(name = "location_id")
	private Integer locationId;

	public Department() {
	}

	public Department(String name, Integer locationId) {
		this.name = name;
		this.locationId = locationId;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getLocationId() {
		return locationId;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", locationId=" + locationId + "]";
	}

}
