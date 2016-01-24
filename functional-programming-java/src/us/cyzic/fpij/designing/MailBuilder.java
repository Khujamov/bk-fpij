package us.cyzic.fpij.designing;

public class MailBuilder {

	public MailBuilder from(final String address) { /* interesting code goes here */; return this; }
	public MailBuilder to(final String address) { /* interesting code goes here */; return this; }
	public MailBuilder subject(final String line) { /* interesting code goes here */; return this; }
	public MailBuilder body(final String message) { /* interesting code goes here */; return this; }
	
	public void send() {
		System.out.println("sending message in a slightly better way...");
	}
	
}
