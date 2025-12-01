abstract class Person {

    private String password;
    private String name;
    private String phoneNumber;
    private String email;
    private String id;

    protected Person(String password, String name, String phoneNumber, String email, String id){
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.id = id;
    }

    public boolean login(String email, String password){
        if(this.email==email && this.password==password){
            return true;
        } else{
            return false;
        }
    }

    public String getPassword(){
        return password;
    }
    
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }
//jijkjk

    
    
}





