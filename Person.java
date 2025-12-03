abstract class Person {

    private String password;
    private String name;
    private String phoneNumber;
    private String email;

    public Person(String password, String name, String phoneNumber, String email){
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
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



    public void displayInfo(){
        System.out.println("Name: " + name);
        System.out.println("Phone" + phoneNumber);
        System.out.println("Email: " + email);
    }

    
    
}





