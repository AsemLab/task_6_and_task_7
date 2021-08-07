package jo.secondstep.tables;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id", nullable = false)
	private Integer id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "hire_date", nullable = false)
	private Date hireDate;
	
	@Column(name = "job_id", nullable = false)
	private Integer jobId;
	
	@Column(name = "salary", nullable = false)
	private Double salary;
	
	@Column(name = "manager_id")
	private Integer managerId;
	
	@Column(name = "department_id")
	private Integer departmentId;
	
	

	public Employee( String firstName, String lastName, String email, String phoneNumber, Date hireDate,
			Integer jobId, Double salary, Integer managerId, Integer departmentId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.jobId = jobId;
		this.managerId = managerId;
		this.departmentId = departmentId;
		this.salary = salary;
	}

	public Employee() {
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

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public Integer getJobId() {
		return jobId;
	}

	public Double getSalary() {
		return salary;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", jobId=" + jobId + ", salary=" + salary
				+ ", managerId=" + managerId + ", departmentId=" + departmentId + "]";
	}

	
	
	
	
	
}
