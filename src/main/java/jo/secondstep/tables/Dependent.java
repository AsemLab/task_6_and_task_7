package jo.secondstep.tables;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Dependents")
public class Dependent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dependent_id", nullable = false)
	private Integer id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "relationship", nullable = false)
	private String relationship;
	
	@Column(name = "employee_id", nullable = false)
	private Integer employeeId;
	
	public Dependent() {
	
	}

	
	
	public Dependent( String firstName, String lastName, String relationship, Integer employeeId) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.relationship = relationship;
		this.employeeId = employeeId;
	}



	public Integer getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getRelationship() {
		return relationship;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}



	@Override
	public String toString() {
		return "Dependent [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", relationship="
				+ relationship + ", employeeId=" + employeeId + "]";
	}
	
	
	
	

}
