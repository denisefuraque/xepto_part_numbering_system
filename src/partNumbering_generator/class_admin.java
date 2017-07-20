package partNumbering_generator;

public class class_admin {
    String uname, fname, lname, job, pword;
    
    public class_admin(String user, String first_name, String last_name, String job_title, String pass){
        this.uname = user;
        this.fname = first_name;
        this.lname = last_name;
        this.job = job_title;
        this.pword = pass;
    }
    
    public String getUname(){
        return uname;
    }
    
    public String getFname(){
        return fname;
    }
    
    public String getLname(){
        return lname;
    }
    
    public String getJob(){
        return job;
    }
    
    public String getPword(){
        return pword;
    }
}