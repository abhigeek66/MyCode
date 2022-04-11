package com.example.demo.vo;

public class FilterVO {

	private final String firstName;
	private final String lastName;
	private final String email;
	private final String sortBy;
	private final String filter;
	private final String order;
	private final int pageNo;
	private final int pageSize;
	
	public FilterVO(String firstName, String lastName, String email, String sortBy, String filter, String order,
			int pageNo, int pageSize) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.sortBy = sortBy;
		this.filter = filter;
		this.order = order;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
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

	public String getSortBy() {
		return sortBy;
	}

	public String getFilter() {
		return filter;
	}

	public String getOrder() {
		return order;
	}

	public int getPageNo() {
		return pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	@Override
    public String toString() {
        return "EmployeeEntity [firstName=" + firstName + 
                ", lastName=" + lastName + ", email=" + email   + "]";
    }
}
