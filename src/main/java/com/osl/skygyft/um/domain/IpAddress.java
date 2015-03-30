package com.osl.skygyft.um.domain;

public class IpAddress {

	private String segment1;
	
	private String segment2;
	
	private String segment3;
	
	private String segment4;

	
	public IpAddress(){
		
	}
	
	public IpAddress(String segment1, String segment2, String segment3,
			String segment4) {
		super();
		this.segment1 = segment1;
		this.segment2 = segment2;
		this.segment3 = segment3;
		this.segment4 = segment4;
	}

	
	public IpAddress(String ipAddress) {
		String[] split = ipAddress.split("\\.");
		this.segment1 = split[0];
		this.segment2 = split[1];
		this.segment3 = split[2];
		this.segment4 = split[3];
	}

	public String getSegment1() {
		return segment1;
	}

	public void setSegment1(String segment1) {
		this.segment1 = segment1;
	}

	public String getSegment2() {
		return segment2;
	}

	public void setSegment2(String segment2) {
		this.segment2 = segment2;
	}

	public String getSegment3() {
		return segment3;
	}

	public void setSegment3(String segment3) {
		this.segment3 = segment3;
	}

	public String getSegment4() {
		return segment4;
	}

	public void setSegment4(String segment4) {
		this.segment4 = segment4;
	}

	@Override
	public String toString() {
		return segment1 + "." + segment2 + "." + segment3 + "." + segment4;
	}
	
	
}
