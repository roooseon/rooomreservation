package edu.cs545.jungleResort.service;

import java.util.List;

import edu.cs545.jungleResort.domain.Admin;


public interface IAdminService {
	public void addAdmin(Admin admin);
	public void deleteAdmin(int id);
	public Admin getAdminById(int id);
	public List<Admin> getAllAdmin();
	public Admin getAdminByUsernme(String username);
	public boolean loginAuthenticate(String username, String password);
}
