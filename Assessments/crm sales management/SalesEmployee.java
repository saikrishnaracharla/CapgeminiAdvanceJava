package com.CrmSales;

import java.util.List;
import javax.persistence.*;
@Entity
public class SalesEmployee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String name;
    private String department;
    @OneToMany(mappedBy = "employee")
    private List<Lead> leads;
	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public List<Lead> getLeads() {
		return leads;
	}

	public void setLeads(List<Lead> leads) {
		this.leads = leads;
	}

   
}
