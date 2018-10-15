package template;

import java.util.Map;
import daypart.DayPart;
import zippy.Zippy;

public class Template {
	private String[] words;
	
	public Template(String template) {
		words = template.split("\\s");
	}
	
	private boolean isVariable(String s) {
		return s.charAt(0) == '$';
	}
	
	public String format(Map<String, String> params, int order) throws TemplateInstantiationException {
		String[] sa = new String[words.length];
		for (int i=0; i < words.length; i++) {
			if (isVariable(words[i])) {
				if (words[i].equals("$daypart")) {
					sa[i] = (new DayPart()).toString();
				// It will insert a sentence choose from zippy quote if  $zippy appear
				} else if(words[i].equals("$zippy")) {
					sa[i] = (new Zippy().toString(order));
					// Line number will increase if the Drive want quote in sequential order 
					if(order >= 0) {
						order ++;
					}
				// It will insert a newline character if $newline appear
				}else if(words[i].equals("$newline")) {
					sa[i] = "\n";
				} else if (params.containsKey(words[i])) {
					sa[i] = params.get(words[i]);
				} else {
					throw new TemplateInstantiationException();
				}
			} else {
				sa[i] = words[i];
			}
		}
		
		return String.join(" ", sa);
	}
}
