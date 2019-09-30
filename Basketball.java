import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.math.*;
import java.util.Comparator;

public class Basketball{


	public Basketball(){

		File name = new File ("BasketballPlayerList.txt");


		try{
			BufferedReader input = new BufferedReader(new FileReader(name));
			ArrayList<String> list = new ArrayList<>();
			String text;
			while((text = input.readLine())!=null){
				String [] assignments = text.split("\t");
				for(int i = 0;i<assignments.length;i++)
					list.add(assignments[i]);
			}

			ArrayList<BasketballPlayer> players = new ArrayList<>();
			for(int i = 9; i<list.size();i+=9){
				String num = list.get(i);
				String pname = list.get(i+1);
				String pos = list.get(i+2);
				String age = list.get(i+3);
				String height = list.get(i+4);
				String weight = list.get(i+5);
				String university = list.get(i+6);
				String salary = list.get(i+7);
            	String team = list.get(i+8);
				players.add(new BasketballPlayer(pname, pos, team, salary, height, weight, age, university, num));
			}

			HashMap<String, HashSet<BasketballPlayer>> hashmap = new HashMap<>();
			HashSet<BasketballPlayer> hashPlayers;
			for(int i = 0;i<players.size();i++){
				String key = players.get(i).getTeam();
				HashSet<BasketballPlayer> temp = new HashSet<>();
				for(int j =0;j<players.size();j++){
					if(players.get(j).getTeam().equals(key)){
						temp.add(players.get(j));
						hashPlayers = temp;
						hashmap.put(key,hashPlayers);
					}
				}
			}

			System.out.println("HashMap:");
			Iterator it = hashmap.keySet().iterator();
			while(it.hasNext()){
				Object obj = it.next();
				System.out.println(obj+": ");
				System.out.println();
				for(BasketballPlayer basketballPlayer:hashmap.get(obj)){
					System.out.println(basketballPlayer.getName());
				}
            	System.out.println();

			}

			//treemap stuff

			BComparator bcomparator = new BComparator();
			TreeMap<String, TreeSet<BasketballPlayer>> treemap = new TreeMap<>();
			TreeSet<BasketballPlayer> treePlayers;

			for(int i = 0;i<players.size();i++){
				String key = players.get(i).getTeam();
				TreeSet<BasketballPlayer> temp = new TreeSet<>(bcomparator);
				for(int  j = 0;j<players.size();j++){
					if(players.get(j).getTeam().equals(key)){
						temp.add(players.get(j));
						treePlayers = temp;
						treemap.put(key, treePlayers);
					}
				}
			}

			Iterator it2 = treemap.keySet().iterator();
			while(it2.hasNext()){
				Object obj = it2.next();
				System.out.println(obj+": ");

				for(BasketballPlayer basketballPlayer:treemap.get(obj)){
					System.out.println(basketballPlayer.getName()+"\t"+basketballPlayer.getPos()+"\t"+basketballPlayer.getHeight()+"\t"+basketballPlayer.getWeight()+"\t"+basketballPlayer.getNum()+"\t"+basketballPlayer.getSalary()+"\t"+basketballPlayer.getUniversity()+"\t"+basketballPlayer.getAge());
				}
				System.out.println();


			}



		}catch(IOException io){
			System.err.println("DNE");
		}

	}

	public static void main(String [] args){
		Basketball app = new Basketball();
	}

	public class BasketballPlayer{
		private String name;
		private String position;
		private String team;
		private String salary;
		private String height;
		private String weight;
		private String age;
		private String university;
		private String number;

		public BasketballPlayer(String name, String position, String team, String salary, String height, String weight, String age, String university, String number){
			this.name = name;
			this.position = position;
			this.team = team;
			this.salary = salary;
			this.height = height;
			this.weight = weight;
			this.age =age;
			this.university = university;
			this.number = number;
		}

		public String getName(){
			return name;
		}
		public String getPos(){
			return position;
		}
		public String getTeam(){
			return team;
		}
		public String getSalary(){
			return salary;
		}
		public String getWeight(){
			return weight;
		}
		public String getHeight(){
			return height;
		}
		public String getAge(){
			return age;
		}
		public String getUniversity(){
			return university;
		}
		public String getNum(){
			return number;
		}
	}
	public class BComparator implements Comparator<BasketballPlayer> {

		public int compare(BasketballPlayer a, BasketballPlayer b){
			int compPos = a.getPos().compareTo(b.getPos());

			if(compPos<0)
				return -1;
			else if(compPos>0)
				return 1;
			else{
				int compHeight = a.getHeight().compareTo(b.getHeight());
				if(compHeight<0)
					return -1;
				else if(compHeight>0)
					return 1;

				else{
					int compWeight = a.getWeight().compareTo(b.getWeight());
					if(compWeight<0)
						return -1;
					else if(compWeight>0)
						return 1;

					else{
						int compNum = a.getNum().compareTo(b.getNum());
						if(compNum<0)
							return -1;
						else if(compNum>0)
							return 1;

						else{
							int compSalary = a.getSalary().compareTo(b.getSalary());
							if(compSalary<0)
								return -1;
							else if(compSalary>0)
								return 1;

							else{
								int compUniv = a.getUniversity().compareTo(b.getUniversity());
								if(compUniv<0)
									return -1;
								else if(compUniv>0)
									return 1;

								else{
									int compAge = a.getAge().compareTo(b.getAge());
									if(compAge<0)
										return -1;
									else if(compAge>0)
										return 1;
									else
										return 0;
								}
							}
						}
					}
				}
			}
		}
	}
}