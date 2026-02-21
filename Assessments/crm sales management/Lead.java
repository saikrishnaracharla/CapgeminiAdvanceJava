package com.CrmSales;

import javax.persistence.*;
@Entity
public class Lead {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leadId;
    private String source;
    private String status;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private SalesEmployee employee;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

	public Long getLeadId() {
		return leadId;
	}

	public void setLeadId(Long leadId) {
		this.leadId = leadId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public SalesEmployee getEmployee() {
		return employee;
	}

	public void setEmployee(SalesEmployee employee) {
		this.employee = employee;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

   
}
