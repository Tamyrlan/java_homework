package oop_2;
import java.util.List;
public class person {
    private Integer id;
    private String firstName;
    private String lastName;
    private Sex sex;
    private Integer motherId;
    private Integer fatherId;
    private List <Integer> brothersId;
    private List <Integer> sistersId;
    private List <Integer> sonsId;
    private List <Integer> daughtersId;
    private List <Integer> spousesId;

    public person(Integer id, String firstName, String lastName, Sex sex, Integer motherId, Integer fatherId,
    List<Integer> brothersId, List<Integer> sistersId, List<Integer> sonsId,
    List<Integer> daughtersId, List<Integer> spousesId){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.motherId = motherId;
        this.fatherId = fatherId;
        this.brothersId = brothersId;
        this.sistersId = sistersId;
        this.sonsId = sonsId;
        this.daughtersId = daughtersId;
        this.spousesId = spousesId;
    }
    public person(person persn){
        this(persn.getId(), persn.getFirstName(), persn.getLastName(), persn.getSex(),
                persn.motherId, persn.fatherId, persn.brothersId, persn.sistersId,
                persn.sonsId, persn.daughtersId, persn.spousesId);
    }
    public Integer getId(){
        return id;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public Integer getMotherId() {
        return motherId;
    }
    public Integer getFatherId() {
        return fatherId;
    }
    public List<Integer> getBrothersId() {
        return brothersId;
    }
    public List<Integer> getSistersId() {
        return sistersId;
    }
    public List<Integer> getSonsId() {
        return sonsId;
    }
    public List<Integer> getDaughtersId() {
        return daughtersId;
    }
    public Sex getSex() {
        return sex;
    }
    public List<Integer> getSpousesId() {
        return spousesId;
    }
    @Override
    public String toString() {
        return "id(" + id + ") " + firstName + " " + lastName;
    }

}
