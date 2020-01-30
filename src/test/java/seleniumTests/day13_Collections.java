package seleniumTests;

import org.testng.annotations.Test;

import java.util.*;

public class day13_Collections {
    String model;
    int year;

    public static void main(String[] args) {

//*************************************************************************
//List Ex:
        List<String> names = new ArrayList<>();
        names.add("James");
        names.add("John");
        names.add("Emily");
        names.add("Josh");
        System.out.println(names);
        System.out.println(names.get(3));
        System.out.println("-----------");
        System.out.println("-----------");
//*************************************************************************

//QUEUE EX:
        System.out.println("-----QUEUE EX------");
        Queue<String> candidates = new PriorityQueue<>();
        candidates.add("Person1");
        candidates.add("Person2");
        candidates.add("Person3");
        candidates.add("Person4");
        System.out.println("-----------");

    //peek method
        System.out.println("----peek method-------");
        System.out.println(candidates.peek());
        System.out.println(candidates.size());
        System.out.println(candidates);
        System.out.println("-----------");
//*************************************************************************


//LIST EX:
        System.out.println("-----LIST EX------");
        List<String> students = new LinkedList<>();
        students.add("Student1");
        students.add("Student2");
        students.add("Student3");
        students.add("Student4");

        System.out.println(students);
        System.out.println("-----------");
//*************************************************************************


//SET EX:
     // Sort first bigger String   maryna, denys, vlad
        System.out.println("-----SET EX:------");
        Set<String> handles = new HashSet<>();
        handles.add("vlad");
        handles.add("maryna");
        handles.add("denys");
        System.out.println("-------------");

        List<String> listHandles = new ArrayList<>(handles);
        System.out.println(listHandles);
        System.out.println("----------");


//*************************************************************************
//TREESET EX:
     //Sort in alphabet order
        System.out.println("------TREESET EX-----");
        Set<String> handlesTree = new TreeSet<>();

        handlesTree.add("Maryna");
        handlesTree.add("Denys");
        handlesTree.add("Vlad");
        handlesTree.add("Polina");
        handlesTree.add("12345");

        System.out.println("-----------");

        List<String> listHandlesTree = new ArrayList<>(handlesTree);
        System.out.println(listHandlesTree);
        System.out.println("-----------");


//*************************************************************************
//Iterator EX:
        // work like for each loop
        //      for(String s: listHandlesTree){
        //         System.out.println(s);
        //  }

        Iterator<String> iterator = handlesTree.iterator();

        System.out.println(iterator.next());              //34dsd
        System.out.println(iterator.next());              //aagsdgb

     //remove iterator
        while (iterator. hasNext()){
            //System.out.println(iterator.next());
            if(iterator.next().equals("34dsd")){
                iterator.remove();

            }
        }
        System.out.println(handlesTree);
    }


//*************************************************************************
//MAP EX:
    // Using Map to store data in KEY & Value format
 @Test
     public void mapping() {
                System.out.println("------Map EX-------");

         Map<String, String> configs = new HashMap<>();   //or TreeMap<>() -> it will sort
             configs.put("url", "google.com");
             configs.put("username","jbond");
             configs.put("password", "jb123");
             configs.put("abc","some value");

                System.out.println(configs);
                System.out.println("-------------");
                System.out.println(configs.get("password"));
                System.out.println("-------------");

            Set<String> keys = configs.keySet();
                for(String key: keys){
                 System.out.println(configs.get(key));
        }
    }
}
