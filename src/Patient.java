/**
 * This class represents each patient
 */
public class Patient implements Comparable<Patient> {

    /**
     * Takes the name of the patient
     */
    private String name;
    /**
     * Takes de sickness of the patient
     */
    private String disease;
    /**
     * Represents the priority that should give to the patient
     */
    private String priority;


    /**
     * Constructor
     * @param name
     * @param disease
     * @param priority
     */
    public Patient(String name, String disease, String priority){
        this.name = name;
        this.disease = disease;
        this.priority = priority;
    }

    /**
     * @return this priority
     */
    public String getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Patient patient) {
        return this.getPriority().compareTo(patient.getPriority());

    }

    /**
     * @return this priority
     */
    public String toString(){
        return priority;
    }

    /**
     * @return print patient
     */
    public String getInfo(){
        return name + " " + disease;
    }
}
