package Basic.src.EmployeePayrollSystem;
import java.util.*;

/*
* What will learn in this project.
*
* we are checking organization is in profilt  and loss
* by calculating salary spent on employee and getting project cost by client
* there is employee department having FulltimeEmp and PartTime emp
* there is Project department who will provide project cost and allocate project to emp
* Org can add/remove/display  employee
* org can add project
* org can check how many salary spent on emp
* org can check and to get total project money
* org can check is in profit and loss by totalProjectCost-totalSalary spent
* employee can update project status i.e complete,inprogress,etc.
*
* */


abstract class Employee{
    private String name;
    private int id;
    private List<Project> allocateProjects; // Store assigned projects

    public Employee(String name,int id){
        this.name=name;
        this.id=id;
        allocateProjects = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    abstract double calculateSalary();


    @Override
    public String toString(){
        return "Employee [name="+name+", id="+id+", salary="+calculateSalary()+", projects=" + allocateProjects+"]";
    }
    // Assign a project to an employee
    public void mapProject(Project p){
        allocateProjects.add(p);
    }

    public List<Project> getProjects(){
        return allocateProjects;
    }

    public void updateProjectStatus(Project p,String status){
            for (Project project : this.getProjects()) {
                if (project.getId() == p.getId()) { // 🔹 Find the project
                    System.out.println("Project status before: " + project);
                    project.setStatus(status);
                    System.out.println("Project status after: " + project);
                    return;
                }
            }
        System.out.println("Project " + p.getName() + " not found for employee " + this.getName());
    }

}

class FullTimeEmployee extends Employee{
    private double monthlySalary;

    public FullTimeEmployee(String name,int id, double salary){
       super(name,id);
        this.monthlySalary = salary;

    }

    @Override
    public double calculateSalary(){
        return monthlySalary;
    }

}

class PartTimeEmployee extends Employee {
    private int hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String name,int id, int hourlyRate,int hoursWorked){
        super(name,id);
        this.hourlyRate=hourlyRate;
        this.hoursWorked=hoursWorked;
    }

    @Override
    public double calculateSalary(){
        return hoursWorked * hourlyRate;
    }
}

abstract class Project {
    private String name;
    private int id;
    private double cost;
    private String estimationTime;
    private int noOfResource;
    private String managerName;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Project(String name, int id, String estimationTime, int noOfResource, String managerName){
        this.name=name;
        this.id=id;
        this.estimationTime=estimationTime;
        this.noOfResource=noOfResource;
        this.managerName=managerName;
        this.setStatus("pending");
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public String getEstimationTime() {
        return estimationTime;
    }

    public int getNoOfResource() {
        return noOfResource;
    }

    abstract double costCalculate();

    @Override
    public String toString(){
        return "Project [name="+name+", id="+id+", cost="+costCalculate()+", estimationTime="+estimationTime+", noOfResource="+noOfResource+", Manager Name="+managerName+", Status="+status+"]";
    }
}

class ProjectDepartment extends Project{

    // we can also used here depend on requirment
    //Instead of each Employee maintaining its project list,
    // ProjectDepartment maintains a Map<Employee, List<Project>>,
    // which acts as a central mapping between employees and projects.
    private static Map<Employee, List<Project>> employeeProjects = new HashMap<>();
    private static final double BASE_COST = 10000.0;

    public static Map<Employee, List<Project>> getEmployeeProjects() {
        return employeeProjects;
    }

    public static void assignProject(Employee e, Project p) {
        List<Project> projects = employeeProjects.getOrDefault(e, new ArrayList<>());
        projects.add(p);
        employeeProjects.put(e, projects);
        System.out.println("Project '" + p.getName() + "' assigned to " + e.getName());
        //Project 'Java project' assigned to krish
        //Project 'Phython project' assigned to vicky

        e.mapProject(p);//imp
    }


    public ProjectDepartment(String name,int id,String estimationTime, int noOfResource, String managerName){
        super(name,id,estimationTime,noOfResource,managerName);
    }

    public double costCalculate(){
        double cost = BASE_COST * getNoOfResource();
        setCost(cost);
        return cost;
    }

//    public static void assignProject(Employee e,Project p){
//        e.assignedProject(e,p);// Directly add project to employee's list
//    }
}

class PayrollSystem  {
    private double totalSalarySpent=0.0;
    private double companyEarnedProfit=0.0;

    // 🔹 Static list of employees to be accessible from Employee class
    private  ArrayList <Employee> empList;
    private ArrayList<Project> projectList;

