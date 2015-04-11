package model;


import javax.persistence.*;
import java.util.Date;

/*
  id bigserial primary key,
  name varchar(255)  NOT NULL,
  description TEXT,
  x integer,
  y integer,
  id_parent bigserial references item (id) ON DELETE CASCADE ,
  filename varchar(255) DEFAULT NULL,
  theblop BYTEA,
  ts timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  deleted boolean
*/

@Entity  
@Table(name="item")
public class Item {

    public Item() {
    }
    
    @Id
    @GeneratedValue
    public Integer id;
    
    private String name;
    private String description;
    private String filename;
    private Item parent;
    private Date ts;
    private boolean deleted;
    private byte[] theBlop;
    private Integer x;
    private Integer y;

    @Column(name="x")
    public Integer getX() {
        return x;
    }

    public void setX(Integer x){
        this.x = x;
    }    

    @Column(name="y")
    public Integer getY() {
        return y;
    }

    public void setY(Integer y){
        this.y = y;
    }    
    
    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="filename")
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    @Column(name="id_parent")
    public Item getParent() {
        return parent;
    }    

    public void setParent(Item parent) {
        this.parent = parent;
    }
    
    @Column(name = "deleted")
    public boolean getDeleted(){
        return deleted;
    }

    public void setDeleted(boolean deleted1){
        deleted = deleted1;
    }

    @Column(name = "ts")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getTs() {
      	return ts;
    }

    public void setTs(Date ts) {
       	this.ts = ts;
    }

    @Column(name = "theblop")
    public byte[] getTheBlob() {
        return theBlob;
    }

    public void setTheBlob(byte[] theBlob) {
        this.theBlob = theBlob;
    }
    
    @Override
    public String toString() {
        return  "Item@" + id + ":" + name ;
    }

}
