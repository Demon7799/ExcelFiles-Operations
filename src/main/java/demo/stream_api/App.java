package demo.stream_api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.github.javafaker.Faker;

public class App {

	public static void main(String[] args) 
	{
		List<String> names = new ArrayList<String>();
		Faker faker = new Faker();
		
		for(int i=0;i<20;i++)
		{
			names.add(faker.name().firstName());
		}
		System.out.println(names);
		System.out.println(names.stream().filter(p->p.endsWith("e")).collect(Collectors.toList()));
		
		if(names.stream().filter(p->p.endsWith("k")) != null)
		{
			System.out.println("Yay!");
		}
		else
		{
			System.out.println("aiyo na na na na na");
		}
	}

}
