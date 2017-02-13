package assignment;

import java.awt.List;
import java.util.ArrayList;

public class Assignment4 {

/**
* 1.Design a simple registration system that allows Student to register in a course using 2 classes: class Student & 
* class Course. Implement the scenarios in class Test’s main method.
* Each student has a name and an id variables. Each object of class Student is initialized using values of name and 
* id passed to constructor. Class Student has accessor methods for its instance variables
* Each Course has a name, and a variable numberOfStudent representing the number of registered students. A course can 
* have a maximum number of 10 students registered in it. Class Course store the registered students in students which is 
* an array of type Student. When a student register in a course, he is added to the array. Each object of class Course 
* is initialized using the title. Class Course has the following methods: method getStudents(): return the array of 
* registered students; 
* method boolean isFull():  return true if the course is full, accessor method for the title and numberOfStudent field, 
* method registerStudent (Student student): if the course is not full, register a student in course.
*/
	//define class Student
	public class Student {
		private int id;
		private String name;

		public Student(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}
		
	//define class Course
		public class Crouse {
			private int max_count = 10;
			private String title;
			private int numberOfStudent;
			private Student[] students = new Student[max_count];
			public Crouse(String title) {
				this.title = title;
			}
			
			public String getTitle() {
				return title;
			}
			public void setTitle(String title) {
				this.title = title;
			}
			public int getNumberOfStudent() {
				return numberOfStudent;
			}
			public void setNumberOfStudent(int numberOfStudent) {
				this.numberOfStudent = numberOfStudent;
			}
			
			public boolean isFull() {
				return numberOfStudent == max_count;
			}
			
			public Student[] getStudents() {
				return students;
			}

			public boolean registerStudent(Student student) {
				if(!isFull()) {
					students[numberOfStudent++] = student;
					return true;
				}
				return false;
			}
		}
			
		//Junit Test
			
/**
import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class CrouseTest {

	@Test
	//test Crouse and Student
	public void test() {
		Crouse course = new Crouse("Java");
		Student student = new Student(001,"Mia");
		boolean register = course.registerStudent(student);
		Assert.assertTrue(register);
		}
	
	//test RegisterStudent false
	public void testRegisterStudent() {
		Crouse crouse = new Crouse("Java");
		for(int i = 0; i <= 10; i++) {
			Student student = new Student(i,"student"+i);
			crouse.registerStudent(student);			
		}
		//when the eleventh student want to register, return false.
		Student student = new Student(11,"Mia");
		boolean register = crouse.registerStudent(student);
		Assert.assertFalse(register);
	}
	
	//test student register successful
	public void testIsFull() {
		Crouse course = new Crouse("Java");
		Student student = new Student(001,"Mia");
		course.registerStudent(student);
		Assert.assertFalse(course.isFull());
	}	

}
 */
	
	
/**
 * 2.Design and implement class Book and class Customer. You need to create necessary attributes for these two classes 
 * and methods if needed. Every customer can purchase books, and every book has price and title. Besides, you need to 
 * write the main method to test some scenarios like this: a customer is buying several books, and it prints out the 
 * total price for this purchase on the screen. 	
 */
	
		//define class Book
		public class Book {
			private int id; //some books maybe have the same title
			private String title;
			private double price;
			
			public Book(String title, double price) {
				this.title = title;
				this.price = price;
			}

			public String getTitle() {
				return title;
			}

			public void setTitle(String title) {
				this.title = title;
			}

			public double getPrice() {
				return price;
			}

			public void setPrice(double price) {
				this.price = price;
			}
			
		}
		
		//define class Customer		
		public class Customer {
			private String name;
			private int numOfBooks;
			private double totalPrice; 
			ArrayList <Book> books = new ArrayList<Book>();
			
			public Customer(String name) {
				this.name = name;
			}
			
			public void setName(String name){
				this.name = name;
			}
			
