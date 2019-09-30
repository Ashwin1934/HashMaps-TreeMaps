import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.math.*;
import java.util.Comparator;

public class Bowling{

	public Bowling(){
		File name = new File("BowlingData.txt");
		ArrayList<Bowler> list = new ArrayList<Bowler>();
		try{
			BufferedReader input = new BufferedReader(new FileReader(name));
			String text;
			while((text = input.readLine())!=null){
				String [] array = text.split(" ");
				String first = array[0];
				String last = array[1];
				int score = Integer.parseInt(array[2]);
				list.add(new Bowler(first,last,score));
			}

			TreeMap<Integer, PriorityQueue<Bowler>> map = new TreeMap<>();
			BComparator bcomparator = new BComparator();

			for(int i = 0;i<list.size();i++){
				int score = list.get(i).getScore();
				PriorityQueue<Bowler> temp = new PriorityQueue<>(bcomparator);

				for(int j = 0;j<list.size();j++){
					if(list.get(j).getScore()==score){
						temp.add(list.get(j));
						map.put(score,temp);
					}
				}
			}
			Iterator it = map.keySet().iterator();
			while(it.hasNext()){
				Object obj = it.next();
				System.out.println(obj+": \n");
				for(Bowler bowler:map.get(obj))
				{

					System.out.println(bowler.getFirst()+" "+bowler.getLast());
				}
				System.out.println();
			}
		}catch(IOException io){
			System.err.println("File does not exist");
		}

	}
	//Bowler class
	public class Bowler{
		private String first;
		private String last;
		private int score;

		public Bowler(String first,String last ,int score){
			this.first = first;
			this.last = last;
			this.score = score;
		}
		public String getFirst(){
			return first;
		}
		public String getLast(){
			return last;
		}
		public int getScore(){
			return score;
		}

	}//bowler class
	//comparator class
	public class BComparator implements Comparator<Bowler>{
		public int compare(Bowler a, Bowler b){
			int comp = a.getLast().compareTo(b.getLast());

			if(comp != 0)
				return comp;
			else
				return a.getFirst().compareTo(b.getFirst());

		}
	}//comparator class

	public static void main(String [] args){
		Bowling app = new Bowling();
	}

}