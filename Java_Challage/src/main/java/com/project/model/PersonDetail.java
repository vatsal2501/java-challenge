package com.project.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.project.exception.InavlidGenderException;
import com.project.exception.InvalidDateException;

@Entity
@Table(name = "person_details_table")
public class PersonDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_id")
	private int id;

	@Column(name = "gender")
	private String gender;

	@Column(name = "date_of_birth", nullable = false, updatable = false)
	private Date dob;

	@Column(name = "native_place", nullable = false, length = 255)
	private String nativePlace;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) throws InavlidGenderException {

		switch (gender) {

		case "male":
			this.gender = gender;
			break;
		case "female":
			this.gender = gender;
			break;
		default:
			throw new InavlidGenderException();
		}
//		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) throws InvalidDateException{
		String date_String = "01-01-2002";
		SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy");

		try {
			Date dateLimit = formater.parse(date_String);

			if (dob.before(dateLimit)) {
				this.dob = dob;
			} else if (dob.equals(dateLimit)) {
				this.dob = dob;
			} else {
				throw new InvalidDateException();
			}

		} catch (ParseException e) {
			e.printStackTrace();
		} catch (InvalidDateException e) {
			throw e;
		}
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

}
