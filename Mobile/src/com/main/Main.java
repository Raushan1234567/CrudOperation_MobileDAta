package com.main;
import java.time.LocalDate;
import java.util.*;
import com.dto.*;
import com.exception.Norecord;
import com.exception.Somethin;
import com.dao.*;
public class Main {
 
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int c;
		do {
			
			System.out.println("1. Enter Mobile data");
			System.out.println("2. Update Mobile data");
			System.out.println("3. Deleted Mobile data");
			System.out.println("4. View Mobile data");
			System.out.println("5. Search Mobile data");
			System.out.println("0. Exit");
			
			c=sc.nextInt();
			switch(c) {
			case 1:
				AddUi(sc);
				break;
			case 2:
				UpdateUi(sc);
				break;
			case 3:
				DeletedUi(sc);
				break;
			case 4:
				View(sc);
				break;
			case 5:
				SearchByModelno(sc);
				break;
			case 0:
				System.out.println("thanks");
				break;
			case 6:
				System.out.println("Invalid Selection");
			}
			
		}while(c!=0);
		sc.close();
		
	}

	private static void SearchByModelno(Scanner sc) {
		
		System.out.println("Enter model no");
		String modelno=sc.next();
		
Interface b=new ServiceImple();
		
		try {
			
			Mobile f=b.Serch(modelno);
			
			System.out.println(f);
		
			
//			if(p>0) {
//				System.out.println("Success");
//			}
//			else {
//				System.out.println("not Success");
//			}
		} catch (Somethin | Norecord e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void View(Scanner sc) {
		
		Interface b=new ServiceImple();
		
		try {
			List<Mobile> list=b.View();
			
			list.stream().sorted((a,h) -> a.getPrice()>h.getPrice() ? 1:-1).toList().forEach(t -> {
				System.out.println(t);
			});
			
		} catch (Norecord e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void DeletedUi(Scanner sc) {
		System.out.println("Enter model no");
		String modelno=sc.next();
		
Interface b=new ServiceImple();
		
		try {
			
			b.Deleted(modelno);
		
			
//			if(p>0) {
//				System.out.println("Success");
//			}
//			else {
//				System.out.println("not Success");
//			}
		} catch (Somethin e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void UpdateUi(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("Enter model no");
		String modelno=sc.next();
		System.out.println("Enter company name");
		String company=sc.next();
		System.out.println("Enter price");
		int price=sc.nextInt();
		System.out.println("Enter mfg date");
		LocalDate d=LocalDate.parse(sc.next());
		
		
		
		Mobile a=new Mobile(modelno, company, price, d);
		
		Interface b=new ServiceImple();
		
		try {
			
			b.Update(a);
		
			
//			if(p>0) {
//				System.out.println("Success");
//			}
//			else {
//				System.out.println("not Success");
//			}
		} catch (Somethin e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private static void AddUi(Scanner sc) {
		
		System.out.println("Enter model no");
		String modelno=sc.next();
		System.out.println("Enter company name");
		String company=sc.next();
		System.out.println("Enter price");
		int price=sc.nextInt();
		System.out.println("Enter mfg date");
		LocalDate d=LocalDate.parse(sc.next());
		
		
		
		Mobile a=new Mobile(modelno, company, price, d);
		
		Interface b=new ServiceImple();
		
		try {
			
			b.Add(a);
			System.out.println("added success");
//			if(p>0) {
//				System.out.println("Success");
//			}
//			else {
//				System.out.println("not Success");
//			}
		} catch (Somethin e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
  
  
  
	
	
	
	
}
