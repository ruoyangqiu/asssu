package greeter;

import java.util.Map;

import template.Template;
import template.TemplateInstantiationException;

public class Greeter {
	private Template template;
	
	public Greeter(Template template) {
		this.template = template;
	}
	
	public String greet(Map<String, String> params, int order) throws TemplateInstantiationException {
		return template.format(params, order);
	}

}
