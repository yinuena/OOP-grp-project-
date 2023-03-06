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
    public String getMname() {
        return mname;
    }
    public String getLname() {
        return lname;
    }


    @Override
    public String toString() {
        return "Name{" +
                "fname='" + fname + '\'' +
                ", mname='" + mname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }
}
