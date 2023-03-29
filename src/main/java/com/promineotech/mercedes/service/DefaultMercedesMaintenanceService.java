package com.promineotech.mercedes.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.mercedes.controller.Mercedes;
import com.promineotech.mercedes.dao.MercedesMaintenanceDao;
import com.promineotech.mercedes.entity.Chassis;
import com.promineotech.mercedes.entity.MercedesName;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultMercedesMaintenanceService implements MercedesMaintenanceService{
	@Autowired
	private MercedesMaintenanceDao mercedesMaintenanceDao;
	
	@Transactional(readOnly = true)
	//@Override
	public List<Chassis> fetchMercedes(Chassis name) {
		log.info("The fetchMercedes method was called with name={} and chassis ={}",
				name);
		List<Chassis> mercedes = mercedesMaintenanceDao.fetchMercedes(name);
		
		if(mercedes.isEmpty()) {
			String msg = String.format("No mercedes found with name=%s",
					name);
			throw new NoSuchElementException(msg);
		}
		
		
		return mercedes;
	}

	@Override
	public List<Mercedes> fetchMercedes(MercedesName name, String chassis) {
		// TODO Auto-generated method stub
		return null;
	}

}
