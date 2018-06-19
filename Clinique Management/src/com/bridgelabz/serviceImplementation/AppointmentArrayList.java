package com.bridgelabz.serviceImplementation;

import java.util.ArrayList;
import java.util.List;

import com.bridgelabz.model.Appointment;

public class AppointmentArrayList {
	
	private List<Appointment> appointmentList=new ArrayList<>();

	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}
	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}
}
