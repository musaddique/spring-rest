package com.sohel.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sohel.database.DatabaseClass;
import com.sohel.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("SOHEL 1", new Profile(1L, "sohel 1", "sohel 1", "hossain 1"));
		profiles.put("SOHEL 2", new Profile(1L, "sohel 2", "sohel 2 ", "hossain 2"));
		profiles.put("SOHEL 3", new Profile(1L, "sohel 3", "sohel 3 ", "hossain 3"));
	}
	
	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values()); 
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
	
	
}