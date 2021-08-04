package my.ch23annotation.database;

import bookcode.annotations.database.*;


@DBTable(name = "MEMBER")
public class Member {
    @SQLString(30) 
    String firstName;
    @SQLString(50)
    String lastName;
    @SQLInteger
    Integer age;
    @SQLString(value = 30, constraints = @Constraints(primaryKey = true))
    String reference;
    static int memberCount;
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getReference() { return reference; }
    @Override public String toString() {
        return reference;
    }
    public Integer getAge() { return age; }
}
