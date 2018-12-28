package com.gmail.atpt.model;

public class Message {

	private int id;
	private String header;
	private String body;
	
	public Message(int id, String header, String body) {
		this.setId(id);
		this.setHeader(header);
		this.setBody(body);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
}
