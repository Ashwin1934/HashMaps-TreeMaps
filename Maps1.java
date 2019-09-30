import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.math.*;
public class Maps1{

	public static void main(String[] args){
		ArrayList<Integer> list = new ArrayList<Integer>();

		File name = new File("IntegerCollection.txt");

		try{
			BufferedReader input = new BufferedReader(new FileReader(name));
			String text;
			while((text = input.readLine())!=null){
				//System.out.println(text);

				String[] array = text.split(" ");
				for(int i = 0;i<array.length;i++){
					list.add(Integer.parseInt(array[i]));

				}
			}
		System.out.println(list);
		//unique numbers
		ArrayList<Integer> uniquenumbers = new ArrayList<Integer>();
		for(int i = 0;i<list.size();i++){
			if(!uniquenumbers.contains(list.get(i)))
				uniquenumbers.add(list.get(i));
		}
		System.out.println(uniquenumbers);
		//counter of each uniqenumber
		ArrayList<Integer> counters = new ArrayList<Integer>();
		int counter = 0;
		for(int i = 0;i<uniquenumbers.size();i++){
			counter = 0;
			for(int j = 0;j<list.size();j++){
				if(list.get(j)==uniquenumbers.get(i)){
					counter++;
				}
			}
			counters.add(counter);
		}
		System.out.println(counters);

		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

		for(int i = 0;i<uniquenumbers.size();i++){
			map.put(uniquenumbers.get(i),counters.get(i));
		}

		Iterator it = map.entrySet().iterator();
		while(it.hasNext())
			System.out.println(it.next());










		}catch (IOException io){

			System.err.println("File does not exist");
		}

		}



}