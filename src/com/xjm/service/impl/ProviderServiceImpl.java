package com.xjm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xjm.dao.ProviderDao;
import com.xjm.entity.Provider;
import com.xjm.service.ProviderService;


@Service("providerService")
public class ProviderServiceImpl implements ProviderService{

	@Autowired
	private ProviderDao providerDao;
	
	@Override
	public List<Provider> findProviders(String queryProCode, String queryProName,
			Integer pageIndex, Integer pageSize) {
		try {
			return providerDao.findProviders(queryProCode, queryProName, (pageIndex-1)*pageSize, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Integer getProvidCount(String queryProCode,String queryProName) {
		try {
			return providerDao.getProvidCount(queryProCode, queryProName);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Integer addProvider(Provider provider) {
		// TODO Auto-generated method stub
		return providerDao.addProvider(provider);
	}

	@Override
	public Provider findProById(Integer id) {
		// TODO Auto-generated method stub
		return providerDao.findProById(id);
	}

	@Override
	public List<Provider> getAllPro() {
		// TODO Auto-generated method stub
		return providerDao.getAllPro();
	}

	@Override
	public int deletePro(Integer id) {
		return providerDao.deletePro(id);
	}

	@Override
	public int updatePro(Provider provider) {
		return providerDao.updatePro(provider);
	}

	
}
