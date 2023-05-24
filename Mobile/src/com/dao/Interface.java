package com.dao;

import java.util.List;

import com.dto.Mobile;
import com.exception.Norecord;
import com.exception.Somethin;

public interface Interface {

	void Add(Mobile a) throws Somethin;

	void Update(Mobile a) throws Somethin;

	void Deleted(String modelno) throws Somethin;

	List<Mobile> View() throws Norecord;

	Mobile Serch(String modelno) throws Norecord, Somethin;

}
