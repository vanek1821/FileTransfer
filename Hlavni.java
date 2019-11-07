import java.io.*;
import java.util.ArrayList;

public class Hlavni {

	//private Osoba[] pole;
	//private Student[] poleStudentu;
	
	public static void main(String[] args) throws IOException {
		
		//Osoba[] pole = new Osoba[7];
		ArrayList<Osoba> list = new ArrayList<Osoba>();
		Osoba os = new Osoba("Jakub", "Vanek", 24, 10, 1996);
		list.add(os);
				
		Student s = new Student("kamil", "hoffman", 1, 2, 2003, "3G", "3G001");
		list.add(s);
		
		Zamestnanec z = new Zamestnanec("James", "Bond", 1,2,2000, "Agent", "007 bitch" );
		list.add(z);
		
		list.add(new Student("Ruda", "Puda", 12,7,2014, "S002", "1.A"));
		list.add(new Student("Kuøivoj", "Vysajbong", 2,6,2016, "S004", "3.B"));
		list.add(new Zamestnanec("James", "Bond", 1,2,2000, "Agent", "007 bitch" ));
		list.add(new Osoba("Karolina", "Ori", 1,9,1996));
		list.add(new Osoba());
		list.add(new Student());
		list.add(new Zamestnanec());
		
		for (Osoba osoba : list) {
			System.out.println(osoba);
		}
		
		//ulozeni do souboru 
		File file = new File("save.txt");
		
		FileOutputStream fileOut = new FileOutputStream(file);
		ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
		for (Osoba osoba : list) {
			objectOut.writeObject(osoba);
		}
		objectOut.close();
		System.out.println();
		System.out.println("_____________________________________");
		System.out.println("Uloženo do souboru");
		System.out.println("_____________________________________");
		System.out.println();
		
		list.clear();
		
		//nacteni ze souboru
		FileInputStream fileIn = new FileInputStream(file);
		ObjectInputStream objectIn = new ObjectInputStream(fileIn);
		
		Object obj;
		boolean notEnd = true;
		
		while(notEnd) {
			try {
				obj = objectIn.readObject();
				System.out.println("naèteno - " + obj.toString());
				if(obj instanceof Osoba) {
					list.add((Osoba) obj);
				}
			} catch (EOFException e) {
				// TODO Auto-generated catch block
				notEnd = false;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println();
		System.out.println("_____________________________________");
		System.out.println("Naèteno ze souboru");
		System.out.println("_____________________________________");
		System.out.println();
		for (Osoba osoba : list) {
			System.out.println(osoba);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
