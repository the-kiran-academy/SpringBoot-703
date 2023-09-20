package com.jbk.model;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Address {
	
	
	private long addressId;
	
	@NotBlank(message = "City Name Should Not Be Blank")
	@Pattern(regexp = "^[a-zA-Z]+$",message = "Invalid City Name")
	private String city;
	
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z]+$")
	private String district;
	
	@NotBlank
	@Pattern(regexp = "^[a-zA-Z]+$")
	private String state;
	
	@Pattern(regexp = "^[0-9]+$")
	@Size(min = 6,max = 6)
	private String pinCode;
	
	public Address() {
		
	}

	public Address(long addressId, String city, String district, String state, String pinCode) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.district = district;
		this.state = state;
		this.pinCode = pinCode;
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ", district=" + district + ", state=" + state
				+ ", pinCode=" + pinCode + "]";
	}
	
	

}
