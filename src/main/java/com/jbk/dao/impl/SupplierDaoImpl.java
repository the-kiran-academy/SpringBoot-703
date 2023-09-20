package com.jbk.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.jbk.dao.SupplierDao;
import com.jbk.model.Supplier;

@Repository
public class SupplierDaoImpl implements SupplierDao {

	List<Supplier> list = new ArrayList<>();
	
	
	private boolean isExists(Supplier supplier) {
		
		boolean isExists=false;
		for (Supplier dbSupplier : list) {
			if (supplier.getSupplierName().equalsIgnoreCase(dbSupplier.getSupplierName())
					|| supplier.getSupplierMobileNumber().equals(dbSupplier.getSupplierMobileNumber())) {
				isExists=true;
				break;
			}
		
		}
		return isExists;
	}
	

	@Override
	public int addSupplier(Supplier supplier) {
		if (isExists(supplier)==false) {
			list.add(supplier);
			return 1;
		}else
		{
			return 2;
		}

	}

	@Override
	public Supplier getSupplierById(long supplierId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Supplier> getAllSupplier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Supplier> deleteSupplier(long supplierId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Supplier updateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return null;
	}

}
