package com.mindtree.CMS.service;

import java.util.List;

import com.mindtree.CMS.model.Apparal;

public interface ApparalService {

	public List<Apparal> getAllApparals();

	public Apparal getApparal(Long apparalId);

	public Apparal create(Apparal apparal);

}
