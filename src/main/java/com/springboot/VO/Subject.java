package com.springboot.VO;

import java.util.Set;

public class Subject {

	private  long subjectId;
	private  String subTitle;
	private int durationHours;
	private Set<BookVO> references;
	
	public long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public int getDurationHours() {
		return durationHours;
	}
	public void setDurationHours(int durationHours) {
		this.durationHours = durationHours;
	}
	public Set<BookVO> getReferences() {
		return references;
	}
	public void setReferences(Set<BookVO> references) {
		this.references = references;
	}
	
}
