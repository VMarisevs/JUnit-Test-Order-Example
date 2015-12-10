package gmit;

import java.util.regex.*;

public class Part {
	private static String partNameRegEx = "[a-zA-Z]{2}([\\-]\\d{4})";
	private static Pattern pattern = Pattern.compile(partNameRegEx);
	
	private String number;
	private String name;
	private String description;
	private double price;
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) throws PartException{
		if (description.length() < 1 || description.length() > 200){
			throw new PartException("Invalid part description.");
		}else{
			this.description = description;
		}		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) throws PartException{
		if (name.length() < 1 || name.length() > 50){
			throw new PartException("Invalid part name.");
		}else{
			this.name = name;
		}
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) throws PartException{
		Matcher mtcher = pattern.matcher(number);
		if(mtcher.matches()){
			this.number = number;
		}else{
			throw new PartException("Invalid part number specified");
		}
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) throws PartException{
		if (price < 2.00f || price > 200.00f){
			throw new PartException("Price out of bounds.");
		}else{
			this.price = price;
		}
	}
}