    public PayrollSystem(){
       empList =  new ArrayList<>();
       projectList = new ArrayList<>();
    }

    public ArrayList<Project> getProjectList() {
        return projectList;
    }

    public ArrayList<Employee> getEmpList() {
        return empList;
    }

    public void addEmp(Employee e){
        empList.add(e);
    }
    public void removeEmp(int empId){
       ListIterator<Employee> empItr =  empList.listIterator();
       while(empItr.hasNext()){
         Employee currentEmp =  empItr.next();
            if(currentEmp.getId() == empId){
                //empList.remove(currentEmp); cause issues You're modifying empList inside the loop, which can cause a ConcurrentModificationException.
                empItr.remove(); // ✅ Correct way to remove
                System.out.println("Employee removed successfully");
                break;
            };
        }
    }

    @Override
    public String toString() {
        return "PayrollSystem{" +
                "totalSalarySpent=" + totalSalarySpent +
                ", empList=" + empList +
                ", projectList=" + projectList +
                '}';
    }

    public void displayEmployee(){
        for(Employee e : empList){
            System.out.println(e.getName());
        }
    }

    public void addProject(Project p){
        projectList.add(p);
    }

    public void totalSalarySpent(){
        for(Employee e : empList){
            totalSalarySpent += e.calculateSalary();
        }
        System.out.println("company spent total salary on employee "+totalSalarySpent);
    }

    public void totalProfitEarned(){
        double totalProjectCost=0.0;
        for(Project p: projectList){
            totalProjectCost+=p.getCost();
        }
        System.out.println("Total project cost received by client "+totalProjectCost);
        companyEarnedProfit = totalProjectCost-totalSalarySpent;
        System.out.println("company Earned profit "+companyEarnedProfit);
    }
}

public class Test {
    public static void main(String[] args) {
        FullTimeEmployee ft1=new FullTimeEmployee("krish",100,1000);
        FullTimeEmployee ft2=new FullTimeEmployee("vicky",101,2000);
        //System.out.println(ft1.toString());
        //System.out.println(ft2.toString());

        PartTimeEmployee pt1=new PartTimeEmployee("vikas",102,100,6);
        PartTimeEmployee pt2=new PartTimeEmployee("priya",103,50,8);
        //System.out.println(pt1.toString());
        //System.out.println(pt2.toString());

        //creating project
        ProjectDepartment javaProject = new ProjectDepartment("Java project",101,"2 months",4,"Ramesh");
        ProjectDepartment phythonProject = new ProjectDepartment("Phython project",102,"3 months",2,"Robert");
        ProjectDepartment dotnetProject = new ProjectDepartment("DotNet project",103,"6 months",3,"Nitin");
        ProjectDepartment HTMlProject = new ProjectDepartment("HTML project",104,"1 months",1,"Max");

        //assign project to employee
        System.out.println("++++++++ assign project+++++++");
        ProjectDepartment.assignProject(ft1,javaProject);
        ProjectDepartment.assignProject(ft2,phythonProject);
        ProjectDepartment.assignProject(pt1,dotnetProject);
        ProjectDepartment.assignProject(ft1,HTMlProject);
        ProjectDepartment.assignProject(ft2,javaProject);

        //Update project status
        ft1.updateProjectStatus(javaProject,"completed");


        PayrollSystem org = new PayrollSystem();
        //add employee
        org.addEmp(ft1);
        org.addEmp(ft2);
        org.addEmp(pt1);
        org.addEmp(pt2);
        System.out.println("show employes name");
        System.out.println(org.getEmpList());

        System.out.println("++++++++++++++");

        //add project
        org.addProject(javaProject);
        org.addProject(phythonProject);
        org.addProject(dotnetProject);
        System.out.println("show projects");
        System.out.println(org.getProjectList());

        System.out.println("++++++++++++++");



        org.totalSalarySpent();//4000.0
        org.totalProfitEarned();//86000.0
        System.out.println(org.toString());
        //org.removeEmp(103);
        //org.displayEmployee();

    }
}


/*
* What’s Good?
✔ Encapsulation: You’ve used private fields with getters and setters.
✔ Abstraction: Employee and Project are abstract classes, forcing subclasses to implement required methods (calculateSalary(), costCalculate()).
✔ Polymorphism: You’ve overridden calculateSalary() for different employee types.
✔ Good Use of Collections: ArrayList, HashMap, and ListIterator are used effectively.
✔ Project Assignment System: Both individual employee assignment and centralized tracking (ProjectDepartment) are handled well.
✔ Salary and Profit Calculation: You’ve implemented total salary spent and company earnings properly.
* */