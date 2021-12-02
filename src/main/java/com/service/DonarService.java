package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dao.DonarDAO;
import com.model.Donar;

@Component("ds")
public class DonarService {
	@Autowired 
	private DonarDAO donarDAO;
	
	public DonarDAO getDonarDAO() {
		return donarDAO;
	}

	public void setDonarDAO(DonarDAO donarDAO) {
		this.donarDAO = donarDAO;
	}

	public List<Donar> service1(String bg) {
		return donarDAO.findAllByBloodgroup(bg);
	}
	 
    public boolean service2(String donarid) {
    	return donarDAO.existsById(donarid);
	}
    
	public void service3(Donar donar) {
		donarDAO.save(donar);
	}
	
	public Donar service4(String donarid) {
		return donarDAO.findById(donarid).get();
	}
	
	public void service5(Donar donar) {
		donarDAO.save(donar);
	}
	
	public void service6(String donarid) {
		donarDAO.deleteById(donarid);
	}
	
	public List<String> service7(String bg) {
		return donarDAO.findMailByBloodgroup(bg);
	}
}