			public String getName(){
				return name;
			}

			//method purchaseBooks
			public void purchaseBooks(Book book) {
				books.add(book);
				numOfBooks++;
				totalPrice += book.getPrice();
			}
			
			//get the book numbers which customer have bought 
			public int getNumOfBooks() {
				return numOfBooks;
			}
			
			//the total price of books
			public double getTotalPrice() {
				return totalPrice;
			}
			
			//main method
			public void main (String [] args) {
				Customer customer = new Customer("Mia");
				for(int i = 0; i <= 8; i++) {
					Book book = new Book("book"+i, 5.5);
					customer.purchaseBooks(book);
				}
				System.out.println(customer.getName() + " " + "have paid $" + customer.getTotalPrice());
			}
		}


	
/**
 * 3.Write a class named GasTank containing:
 * An instance variable named amount of type double, initialized to 0.
 * A method named addGas that accepts a parameter of type double . The value of the amount instance variable is increased by the value of the parameter.
 * A method named useGas that accepts a parameter of type double . The value of the amount instance variable is decreased by the value of the parameter.
 * A method named getGasLevel that accepts no parameters. getGasLevel returns the value of the amount instance variable.
 */
		public class GasTank {
			double numOfGas = 0;
			

			public double getNumOfGas() {
				return numOfGas;
			}


			public void setNumOfGas(double numOfGas) {
				this.numOfGas = numOfGas;
			}


			public void AddGas(double gas) {
				// add gas to numOfGas
				this.numOfGas += gas;
			}
			
			
			public void UseGas(double gas) {
				//subtract gas from the numOfGas
				this.numOfGas -= gas;
			}
			
			public double getGasLevel() {
				return numOfGas;		
			}

		}

	
/**
 * 4. Design and implement a class called Car. You need to create necessary attributes for this class, and method if needed.
 * Define the Car constructor to initialize these values (in that order). 
 * Include getter and setter methods for all instance data 
 */
		public class Car {
			String brand;
			String color;
			double size;
			double mileage;
			int maxNumOfPassengers;
			
			
			public String getBrand() {
				return brand;
			}

			public void setBrand(String brand) {
				this.brand = brand;
			}

			public String getColor() {
				return color;
			}

			public void setColor(String color) {
				this.color = color;
			}

			public double getSize() {
				return size;
			}

			public void setSize(double size) {
				this.size = size;
			}

			public double getMileage() {
				return mileage;
			}

			public void setMileage(double mileage) {
				this.mileage = mileage;
			}

			public int getMaxNumOfPassengers() {
				return maxNumOfPassengers;
			}

			public void setMaxNumOfPassengers(int maxNumOfPassengers) {
				this.maxNumOfPassengers = maxNumOfPassengers;
			}
			

			public Car(String brand, String color, double size, double mileage, int maxNumOfPassengers) {
				this.brand = brand;
				this.color = color;
				this.size = size;
				this.mileage = mileage;
				this.maxNumOfPassengers = maxNumOfPassengers;
			}

			GasTank gt = new GasTank();
			public void addMileage(double mileage){
				this.mileage += mileage;
			}
			
			public boolean ifAddGas(double gas) {
				
				if(gt.numOfGas < 10) {
					System.out.println("You should add gas now, or you could not drive the car!");
					return true;
				} else {
					return false;
				}
			}
			
			public void running(double mileage) {
				addMileage(mileage);
				gt.UseGas(mileage * 5);
			}
			
	}

		
/**
 * 5.Combine with problem 3 and 4, define a class named Driver that contains methods like drive and addGas so that 
 * the driver can drive the car.
 */
		class Driver {
			Car c;
			private double mileage;
			
			public double getMileage() {
				return mileage;
			}
			
			public void drive(double mileage) {
				
					c.running(mileage);
					System.out.println("The car have runned for:" + c.getMileage() + "miles");					
				
			}
			

		}
			

}


	
		
