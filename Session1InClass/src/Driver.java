import java.util.HashMap;
import java.util.Map;
import greeter.Greeter;
import template.Template;
import template.TemplateInstantiationException;

public class Driver {
	
	public static void main(String[] args) throws TemplateInstantiationException {
		// Prepare arguments
		String template = "Good $daypart $name you have nice $eyecolor eyes";
		Map<String, String> params = new HashMap<String, String>();
		params.put("$name", "Steve");
		params.put("$eyecolor", "blue");
		
		/*
		 Decide sequential or random by number
		 If the number is less than zero, it is random. 
		 Else it is the first line number print from 
		 zippy file, and line number will increase
		 sequentially in Template Class.
		 */
		
		int order = 0;
		// Get the greeting
		Greeter g = new Greeter(new Template(template));
		String greeting = g.greet(params, order);
		// This is what I do with the greeting
		System.out.println(greeting);
	}
}
