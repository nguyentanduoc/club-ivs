package com.vn.ivs.ctu.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;

import com.vn.ivs.ctu.service.RoleService;

public class CustomFormBinder<T extends RoleService> extends CustomCollectionEditor {
	
	private final T dao;
	private static final Logger LOG = LoggerFactory.getLogger(CustomFormBinder.class);
	
	public CustomFormBinder(final T daoIn, final Class collectionType) {
		super(collectionType, true);
	      dao = daoIn;
	}
	
	@Override
	protected Object convertElement(final Object element) {
		try {		
			return dao.getRoleById(Integer.valueOf(element.toString()));
		} catch (NumberFormatException e) {
			LOG.warn("Unable to convert " + element + " to an integer");
			return null;
		}
	}

}
