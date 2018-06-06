package util;

import java.util.Random;

public class RandomUtil {
	
	Random generator;
	
	public RandomUtil(){
		
		generator = new Random();
		
	}
	
	public Integer generateInteger(Integer range){
		
		return generator.nextInt(range);
		
	}

}
