package edu.ucalgary.ensf409;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VisitorParking {
	ArrayList<String> licences = new ArrayList<String>();
	HashMap<LocalDate, ArrayList<String>> info = new HashMap<LocalDate, ArrayList<String>>();
	ArrayList<LocalDate> startDates = new ArrayList<LocalDate>();
	
	public VisitorParking() {
	}
	public VisitorParking(String licence) {
		var today = LocalDate.now();
		String REGEX = "(^[A-Z0-9]{0,7}$)";
		Pattern pattern = Pattern.compile(REGEX);
		 licence = licence.toUpperCase();
         licence = licence.replaceAll("[^\\w]", "");
		Matcher match = pattern.matcher(licence);
		if(!match.find()) {
			throw new IllegalArgumentException();
		}
		else {
				startDates.add(today);
				for(int i = 0; i < 3; i++) {
					licences = new ArrayList<String>();
					if(info.containsKey(today.plusDays(i))) {
						this.licences = info.get(today.plusDays(i));
						this.licences.add(licence);
					}
					else {
						this.licences.add(licence);
					}
				info.put(today.plusDays(i),licences);
				}
			}
		}
	public VisitorParking(String licence, LocalDate date) {
		var today = LocalDate.now();
		String REGEX = "(^[A-Z0-9]{0,7}$)";
		Pattern pattern = Pattern.compile(REGEX);
		 licence = licence.toUpperCase();
         licence = licence.replaceAll("[^\\w]", "");
		Matcher match = pattern.matcher(licence);
		if(!match.find()) {
			throw new IllegalArgumentException();
		}
		else {
			if(date.isBefore(today)) {
				throw new IllegalArgumentException();
			}
			else {
					startDates.add(date);
				for(int i = 0; i < 3; i++) {
					licences = new ArrayList<String>();
					if(info.containsKey(date.plusDays(i))) {
						this.licences = info.get(date.plusDays(i));
						this.licences.add(licence);
					}
					else {
						this.licences.add(licence);
					}
				info.put(date.plusDays(i),licences);
				}
			}
		}
	}
		
	public void addVisitorReservation(String licence, LocalDate date) {
		var today = LocalDate.now();
		String REGEX = "(^[A-Z0-9]{0,7}$)";
		Pattern pattern = Pattern.compile(REGEX);
		 licence = licence.toUpperCase();
         licence = licence.replaceAll("[^\\w]", "");
		Matcher match = pattern.matcher(licence);
		if(!match.find()) {
			throw new IllegalArgumentException();
		}
		else {
			if(date.isBefore(today)) {
				throw new IllegalArgumentException();
			}
			else {
				startDates.add(date);
				for(int j = 0; j < 3; j++) {
					licences = new ArrayList<String>();
					if(info.containsKey(date.plusDays(j))) {
						licences = info.get(date.plusDays(j));
						if(licences.size() == 2) {
							throw new IllegalArgumentException();
						}
						Iterator<String> iterator = licences.iterator();
						while (iterator.hasNext()) {
							if(iterator.next().equals(licence)) {
								throw new IllegalArgumentException();
							}
						}
							licences.add(licence);
					}
					else {
							licences.add(licence);
					}
				info.put(date.plusDays(j),licences);
				}
			}
		}
	
	}
	public void addVisitorReservation(String licence) {
		var today = LocalDate.now();
		String REGEX = "(^[A-Z0-9]{0,7}$)";
		 licence = licence.toUpperCase();
         licence = licence.replaceAll("[^\\w]", "");
		Pattern pattern = Pattern.compile(REGEX);
		Matcher match = pattern.matcher(licence);
		if(!match.find()) {
			throw new IllegalArgumentException();
		}
		else {
			startDates.add(today);
			for(int i = 0; i < 3; i++) {
				licences = new ArrayList<String>();
				if(info.containsKey(today.plusDays(i))) {
					this.licences = info.get(today.plusDays(i));
					if(licences.size() == 2) {
						throw new IllegalArgumentException();
					}
					Iterator<String> iterator = licences.iterator();
					while (iterator.hasNext()) {
						if(iterator.next().equals(licence)) {
							throw new IllegalArgumentException();
						}
					}
					licences.add(licence);
				}
				else {
					licences.add(licence);
				}
			info.put(today.plusDays(i),licences);
		}
	}
}
	
	public boolean licenceIsRegisteredForDate(String licence, LocalDate date) {
		boolean state = false;
		 licence = licence.toUpperCase();
         licence = licence.replaceAll("[^\\w]", "");
		ArrayList<String> registered = new ArrayList<String>();
			if(info.get(date)!=null) {
				registered = info.get(date);
				Iterator<String> iterator = registered.iterator();
				while (iterator.hasNext()) {
					if(iterator.next().equalsIgnoreCase(licence)) {
						state = true;
						break;
					}
				}
			}
			return state;
				
	}
	public boolean licenceIsRegisteredForDate(String licence) {
		var today = LocalDate.now();
		 licence = licence.toUpperCase();
         licence = licence.replaceAll("[^\\w]", "");
		boolean state = false;
		ArrayList<String> registered = new ArrayList<String>();
		registered = info.get(today);
		Iterator<String> iterator = registered.iterator();
		while (iterator.hasNext()) {
			if(iterator.next().equalsIgnoreCase(licence)) {
				state = true;
				break;
			}
		}
		return state;
		
	}
	public ArrayList<String> getLicencesRegisteredForDate(){
		ArrayList<String> todayLicence = new ArrayList<String>();
			var today = LocalDate.now();
			licences = info.get(today);
			Iterator<String> it = licences.iterator();
			while (it.hasNext()) {
				todayLicence.add(it.next());
			}
			
		return todayLicence;
	}
	public ArrayList<String> getLicencesRegisteredForDate(LocalDate date){
		ArrayList<String> licenceDays = new ArrayList<String>(10); 
		if(info.get(date) != null) {
			licenceDays = info.get(date);
		}
		return licenceDays;
	}
	public ArrayList<LocalDate> getAllDaysLicenceIsRegistered(String licence) {
			Set<LocalDate> dates = info.keySet();
			 licence = licence.toUpperCase();
	         licence = licence.replaceAll("[^\\w]", "");
			LinkedList<LocalDate> sortedDate = new LinkedList<LocalDate>();
			ArrayList<LocalDate> desiredDate = new ArrayList<LocalDate>();
			for(LocalDate ne: dates) {
				sortedDate.add(ne);
			}
			sortedDate.sort(Comparator.naturalOrder());
			for(LocalDate ne: sortedDate) {
				licences = info.get(ne);
				Iterator<String> it = licences.iterator();
				while (it.hasNext()) {
					if(it.next().equalsIgnoreCase(licence)) {
					desiredDate.add(ne);
					}
				}
			}
		return desiredDate;
	}
	public ArrayList<LocalDate> getStartDaysLicenceIsRegistered(String licence) {
		ArrayList<LocalDate> startDate = new ArrayList<LocalDate>();
		 licence = licence.toUpperCase();
         licence = licence.replaceAll("[^\\w]", "");
		for(LocalDate date: startDates) {
			licences = info.get(date);
			Iterator<String> it = licences.iterator();
			while (it.hasNext()) {
				if(it.next().equalsIgnoreCase(licence)) {
					startDate.add(date);
				}
			}
		}
		startDate.sort(Comparator.naturalOrder());
		return startDate;
	}
}
