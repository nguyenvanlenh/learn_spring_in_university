package com.watermelon;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "thanhvien")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String password;
	private String name;
	private Date birthday; 
	private String gender; // checkbox
	private String profession; // select option : Cao đẳng, Đại học ,Thạc sĩ, Tiến sĩ
	private String address;
	private String city;// select option : Thành phố Hồ Chí Minh, Quảng Ngãi, Đà Nẵng, Hà Nội
	private String county; // select option : Quận 1, Quận 3, Quận 4, Tp Thủ Đức, Tân Bình....
	private String ward; // select option : Bình Chiểu, Tam Bình, Linh Đông, Linh Trung, Hiệp Bình Chiểu,
							// Phước Long A..
	private String phone;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", name=" + name + ", birthday="
				+ birthday + ", gender=" + gender + ", profession=" + profession + ", address=" + address + ", city="
				+ city + ", county=" + county + ", ward=" + ward + ", phone=" + phone + "]";
	}

}
