
package partNumbering_generator;

import java.util.Date;

public class Class_data {
    String partNum, category, description, author, configuration, manufacturer, manuPartNum, whereUsed;
    Date date;
    
    public Class_data(String pn, String cat, String des, Date gDate, String aut, String config, String manu, String mpn, String where){
        this.partNum = pn;
        this.category = cat;
        this.description = des;
        this.date = gDate;
        this.author = aut;
        this.configuration = config;
        this.manufacturer = manu;
        this.manuPartNum = mpn;
        this.whereUsed = where; 
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
    public Date getDate(){
        return date;
    }
    
    public String getAut(){
        return author;
    }
    
    public String getConfig(){
        return configuration;
    }
    public String getManu(){
        return manufacturer;
    }
    public String getMpn(){
        return manuPartNum;
    }
    public String getWhere(){
        return whereUsed;
    }
}
