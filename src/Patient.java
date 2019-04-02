 public class Patient implements Comparable<Patient> {

    private String name;
    private String disease;
    private String priority;


    public Patient(String name, String disease, String priority){
        this.name = name;
        this.disease = disease;
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Patient patient) {
        return this.getPriority().compareTo(patient.getPriority());

    }

    public String toString(){
        return priority;
    }

    public String getInfo(){
        return name + " " + disease;
    }
}
