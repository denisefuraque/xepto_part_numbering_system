
package partNumbering_generator;

public class Class_data {
    String partNum, category, description;
    
    public Class_data(String pn, String cat, String des){
        this.partNum = pn;
        this.category = cat;
        this.description = des;
    }
    
    public String getPn(){
        return partNum;
    }
    
    public String getCat(){
        return category;
    }
    
    public String getDes(){
        return description;
    }
}
