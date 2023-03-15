import java.util.ArrayList;

public class DSchoolList {
    //data SecurityException
    ArrayList<School>schools = new ArrayList<>();

    public void addSchool(School sc) {
        schools.add(sc);

    }

    public void display() {
        for (int i = 0; i < schools.size(); i++) {
            System.out.println("school:" + schools.get(i).getName());
        }
    }

    public static void main(String args[]){
        DSchoolList dl = new DSchoolList();

        School sc = new School();
        sc.setName("St Patrick");
        dl.addSchool(sc);
        dl.addSchool(sc);

        School sc2 = new School();
        sc2.setName("Woodsville");
        dl.addSchool(sc2);

        dl.display();
    }



}