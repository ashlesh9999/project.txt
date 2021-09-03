import java.util.ArrayList;

 abstract class Course {
    
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    
    public void attach(Observer observer) {
       observers.add(observer);
    }
    public void detach(Observer observer) {
       observers.remove(observer);
    }
    public void notifyObservers() {
       for (Observer o : observers)    
          o.update();
   }
 }
 
 class ConcreteCourse extends Course {
  
  private String courseState;
  
  public String getCourseState() {
    return courseState;
  }
  public void setCourseState(String value) {
    courseState = value;
  }
 }
 
 abstract class Observer {
   
   abstract public void update();
 }
  class ConcreteObserver extends Observer {
  
  private String name;
  private String observerState;
  private ConcreteCourse course;
 
  public ConcreteObserver(ConcreteCourse course, String name) {
     this.course = course;
     this.name = name;
     
  }
  
  public void update() {
     observerState = course.getCourseState();
     System.out.printf("Observer %s's new state is %s\n", name, observerState);
  }
 }
 
 public class Client {
   public static void main(String[] args) {
      
      ConcreteCourse s = new ConcreteCourse();
      s.attach(new ConcreteObserver(s, "1"));
      s.attach(new ConcreteObserver(s, "2"));
      s.attach(new ConcreteObserver(s, "9"));

     
      s.setCourseState(" registered ");
      s.notifyObservers();
   }
 }
