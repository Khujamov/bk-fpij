package us.cyzic.fpij.designing;

public class FluentInterfaces {

	public static void main(String[] args) {
		
		// The bad way
		Mailer mailer = new Mailer();
		mailer.from("build@agiledeveloper.com");
		mailer.to("jason@cyzic.us");
		mailer.subject("build notification");
		mailer.body("...your code sucks...");
		mailer.send();

		// The slightly better way
		new MailBuilder()
			.from("build@agiledeveloper.com")
			.to("jason@cyzic.us")
			.subject("build notification")
			.body("...it sucks a little less")
			.send();
		
		FluentMailer.send(fluentMailer -> 
			fluentMailer.from("build@agiledeveloper.com")
				.to("jason@cyzic.us")
				.subject("build notification")
				.body("...much better"));
		
	}

}
