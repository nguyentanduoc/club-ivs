package com.vn.ivs.ctu.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;

import com.vn.ivs.ctu.service.MemberService;

public class CustomFormBinderMember<T extends MemberService> extends CustomCollectionEditor {
	
	private final T dao;
	private static final Logger LOG = LoggerFactory.getLogger(CustomFormBinder.class);
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CustomFormBinderMember(final T daoIn, final Class collectionType) {
		super(collectionType, true);
	      dao = daoIn;
	}

	@Override
	protected Object convertElement(final Object element) {
		try {		
			return dao.getMemberById(Long.valueOf(element.toString()));
		} catch (NumberFormatException e) {
			System.out.println("CustomFormBinderMember "+e.toString());
			LOG.warn("Unable to convert " + element + " to an integer");
			return null;
		}
	}
}
