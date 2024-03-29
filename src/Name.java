public class Name {
    private String fname;
    private String mname;
    private String lname;

    public Name() {
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void DisplayName(){
        System.out.println("First name: " + fname);
        System.out.println("Middle name: " + mname);
        System.out.println("Last name: " + lname);
    }

    @Override
    public String toString() {
        return "Name{" +
                "fname='" + fname + '\'' +
                ", mname='" + mname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }
