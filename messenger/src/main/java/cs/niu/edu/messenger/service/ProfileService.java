package cs.niu.edu.messenger.service;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Date;

import cs.niu.edu.messenger.database.DatabaseClass;
import cs.niu.edu.messenger.model.Profile;

public class ProfileService {
	private Map<String, Profile> profiles=DatabaseClass.getProfiles();
	
	public ProfileService(){
		profiles.put("Anwar", new Profile(1L,"Anwar","Anwar","Siddiqui", new Date()));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<>(profiles.values());
	}
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	public Profile updateProfile(Profile profile){
		if(profile ==null || profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	public Profile removeProfile(String profileName){
		return profiles.remove(profileName);
	}
}