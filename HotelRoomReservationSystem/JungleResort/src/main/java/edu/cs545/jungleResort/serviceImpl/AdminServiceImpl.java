package edu.cs545.jungleResort.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cs545.jungleResort.DAO.AdminDAO;
import edu.cs545.jungleResort.domain.Admin;
import edu.cs545.jungleResort.service.IAdminService;

@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	AdminDAO admindao;

	@Override
	public void addAdmin(Admin admin) {
		admindao.save(admin);
	}

	@Override
	public void deleteAdmin(int id) {
		admindao.delete(id);
	}

	@Override
	public Admin getAdminById(int id) {
		// TODO Auto-generated method stub
		return admindao.findOne(id);
	}

	@Override
	public List<Admin> getAllAdmin() {
		return (List<Admin>) admindao.findAll();
	}

	@Override
	public Admin getAdminByUsernme(String username) {
		return admindao.getAdminByUsername(username);
	}

	@Override
	public boolean loginAuthenticate(String username, String password) {
		Admin admin = admindao.getAdminByUsername(username);

		if (admin != null) {
			if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
				return true;
			}
		}
		return false;
	}

}
