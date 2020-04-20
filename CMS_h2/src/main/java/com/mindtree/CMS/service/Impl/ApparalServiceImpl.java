package com.mindtree.CMS.service.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.CMS.dao.ApparalRepository;
import com.mindtree.CMS.enums.Category;
import com.mindtree.CMS.model.Apparal;
import com.mindtree.CMS.service.ApparalService;

@Service
@Transactional
public class ApparalServiceImpl implements ApparalService {

	@Autowired
	private ApparalRepository apparalRepository;

	@Override
	public List<Apparal> getAllApparals() {
		return apparalRepository.findAll(false);
	}

	@Override
	public Apparal getApparal(Long apparalId) {
		return apparalRepository.findByApparalId(apparalId, false);
	}

	@Override
	public Apparal create(Apparal apparal) {
		apparal.setCategory(Category.APPARAL);
		apparal.setDeleted(false);
		apparal = apparalRepository.save(apparal);
		return apparal;
	}

}
